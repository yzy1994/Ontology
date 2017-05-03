package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.di.ifin.zeus.admin.bont.pojo.Paper;
import com.di.ifin.zeus.admin.bont.service.PaperService;
import com.shu.global.Global;

@Named("PaperService")
public class PaperServiceImpl implements PaperService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	private String collectionName = Global.opaper;
	
	@Override
	public List<Paper> queryAllPaper() {
		Query query = new Query();  
	    query.with(new Sort(new Order(Direction.ASC,"pid")));
		return mongoTemplate.find(query,Paper.class, collectionName);
	}
	
}
