package com.di.ifin.zeus.admin.bont.pojo;

public class OntLat {
	private String ontname;

	private String latsid;

	private String latname;

	/* private String parentsid; */

	private String parentlatname;

	private String latnote;
	
	private Integer x;
	
	public OntLat() {

	}

	public void setLatname(String latname) {
		this.latname = latname;
	}

	public String getLatname() {
		return this.latname;
	}

	public void setLatnote(String latnote) {
		this.latnote = latnote;
	}

	public String getLatnote() {
		return this.latnote;
	}

	public String getParentlatname() {
		return parentlatname;
	}

	public void setParentlatname(String parentlatname) {
		this.parentlatname = parentlatname;
	}

	public String getOntname() {
		return ontname;
	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	public String getLatsid() {
		return latsid;
	}

	public void setLatsid(String latsid) {
		this.latsid = latsid;
	}

	public String toString() {
		String result = latname + " " + latname + " " + parentlatname + " " + latnote;
		return result;
	}
	
	public OntLat(String ontname,String latsid ,String latname, String parentlatname, String latnote) {
		this.setOntname(ontname);
		this.setLatsid(latsid);
		this.setLatname(parentlatname);
		this.setParentlatname(parentlatname);
		this.setLatnote(latnote);
	}

	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
		this.x = x;
	}


}
