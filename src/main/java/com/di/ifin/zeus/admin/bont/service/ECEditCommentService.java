package com.di.ifin.zeus.admin.bont.service;

import java.util.List;

import com.di.ifin.zeus.admin.bont.pojo.ECEditComment;

public interface ECEditCommentService {
	public List<ECEditComment> queryCommentList(String ontname);
	
	public void insertComment(ECEditComment comment);
}
