package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.di.ifin.zeus.admin.bont.pojo.ECRelationship;
import com.di.ifin.zeus.admin.bont.service.ECRelationshipService;

public class ECRelationshipServiceImpl implements ECRelationshipService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public final static String collectionName="ec_relationship"; 
	
	@Override
	public List<ECRelationship> query(String ontname, String evelatsid) {
		// TODO Auto-generated method stub
		Criteria c= Criteria.where("evelatsid").is(evelatsid).andOperator(Criteria.where("ontname").is(ontname));
		return mongoTemplate.find(new Query(c), ECRelationship.class, collectionName);
	}
	
}
