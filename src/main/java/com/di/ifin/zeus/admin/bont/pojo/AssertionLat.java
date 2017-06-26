package com.di.ifin.zeus.admin.bont.pojo;

public class AssertionLat {
	private String ontname;
	private String evelatname;
	private String prestate;
	private String massert;
	private String poststate;

	public String getOntname() {
		return ontname;
	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}


	public String getPrestate() {
		return prestate;
	}

	public void setPrestate(String prestate) {
		this.prestate = prestate;
	}

	public String getMassert() {
		return massert;
	}

	public void setMassert(String massert) {
		this.massert = massert;
	}

	public String getPoststate() {
		return poststate;
	}

	public void setPoststate(String poststate) {
		this.poststate = poststate;
	}

	public String getEvelatname() {
		return evelatname;
	}

	public void setEvelatname(String evelatname) {
		this.evelatname = evelatname;
	}
	
	public AssertionLat(){
		
	}
	
	public AssertionLat(String ontname,String latname,String prestate,String massert,String poststate){
		this.ontname = ontname;
		this.evelatname = latname;
		this.prestate = prestate;
		this.massert = massert;
		this.poststate = poststate;
	}
}
