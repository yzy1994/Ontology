package edu.shu.skytorif.realm;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.shu.eo.admin.service.UserService;
import com.shu.eo.admin.user.pojo.User;

import edu.shu.skytorif.mapper.UserMapper;

public class MyRealm extends AuthorizingRealm{

	@Autowired
	private UserMapper userMapper;
	
	@Inject
	@Named("UserService")
	private UserService userservice;
	
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		// TODO Auto-generated method stub
		String username = (String) principals.getPrimaryPrincipal();
		SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
		
		try {
			info.setRoles(userservice.getRolenamesByUsername(username));
			//info.setStringPermissions(userMapper.getPernamesByUsername(username));
			//System.out.println(userMapper.getRolenamesByUsername(username));
			//System.out.println(userMapper.getPernamesByUsername(username));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return info;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		// TODO Auto-generated method stub
		String username = (String) token.getPrincipal();
		User user = null;
		try {
			user = userservice.getUserByUsername(username);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(user == null){
			throw new UnknownAccountException();
		}
		
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user.getUsername(), user.getPassword(), "myRealm");
		return info;
	}

}
