package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import com.di.ifin.zeus.admin.bont.pojo.EnvOntLat;
import com.di.ifin.zeus.admin.bont.pojo.EveOntLat;
import com.di.ifin.zeus.admin.bont.pojo.ObjOntLat;
import com.di.ifin.zeus.admin.bont.service.EveOntLatService;

import edu.shu.skytorif.mapper.EveOntLatMapper;

@Named("eveOntLatService")
public class EveOntLatServiceImpl implements EveOntLatService {
	@Autowired
	private EveOntLatMapper eveOntLatMapper;

	public int deleteByPrimaryKey(Integer eid) {
		return eveOntLatMapper.deleteByPrimaryKey(eid);
	}

	public int insert(EveOntLat record) {
		// TODO Auto-generated method stub
		return eveOntLatMapper.insert(record);
	}

	public int insertSelective(EveOntLat record) {
		// TODO Auto-generated method stub
		return eveOntLatMapper.insertSelective(record);
	}

	public EveOntLat selectByPrimaryKey(Integer eid) {
		// TODO Auto-generated method stub
		return eveOntLatMapper.selectByPrimaryKey(eid);
	}

	public int updateByPrimaryKeySelective(EveOntLat record) {
		// TODO Auto-generated method stub
		return eveOntLatMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(EveOntLat record) {
		// TODO Auto-generated method stub
		return eveOntLatMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(EveOntLat record) {
		// TODO Auto-generated method stub
		return eveOntLatMapper.updateByPrimaryKey(record);
	}

	public List<EveOntLat> queryAllEveOntLatList() {
		// TODO Auto-generated method stub
		return eveOntLatMapper.queryAllEveOntLatList();
	}

	public void removeParAndSonByLatSid(String latSid) {
		remove(latSid);
	}

	public void remove(String latSid) {
		eveOntLatMapper.removeObjOntLatByLatSid(latSid);
		List<EveOntLat> list = eveOntLatMapper.queryObjOntLatSonByLatSid(latSid);
		if (list.size() == 0)
			return;
		for (EveOntLat t : list)
			remove(t.getLatsid());
	}

	public void createOntLat(EveOntLat eveOntLat) {
		// TODO Auto-generated method stub
		eveOntLatMapper.createOntLat(eveOntLat);
	}

	public void updateOntLat(EveOntLat eveOntLat) {
		// TODO Auto-generated method stub
		eveOntLatMapper.updateOntLat(eveOntLat);
	}

	public boolean checkLatSid(String latSid) {
		// TODO Auto-generated method stub
		EveOntLat objOntLat = eveOntLatMapper.queryOntLatByLatSid(latSid);
		if (objOntLat != null)
			return true;
		else
			return false;
	}

	public boolean checkLatName(String latName) {
		// TODO Auto-generated method stub
		EveOntLat objOntLat = eveOntLatMapper.queryOntLatByLatName(latName);
		if (objOntLat != null)
			return true;
		else
			return false;
	}
}
