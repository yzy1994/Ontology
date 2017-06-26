package com.di.ifin.zeus.admin.bont.service;

import java.util.List;
import java.util.Map;

import com.di.ifin.zeus.admin.bont.pojo.OntLat;

public interface LatService {
	List<OntLat> queryall(String collection,String ontname);
	
	List<OntLat> queryall(String collection);

	String insert(String collection,OntLat object);
	
	String insert(String collection,OntLat object,Map<String,String> mapadd);
	
	void removeBySid(String collection,String ontname,String latsid);

	void updateBySid(String collection,String ontname,String latsid, Map<String, String> map, Map<String, String> mapadd);
	
	void removeByOntname(String collection,String ontname);
	
	void removeByLatname(String collection,String ontname,String latname);

	void updateByLatname(String collection,String ontname,String latname, Map<String, String> mapadd);
	
	OntLat queryByLatname(String collection,String ontname,String latname);

	void updateByLatname(String collection, String ontname, String latname, Map<String, String> map,
			Map<String, String> mapadd);
	
	boolean IsExistChildren(String collection,String ontname,String latname);
	
	void updateXByLatname(String collection, String ontname, String latname , Integer x);
}
