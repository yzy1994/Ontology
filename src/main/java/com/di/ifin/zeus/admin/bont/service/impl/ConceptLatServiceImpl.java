package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.di.ifin.zeus.admin.bont.pojo.ConceptLat;
import com.di.ifin.zeus.admin.bont.service.ConceptLatService;
import com.shu.global.Global;

@Named("ConceptLatService")
public class ConceptLatServiceImpl implements ConceptLatService {

	@Autowired
	MongoTemplate mongoTemplate;

	public static String collectionName = Global.concept;

	@Override
	public String delete(String latname) {
		mongoTemplate.remove(new Query(Criteria.where("latname").is(latname)), collectionName);
		return "suc";
	}

	@Override
	public List<ConceptLat> queryAll() {
		return mongoTemplate.findAll(ConceptLat.class, collectionName);
	}

	@Override
	public String upsert(String latname, Map<String, String> map) {
		Criteria c = Criteria.where("latname").is(latname);
		for (Entry<String, String> entry : map.entrySet()) {
			mongoTemplate.upsert(new Query(c), new Update().set(entry.getKey(), entry.getValue()), collectionName);
		}
		return null;
	}

	@Override
	public boolean IsExists(String latname) {
		// TODO Auto-generated method stub
		List<ConceptLat> list = mongoTemplate.find(new Query(Criteria.where("latname").is(latname)), ConceptLat.class);
		if (list.size() == 0)
			return false;
		else
			return true;
	}

	@Override
	public boolean IsExistsChildNode(String latname) {
		// TODO Auto-generated method stub
		List<ConceptLat> list = this.queryAll();
		for (ConceptLat c : list) {
			String[] ap = c.getParentlatname().split(",");
			for (String s : ap) {
				if (s.equals(latname))
					return true;
			}
		}
		return false;
	}

	@Override
	public void UpdateXByLatname(String latname, Integer x) {
		// TODO Auto-generated method stub
		mongoTemplate.updateFirst(new Query(Criteria.where("latname").is(latname)), new Update().set("x", x), collectionName);
	}

}
