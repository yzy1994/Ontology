package com.di.ifin.zeus.admin.bont.service;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.ECRelationship;

public interface ECRelationshipService {
	public List<ECRelationship> query(String ontname,String evelatsid);
	
}
