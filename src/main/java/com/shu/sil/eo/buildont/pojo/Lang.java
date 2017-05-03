package com.shu.sil.eo.buildont.pojo;

public class Lang {
	private Long id;
	private String langtype;//语言表现类型
	private String arg1;//参数1
	private String arg1value;//属性值1
	private String  arg2;//参数2
	private String  arg2value;//属性值2
	private String  note;//备注
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLangtype() {
		return langtype;
	}
	public void setLangtype(String langtype) {
		this.langtype = langtype;
	}
	public String getArg1() {
		return arg1;
	}
	public void setArg1(String arg1) {
		this.arg1 = arg1;
	}
	public String getArg1value() {
		return arg1value;
	}
	public void setArg1value(String arg1value) {
		this.arg1value = arg1value;
	}
	public String getArg2() {
		return arg2;
	}
	public void setArg2(String arg2) {
		this.arg2 = arg2;
	}
	public String getArg2value() {
		return arg2value;
	}
	public void setArg2value(String arg2value) {
		this.arg2value = arg2value;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	
}
