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

	/**
	 * 
	 * 方法: isExistsChildPage <br>
	 * 描述: 判断是否包含子页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月9日 下午5:01:58
	 * 
	 * @param parentCode
	 * @return
	 */
	Integer isExistsChildPage(String parentCode);

	/**
	 * 
	 * 方法: findPages <br>
	 * 描述: 获取所有页面信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月12日 下午8:50:51
	 * 
	 * @return
	 */
	List<SmPage> findPages(SmPageDto dto);

}