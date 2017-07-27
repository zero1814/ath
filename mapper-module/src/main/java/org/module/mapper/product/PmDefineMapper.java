package org.module.mapper.product;

import java.util.List;

import org.module.dto.product.PmDefineDto;
import org.module.mapper.BaseMapper;
import org.module.model.product.PmDefine;

public interface PmDefineMapper extends BaseMapper<PmDefine, PmDefineDto> {
	/**
	 * 
	 * 方法: findDataAll <br>
	 * 描述: 根据父级编码和分组编码查询菜单集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月1日 上午10:42:43
	 * 
	 * @param parentCode
	 * @return
	 */
	List<PmDefine> findDefineByParentCode(String parentCode);
}