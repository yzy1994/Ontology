package com.di.ifin.zeus.admin.bont.pojo;

public class OntLatWithOntName extends OntLat {
	private String ontname;

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	public String getOntname() {
		return this.ontname;
	}

	public OntLatWithOntName(){
		super();
	}
	
	public OntLatWithOntName(String latsid, String latname, String parentlatname, String latnote, String ontname) {
		this.setLatsid(latsid);
		this.setLatname(latname);
		this.setParentlatname(parentlatname);
		this.setLatnote(latnote);
		this.ontname=ontname;
	}
}
