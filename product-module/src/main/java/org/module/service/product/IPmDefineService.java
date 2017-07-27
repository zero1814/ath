package org.module.service.product;

import org.module.dto.product.PmDefineDto;
import org.module.model.product.PmDefine;
import org.module.result.TreeResult;
import org.module.service.IBaseService;

/**
 * 
 * 类: IPmDefineService <br>
 * 描述: 商品参数业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月27日 上午9:41:04
 */
public interface IPmDefineService extends IBaseService<PmDefine, PmDefineDto> {

	/**
	 * 
	 * 方法: tree <br>
	 * 描述: 获取所有参数集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月1日 上午10:41:52
	 * 
	 * @return
	 */
	TreeResult tree();
}
