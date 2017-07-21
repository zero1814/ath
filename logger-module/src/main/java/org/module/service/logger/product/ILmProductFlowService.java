package org.module.service.logger.product;

import org.module.dto.logger.product.LmProductFlowDto;
import org.module.model.logger.product.LmProductFlow;
import org.module.result.DataResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: ILmProductFlowService <br>
 * 描述: 商品审核日志业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午11:34:54
 */
public interface ILmProductFlowService extends IBaseService<LmProductFlow, LmProductFlowDto>{

	/**
	 * 
	 * 方法: selectByProductCode <br>
	 * 描述: 根据商品编码查询商品审核日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 上午11:34:42
	 * @param productCode
	 * @return
	 */
	DataResult selectByProductCode(String productCode);
}
