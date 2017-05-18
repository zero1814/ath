package org.module.service.system.user;

import org.module.dto.system.user.SmUserRoleDto;
import org.module.model.system.user.SmUserRole;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ISmUesrRoleService <br>
 * 描述: 用户角色管理表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月18日 下午4:18:55
 */
public interface ISmUesrRoleService extends IBaseService<SmUserRole, SmUserRoleDto> {

	/**
	 * 
	 * 方法: selectByUserCode <br>
	 * 描述: 根据用户编码查询角色关系 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月18日 下午4:28:46
	 * 
	 * @param userCode
	 * @return
	 */
	public EntityResult selectByUserCode(String userCode);

	/**
	 * 
	 * 方法: deleteByUserCode <br>
	 * 描述: 根据用户编码删除角色关系 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月18日 下午4:29:03
	 * 
	 * @param userCode
	 * @return
	 */
	public RootResult deleteByUserCode(String userCode);
}
