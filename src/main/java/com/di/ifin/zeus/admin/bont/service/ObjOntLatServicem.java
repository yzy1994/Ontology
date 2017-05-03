package com.di.ifin.zeus.admin.bont.service;

import java.util.List;
import java.util.Map;

import com.di.ifin.zeus.admin.bont.pojo.OntLat;

public interface ObjOntLatServicem {
	List<OntLat> queryall();

	void insert(OntLat object);

	void removeBySid(String latsid);

	void updateBySid(String latsid, Map<String, String> map, Map<String, String> mapadd);
}
