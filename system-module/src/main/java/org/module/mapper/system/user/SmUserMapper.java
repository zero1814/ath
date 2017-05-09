package org.module.mapper.system.user;

import org.module.dto.system.user.SmUserDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.user.SmUser;

/**
 * 
 * 类: SmUserMapper <br>
 * 描述: 用户表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月9日 上午10:25:12
 */
public interface SmUserMapper extends BaseMapper<SmUser, SmUserDto> {

	/**
	 * 
	 * 方法: userExists <br>
	 * 描述: 根据用户名，密码查询用户是否存在 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月9日 上午10:59:14
	 * 
	 * @param entity
	 * @return
	 */
	SmUser userExists(SmUser entity);
}