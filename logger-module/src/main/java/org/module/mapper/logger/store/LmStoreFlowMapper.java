package org.module.mapper.logger.store;

import java.util.List;

import org.module.dto.logger.store.LmStoreFlowDto;
import org.module.mapper.BaseMapper;
import org.module.model.logger.store.LmStoreFlow;

/**
 * 
 * 类: LmStoreFlowMapper <br>
 * 描述: 店铺审核日志数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 下午12:31:20
 */
public interface LmStoreFlowMapper extends BaseMapper<LmStoreFlow, LmStoreFlowDto> {
	/**
	 * 
	 * 方法: selectByStoreCode <br>
	 * 描述: 根据店铺编码查询店铺审核日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午12:29:55
	 * @param storeCode
	 * @return
	 */
	List<LmStoreFlow> selectByStoreCode(String storeCode);
}