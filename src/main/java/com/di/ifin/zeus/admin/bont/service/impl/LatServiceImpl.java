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

import com.di.ifin.zeus.admin.bont.action.OntLatUtil;
import com.di.ifin.zeus.admin.bont.pojo.OntLat;
import com.di.ifin.zeus.admin.bont.service.LatService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@Named("LatService")
public class LatServiceImpl implements LatService {
	@Autowired
	MongoTemplate mongoTemplate;

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	public List<OntLat> queryall(String collection, String ontname) {
		// TODO Auto-generated method stub
		return mongoTemplate.find(new Query(Criteria.where("ontname").is(ontname)), OntLat.class, collection);
	}

	@Override
	public List<OntLat> queryall(String collection) {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(OntLat.class, collection);
	}

	public String insert(String collection, OntLat object) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(object, collection);
		return "suc";
	}

	public void removeBySid(String collection, String ontname, String latsid) {
		// TODO Auto-generated method stub
		Criteria criteria = Criteria.where("ontname").is(ontname);
		criteria.andOperator(Criteria.where("latsid").is(latsid), criteria);
		mongoTemplate.remove(new Query(criteria), collection);
	}

	public void updateBySid(String collection, String ontname, String latsid, Map<String, String> map,
			Map<String, String> mapadd) {
		// TODO Auto-generated method stub
		Criteria criteria = Criteria.where("ontname").is(ontname);
		criteria.andOperator(Criteria.where("latsid").is(latsid), criteria);

		Map<String, String> m = OntLatUtil.getmap(latsid, collection);
		for (Entry<String, String> entry : map.entrySet()) {
			if (!entry.getKey().startsWith("_") && !entry.getKey().equals("oid"))
				mongoTemplate.updateFirst(new Query(criteria), new Update().set(entry.getKey(), entry.getValue()),
						collection);
		}
		if (mapadd != null) {
			for (Entry<String, String> entry : mapadd.entrySet()) {
				if (!entry.getKey().startsWith("_") && !entry.getKey().equals("oid"))
					mongoTemplate.updateFirst(new Query(criteria), new Update().set(entry.getKey(), entry.getValue()),
							collection);
				m.remove(entry.getKey());
			}
		}
		m.remove("ontname");
		for (Entry<String, String> entry : m.entrySet()) {
			mongoTemplate.updateFirst(new Query(criteria), new Update().unset(entry.getKey()), collection);
		}
	}

	@Override
	public void removeByOntname(String collection, String ontname) {
		// TODO Auto-generated method stub
		mongoTemplate.remove(new Query(Criteria.where("ontname").is(ontname)), collection);
	}

	@Override
	public String insert(String collection, OntLat object, Map<String, String> mapadd) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(object, collection);
		Criteria criteria = Criteria.where("latname").is(object.getLatname());
		if (mapadd != null) {
			for (Entry<String, String> entry : mapadd.entrySet()) {
				mongoTemplate.updateFirst(new Query(criteria), new Update().set(entry.getKey(), entry.getValue()),
						collection);
			}
		}
		return "suc";
	}

	@Override
	public void removeByLatname(String collection, String ontname, String latname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname).andOperator(Criteria.where("latname").is(latname));
		mongoTemplate.remove(new Query(c), collection);
	}

	@Override
	public void updateByLatname(String collection, String ontname, String latname, Map<String, String> map,
			Map<String, String> mapadd) {
		// TODO Auto-generated method stub
		return ;
	}	

	@Override
	public List<OntLat> queryByLatname(String collection, String ontname, String latname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname).andOperator(Criteria.where("latname").is(latname));
		return mongoTemplate.find(new Query(c), OntLat.class, collection);
	}

	@Override
	public void updateByLatname(String collection, String ontname, String latname, Map<String, String> mapadd) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean IsExistChildren(String collection, String ontname, String latname) {
		// TODO Auto-generated method stub
		List<OntLat> list = this.queryall(collection, ontname);
		for(OntLat ol:list){
			String [] ap = ol.getParentlatname().split(",");
			for(String p:ap){
				if(p.equals(latname))
					return true;
			}
		}
		return false;
	}

}
