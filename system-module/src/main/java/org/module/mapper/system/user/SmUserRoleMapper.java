package org.module.mapper.system.user;

import org.module.dto.system.user.SmUserRoleDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.user.SmUserRole;

/**
 * 
 * 类: SmUesrRoleMapper <br>
 * 描述: 用户角色关系表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月18日 下午4:17:31
 */
public interface SmUserRoleMapper extends BaseMapper<SmUserRole, SmUserRoleDto> {

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
	public SmUserRole selectByUserCode(String userCode);

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
	public int deleteByUserCode(String userCode);
}
