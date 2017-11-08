package org.module.mapper.system.user;

import java.util.List;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.user.SmRoleDto;
import org.module.model.system.user.SmRole;

/**
 * 
 * 类: SmRoleMapper <br>
 * 描述: 角色表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:56:57
 */
public interface SmRoleMapper extends BaseMapper<SmRole, SmRoleDto> {

	/**
	 * 
	 * 方法: findUserRoleData <br>
	 * 描述: 查询用户所有角色信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月8日 上午11:13:26
	 * 
	 * @param userCode
	 * @return
	 */
	List<SmRole> findUserRoleData(String userCode);
}