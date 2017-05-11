package com.di.ifin.zeus.admin.bont.pojo;

public class Node {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Node(String name){
		this.name = name;
	}
	
	public boolean equals(Object node){
		
		return true;
	}
}
