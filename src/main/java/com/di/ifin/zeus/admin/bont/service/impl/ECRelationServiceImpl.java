package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.BasicUpdate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import com.di.ifin.zeus.admin.bont.pojo.ECRelation;
import com.di.ifin.zeus.admin.bont.pojo.ECRelationDef;
import com.di.ifin.zeus.admin.bont.service.ECRelationService;
import com.shu.global.Global;

@Named("ECRelationService")
public class ECRelationServiceImpl implements ECRelationService {

	@Autowired
	MongoTemplate mongoTemplate;

	public static final String ec_relationship = Global.ec_relationship;

	public static final String ec_relationship_def = Global.ec_relationship_def;

	@Override
	public List<ECRelationDef> queryECRelationDef() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(ECRelationDef.class, ec_relationship_def);
	}

	@Override
	public List<ECRelation> queryECRelation(String ontname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname);
		return mongoTemplate.find(new Query(c).with(new Sort(new Order(Direction.ASC, "ecrid"))), ECRelation.class,
				ec_relationship);
	}

	@Override
	public List<ECRelation> queryECRelationByLatname(String ontname, String latname) {
		// TODO Auto-generated method stub
		Criteria c = Criteria.where("ontname").is(ontname).andOperator(Criteria.where("source").is(latname));
		return mongoTemplate.find(new Query(c), ECRelation.class, ec_relationship);
	}

	@Override
	public void deleteECRelation(Integer ecrid) {
		// TODO Auto-generated method stub
		// String q = "{ ontname : \""+ontname+"\", source : \""+source+ "\",
		// target: \""+target+"\"}";
		// BasicQuery query = new BasicQuery(q);
		Criteria c = Criteria.where("ecrid").is(ecrid);
		mongoTemplate.remove(new Query(c), ec_relationship);
	}

	@Override
	public void upsertECRelatin(ECRelation ecr) {
		// TODO Auto-generated method stub
		Query q = new Query(Criteria.where("ecrid").is((int)ecr.getEcrid()));
		if (mongoTemplate.find(q, ecr.getClass(), ec_relationship).size() == 0)
			mongoTemplate.insert(ecr, ec_relationship);
		else {
			String sbu = "{$set:{'ontname':'" + ecr.getOntname() + "','source':'" + ecr.getSource() + "','target':'"
					+ ecr.getTarget() + "','rid':'" + ecr.getRid() + "'}}";
			System.err.println(sbu);
			BasicUpdate bu = new BasicUpdate(sbu);
			mongoTemplate.updateFirst(q, bu, ec_relationship);
		}

	}

	@Override
	public void removeECRelation(ECRelation ecr) {
		// TODO Auto-generated method stub
		String q = "{ ontname : " + ecr.getOntname() + ", source : " + ecr.getSource() + ", target: " + ecr.getTarget()
				+ "}";
		BasicQuery query = new BasicQuery(q);
		mongoTemplate.remove(query, ec_relationship);
	}
}
