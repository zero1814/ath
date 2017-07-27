package org.module.service.impl.product;

import org.module.dto.product.PmProductDraftsDto;
import org.module.mapper.product.PmProductDraftsMapper;
import org.module.model.product.PmProductDrafts;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.product.IPmProductDraftsService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PmProductDraftsServiceImpl <br>
 * 描述: 商品草稿箱业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月27日 上午9:43:07
 */
@Service
public class PmProductDraftsServiceImpl extends
		BaseServiceImpl<PmProductDrafts, PmProductDraftsMapper, PmProductDraftsDto> implements IPmProductDraftsService {

}
