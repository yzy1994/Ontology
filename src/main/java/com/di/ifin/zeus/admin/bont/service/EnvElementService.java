package com.di.ifin.zeus.admin.bont.service;

import com.di.ifin.zeus.admin.bont.pojo.EnvLat;

public interface EnvElementService {
	public EnvLat queryEnvLat(String ontname,String evelatname);
	
	public String editEnvLat(EnvLat e);
	
	public String remove(String ontname, String evelatname);
}
