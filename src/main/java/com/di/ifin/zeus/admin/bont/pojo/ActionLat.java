package com.di.ifin.zeus.admin.bont.pojo;

public class ActionLat {
	/* private String actionsid; */
	private String ontname;
	private String evelatname;
	private String degree;
	private String tool;
	private String method;

	/*
	 * public String getActionsid() { return this.actionsid; }
	 * 
	 * public void setId(String actionsid) { this.actionsid = actionsid; }
	 */

	public String getOntname() {
		return ontname;
	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getTool() {
		return this.tool;
	}

	public void setTool(String tool) {
		this.tool = tool;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getEvelatname() {
		return evelatname;
	}

	public void setEvelatname(String evelatname) {
		this.evelatname = evelatname;
	}

	public ActionLat() {

	}

	public ActionLat(String ontname, String latname, String degree, String tool, String method) {
		this.ontname = ontname;
		this.evelatname = latname;
		this.degree = degree;
		this.tool = tool;
		this.method = method;
	}
}
