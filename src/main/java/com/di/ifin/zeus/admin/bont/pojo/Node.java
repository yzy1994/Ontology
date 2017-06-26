package com.di.ifin.zeus.admin.bont.pojo;

public class Node {
	private String name;

	private Integer[] symbolSize;
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Node(String name) {
		this.name = name;
		Integer[] i = new Integer[2];
		i[0] = name.length() * 12 + 28;
		i[1] = 28;
		this.setSymbolSize(i);
	}

	public boolean equals(Object node) {

		return true;
	}

	public Integer[] getSymbolSize() {
		return symbolSize;
	}

	public void setSymbolSize(Integer[] symbolSize) {
		this.symbolSize = symbolSize;
	}

}
