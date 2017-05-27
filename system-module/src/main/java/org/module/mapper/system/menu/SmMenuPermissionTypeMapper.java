package org.module.mapper.system.menu;

import java.util.List;

import org.module.dto.system.menu.SmMenuPermissionTypeDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.menu.SmMenuPermissionType;

public interface SmMenuPermissionTypeMapper extends BaseMapper<SmMenuPermissionType, SmMenuPermissionTypeDto> {

	/**
	 * 
	 * 方法: findEntityAll <br>
	 * 描述: 获取所有菜单权限类型 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月27日 上午11:29:55
	 * 
	 * @return
	 */
	List<SmMenuPermissionType> findEntityAll();
}