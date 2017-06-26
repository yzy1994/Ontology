package com.di.ifin.zeus.admin.bont.service.impl;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.di.ifin.zeus.admin.bont.pojo.AccessRecord;
import com.di.ifin.zeus.admin.bont.service.AccessRecordService;

@Named("AccessRecordService")
public class AccessRecordServiceImpl implements AccessRecordService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public static String collectionName = "access_record";
	
	@Override
	public void insert(AccessRecord ar) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(ar, collectionName);
	}

}
