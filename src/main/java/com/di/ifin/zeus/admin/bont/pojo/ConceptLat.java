package com.di.ifin.zeus.admin.bont.pojo;

public class ConceptLat {
	
	private String latname;

	private String parentlatname;
	
	private Integer x;

	/*public void setLatsid(String latsid) {
		this.latsid = latsid;
	}

	public String getLatsid() {
		return this.latsid;
	}*/
	
	public void setLatname(String latname) {
		this.latname = latname;
	}

	public String getLatname() {
		return this.latname;
	}


	public String toString() {
		String result = latname + " " + parentlatname;
		return result;
	}

	public String getParentlatname() {
		return parentlatname;
	}

	public void setParentlatname(String parentlatname) {
		this.parentlatname = parentlatname;
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}
}
