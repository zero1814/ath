package org.module.service.system.page;

import org.module.dto.system.page.SmPageGroupDto;
import org.module.model.system.page.SmPageGroup;
import org.module.result.DataResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ISmPageGroupService <br>
 * 描述: 页面分组表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月1日 上午9:00:54
 */
public interface ISmPageGroupService extends IBaseService<SmPageGroup, SmPageGroupDto> {

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
	DataResult findDataAll();
}
