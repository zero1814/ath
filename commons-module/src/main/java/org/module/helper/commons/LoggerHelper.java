package org.module.helper.commons;

import java.util.UUID;

import org.apache.commons.lang3.StringUtils;
import org.module.annotation.commons.Inject;
import org.module.factory.UserFactory;
import org.module.mapper.logger.user.LmLoginMapper;
import org.module.mapper.logger.user.LmOperateMapper;
import org.module.model.logger.user.LmLogin;
import org.module.model.logger.user.LmOperate;
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
	@Inject
	private LmOperateMapper operateMapper;

	private static LoggerHelper self;

	public static LoggerHelper instance() {
		if (self == null) {
			self = new LoggerHelper();
		}
		return self;
	}

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 添加登录日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月11日 下午1:47:19
	 * 
	 * @param userCode
	 */
	public void login(String userCode) {
		LmLogin entity = new LmLogin();
		entity.setUid(UUID.randomUUID().toString().replace("-", ""));
		entity.setUserCode(userCode);
		entity.setIp(WebHelper.getIpAddress());
		entity.setLoginTime(DateUtil.getSysDateTime());
		loginMapper.insertSelective(entity);
	}

	/**
	 * 
	 * 方法: operate <br>
	 * 描述: 添加操作日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月11日 下午1:49:50
	 * 
	 * @param clazz
	 * @param request
	 * @param response
	 * @param userCode
	 */
	public void operate(Class<?> clazz, String request, String response, String type) {
		try {
			String userCode = UserFactory.instance().userInfo().getCode();
			if (StringUtils.isNotBlank(userCode)) {
				LmOperate entity = new LmOperate();
				entity.setUid(UUID.randomUUID().toString().replace("-", ""));
				entity.setClassPath(clazz.getCanonicalName());
				entity.setRequestData(request);
				entity.setResponseData(response);
				entity.setOperateType(type);
				entity.setCreateUser(userCode);
				entity.setCreateTime(DateUtil.getSysDateTime());
				operateMapper.insertSelective(entity);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
