package com.shu.eo.admin.service;

import java.util.Set;

import com.shu.eo.admin.user.pojo.User;

public interface UserService {
	public User getUserByUsername(String username);
	
	public Set<String> getRolenamesByUsername(String username);
	
	public Set<String> getPernamesByUsername(String username);
}
