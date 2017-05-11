package org.module.cache.system;

import javax.annotation.Resource;

import org.module.cache.RootCache;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmUserService;
import org.springframework.stereotype.Component;


@Component
public class UserCache extends RootCache {

	@Resource
	private ISmUserService service;
	
	public SmUser getUserInfo(String userName){
		SmUser user = new SmUser();
		return user;
	}
}
