package com.di.ifin.zeus.admin.bont.pojo;

public class EnvOntLat {
	private Integer oid;
	private String latSid;
	private String latName;
	private String parentSid;
	private String latNote;

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
}