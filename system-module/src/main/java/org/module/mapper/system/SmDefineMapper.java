package org.module.mapper.system;

import java.util.List;

import org.module.dto.system.SmDefineDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.SmDefine;

public interface SmDefineMapper extends BaseMapper<SmDefine, SmDefineDto> {

	/**
	 * 
	 * 方法: findDataByParentCode <br>
	 * 描述: 根据父级编码查询数据集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月19日 下午7:48:56
	 * 
	 * @param parentCode
	 * @return
	 */
	List<SmDefine> findDataByParentCode(String parentCode);
}