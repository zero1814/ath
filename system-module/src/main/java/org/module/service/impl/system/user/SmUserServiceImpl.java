package org.module.service.impl.system.user;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.module.dto.system.user.SmUserDto;
import org.module.mapper.system.user.SmUserMapper;
import org.module.model.system.user.SmUser;
import org.module.result.RootResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.user.ISmUserService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmUserServiceImpl <br>
 * 描述: 用户表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月9日 上午10:44:28
 */
@Service
public class SmUserServiceImpl extends BaseServiceImpl<SmUser, SmUserMapper, SmUserDto> implements ISmUserService {

	@Resource
	public SmUserMapper mapper;

	/**
	 * 
	 * 方法: login <br>
	 * 
	 * @param user_name
	 * @param password
	 * @return
	 * @see org.module.service.system.user.ISmUserService#login(java.lang.String,
	 *      java.lang.String)
	 */
	@Override
	public RootResult login(String user_name, String password) {
		RootResult result = new RootResult();
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
	public RootResult register(SmUser entity) {
		RootResult result = verifyUser(entity);
		if (result.getCode() == 0) {
			result = insertSelective(entity);
		}
		return result;
	}

	private static RootResult verifyUser(SmUser entity) {
		RootResult result = new RootResult();
		if (StringUtils.isBlank(entity.getUserName())) {
			result.setCode(-1);
			result.setMessage("用户名不能为空");
		} else if (StringUtils.isBlank(entity.getPassword())) {
			result.setCode(-1);
			result.setMessage("密码不能为空");
		} else if (StringUtils.isBlank(entity.getRealName())) {
			result.setCode(-1);
			result.setMessage("真实姓名不能为空");
		}
		return result;
	}
}
