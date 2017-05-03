package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.di.ifin.zeus.admin.bont.pojo.AssertionLat;
import com.di.ifin.zeus.admin.bont.service.AssertionElementService;
import com.shu.global.Global;

@Named("AssertionElementService")
public class AssertionElementServiceImpl implements AssertionElementService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public static String collectionName = Global.assertelement;
	
	@Override
	public AssertionLat query(String ontname, String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname).andOperator(Criteria.where("evelatname").is(evelatname));
		List<AssertionLat> list = mongoTemplate.find(new Query(c), AssertionLat.class,collectionName);
		if(list.size()==0)
			return null;
		else
			return list.get(0);
	}

	@Override
	public String upsert(AssertionLat a) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(a.getOntname()).andOperator(Criteria.where("evelatname").is(a.getEvelatname()));
		mongoTemplate.remove(new Query(c), collectionName);
		mongoTemplate.insert(a, collectionName);
		return "updatesuc";
	}
	
}
