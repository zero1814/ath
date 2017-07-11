package org.module.factory.system;

import org.module.annotation.commons.Inject;
import org.module.base.BaseClass;
import org.module.result.EntityResult;
import org.module.service.system.user.ISmUserService;

public class UserFactory extends BaseClass {

	private static UserFactory self;

	public static UserFactory instance() {
		if (self == null) {
			self = new UserFactory();
		}
		return self;
	}

	@Inject
	private ISmUserService service;

	public EntityResult login(String userName, String password) {
		return service.login(userName, password);
	}
}
