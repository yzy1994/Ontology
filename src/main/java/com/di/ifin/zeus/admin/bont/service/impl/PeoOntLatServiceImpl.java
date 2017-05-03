package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.di.ifin.zeus.admin.bont.pojo.EnvOntLat;
import com.di.ifin.zeus.admin.bont.pojo.PeoOntLat;
import com.di.ifin.zeus.admin.bont.service.PeoOntLatService;

import edu.shu.skytorif.mapper.PeoOntLatMapper;

@Named("peoOntLatService")
public class PeoOntLatServiceImpl implements PeoOntLatService {
	@Autowired
	PeoOntLatMapper peoOntLatMapper;

	public List<PeoOntLat> queryAllOntLatList() {
		return peoOntLatMapper.queryAllOntLatList();
	}

	public boolean checkLatSid(String latSid) {
		PeoOntLat peoOntLat = peoOntLatMapper.queryOntLatByLatSid(latSid);
		if (peoOntLat != null)
			return true;
		else
			return false;
	}

	public boolean checkLatName(String latName) {
		PeoOntLat peoOntLat = peoOntLatMapper.queryOntLatByLatName(latName);
		if (peoOntLat != null)
			return true;
		else
			return false;
	}

	public void createOntLat(PeoOntLat peoOntLat) {
		peoOntLatMapper.createOntLat(peoOntLat);
	}

	public void updateOntLat(PeoOntLat peoOntLat) {
		// TODO Auto-generated method stub
		peoOntLatMapper.updateOntLat(peoOntLat);
	}

}