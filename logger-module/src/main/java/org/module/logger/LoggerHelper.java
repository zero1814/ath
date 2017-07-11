package org.module.logger;

import org.module.annotation.commons.Inject;
import org.module.helper.commons.LoggerBaseHelper;
import org.module.helper.commons.WebHelper;
import org.module.model.logger.user.LmLogin;
import org.module.service.logger.user.ILmLoginService;
import org.module.util.DateUtil;

public class LoggerHelper extends LoggerBaseHelper {

	private static LoggerHelper self;

	public static LoggerHelper instance() {
		if (self == null) {
			self = new LoggerHelper();
		}
		return self;
	}

	@Inject
	private ILmLoginService loginService;

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 添加登录日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月11日 上午9:16:17
	 * 
	 * @param userCode
	 */
	public void login(String userCode) {
		LmLogin entity = new LmLogin();
		entity.setUserCode(userCode);
		entity.setIp(WebHelper.getIpAddress());
		entity.setLoginTime(DateUtil.getSysDateTime());
		loginService.insertSelective(entity);
	}

}
