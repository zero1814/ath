package org.module.service.product;

import java.util.List;

import org.module.dto.product.PmProductInfoDto;
import org.module.model.product.PmDefine;
import org.module.model.product.PmProductInfo;
import org.module.service.IBaseService;

/**
 * 
 * 类: IPmProductInfoService <br>
 * 描述: 商品表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月27日 上午9:44:16
 */
public interface IPmProductInfoService extends IBaseService<PmProductInfo, PmProductInfoDto> {

	/**
	 * 
	 * 方法: getProductType <br>
	 * 描述: 获取商品类型 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月27日 下午4:41:00
	 * 
	 * @return
	 */
	List<PmDefine> getProductType();

	/**
	 * 
	 * 方法: getProductStatus <br>
	 * 描述: 获取商品状态集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月27日 下午4:24:35
	 * 
	 * @return
	 */
	List<PmDefine> getProductStatus();
}
