package com.di.ifin.zeus.admin.bont.pojo;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class MonEveOntLat {
	private String latsid;

	private String latname;

	private String parentsid;

	private String latnote;

	public MonEveOntLat(String latsid, String latname, String parentsid, String latnote) {
		this.latsid = latsid;
		this.latname = latname;
		this.parentsid = parentsid;
		this.latnote = latnote;
	}

	public void setLatsid(String latsid) {
		this.latsid = latsid;
	}

	public String getLatsid() {
		return this.latsid;
	}

	public void setLatname(String latname) {
		this.latname = latname;
	}

	public String getLatname() {
		return this.latname;
	}

	public void setParentsid(String parentsid) {
		this.parentsid = parentsid;
	}

	public String getParentsid() {
		return this.parentsid;
	}

	public void setLatnote(String latnote) {
		this.latnote = latnote;
	}

	public String getLatnote() {
		return this.latnote;
	}

	public String toString() {
		String result = latsid + " " + latname + " " + parentsid + " " + latnote;
		return result;
	}
}
