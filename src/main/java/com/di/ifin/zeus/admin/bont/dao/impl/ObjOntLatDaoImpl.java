package com.di.ifin.zeus.admin.bont.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import com.di.ifin.zeus.admin.bont.dao.ObjOntLatDao;
import com.di.ifin.zeus.admin.bont.pojo.ObjOntLat;

@Named("objOntLatDao")
public class ObjOntLatDaoImpl  implements ObjOntLatDao {

	@SuppressWarnings("unchecked")
	public List<ObjOntLat> queryAllObjOntLatList() {
		// TODO Auto-generated method stub
		List<ObjOntLat> objOntLatList = new ArrayList<ObjOntLat>();
//		SqlMaker maker = SqlMaker.getInstance();
//		String hql = " from ObjOntLat ";
//		objOntLatList = queryByHQL(hql,
//				new QueryParam(maker.values(), maker.types()));
		return objOntLatList;
	}

	@SuppressWarnings("unchecked")
	public ObjOntLat queryObjOntLatByOid(Long oid) {
		// TODO Auto-generated method stub
		ObjOntLat objOntLat = null;
		List<ObjOntLat> objOntLatList = new ArrayList<ObjOntLat>();
//		SqlMaker maker = SqlMaker.getInstance();
//		String hql = " from ObjOntLat ";
//		hql += " where oid = " + oid + " ";
//		objOntLatList = queryByHQL(hql,
//				new QueryParam(maker.values(), maker.types()));
		if (objOntLatList.size() > 0)
			objOntLat = objOntLatList.get(0);
		return objOntLat;
	}

	@SuppressWarnings("unchecked")
	public void createObjOntLat(ObjOntLat objOntLat) {
		// TODO Auto-generated method stub
//		this.save(objOntLat);
//		this.flush();
	}

	@SuppressWarnings("unchecked")
	public void removeObjOntLat(Long oid) {
		// TODO Auto-generated method stub
//		this.removeById(ObjOntLat.class, oid);
//		this.flush();
	}

	@SuppressWarnings("unchecked")
	public void updateObjOntLat(ObjOntLat objOntLat) {
		// TODO Auto-generated method stub
//		this.update(objOntLat);
//		this.flush();
	}

	@SuppressWarnings("unchecked")
	public ObjOntLat queryObjOntLatByLatSid(String latSid) {
		// TODO Auto-generated method stub
		ObjOntLat objOntLat = null;
		List<ObjOntLat> objOntLatList = new ArrayList<ObjOntLat>();
//		SqlMaker maker = SqlMaker.getInstance();
//		String hql = " from ObjOntLat ";
//		hql += " where 1 = " + 1 + " ";
//		hql += maker.addEquals("latSid", latSid, QueryParam.Type.STRING,
//				CharCase.NONE).where();
//		objOntLatList = queryByHQL(hql,
//				new QueryParam(maker.values(), maker.types()));
		if (objOntLatList.size() > 0)
			objOntLat = objOntLatList.get(0);
		return objOntLat;
	}

	@SuppressWarnings("unchecked")
	public ObjOntLat queryObjOntLatByLatName(String latName) {
		// TODO Auto-generated method stub
		ObjOntLat objOntLat = null;
		List<ObjOntLat> objOntLatList = new ArrayList<ObjOntLat>();
//		SqlMaker maker = SqlMaker.getInstance();
//		String hql = " from ObjOntLat ";
//		hql += " where 1 = " + 1 + " ";
//		hql += maker.addEquals("latName", latName, QueryParam.Type.STRING,
//				CharCase.NONE).where();
//		objOntLatList = queryByHQL(hql,
//				new QueryParam(maker.values(), maker.types()));
		if (objOntLatList.size() > 0)
			objOntLat = objOntLatList.get(0);
		return objOntLat;
	}

	public List<ObjOntLat> queryObjOntLatSonByLatSid(String latSid) {
		// TODO Auto-generated method stub

		List<ObjOntLat> objOntLatList = new ArrayList<ObjOntLat>();
//		SqlMaker maker = SqlMaker.getInstance();
//		String hql = " from ObjOntLat ";
//		hql += " where 1 = 1";
//		hql += maker.addLike("parent_sid", latSid, CharCase.NONE).where();
//		// hql += maker.addEquals("latSid", latSid, QueryParam.Type.STRING,
//		// CharCase.NONE).where();
//		// hql += maker.addOr(maker.addLike("parent_sid", latSid,
//		// CharCase.NONE));
//		objOntLatList = queryByHQL(hql,
//				new QueryParam(maker.values(), maker.types()));
		return objOntLatList;
	}

	public void removeObjOntLatByLatSid(String latSid) {
		// TODO Auto-generated method stub
//		SqlMaker maker = SqlMaker.getInstance();
//		String hql = " delete ObjOntLat ";
//		hql += " where latSid=?";
//		maker.add(latSid);
//		QueryParam param = new QueryParam(maker);
//		executeHQL(hql, param);
	}
}
