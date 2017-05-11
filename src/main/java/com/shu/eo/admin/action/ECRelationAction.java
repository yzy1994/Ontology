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

import com.di.ifin.zeus.admin.bont.pojo.ECRelation;
import com.di.ifin.zeus.admin.bont.pojo.ECRelationDef;
import com.di.ifin.zeus.admin.bont.service.ECRelationService;
import com.di.ifin.zeus.admin.bont.service.GlobalMongoService;
import com.di.ifin.zeus.admin.bont.service.OntService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.shu.global.Global;

@Controller("ecRelationAction")
public class ECRelationAction extends ActionSupport {
	private List<ECRelation> relationList;

	public List<ECRelation> getRelationList() {
		return relationList;
	}

	public void setRelationList(List<ECRelation> relationList) {
		this.relationList = relationList;
	}

	private List<ECRelationDef> relationDefList;

	public List<ECRelationDef> getRelationDefList() {
		return relationDefList;
	}

	public void setRelationDefList(List<ECRelationDef> relationDefList) {
		this.relationDefList = relationDefList;
	}

	static Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();

	private String source;

	private String target;

	private String ontname;

	private String rid;

	private Integer ecrid;

	public Integer getEcrid() {
		return ecrid;
	}

	public void setEcrid(Integer ecrid) {
		this.ecrid = ecrid;
	}

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getOntname() {
		return ontname;
	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	private String inputStr;

	public String getInputStr() {
		return inputStr;
	}

	public void setInputStr(String inputStr) {
		this.inputStr = inputStr;
	}

	@Inject
	@Named("ECRelationService")
	private ECRelationService ecrelationService;

	@Inject
	@Named("GlobalMongoService")
	private GlobalMongoService globalMongoService;

	@Inject
	@Named("OntService")
	private OntService ontService;

	public String queryList() {
		try {
			if (ontname == null || ontname == "")
				this.ontname = ontService.findall().get(0).getName();
			this.relationList = ecrelationService.queryECRelation(ontname);

			this.relationDefList = ecrelationService.queryECRelationDef();

			HttpServletRequest request = ServletActionContext.getRequest();
			HttpServletResponse response = ServletActionContext.getResponse();
			request.getRequestDispatcher("/pages/admin/ecr.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return SUCCESS;
	}

	public String deleteECRelation() {
		ecrelationService.deleteECRelation(ecrid);
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		try {
			response.sendRedirect("ecRelationAction!queryList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}

	public String upsertECRelation() {
		ECRelation ecr = gsonTemp.fromJson(inputStr, new TypeToken<ECRelation>() {
		}.getType());
		if (ecr.getEcrid() == 0) {
			Integer ecrid = globalMongoService.getid(Global.ecrid);
			ecr.setEcrid(ecrid);
		}
		ecrelationService.upsertECRelatin(ecr);
		return SUCCESS;
	}

}
