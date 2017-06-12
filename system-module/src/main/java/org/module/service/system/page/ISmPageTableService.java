package org.module.service.system.page;

import java.util.List;

import org.module.dto.system.page.SmPageTableDto;
import org.module.model.system.page.SmPage;
import org.module.model.system.page.SmPageTable;
import org.module.service.IBaseService;

/**
 * 
 * 类: ISmPageTableService <br>
 * 描述: 页面列表显示设置表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月12日 下午5:03:52
 */
public interface ISmPageTableService extends IBaseService<SmPageTable, SmPageTableDto> {

	/**
	 * 
	 * 方法: findPageAll <br>
	 * 描述: 查询所有可用页面列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月12日 下午8:49:56
	 * @return
	 */
	List<SmPage> findPageAll();
}
