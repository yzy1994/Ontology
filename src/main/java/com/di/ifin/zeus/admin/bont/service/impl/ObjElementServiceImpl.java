package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.di.ifin.zeus.admin.bont.pojo.ObjLat;
import com.di.ifin.zeus.admin.bont.service.ObjElementService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shu.global.Global;

import net.sf.json.JSONObject;

@Named("ObjElementService")
public class ObjElementServiceImpl implements ObjElementService {

	@Autowired
	MongoTemplate mongoTemplate;

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();
	
	public static String collectionName=Global.objectelement;

	@Override
	public List<ObjLat> queryObjElement(String ontname, String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname).andOperator(Criteria.where("evelatname").is(evelatname));
		return mongoTemplate.find(new Query(c), ObjLat.class, collectionName);
	}

	@Override
	public String editObjElement(ObjLat objlat) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(objlat.getOntname()).andOperator(Criteria.where("conceptlatname").is(objlat.getConceptlatname()).andOperator(Criteria.where("evelatname").is(objlat.getEvelatname())));
		mongoTemplate.remove(new Query(c), collectionName);
		mongoTemplate.insert(objlat, collectionName);
		return "suc";
	}

	@Override
	public String removeObjElement(String objsid , String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("objsid").is(objsid);
		mongoTemplate.remove(new Query(c), collectionName);
		return "suc";
	}

	@Override
	public ObjLat queryObjElementByoid(String objsid) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("objsid").is(objsid);
		List<ObjLat> list = mongoTemplate.find(new Query(c), ObjLat.class,collectionName);
		if(list.size()==0)
			return null;
		else
			return list.get(0);
	}

	@Override
	public String delObjElement(String evelatname, String ontname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("evelatname").is(evelatname).andOperator(Criteria.where("ontname").is(ontname));
		mongoTemplate.remove(new Query(c), collectionName);
		return "suc";
	}

	@Override
	public String removeObjElement(String objsid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeAll(String ontname, String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("evelatname").is(evelatname).andOperator(Criteria.where("ontname").is(ontname));
		mongoTemplate.remove(new Query(c),collectionName);
		return null;
	}


}
