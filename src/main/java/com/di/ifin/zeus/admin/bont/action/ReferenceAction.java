package com.di.ifin.zeus.admin.bont.action;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;

import com.di.ifin.zeus.admin.bont.pojo.Paper;
import com.di.ifin.zeus.admin.bont.pojo.Researcher;
import com.di.ifin.zeus.admin.bont.service.PaperService;
import com.di.ifin.zeus.admin.bont.service.ResearcherService;
import com.opensymphony.xwork2.ActionSupport;

@Controller("referenceAction")
public class ReferenceAction extends ActionSupport {
	private List<Researcher> rlist;

	private List<Paper> plist;
	
	private String result;

	public List<Researcher> getRlist() {
		return rlist;
	}

	public void setRlist(List<Researcher> rlist) {
		this.rlist = rlist;
	}

	public List<Paper> getPlist() {
		return plist;
	}

	public void setPlist(List<Paper> plist) {
		this.plist = plist;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Inject
	@Named("PaperService")
	private PaperService paperService;

	@Inject
	@Named("ResearcherService")
	private ResearcherService researcherService;

	public String execute() {
		rlist = researcherService.queryAllResearcher();
		plist = paperService.queryAllPaper();
		return SUCCESS;
	}

}
