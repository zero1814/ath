package org.module.mapper.system.user;

import java.util.List;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.user.SmUserRoleDto;
import org.module.model.system.user.SmRole;
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
	 * 方法: deleteByUserCode <br>
	 * 描述: 根据用户编号删除角色 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月31日 下午2:40:47
	 * 
	 * @param userCode
	 * @return
	 */
	int deleteByUserCode(String userCode);

	/**
	 * 
	 * 方法: deleteUserRole <br>
	 * 描述: 删除用户角色信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月8日 上午11:29:25
	 * 
	 * @param dto
	 * @return
	 */
	int deleteUserRole(SmUserRoleDto dto);

	/**
	 * 
	 * 方法: findUserRoleData <br>
	 * 描述: 根据用户编码查询角色列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月8日 上午11:45:05
	 * 
	 * @param dto
	 * @return
	 */
	List<SmRole> findUserRoleData(SmUserRoleDto dto);

	/**
	 * 
	 * 方法: batchInsert <br>
	 * 描述: 批量添加 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月9日 上午11:41:11
	 * 
	 * @param list
	 * @return
	 */
	int batchInsert(List<SmUserRole> list);
}