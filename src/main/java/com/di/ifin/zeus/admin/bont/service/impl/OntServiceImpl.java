package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.di.ifin.zeus.admin.bont.dao.OntDao;
import com.di.ifin.zeus.admin.bont.pojo.OntInfo;
import com.di.ifin.zeus.admin.bont.service.OntService;
import com.mongodb.WriteResult;
import com.shu.global.Global;

@Named("OntService")
public class OntServiceImpl implements OntService {
	@Autowired
	private OntDao ontDao;

	public List<OntInfo> findall() {
		return ontDao.queryAll();
	}

	public String delOntByName(String ontname) {
		return ontDao.delOntByName(ontname);
	}

	public void addOnt(OntInfo ontinfo) {
		ontDao.addOnt(ontinfo);
	}

	public boolean findByName(String ontname) {
		return ontDao.isExistByName(ontname);
	}

	public OntInfo findInfoByName(String ontname) {
		return ontDao.findInfoByName(ontname);
	}

	@Override
	public void editOnt(String ontname, String field) {
		ontDao.editOnt(ontname, field);
	}
}
