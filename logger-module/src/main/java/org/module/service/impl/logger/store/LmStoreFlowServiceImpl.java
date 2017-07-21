package org.module.service.impl.logger.store;

import java.util.List;

import org.module.dto.logger.store.LmStoreFlowDto;
import org.module.helper.commons.LoggerHelper;
import org.module.mapper.logger.store.LmStoreFlowMapper;
import org.module.model.logger.store.LmStoreFlow;
import org.module.result.DataResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.logger.store.ILmStoreFlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: LmStoreFlowServiceImpl <br>
 * 描述: 店铺审核日志业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 下午12:31:37
 */
@Service
public class LmStoreFlowServiceImpl extends BaseServiceImpl<LmStoreFlow, LmStoreFlowMapper, LmStoreFlowDto>
		implements ILmStoreFlowService {

	@Autowired
	private LmStoreFlowMapper mapper;

	/**
	 * 
	 * 方法: selectByStoreCode <br>
	 * 
	 * @param storeCode
	 * @return
	 * @see org.module.service.logger.store.ILmStoreFlowService#selectByStoreCode(java.lang.String)
	 */
	@Override
	public DataResult selectByStoreCode(String storeCode) {
		LoggerHelper.info(this.getClass(), "根据店铺编码查询店铺审核日志");
		DataResult result = new DataResult();
		try {
			List<LmStoreFlow> list = mapper.selectByStoreCode(storeCode);
			if (list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
				result.setMessage("获取店铺审核日志成功");
			} else {
				result.setCode(-1);
				result.setMessage("获取店铺审核日志为空");
			}
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("获取店铺审核日志失败，失败原因:" + e.getMessage());
		}
		return result;
	}

}
