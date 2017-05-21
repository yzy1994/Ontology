package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.di.ifin.zeus.admin.bont.pojo.LanguageLat;
import com.di.ifin.zeus.admin.bont.service.LanguageElementService;
import com.shu.global.Global;

@Named("LanguageElementService")
public class LanguageElementServiceImpl implements LanguageElementService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public static String collectionName = Global.languageelement;

	@Override
	public LanguageLat query(String ontname, String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname).andOperator(Criteria.where("evelatname").is(evelatname));
		List<LanguageLat> list =  mongoTemplate.find(new Query(c), LanguageLat.class,collectionName);
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	@Override
	public void upsert(LanguageLat languagelat) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(languagelat.getOntname()).andOperator(Criteria.where("evelatname").is(languagelat.getEvelatname()));
		mongoTemplate.remove(new Query(c), collectionName);
		mongoTemplate.insert(languagelat, collectionName);
	}

	@Override
	public String remove(String ontname, String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("evelatname").is(evelatname).andOperator(Criteria.where("ontname").is(ontname));
		mongoTemplate.remove(new Query(c),collectionName);
		return null;
	}
	
}
