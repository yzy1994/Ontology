package com.di.ifin.zeus.admin.bont.pojo;

public class Link {
	private String source;
	private String target;
	private String value;
	private String [] symbol;
	private Integer [] symbolSize;

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Link() {

	}

	public Link(ECRelation ecr) {
		this.source = ecr.getSource();
		this.target = ecr.getTarget();
		this.value = ecr.getRid();
	}

	public String [] getSymbol() {
		return symbol;
	}

	public void setSymbol(String [] symbol) {
		this.symbol = symbol;
	}

	public Integer [] getSymbolSize() {
		return symbolSize;
	}

	public void setSymbolSize(Integer [] symbolSize) {
		this.symbolSize = symbolSize;
	}

}
