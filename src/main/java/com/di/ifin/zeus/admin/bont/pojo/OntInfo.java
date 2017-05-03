package com.di.ifin.zeus.admin.bont.pojo;

public class OntInfo {
	private String name;
	private String field;
	private String element;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getElement() {
		return element;
	}

	public void setElement(String element) {
		this.element = element;
	}

	public String toString() {
		return name + " " + field + " " + element;
	}
}
