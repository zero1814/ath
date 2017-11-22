package org.module.service.system.user;

import org.module.commons.result.BaseResult;
import org.module.commons.service.IBaseService;
import org.module.dto.system.user.SmUserRoleDto;
import org.module.model.system.user.SmUserRole;

/**
 * 
 * 类: ISmUserRoleService <br>
 * 描述: 用户角色关系表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:07:13
 */
public interface ISmUserRoleService extends IBaseService<SmUserRole, SmUserRoleDto> {

	/**
	 * 
	 * 方法: deleteByUserCode <br>
	 * 描述: 根据用户编号删除角色 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月31日 下午2:42:23
	 * 
	 * @param userCode
	 * @return
	 */
	BaseResult deleteByUserCode(String userCode);

	/**
	 * 
	 * 方法: deleteUserRole <br>
	 * 描述: 删除用户角色 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月8日 上午11:41:47
	 * 
	 * @param dto
	 * @return
	 */
	BaseResult deleteUserRole(SmUserRoleDto dto);
	
	BaseResult batchInsert(SmUserRole entity);
}
