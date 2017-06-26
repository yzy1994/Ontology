package com.di.ifin.zeus.admin.bont.pojo;

public class ECEditComment {
	private String ontname;
	private String latname;
	private String username;
	private String comment;

	public String getOntname() {
		return ontname;
	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	public String getLatname() {
		return latname;
	}

	public void setLatname(String latname) {
		this.latname = latname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ECEditComment() {

	}

	public ECEditComment(String ontname, String latname, String username, String comment) {
		this.ontname = ontname;
		this.latname = latname;
		this.username = username;
		this.comment = comment;
	}
}
