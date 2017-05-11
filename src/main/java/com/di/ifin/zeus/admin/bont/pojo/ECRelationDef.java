package com.di.ifin.zeus.admin.bont.pojo;

public class ECRelationDef {
	private String rid;
	private String rname;
	private String rdes;
	private String [] symbol;
	private Integer [] symbolSize;

	public String getRid() {
		return rid;
	}

	public void setRid(String rid) {
		this.rid = rid;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getRdes() {
		return rdes;
	}

	public void setRdes(String rdes) {
		this.rdes = rdes;
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
