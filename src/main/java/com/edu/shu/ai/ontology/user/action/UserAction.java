package com.edu.shu.ai.ontology.user.action;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

import edu.shu.skytorif.mapper.UserMapper;
import edu.shu.skytorif.pojo.User;

@SuppressWarnings("serial")
@Controller("userAction")
public class UserAction extends ActionSupport {
	
	@Autowired
	private UserMapper userMapper;
	
	private String username;
	private String password;
	private String message;
	
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
		
		try{
			subject.login(token);
		}catch(Exception e){
			message = "用户名或密码错误！";
			return "error";
		}
		
		return "success";
	}

	public void logout() {  
	    Subject subject = SecurityUtils.getSubject();  
	    if (subject.isAuthenticated()) {  
	        subject.logout(); // session 会销毁，在SessionListener监听session销毁，清理权限缓存  
	        if (LOG.isDebugEnabled()) {  
	            LOG.debug("用户" + username + "退出登录");  
	        }  
	    }  
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
		
		User user = userMapper.getUserByUsername("admin1");
		System.out.println("dfasfadf:" + user.getPassword() );
		return SUCCESS;

	}

}
