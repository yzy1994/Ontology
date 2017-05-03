package com.di.ifin.zeus.admin.bont.pojo;

public class ObjLat {
	private String objsid; // 唯一

	private String ontname;

	private String evelatname;
	
	private String objname;

	private String amount;

	private String conceptlatname;

	private String lane;

	public String getObjsid() {
		return objsid;
	}

	public void setObjsid(String objsid) {
		this.objsid = objsid;
	}

	public String getOntname() {
		return ontname;
	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getLane() {
		return lane;
	}

	public void setLane(String lane) {
		this.lane = lane;
	}

	public String getObjname() {
		return objname;
	}

	public void setObjname(String objname) {
		this.objname = objname;
	}

	public String getEvelatname() {
		return evelatname;
	}

	public void setEvelatname(String evelatname) {
		this.evelatname = evelatname;
	}

	public String getConceptlatname() {
		return conceptlatname;
	}

	public void setConceptlatname(String conceptlatname) {
		this.conceptlatname = conceptlatname;
	}

}
