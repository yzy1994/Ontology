package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.di.ifin.zeus.admin.bont.pojo.ActionLat;
import com.di.ifin.zeus.admin.bont.service.ActionElementService;
import com.shu.global.Global;

@Named("ActionElementService")
public class ActionElementServiceImpl implements ActionElementService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public static String collectionName = Global.actionelement;
	
	@Override
	public ActionLat query(String evelatname,String ontname) {
		// TODO Auto-generated method stub
		Criteria c= Criteria.where("evelatname").is(evelatname).andOperator(Criteria.where("ontname").is(ontname));
		List<ActionLat> list = mongoTemplate.find(new Query(c), ActionLat.class, collectionName);
		if(list.size()!=0){
			return list.get(0);
		}else
			return null;
	}

	@Override
	public String upsert(ActionLat actionLat) {
		Criteria c= Criteria.where("evelatname").is(actionLat.getEvelatname()).andOperator(Criteria.where("ontname").is(actionLat.getOntname()));
		mongoTemplate.remove(new Query(c), collectionName);
		mongoTemplate.insert(actionLat, collectionName);
		return "suc";
	}

	@Override
	public String remove(String ontname, String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("evelatname").is(evelatname).andOperator(Criteria.where("ontname").is(ontname));
		mongoTemplate.remove(new Query(c), collectionName);
		return "";
	}
	
}
