package org.module.mapper.system.page;

import java.util.List;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.page.SmPageGroupDto;
import org.module.model.system.page.SmPageGroup;

/**
 * 
 * 类: SmPageGroupMapper <br>
 * 描述: 页面分组表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 下午5:57:55
 */
public interface SmPageGroupMapper extends BaseMapper<SmPageGroup, SmPageGroupDto> {

	/**
	 * 
	 * 方法: findDataAll <br>
	 * 描述: 根据父级编码查询分组列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月1日 上午9:55:46
	 * 
	 * @param parentCode
	 * @return
	 */
	List<SmPageGroup> findDataAll(String parentCode);

}