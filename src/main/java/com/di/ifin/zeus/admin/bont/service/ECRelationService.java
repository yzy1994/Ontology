package com.di.ifin.zeus.admin.bont.service;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.ECRelationDef;

import com.di.ifin.zeus.admin.bont.pojo.ECRelation;

public interface ECRelationService {
	public List<ECRelationDef> queryECRelationDef();
	
	public List<ECRelation> queryECRelation(String ontname);
	
	public List<ECRelation> queryECRelationByLatname(String ontname,String latname);
	
	public void deleteECRelation(Integer ecrid);
	
	public void upsertECRelatin(ECRelation ecr);
	
	public void removeECRelation(ECRelation ecr);
}
