package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.di.ifin.zeus.admin.bont.pojo.OntInfo;
import com.di.ifin.zeus.admin.bont.service.OntService;
import com.mongodb.WriteResult;

@Named("OntService")
public class OntServiceImpl implements OntService {
	@Autowired
	private MongoTemplate mongoTemplate;

	private static String collection = "ont_info";

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<OntInfo> findall() {
		List<OntInfo> list = mongoTemplate.findAll(OntInfo.class, "ont_info");
		return list;
	}

	public String delOntByName(String ontname) {
		// TODO Auto-generated method stub
		WriteResult wr = mongoTemplate.remove(new Query(Criteria.where("name").is(ontname)), OntServiceImpl.collection);
		return wr.toString();
	}

	public void addOnt(OntInfo ontinfo) {
		mongoTemplate.insert(ontinfo, collection);
	}

	public boolean findByName(String ontname) {
		// TODO Auto-generated method stub
		return mongoTemplate.exists(new Query(Criteria.where("name").is(ontname)), collection);
	}

	public OntInfo findInfoByName(String ontname) {
		OntInfo result = mongoTemplate.find(new Query(Criteria.where("name").is(ontname)),OntInfo.class, collection).get(0);
		return result;
	}
}
