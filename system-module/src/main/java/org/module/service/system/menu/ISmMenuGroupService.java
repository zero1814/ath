package org.module.service.system.menu;


import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.DataResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ISmMenuGroupService <br>
 * 描述: 菜单组业务处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年1月13日 下午1:13:53
 */
public interface ISmMenuGroupService extends IBaseService<SmMenuGroup, SmMenuGroupDto> {

	/**
	 * 
	 * 方法: getMenuData <br>
	 * 描述: 获取系统菜单集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月13日 下午1:14:36
	 * 
	 * @param userCode
	 * @return
	 */
	DataResult getMenuData(String userCode);
}
