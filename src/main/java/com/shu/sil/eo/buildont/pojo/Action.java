package com.shu.sil.eo.buildont.pojo;

public class Action {
	private Long id;
	private Long aecfn;// 动作流程号
	private String ecn;// 事件类名
	private String aecrn;// 动作事件组号
	private String aecrnType;// 动作事件组类型
	private String note;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getAecfn() {
		return aecfn;
	}
	public void setAecfn(Long aecfn) {
		this.aecfn = aecfn;
	}
	public String getEcn() {
		return ecn;
	}
	public void setEcn(String ecn) {
		this.ecn = ecn;
	}

	public String getAecrn() {
		return aecrn;
	}
	public void setAecrn(String aecrn) {
		this.aecrn = aecrn;
	}
	public String getAecrnType() {
		return aecrnType;
	}
	public void setAecrnType(String aecrnType) {
		this.aecrnType = aecrnType;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
