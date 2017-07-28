package org.module.mapper.logger.event;

import java.util.List;

import org.module.dto.logger.event.LmEventStatusDto;
import org.module.mapper.BaseMapper;
import org.module.model.logger.event.LmEventStatus;

/**
 * 
 * 类: LmEventStatusMapper <br>
 * 描述: 活动状态变更日志数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午10:43:29
 */
public interface LmEventStatusMapper extends BaseMapper<LmEventStatus, LmEventStatusDto> {
	
	/**
	 * 
	 * 方法: selectByEventCode <br>
	 * 描述: 根据活动编码查询活动状态变更日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 上午10:44:33
	 * @param eventCode
	 * @return
	 */
	List<LmEventStatus> selectByEventCode(String eventCode);
}