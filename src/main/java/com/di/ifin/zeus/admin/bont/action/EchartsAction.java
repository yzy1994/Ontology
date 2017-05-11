package com.di.ifin.zeus.admin.bont.action;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;

import com.di.ifin.zeus.admin.bont.pojo.ECRelation;
import com.di.ifin.zeus.admin.bont.pojo.ECRelationDef;
import com.di.ifin.zeus.admin.bont.pojo.Link;
import com.di.ifin.zeus.admin.bont.pojo.Node;
import com.di.ifin.zeus.admin.bont.service.ECRelationService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

@Controller("echartsAction")
public class EchartsAction extends ActionSupport {
	private String resultStr;

	private String links;

	private String nodes;

	private String inputStr;

	public String getResultStr() {
		return resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

	public String getLinks() {
		return links;
	}

	public void setLinks(String links) {
		this.links = links;
	}

	public String getNodes() {
		return nodes;
	}

	public void setNodes(String nodes) {
		this.nodes = nodes;
	}

	public String getInputStr() {
		return inputStr;
	}

	public void setInputStr(String inputStr) {
		this.inputStr = inputStr;
	}

	@Inject
	@Named("ECRelationService")
	private ECRelationService ecrelationService;

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();

	public String getChartData() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");

		List<ECRelationDef> list1 = ecrelationService.queryECRelationDef();
		if (list1.size() != 0) {
			this.setResultStr(gsonTemp.toJson(list1));
		} else {
			this.setResultStr("");
		}

		List<ECRelation> list2 = ecrelationService.queryECRelation(ontname);
		List<Link> resultlist = OntLatUtil.toLinkList(list2, list1);
		if (resultlist.size() != 0) {
			this.setLinks(gsonTemp.toJson(resultlist));
		} else {
			this.setLinks("[]");
		}
		if (list2.size() != 0) {
			List<String> nodelist = new ArrayList<String>();
			for (ECRelation ecr : list2) {
				if (!nodelist.contains(ecr.getSource()))
					nodelist.add(ecr.getSource());
				if (!nodelist.contains(ecr.getTarget()))
					nodelist.add(ecr.getTarget());
			}

			List<Node> list3 = new ArrayList<Node>();
			for (String s : nodelist) {
				list3.add(new Node(s));
			}
			this.setNodes(gsonTemp.toJson(list3));
		} else {
			this.setNodes("[]");
		}
		return SUCCESS;
	}

	public String queryECR() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String latname = json.getString("latname");
		List<ECRelationDef> list1 = ecrelationService.queryECRelationDef();
		if (list1.size() != 0) {
			this.setResultStr(gsonTemp.toJson(list1));
		} else {
			this.setResultStr("");
		}
		List<ECRelation> list2 = ecrelationService.queryECRelationByLatname(ontname, latname);
		List<Link> resultlist = OntLatUtil.toLinkList(list2, list1);
		if (list2.size() == 0) {
			this.setNodes("[]");
			this.setLinks("[]");
		} else {
			this.setLinks(gsonTemp.toJson(resultlist));
			List<String> nodelist = new ArrayList<String>();
			for (ECRelation ecr : list2) {
				if (!nodelist.contains(ecr.getSource()))
					nodelist.add(ecr.getSource());
				if (!nodelist.contains(ecr.getTarget()))
					nodelist.add(ecr.getTarget());
			}

			List<Node> list3 = new ArrayList<Node>();
			for (String s : nodelist) {
				list3.add(new Node(s));
			}
			this.setNodes(gsonTemp.toJson(list3));
		}

		return SUCCESS;
	}

}
