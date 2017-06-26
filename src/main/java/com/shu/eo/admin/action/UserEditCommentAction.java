package com.shu.eo.admin.action;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.di.ifin.zeus.admin.bont.pojo.ECEditComment;
import com.di.ifin.zeus.admin.bont.service.ECEditCommentService;
import com.di.ifin.zeus.admin.bont.service.ECRelationService;
import com.di.ifin.zeus.admin.bont.service.GlobalMongoService;
import com.di.ifin.zeus.admin.bont.service.OntService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import edu.shu.yzy.util.PropertiesUtil;

@Controller("userEditCommentAction")
public class UserEditCommentAction extends ActionSupport{
	private static final int pageSize = 10;

	static Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();

	private int page;
	
	private String pagerCode;
	
	private List<ECEditComment> commentList;
	
	private String ontname;
	
	public String getOntname(){
		return this.ontname;
	}
	
	public void setOntname(String ontname){
		this.ontname = ontname;
	}
	
	public List<ECEditComment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<ECEditComment> commentList) {
		this.commentList = commentList;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
	public String getPagerCode() {
		return pagerCode;
	}

	public void setPagerCode(String pagerCode) {
		this.pagerCode = pagerCode;
	}

	@Inject
	@Named("ECEditCommentService")
	private ECEditCommentService eceditcommentservices;

	@Inject
	@Named("OntService")
	private OntService ontService;

	public String queryList() {
		try {
			if("null".equals(String.valueOf(page))||page==0) page=1;
			if (ontname == null || ontname == "")
				this.ontname = ontService.findall().get(0).getName();
			List<ECEditComment> tempList = eceditcommentservices.queryCommentList(ontname);
			int totalPage=tempList.size()%pageSize==0?tempList.size()/pageSize:tempList.size()/pageSize+1;
			page = (totalPage<page)?totalPage:page;
			this.commentList = tempList.subList((page-1)*pageSize, Math.min(page*pageSize, tempList.size()));
			
			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			
			String url = request.getRequestURI();
			this.pagerCode = PropertiesUtil.getNextAndPrevious(page, pageSize, totalPage, url, ontname);
		
			request.getRequestDispatcher("/pages/admin/user_comment.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

}
