package com.di.ifin.zeus.admin.bont.service;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.EnvOntLat;

public interface EnvOntLatService {
	List<EnvOntLat> queryAllEnvOntLatList();

	void removeParAndSonByLatSid(String latSid);

	void createOntLat(EnvOntLat envOntLat);

	void updateOntLat(EnvOntLat envOntLat);

	boolean checkLatSid(String latSid);

	boolean checkLatName(String latName);
}
