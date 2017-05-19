package org.module.service.system;

import org.module.dto.system.SmDefineDto;
import org.module.model.system.SmDefine;
import org.module.result.DataMapResult;
import org.module.result.DataResult;
import org.module.service.IBaseService;

public interface ISmDefineService extends IBaseService<SmDefine, SmDefineDto> {

	/**
	 * 
	 * 方法: findDataByParentCode <br>
	 * 描述: 根据父级编码查询数据集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月19日 下午7:49:53
	 * 
	 * @param parentCode
	 * @return
	 */
	DataResult findDataByParentCode(String parentCode);

	/**
	 * 
	 * 方法: findDataAll <br>
	 * 描述: 获取所有参数数据 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月19日 下午8:25:36
	 * 
	 * @return
	 */
	DataMapResult findDataAll();
}
