package org.module.service.system.user;

import org.module.dto.system.user.SmUserDto;
import org.module.model.system.user.SmUser;
import org.module.result.RootResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ISmUserService <br>
 * 描述: 用户表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月9日 上午10:43:11
 */
public interface ISmUserService extends IBaseService<SmUser, SmUserDto> {

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 登录 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月9日 上午10:49:25
	 * 
	 * @param user_name
	 * @param password
	 * @return
	 */
	RootResult login(String user_name, String password);

	/**
	 * 
	 * 方法: register <br>
	 * 描述: 注册新用户 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月9日 上午10:49:30
	 * 
	 * @param entity
	 * @return
	 */
	RootResult register(SmUser entity);
}
