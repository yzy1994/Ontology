package edu.shu.skytorif.mapper;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.ObjOntLat;

public interface ObjOntLatMapper {

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
