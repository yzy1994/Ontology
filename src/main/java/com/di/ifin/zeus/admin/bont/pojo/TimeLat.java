package com.di.ifin.zeus.admin.bont.pojo;

public class TimeLat {
	private String ontname;

	private String evelatname;

	private String start;

	private String length;

	public TimeLat(String ontname, String evelatname, String start, String length) {
		this.ontname = ontname;
		this.evelatname = evelatname;
		this.start = start;
		this.length = length;
	}

	public TimeLat() {

	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	public String getOntname() {
		return this.ontname;
	}

	public void setStart(String start) {
		this.start = start;
	}

	public String getStart() {
		return this.start;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getLength() {
		return this.length;
	}

	public String toString() {
		String result = ontname + " " + evelatname + " " + start + " " + length;
		return result;
	}

	public String getEvelatname() {
		return evelatname;
	}

	public void setEvelatname(String evelatname) {
		this.evelatname = evelatname;
	}
	
}
