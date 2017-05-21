package com.di.ifin.zeus.admin.bont.service;

import com.di.ifin.zeus.admin.bont.pojo.LanguageLat;

public interface LanguageElementService {
	public LanguageLat query(String ontname,String evelatname);
	
	public void upsert(LanguageLat languagelat);
	
	public String remove(String ontname, String evelatname);
}
