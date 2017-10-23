package org.module.mapper.system;

import java.util.List;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.SmDefineDto;
import org.module.model.system.SmDefine;

/**
 * 
 * 类: SmCodeMapper <br>
 * 描述: 系统参数数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月23日 上午10:34:48
 */
public interface SmDefineMapper extends BaseMapper<SmDefine, SmDefineDto> {

	/**
	 * 
	 * 方法: selectByParentCode <br>
	 * 描述: 根据父级编码查询子级集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月23日 上午11:44:10
	 * 
	 * @param parentCode
	 * @return
	 */
	List<SmDefine> selectByParentCode(String parentCode);
}
