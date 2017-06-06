package org.module.mapper.system.page;

import java.util.List;

import org.module.dto.system.page.SmPageDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.page.SmPage;

/**
 * 
 * 类: SmPageMapper <br>
 * 描述: 页面表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午10:57:34
 */
public interface SmPageMapper extends BaseMapper<SmPage, SmPageDto> {

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
	List<SmPage> findDataAll(SmPageDto dto);
}