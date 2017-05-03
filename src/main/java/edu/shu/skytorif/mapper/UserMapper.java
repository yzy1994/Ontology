package edu.shu.skytorif.mapper;

import java.util.Set;

import edu.shu.skytorif.pojo.User;

public interface UserMapper {

	public User getUserByUsername(String username) throws Exception;
	
	public Set<String> getRolenamesByUsername(String username) throws Exception;
	
	public Set<String> getPernamesByUsername(String username) throws Exception;
}
