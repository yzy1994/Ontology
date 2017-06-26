package com.di.ifin.zeus.admin.bont.pojo;

public class LanguageLat {
	private String ontname;
	private String evelatname;
	private String triggerwords;
	private String collocation;
	public String getOntname() {
		return ontname;
	}
	public void setOntname(String ontname) {
		this.ontname = ontname;
	}
	public String getTriggerwords() {
		return triggerwords;
	}
	public void setLanguage(String triggerwords) {
		this.triggerwords = triggerwords;
	}
	public String getEvelatname() {
		return evelatname;
	}
	public void setEvelatsid(String evelatname) {
		this.evelatname = evelatname;
	}
	public String getCollocation() {
		return collocation;
	}
	public void setCollocation(String collocation) {
		this.collocation = collocation;
	}
	public LanguageLat(){
		
	}
	public LanguageLat(String ontname,String latname,String triggerwords,String collocation){
		this.ontname = ontname;
		this.evelatname = latname;
		this.triggerwords = triggerwords;
		this.collocation = collocation;
	}
}
