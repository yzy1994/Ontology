package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.di.ifin.zeus.admin.bont.dao.ResearcherDao;
import com.di.ifin.zeus.admin.bont.pojo.Researcher;
import com.di.ifin.zeus.admin.bont.service.ResearcherService;

@Service("ResearcherService")
public class ResearcherServiceImpl implements ResearcherService{
	
	@Autowired
	ResearcherDao researcherDao;
	
	@Override
	public List<Researcher> queryAllResearcher() {
		return researcherDao.queryAllResearchers();
	}
	
}
