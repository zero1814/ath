package org.module.mapper.system;

import java.util.List;

import org.module.dto.system.SmDefineDto;
import org.module.mapper.BaseMapper;
import org.module.model.system.SmDefine;

public interface SmDefineMapper extends BaseMapper<SmDefine, SmDefineDto> {

	/**
	 * 
	 * 方法: findDataByParentCode <br>
	 * 描述: 根据父级编码查询子编码集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月9日 上午10:27:11
	 * 
	 * @param parentCode
	 * @return
	 */
	List<SmDefine> findDataByParentCode(String parentCode);
}