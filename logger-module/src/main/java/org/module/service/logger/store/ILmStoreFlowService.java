package org.module.service.logger.store;


import org.module.dto.logger.store.LmStoreFlowDto;
import org.module.model.logger.store.LmStoreFlow;
import org.module.result.DataResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ILmStoreFlowService <br>
 * 描述: 店铺审核日志数业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 下午12:30:20
 */
public interface ILmStoreFlowService extends IBaseService<LmStoreFlow, LmStoreFlowDto> {

	/**
	 * 
	 * 方法: selectByStoreCode <br>
	 * 描述: 根据店铺编码查询店铺审核日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 下午12:29:55
	 * @param storeCode
	 * @return
	 */
	DataResult selectByStoreCode(String storeCode);
}
