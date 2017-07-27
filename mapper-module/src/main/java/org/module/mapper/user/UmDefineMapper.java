package org.module.mapper.user;

import java.util.List;

import org.module.dto.user.UmDefineDto;
import org.module.mapper.BaseMapper;
import org.module.model.user.UmDefine;

/**
 * 
 * 类: UmDefineMapper <br>
 * 描述: 用户模块参数表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月27日 下午5:44:10
 */
public interface UmDefineMapper extends BaseMapper<UmDefine, UmDefineDto> {

	/**
	 * 
	 * 方法: findDefineByParentCode <br>
	 * 描述: 根据父级编码查询子项集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年7月27日 下午5:43:55
	 * 
	 * @param parentCode
	 * @return
	 */
	List<UmDefine> findDefineByParentCode(String parentCode);
}