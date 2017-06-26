package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.di.ifin.zeus.admin.bont.pojo.ECEditComment;
import com.di.ifin.zeus.admin.bont.service.ECEditCommentService;

@Named("ECEditCommentService")
public class ECEditCommentServiceImpl implements ECEditCommentService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	private static String collectionName = "ec_edit_comment";
	
	@Override
	public List<ECEditComment> queryCommentList(String ontname) {
		// TODO Auto-generated method stub
		return mongoTemplate.find(new Query(Criteria.where("ontname").is(ontname)), ECEditComment.class, collectionName);
	}

	@Override
	public void insertComment(ECEditComment comment) {
		// TODO Auto-generated method stub
		mongoTemplate.insert(comment, collectionName);
	}

}
