package com.shu.eo.admin.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.shu.eo.admin.service.UserService;
import com.shu.eo.admin.user.pojo.Role;
import com.shu.eo.admin.user.pojo.User;
import com.shu.eo.admin.user.pojo.User_Role;

@Named("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	MongoTemplate mongoTemplate;
	
	public static final String userc = "user";
	public static final String rolec = "role";
	public static final String user_role = "user_role";
	
	@Override
	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		List<User> list = mongoTemplate.find(new Query(Criteria.where("username").is(username)),User.class,userc);
		if(list.isEmpty())
			return null;
		else
			return list.get(0);
	}

	@Override
	public Set<String> getRolenamesByUsername(String username) {
		// TODO Auto-generated method stub
		Set<String> resultset = new HashSet<String>();
		Integer userid = mongoTemplate.find(new Query(Criteria.where("username").is(username)), User.class, userc).get(0).getUserid();
		List<User_Role> urlist = mongoTemplate.find(new Query(Criteria.where("userid").is(userid)),User_Role.class,user_role);
		for(User_Role u_r:urlist){
			resultset.add(mongoTemplate.find(new Query(Criteria.where("roleid").is(u_r.getRoleid())), Role.class,rolec).get(0).getRolename());
		}
		
		return resultset;
	}

	@Override
	public Set<String> getPernamesByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
