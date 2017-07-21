package org.module.mapper.logger.event;

import java.util.List;

import org.module.dto.logger.event.LmEventFlowDto;
import org.module.mapper.BaseMapper;
import org.module.model.logger.event.LmEventFlow;

/**
 * 
 * 类: LmEventFlowMapper <br>
 * 描述: 活动审核日志数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午10:34:34
 */
public interface LmEventFlowMapper extends BaseMapper<LmEventFlow, LmEventFlowDto> {

	/**
	 * 
	 * 方法: selectByEventCode <br>
	 * 描述: TODO <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 上午10:34:29
	 * 
	 * @param eventCode
	 * @return
	 */
	List<LmEventFlow> selectByEventCode(String eventCode);
}