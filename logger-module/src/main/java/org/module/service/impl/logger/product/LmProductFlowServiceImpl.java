package org.module.service.impl.logger.product;

import java.util.List;

import org.module.dto.logger.product.LmProductFlowDto;
import org.module.helper.commons.LoggerHelper;
import org.module.mapper.logger.product.LmProductFlowMapper;
import org.module.model.logger.product.LmProductFlow;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.logger.product.ILmProductFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: LmProductFlowServiceImpl <br>
 * 描述: 商品审核日志业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 上午11:35:16
 */
@Service
public class LmProductFlowServiceImpl extends BaseServiceImpl<LmProductFlow, LmProductFlowMapper, LmProductFlowDto>
		implements ILmProductFlowService {

	@Autowired
	private LmProductFlowMapper mapper;

	/**
	 * 
	 * 方法: selectByProductCode <br>
	 * 
	 * @param productCode
	 * @return
	 * @see org.module.service.logger.product.ILmProductFlowService#selectByProductCode(java.lang.String)
	 */
	@Override
	public DataResult selectByProductCode(String productCode) {
		LoggerHelper.info(this.getClass(), "根据商品编码查询商品审核日志");
		DataResult result = new DataResult();
		try {
			List<LmProductFlow> list = mapper.selectByProductCode(productCode);
			if (list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
				result.setMessage("获取商品审核日志成功");
			} else {
				result.setCode(-1);
				result.setMessage("获取商品审核日志为空");
			}
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("获取商品审核日志失败，失败原因:" + e.getMessage());
		}
		return result;
	}

}
