package org.module.service.system.impl.user;

import org.module.cache.system.CacheKey;
import org.module.commons.helper.CacheHelper;
import org.module.commons.helper.CodeHelper;
import org.module.commons.helper.WebHelper;
import org.module.commons.result.EntityResult;
import org.module.commons.service.impl.BaseServiceImpl;
import org.module.commons.util.Constant;
import org.module.commons.util.MD5Util;
import org.module.dto.system.user.SmUserDto;
import org.module.mapper.system.user.SmUserMapper;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmUserService;
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

	/**
	 * 
	 * 方法: login <br>
	 * 
	 * @param dto
	 * @return
	 * @see org.module.service.system.user.ISmUserService#login(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public EntityResult login(SmUserDto dto) {
		dto.setPassword(MD5Util.md5Hex(dto.getPassword()));
		EntityResult result = super.selectEntity(dto);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			SmUser user = (SmUser) result.getEntity();
			CacheHelper.setValue(CacheKey.SESSION_USER_KEY + WebHelper.getSession().getId(), JSON.toJSONString(user));
			/**
			 * 记录登录日志
			 */
		}
		/**
		 * 添加操作日志
		 */
		return result;
	}

	@Override
	public EntityResult insertSelective(SmUser entity) {
		String code = CodeHelper.getCode("SU");
		entity.setCode(code);
		entity.setCreateUser(code);
		entity.setPassword(MD5Util.md5Hex(entity.getPassword()));
		EntityResult result = super.insertSelective(entity);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			/**
			 * 注册成功后存储用户信息到redis中
			 */
			CacheHelper.setValue(CacheKey.SESSION_USER_KEY + WebHelper.getSession().getId(),
					JSON.toJSONString(result.getEntity()));
		}
		return result;

	}

}
