package org.module.mapper.system.user;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.user.SmUserDto;
import org.module.model.system.user.SmUser;

/**
 * 
 * 类: SmUserMapper <br>
 * 描述: 用户表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:56:44
 */
public interface SmUserMapper extends BaseMapper<SmUser, SmUserDto> {

	/**
	 * 
	 * 方法: userLogin <br>
	 * 描述: 用户登陆 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月23日 下午5:51:04
	 * 
	 * @param dto
	 * @return
	 */
	SmUser userLogin(SmUserDto dto);
}