package org.module.helper.commons;

import java.util.UUID;

import org.module.annotation.commons.Inject;
import org.module.mapper.logger.user.LmLoginMapper;
import org.module.model.logger.user.LmLogin;
import org.module.util.DateUtil;

/**
 * 
 * 类: LogHelper <br>
 * 描述: 日志帮助类 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月26日 下午2:15:06
 */
public class LoggerHelper extends LoggerBaseHelper {

	@Inject
	private LmLoginMapper loginMapper;

	private static LoggerHelper self;

	public static LoggerHelper instance() {
		if (self == null) {
			self = new LoggerHelper();
		}
		return self;
	}

	public void login(String userCode) {
		LmLogin entity = new LmLogin();
		entity.setUid(UUID.randomUUID().toString().replace("-", ""));
		entity.setUserCode(userCode);
		entity.setIp(WebHelper.getIpAddress());
		entity.setLoginTime(DateUtil.getSysDateTime());
		loginMapper.insertSelective(entity);
	}
}
