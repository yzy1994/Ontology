package com.di.ifin.zeus.admin.bont.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.di.ifin.zeus.admin.bont.dao.PaperDao;
import com.di.ifin.zeus.admin.bont.pojo.Paper;
import com.di.ifin.zeus.admin.bont.service.PaperService;

@Service("PaperService")
public class PaperServiceImpl implements PaperService{

	@Autowired
	PaperDao paperDao;
	
	@Override
	public List<Paper> queryAllPaper() {
		return paperDao.queryAllPaper();
	}
	
}
