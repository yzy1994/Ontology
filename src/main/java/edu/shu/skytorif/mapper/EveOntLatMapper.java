package edu.shu.skytorif.mapper;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.EveOntLat;
import com.di.ifin.zeus.admin.bont.pojo.ObjOntLat;

public interface EveOntLatMapper {
	List<EveOntLat> queryAllEveOntLatList();

	int deleteByPrimaryKey(Integer oid);

	int insert(EveOntLat record);

	int insertSelective(EveOntLat record);

	EveOntLat selectByPrimaryKey(Integer oid);

	int updateByPrimaryKeySelective(EveOntLat record);

	int updateByPrimaryKeyWithBLOBs(EveOntLat record);

	int updateByPrimaryKey(EveOntLat record);

	List<EveOntLat> queryObjOntLatSonByLatSid(String latSid);

	void removeObjOntLatByLatSid(String latSid);

	void createOntLat(EveOntLat eveOntLat);

	void updateOntLat(EveOntLat eveOntLat);

	EveOntLat queryOntLatByLatSid(String latSid);

	EveOntLat queryOntLatByLatName(String latName);
}