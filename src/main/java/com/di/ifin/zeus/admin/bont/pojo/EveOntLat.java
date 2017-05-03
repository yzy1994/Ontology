package com.di.ifin.zeus.admin.bont.pojo;

public class EveOntLat {
	private Integer oid;
	private String latSid;
	private String latName;
	private String parentSid;
	private String latNote;
	private String peoElement;
	private String objElement;
	private String envElement;

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getLatsid() {
		return latSid;
	}

	public void setLatsid(String latsid) {
		this.latSid = latsid == null ? null : latsid.trim();
	}

	public String getLatname() {
		return latName;
	}

	public void setLatname(String latname) {
		this.latName = latname == null ? null : latname.trim();
	}

	public String getParentsid() {
		return parentSid;
	}

	public void setParentsid(String parentsid) {
		this.parentSid = parentsid == null ? null : parentsid.trim();
	}

	public String getLatnote() {
		return latNote;
	}

	public void setLatnote(String latnote) {
		this.latNote = latnote == null ? null : latnote.trim();
	}

	public String getPeoElement() {
		return peoElement;
	}

	public void setPeoElement(String peoElement) {
		this.peoElement = peoElement;
	}

	public String getObjElement() {
		return objElement;
	}

	public void setObjElement(String objElement) {
		this.objElement = objElement;
	}

	public String getEnvElement() {
		return envElement;
	}

	public void setEnvElement(String envElement) {
		this.envElement = envElement;
	}
}
