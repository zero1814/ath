package org.module.service.system.user;

import java.util.Set;

import org.module.base.service.IBaseService;
import org.module.dto.system.user.SmRoleDto;
import org.module.model.system.user.SmRole;

/**
 * 
 * 类: ISmRoleService <br>
 * 描述: 角色业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:06:26
 */
public interface ISmRoleService extends IBaseService<SmRole, SmRoleDto> {

	/**
	 * 
	 * 方法: findRoleByUserCode <br>
	 * 描述: 获取用户角色列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月23日 下午5:39:05
	 * @param userCode
	 * @return
	 */
	Set<String> findRoleByUserCode(String userCode);
}
