package com.di.ifin.zeus.admin.bont.service;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.ObjLat;

public interface ObjElementService {
	public List<ObjLat> queryObjElement(String ontname,String evelatname);
	
	public String editObjElement(ObjLat objlat);
	
	public String removeObjElement(String objsid);
	
	public ObjLat queryObjElementByoid(String objsid);
	
	public String delObjElement(String evelatname,String ontname);

	String removeObjElement(String objsid, String evelatname);
}
