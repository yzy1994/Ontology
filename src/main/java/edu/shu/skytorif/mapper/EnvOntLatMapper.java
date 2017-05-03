package edu.shu.skytorif.mapper;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.EnvOntLat;
import com.di.ifin.zeus.admin.bont.pojo.EveOntLat;

public interface EnvOntLatMapper {
	List<EnvOntLat> queryAllEnvOntLatList();

	int deleteByPrimaryKey(Integer oid);

	int insert(EnvOntLat record);

	int insertSelective(EnvOntLat record);

	EnvOntLat selectByPrimaryKey(Integer oid);

	int updateByPrimaryKeySelective(EnvOntLat record);

	int updateByPrimaryKey(EnvOntLat record);

	List<EnvOntLat> queryObjOntLatSonByLatSid(String latSid);

	void removeObjOntLatByLatSid(String latSid);

	void createOntLat(EnvOntLat envOntLat);

	void updateOntLat(EnvOntLat envOntLat);

	EnvOntLat queryOntLatByLatSid(String latSid);

	EnvOntLat queryOntLatByLatName(String latName);
}