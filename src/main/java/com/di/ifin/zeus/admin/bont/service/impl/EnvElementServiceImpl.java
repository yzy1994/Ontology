package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.di.ifin.zeus.admin.bont.pojo.EnvLat;
import com.di.ifin.zeus.admin.bont.service.EnvElementService;
import com.shu.global.Global;

@Named("EnvElementService")
public class EnvElementServiceImpl implements EnvElementService {
	@Autowired
	MongoTemplate mongoTemplate;

	private String collectionName = Global.envelement;

	@Override
	public EnvLat queryEnvLat(String ontname, String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname).andOperator(Criteria.where("evelatname").is(evelatname));
		List<EnvLat> list = mongoTemplate.find(new Query(c), EnvLat.class, collectionName);
		if (list.size() != 0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public String editEnvLat(EnvLat e) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(e.getOntname()).andOperator(Criteria.where("evelatname").is(e.getEvelatname()));
		mongoTemplate.upsert(new Query(c), new Update().set("conceptlatname", e.getConceptlatname()), collectionName);
		mongoTemplate.upsert(new Query(c), new Update().set("envlane", e.getEnvlane()), collectionName);
		return "suc";
	}

}
