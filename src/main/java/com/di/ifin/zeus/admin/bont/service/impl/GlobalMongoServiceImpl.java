package com.di.ifin.zeus.admin.bont.service.impl;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.di.ifin.zeus.admin.bont.pojo.GlobalMongo;
import com.di.ifin.zeus.admin.bont.service.GlobalMongoService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Named("GlobalMongoService")
public class GlobalMongoServiceImpl implements GlobalMongoService{
	@Autowired
	MongoTemplate mongoTemplate;

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();
	
	public static String collectionName="global_setting";
	
	@Override
	public Integer getid(String name) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("name").is(name);
		GlobalMongo result = mongoTemplate.findAndModify(new Query(c), new Update().inc("value",1), GlobalMongo.class, collectionName);
		return result.getValue();
	}

}
