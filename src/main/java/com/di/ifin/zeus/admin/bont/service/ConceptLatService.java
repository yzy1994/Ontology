package com.di.ifin.zeus.admin.bont.service;

import java.util.List;
import java.util.Map;

import com.di.ifin.zeus.admin.bont.pojo.ConceptLat;

public interface ConceptLatService {
	public String upsert(String latname, Map<String,String> mapadd);

	public String delete(String latname);
	
	public List<ConceptLat> queryAll();
	
	public boolean IsExists(String latname);
	
	public boolean IsExistsChildNode(String latname);
}