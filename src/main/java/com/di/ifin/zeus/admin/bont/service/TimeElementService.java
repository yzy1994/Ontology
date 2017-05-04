package com.di.ifin.zeus.admin.bont.service;

import com.di.ifin.zeus.admin.bont.pojo.TimeLat;
import java.util.List;
import java.util.Map;

public interface TimeElementService {
	public TimeLat queryTimeElement(String ontname,String evelatname);
	
	public String insertTimeElement(TimeLat timelat);
	
	public String editTimeElement(TimeLat timelat);
	
	public String removeTimeElement(String ontname,String evelatname);
	
}
