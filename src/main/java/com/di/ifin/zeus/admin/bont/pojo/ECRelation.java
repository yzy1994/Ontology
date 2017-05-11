package com.di.ifin.zeus.admin.bont.pojo;

public class ECRelation {
	private Integer ecrid;
	private String rid;
	private String source;
	private String target;
	private String ontname;

	public ECRelation(){};
	
	public ECRelation(String rid,String source,String target,String ontname){
		this.rid=rid;
		this.source=source;
		this.target=target;
		this.ontname=ontname;
	};
	
	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getOntname() {
		return ontname;
	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	public Integer getEcrid() {
		return ecrid;
	}

	public void setEcrid(Integer ecrid) {
		this.ecrid = ecrid;
	}

}
