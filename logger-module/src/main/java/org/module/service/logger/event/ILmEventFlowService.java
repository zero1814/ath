package org.module.service.logger.event;

import org.module.dto.logger.event.LmEventFlowDto;
import org.module.model.logger.event.LmEventFlow;
import org.module.result.DataResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ILmEventFlowService <br>
 * 描述: 活动审核日志业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午10:35:14
 */
public interface ILmEventFlowService extends IBaseService<LmEventFlow, LmEventFlowDto> {

	/**
	 * 
	 * 方法: selectByEventCode <br>
	 * 描述: 根据活动编码查询活动审核日志信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 上午10:35:09
	 * 
	 * @param eventCode
	 * @return
	 */
	DataResult selectByEventCode(String eventCode);
}
