package com.di.ifin.zeus.admin.bont.action;

import com.opensymphony.xwork2.ActionSupport;

public class BontAction extends ActionSupport {
	private String ontname;

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	public String getOntname() {
		return this.ontname;
	}

	public String execute() {
		
		return SUCCESS;
	}
}
