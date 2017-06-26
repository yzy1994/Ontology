package com.edu.shu.ai.ontology.user.action;


import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.shu.eo.admin.service.UserService;


@SuppressWarnings("serial")
@Controller("userAction")
public class UserAction extends ActionSupport {
	
	/*@Autowired
	private UserMapper userMapper;*/
	
	@Inject
	@Named("UserService")
	UserService userservice;
	
	private String username;
	private String password;
	private String message;
	private String url;
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String login() throws Exception{
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		HttpServletResponse response = ServletActionContext.getResponse();
		try{
			subject.login(token);
		}catch(Exception e){
			message = "用户名或密码错误！";
			return ERROR;
		}
		HttpServletRequest request = ServletActionContext.getRequest();
		if(WebUtils.getSavedRequest(request)==null){
			this.url = "index.html";
			return SUCCESS;
		}
		String s = WebUtils.getSavedRequest(request).getRequestUrl();		
		if(!s.isEmpty()&&!s.equals("")&&!(s==null)){
			this.url = s.substring(10);
			if(this.url.equals("tool/bont.html"))
				this.url = "tool/ontoedit.html";
		}else{
			this.url = "index.html";
		}
		response.sendRedirect(url);
		return SUCCESS;
	}

	public String logout() throws Exception{  
		HttpServletResponse response = ServletActionContext.getResponse();
	    Subject subject = SecurityUtils.getSubject();  
	    if (subject.isAuthenticated()) {  
	        subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存  
	        if (LOG.isDebugEnabled()) {  
	            LOG.debug("用户" + username + "退出登录");  
	        }  
	    }  
	    this.url = "index.html";
	    response.sendRedirect(url);
	    return SUCCESS;
	}  
	
	@RequiresRoles("builder")
	public String changePWD() throws Exception {
		
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(username, password);
		subject.login(token);
		if(subject.hasRole("normal_user")){
			System.out.println("you quanxian有权限");
		}else{
			System.out.println("wu quanxian!!");
		}
		
		//User user = userMapper.getUserByUsername("admin1");
		//System.out.println("dfasfadf:" + user.getPassword() );
		return SUCCESS;

	}

}
