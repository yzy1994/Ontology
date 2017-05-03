package com.di.ifin.zeus.admin.bont.action;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.struts2.ServletActionContext;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.springframework.stereotype.Controller;

import com.di.ifin.zeus.admin.bont.pojo.OntInfo;
import com.di.ifin.zeus.admin.bont.service.LatService;
import com.di.ifin.zeus.admin.bont.service.OntService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;

@Controller("mainOntAction")
public class MainOntAction extends ActionSupport {
	private String inputStr;

	public void setInputStr(String inputStr) {
		this.inputStr = inputStr;
	}

	public String getInputStr() {
		return this.inputStr;
	}

	private String resultStr;

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

	public String getResultStr() {
		return this.resultStr;
	}

	private String msgStr;

	public void setMsgStr(String msgStr) {
		this.msgStr = msgStr;
	}

	public String getMsgStr() {
		return this.msgStr;
	}

	@Inject
	@Named("OntService")
	OntService ontservice;

	@Inject
	@Named("LatService")
	private LatService latservice;

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();

	private String ontname;

	public String getOntname() {
		return this.ontname;
	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	private File file;

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	private String uploadContentType;

	public void setUploadContentType(String uploadContentType) {
		this.uploadContentType = uploadContentType;
	}

	public String getUploadContentType() {
		return this.uploadContentType;
	}

	private String uploadFileName;

	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public String getUploadFileName() {
		return this.uploadFileName;
	}

	public String queryOntInfo() {
		List<OntInfo> list = ontservice.findall();
		resultStr = gsonTemp.toJson(list);
		return SUCCESS;
	}

	public String queryOntInfoByName() {
		String ontname = inputStr;
		resultStr = gsonTemp.toJson(ontservice.findInfoByName(ontname));
		return SUCCESS;
	}

	public String delOnt() {
		latservice.removeByOntname("eve_ont_lat", this.ontname);
		latservice.removeByOntname("peo_ont_lat", this.ontname);
		latservice.removeByOntname("obj_ont_lat", this.ontname);
		latservice.removeByOntname("env_ont_lat", this.ontname);
		msgStr = ontservice.delOntByName(this.ontname);
		return SUCCESS;
	}

	public String addOnt() {
		OntInfo ontinfo = gsonTemp.fromJson(inputStr, new TypeToken<OntInfo>() {
		}.getType());
		if (ontservice.findByName(ontinfo.getName()) == true) {
			resultStr = "existed";
			return SUCCESS;
		}
		System.out.println(ontinfo.toString());
		ontservice.addOnt(ontinfo);
		resultStr = "success";
		return SUCCESS;
	}

	public String importOnt() {
		String path = ServletActionContext.getRequest().getRealPath("/upload");
		SAXBuilder builder = new SAXBuilder();
		try {
			Document doc = builder.build(file);
			Element root = doc.getRootElement();
			Element eontinfo = root.getChild("OntInfo");
			OntInfo ontinfo =new OntInfo();
			String ontname = eontinfo.getChild("name").getText();
			ontinfo.setElement(eontinfo.getChild("element").getText());
			ontinfo.setField(eontinfo.getChild("field").getText());
			ontinfo.setName(eontinfo.getChild("name").getText());
			ontservice.addOnt(ontinfo);
			
			OntLatUtil.importLats(root.getChild("Eve_Lats"), latservice, "eve_ont_lat");
			Element elements =root.getChild("elements");
			OntLatUtil.importLats(root.getChild("Peo_Lats"), latservice, "peo_ont_lat");
			OntLatUtil.importLats(root.getChild("Env_Lats"), latservice, "env_ont_lat");
			OntLatUtil.importLats(root.getChild("Obj_Lats"), latservice, "obj_ont_lat");
			
		} catch (JDOMException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}