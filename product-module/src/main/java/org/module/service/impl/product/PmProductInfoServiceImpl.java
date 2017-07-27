package org.module.service.impl.product;

import java.util.List;

import org.module.dto.product.PmProductInfoDto;
import org.module.helper.commons.PropHelper;
import org.module.mapper.product.PmDefineMapper;
import org.module.mapper.product.PmProductInfoMapper;
import org.module.model.product.PmDefine;
import org.module.model.product.PmProductInfo;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.product.IPmProductInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PmProductInfoServiceImpl <br>
 * 描述: 商品表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月27日 上午9:44:30
 */
@Service
public class PmProductInfoServiceImpl extends BaseServiceImpl<PmProductInfo, PmProductInfoMapper, PmProductInfoDto>
		implements IPmProductInfoService {

	@Autowired
	private PmDefineMapper defineMapper;

	/**
	 * 
	 * 方法: getProductStatus <br>
	 * 
	 * @return
	 * @see org.module.service.product.IPmProductInfoService#getProductStatus()
	 */
	@Override
	public List<PmDefine> getProductStatus() {
		return defineMapper.findDefineByParentCode(PropHelper.getConfig("product.statusCode"));
	}

	@Override
	public List<PmDefine> getProductType() {
		return defineMapper.findDefineByParentCode(PropHelper.getConfig("product.typeCode"));
	}

}
