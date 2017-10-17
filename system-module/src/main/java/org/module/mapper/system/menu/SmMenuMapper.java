package org.module.mapper.system.menu;

import java.util.List;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;

/**
 * 
 * 类: SmMenuMapper <br>
 * 描述: 菜单表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:57:21
 */
public interface SmMenuMapper extends BaseMapper<SmMenu, SmMenuDto> {

	/**
	 * 
	 * 方法: findDataAll <br>
	 * 描述: 根据父级编码和分组编码查询菜单集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月1日 上午10:42:43
	 * 
	 * @param parentCode
	 * @param groupCode
	 * @return
	 */
	List<SmMenu> findDataAll(SmMenuDto dto);

	/**
	 * 
	 * 方法: isExistsChildMenu <br>
	 * 描述: 判断是否包含子菜单 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月9日 下午5:08:23
	 * 
	 * @param parentCode
	 * @return
	 */
	Integer isExistsChildMenu(String parentCode);
}