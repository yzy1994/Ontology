package com.di.ifin.zeus.admin.bont.service;

import com.di.ifin.zeus.admin.bont.pojo.AssertionLat;

public interface AssertionElementService {
	public AssertionLat query(String ontname,String evelatname);
	
	public String upsert(AssertionLat a);
	
	public String remove(String ontname,String evelatname);
}
