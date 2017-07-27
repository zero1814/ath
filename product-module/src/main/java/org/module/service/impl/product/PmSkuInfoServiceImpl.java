package org.module.service.impl.product;

import org.module.dto.product.PmSkuInfoDto;
import org.module.mapper.product.PmSkuInfoMapper;
import org.module.model.product.PmSkuInfo;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.product.IPmSkuInfoService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PmSkuInfoServiceImpl <br>
 * 描述: 商品sku表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月27日 上午9:45:48
 */
@Service
public class PmSkuInfoServiceImpl extends BaseServiceImpl<PmSkuInfo, PmSkuInfoMapper, PmSkuInfoDto>
		implements IPmSkuInfoService {

}
