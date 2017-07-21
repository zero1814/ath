package org.module.service.logger.event;

import org.module.dto.logger.event.LmEventStatusDto;
import org.module.model.logger.event.LmEventStatus;
import org.module.result.DataResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ILmEventStatusService <br>
 * 描述: 活动状态变更日志业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午10:43:15
 */
public interface ILmEventStatusService extends IBaseService<LmEventStatus, LmEventStatusDto> {

	/**
	 * 
	 * 方法: selectByEventCode <br>
	 * 描述: 根据活动编码查询活动状态变更日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 上午10:45:09
	 * 
	 * @param eventCode
	 * @return
	 */
	DataResult selectByEventCode(String eventCode);
}
