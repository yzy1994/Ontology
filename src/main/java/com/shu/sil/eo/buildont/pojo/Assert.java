package com.shu.sil.eo.buildont.pojo;

public class Assert {
	private Long id;
	private String atype;// 断言类型
	private String eon;// 角色号
	private String ecn;// 事件类名
	private String state;// 角色状态
	private String note;// 备注
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAtype() {
		return atype;
	}
	public void setAtype(String atype) {
		this.atype = atype;
	}
	public String getEon() {
		return eon;
	}
	public void setEon(String eon) {
		this.eon = eon;
	}
	public String getEcn() {
		return ecn;
	}
	public void setEcn(String ecn) {
		this.ecn = ecn;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
