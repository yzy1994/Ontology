package edu.shu.skytorif.mapper;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.PeoOntLat;


public interface PeoOntLatMapper {

	List<PeoOntLat> queryAllOntLatList();

	PeoOntLat queryOntLatByOid(Long oid);

	PeoOntLat queryOntLatByLatSid(String latSid);

	PeoOntLat queryOntLatByLatName(String latName);

	void createOntLat(PeoOntLat objOntLat);

	void removeOntLat(Long oid);

	void updateOntLat(PeoOntLat objOntLat);

	List<PeoOntLat> queryOntLatSonByLatSid(String latSid);

	void removeOntLatByLatSid(String latSid);
}
