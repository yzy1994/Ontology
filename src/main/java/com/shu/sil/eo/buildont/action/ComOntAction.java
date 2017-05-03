package com.shu.sil.eo.buildont.action;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller("comOntAction")
public class ComOntAction extends ActionSupport {
	public String commonActive() throws Exception {
		return SUCCESS;
	}
}
