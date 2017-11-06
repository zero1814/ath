package org.module.service.system.user;

import org.module.base.result.EntityResult;
import org.module.base.service.IBaseService;
import org.module.dto.system.user.SmUserDto;
import org.module.model.system.user.SmUser;

/**
 * 
 * 类: ISmUserService <br>
 * 描述: 用户业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:07:29
 */
public interface ISmUserService extends IBaseService<SmUser, SmUserDto> {

	/**
	 * 
	 * 方法: login <br>
	 * 描述: 用户登录 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月22日 上午10:45:33
	 * @param dto
	 * @return
	 */
	EntityResult login(SmUserDto dto);
	
}
