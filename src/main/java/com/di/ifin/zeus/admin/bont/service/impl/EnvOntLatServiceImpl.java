package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.di.ifin.zeus.admin.bont.pojo.EnvOntLat;
import com.di.ifin.zeus.admin.bont.pojo.ObjOntLat;
import com.di.ifin.zeus.admin.bont.service.EnvOntLatService;

import edu.shu.skytorif.mapper.EnvOntLatMapper;

@Named("envOntLatService")
public class EnvOntLatServiceImpl implements EnvOntLatService {
	@Autowired
	EnvOntLatMapper envOntLatMapper;

	public List<EnvOntLat> queryAllEnvOntLatList() {
		return envOntLatMapper.queryAllEnvOntLatList();
	}

	public void removeParAndSonByLatSid(String latSid) {
		remove(latSid);
	}

	public void remove(String latSid) {
		envOntLatMapper.removeObjOntLatByLatSid(latSid);
		List<EnvOntLat> list = envOntLatMapper.queryObjOntLatSonByLatSid(latSid);
		if (list.size() == 0)
			return;
		for (EnvOntLat t : list)
			remove(t.getLatsid());
	}

	public void createOntLat(EnvOntLat envOntLat) {
		envOntLatMapper.createOntLat(envOntLat);
	}

	public void updateOntLat(EnvOntLat envOntLat) {
		envOntLatMapper.updateOntLat(envOntLat);
	}

	public boolean checkLatSid(String latSid) {
		// TODO Auto-generated method stub
		EnvOntLat objOntLat = envOntLatMapper.queryOntLatByLatSid(latSid);
		if (objOntLat != null)
			return true;
		else
			return false;
	}

	public boolean checkLatName(String latName) {
		// TODO Auto-generated method stub
		EnvOntLat objOntLat = envOntLatMapper.queryOntLatByLatName(latName);
		if (objOntLat != null)
			return true;
		else
			return false;
	}
}
