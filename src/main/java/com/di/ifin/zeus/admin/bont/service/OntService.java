package com.di.ifin.zeus.admin.bont.service;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.OntInfo;

public interface OntService {
	public List<OntInfo> findall();

	public boolean findByName(String ontname);
	
	public String delOntByName(String ontname);

	public void addOnt(OntInfo ontinfo);
	
	public OntInfo findInfoByName(String ontname);
}
