package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import com.di.ifin.zeus.admin.bont.pojo.Researcher;
import com.di.ifin.zeus.admin.bont.service.ResearcherService;
import com.shu.global.Global;

@Named("ResearcherService")
public class ResearcherServiceImpl implements ResearcherService{
	
	@Autowired
	MongoTemplate mongoTemplate;
	
	private String collectionName = Global.oresearcher;
	
	@Override
	public List<Researcher> queryAllResearcher() {
		// TODO Auto-generated method stub
		Query query = new Query();  
	    query.with(new Sort(new Order(Direction.ASC,"rid")));  
		return mongoTemplate.find( query,Researcher.class, collectionName);
		
	}
	
}
