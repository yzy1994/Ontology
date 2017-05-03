package com.di.ifin.zeus.admin.bont.pojo;

public class ECRelationship {
	private String ontname;
	
	private String evelatsid;
	
	private String ec1;
	
	private String ec2;
	
	private String relationship;
	
	public String getOntname(){
		return this.ontname;
	}
	
	public void setOntname(String ontname){
		this.ontname=ontname;
	}
	
	public String getEvelatsid(){
		return this.evelatsid;
	}
	
	public void setEvelatsid(String evelatsid){
		this.evelatsid=evelatsid;
	}
	
	public String getEc1(){
		return this.ec1;
	}
	
	public void setEc1(String ec1){
		this.ec1=ec1;
	}
	
	public String getEc2(){
		return this.ec2;
	}
	
	public void setEc2(String ec2){
		this.ec2=ec2;
	}
	
	public String getRelationship(){
		return this.relationship;
	}
	
	public void setRelationship(String relationship){
		this.relationship=relationship;
	}
}
