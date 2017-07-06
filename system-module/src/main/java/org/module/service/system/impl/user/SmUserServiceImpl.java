package org.module.service.system.impl.user;

import org.module.cache.CacheKey;
import org.module.cache.RedisString;
import org.module.commons.util.DateUtil;
import org.module.commons.util.MD5Util;
import org.module.dto.system.user.SmUserDto;
import org.module.helper.UserHelper;
import org.module.helper.commons.WebHelper;
import org.module.mapper.system.user.SmUserMapper;
import org.module.model.log.user.LmLogin;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.log.ILmLoginService;
import org.module.service.system.user.ISmUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 类: SmUserServiceImpl <br>
 * 描述: 用户业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:14:25
 */
@Service
public class SmUserServiceImpl extends BaseServiceImpl<SmUser, SmUserMapper, SmUserDto> implements ISmUserService {

	@Autowired
	private ILmLoginService logService;

	/**
	 * 
	 * 方法: login <br>
	 * 
	 * @param username
	 * @param password
	 * @return
	 * @see org.module.service.system.user.ISmUserService#login(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public EntityResult login(String userName, String password) {
		SmUserDto entity = new SmUserDto();
		entity.setUserName(userName);
		entity.setPassword(password);
		EntityResult result = super.selectEntity(entity);
		if (result.getCode() == 0) {
			RedisString.instance().setValue(CacheKey.USER + "_" + entity.getUserName(),
					JSON.toJSONString(result.getEntity()));
			/**
			 * 记录登录日志
			 */
			SmUser user = (SmUser) result.getEntity();
			LmLogin login = new LmLogin();
			login.setUserCode(user.getCode());
			login.setIp(WebHelper.getIpAddress());
			login.setLoginTime(DateUtil.getSysDateTime());
			logService.insertSelective(login);
		}
		return result;
	}

	/**
	 * 
	 * 方法: register <br>
	 * 
	 * @param entity
	 * @return
	 * @see org.module.service.system.user.ISmUserService#register(org.module.model.system.user.SmUser)
	 */
	@Override
	public EntityResult register(SmUser entity) {
		String userCode = UserHelper.intance().userInfo().getCode();
		entity.setCreateUser(userCode);
		entity.setPassword(MD5Util.md5Hex(entity.getPassword()));
		EntityResult result = super.insertSelective(entity);
		if (result.getCode() == 0) {
			/**
			 * 注册成功后存储用户信息到redis中
			 */
			RedisString.instance().setValue(CacheKey.USER + "_" + entity.getUserName(),
					JSON.toJSONString(result.getEntity()));
		}
		return result;
	}

}
