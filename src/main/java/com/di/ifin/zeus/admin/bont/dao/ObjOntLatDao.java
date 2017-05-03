package com.di.ifin.zeus.admin.bont.dao;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.ObjOntLat;

public interface ObjOntLatDao {
	List<ObjOntLat> queryAllObjOntLatList();

	ObjOntLat queryObjOntLatByOid(Long oid);

	ObjOntLat queryObjOntLatByLatSid(String latSid);

	ObjOntLat queryObjOntLatByLatName(String latName);

	void createObjOntLat(ObjOntLat objOntLat);

	void removeObjOntLat(Long oid);

	void updateObjOntLat(ObjOntLat objOntLat);

	List<ObjOntLat> queryObjOntLatSonByLatSid(String latSid);

	void removeObjOntLatByLatSid(String latSid);
}
