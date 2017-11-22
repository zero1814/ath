package org.module.service.system;

import org.module.commons.service.IBaseService;
import org.module.dto.system.SmCodeDto;
import org.module.model.system.SmCode;

public interface ISmCodeService extends IBaseService<SmCode, SmCodeDto> {
	
	/**
	 * 
	 * 方法: getCode <br>
	 * 描述: 根据前缀编码获取唯一编码 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月23日 上午11:23:13
	 * @param prefix
	 * @return
	 */
	String getCode(String prefix);
}
