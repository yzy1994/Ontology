package com.di.ifin.zeus.admin.bont.service;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.EveOntLat;

public interface EveOntLatService {
	List<EveOntLat> queryAllEveOntLatList();
	
	void removeParAndSonByLatSid(String latSid);
	
	void createOntLat(EveOntLat envOntLat);

	void updateOntLat(EveOntLat eveOntLat);
	
	boolean checkLatSid(String latSid);

	boolean checkLatName(String latName);
}
