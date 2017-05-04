package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.di.ifin.zeus.admin.bont.pojo.TimeLat;
import com.di.ifin.zeus.admin.bont.service.TimeElementService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.shu.global.Global;

@Named("TimeElementService")
public class TimeElementServiceImpl implements TimeElementService{
	@Autowired
	MongoTemplate mongoTemplate;

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();
	
	public static String collectionName=Global.timeelement;
	
	@Override
	public TimeLat queryTimeElement(String ontname, String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname);
		c.andOperator(Criteria.where("evelatname").is(evelatname));
		List<TimeLat> list = mongoTemplate.find(new Query(c), TimeLat.class,collectionName);
		if(list.size()!=0)
			return list.get(0);
		else
			return null;
	}

	@Override
	public String insertTimeElement(TimeLat timelat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String editTimeElement(TimeLat timelat) {
		// TODO Auto-generated method stub
		TimeLat tl = this.queryTimeElement(timelat.getOntname(), timelat.getEvelatname());
		if(tl==null){
			//insert
			mongoTemplate.insert(timelat, collectionName);
			return "ins_suc";
		}else{
			Criteria c = Criteria.where("ontname").is(timelat.getOntname());
			c.andOperator(Criteria.where("evelatname").is(timelat.getEvelatname()));
			//edit
			mongoTemplate.updateFirst(new Query(c), new Update().set("start", timelat.getStart()), collectionName);
			mongoTemplate.updateFirst(new Query(c), new Update().set("length", timelat.getLength()), collectionName);
			return "edit_suc";
		}
	}

	@Override
	public String removeTimeElement(String ontname, String evelatname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname);
		c.andOperator(Criteria.where("evelatname").is(evelatname));
		mongoTemplate.remove(new Query(c), collectionName);
		return "suc";
	}
	
}
