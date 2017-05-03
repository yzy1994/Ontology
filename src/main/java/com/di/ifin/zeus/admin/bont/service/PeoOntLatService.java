package com.di.ifin.zeus.admin.bont.service;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.PeoOntLat;

public interface PeoOntLatService {
	List<PeoOntLat> queryAllOntLatList();

	boolean checkLatSid(String latSid);

	boolean checkLatName(String latName);
	
	void createOntLat(PeoOntLat peoOntLat);

	void updateOntLat(PeoOntLat peoOntLat);
}
