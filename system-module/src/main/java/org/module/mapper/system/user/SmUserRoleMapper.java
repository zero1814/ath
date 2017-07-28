package org.module.mapper.system.user;

import java.util.List;

import org.module.dto.system.user.SmUserRoleDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.user.SmUserRole;

/**
 * 
 * 类: SmUserRoleMapper <br>
 * 描述: 用户角色关系表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:56:31
 */
public interface SmUserRoleMapper extends BaseMapper<SmUserRole, SmUserRoleDto> {

	/**
	 * 
	 * 方法: selectByUserCode <br>
	 * 描述: 根据用户编号查询角色列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月31日 下午2:40:49
	 * 
	 * @param userCode
	 * @return
	 */
	List<SmUserRole> selectByUserCode(String userCode);

	/**
	 * 
	 * 方法: deleteByUserCode <br>
	 * 描述: 根据用户编号删除角色 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月31日 下午2:40:47
	 * 
	 * @param userCode
	 * @return
	 */
	int deleteByUserCode(String userCode);
}