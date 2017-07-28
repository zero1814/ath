package org.module.mapper.logger.product;

import java.util.List;

import org.module.dto.logger.product.LmProductFlowDto;
import org.module.mapper.BaseMapper;
import org.module.model.logger.product.LmProductFlow;

/**
 * 
 * 类: LmProductFlowMapper <br>
 * 描述: 商品审核日志数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午11:34:00
 */
public interface LmProductFlowMapper extends BaseMapper<LmProductFlow, LmProductFlowDto> {

	/**
	 * 
	 * 方法: selectByProductCode <br>
	 * 描述: 根据商品编码查询商品审核日志 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月21日 上午11:34:12
	 * 
	 * @param productCode
	 * @return
	 */
	List<LmProductFlow> selectByProductCode(String productCode);
}