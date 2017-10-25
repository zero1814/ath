package org.module.mapper.system.menu;

import java.util.List;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.model.system.menu.SmMenuGroup;

public interface SmMenuGroupMapper extends BaseMapper<SmMenuGroup, SmMenuGroupDto> {

	/**
	 * 
	 * 方法: findDataAll <br>
	 * 描述: 获取所有菜单组 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月25日 上午11:28:51
	 * 
	 * @return
	 */
	List<SmMenuGroup> findDataAll();
}
