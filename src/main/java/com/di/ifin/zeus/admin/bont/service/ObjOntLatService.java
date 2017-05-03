package com.di.ifin.zeus.admin.bont.service;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.ObjOntLat;

public interface ObjOntLatService {
	List<ObjOntLat> queryAllObjOntLatList();

	ObjOntLat queryObjOntLatByOid(Long oid);

	void createObjOntLat(ObjOntLat objOntLat);

	void removeObjOntLat(List oidList);

	void updateObjOntLat(ObjOntLat objOntLat);

	boolean checkLatSid(String latSid);

	boolean checkLatName(String latName);

	ObjOntLat queryObjOntLatByLatName(String latName);

	ObjOntLat queryObjOntLatByLatSid(String latSid);

	List<ObjOntLat> queryObjOntLatSonByLatSid(String latSid);

	void removeParAndSonByLatSid(String latSid);

}
