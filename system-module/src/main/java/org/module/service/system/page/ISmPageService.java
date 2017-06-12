package org.module.service.system.page;

import org.module.dto.system.page.SmPageDto;
import org.module.model.system.page.SmPage;
import org.module.result.TreeResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ISmPageService <br>
 * 描述: 页面业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:05:59
 */
public interface ISmPageService extends IBaseService<SmPage, SmPageDto> {

	/**
	 * 
	 * 方法: findDataAll <br>
	 * 描述: 获取页面数据 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月6日 上午10:24:25
	 * 
	 * @return
	 */
	TreeResult treeData(String groupCode);

}
