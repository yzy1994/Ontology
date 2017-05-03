package com.di.ifin.zeus.admin.bont.service;

import com.di.ifin.zeus.admin.bont.pojo.ActionLat;

public interface ActionElementService {
	public ActionLat query(String evelatname,String ontname);
	
	public String upsert(ActionLat actionLat);
	
}
