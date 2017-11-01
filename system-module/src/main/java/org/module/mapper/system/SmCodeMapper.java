package org.module.mapper.system;

import org.module.base.mapper.BaseMapper;
import org.module.dto.system.SmCodeDto;
import org.module.model.system.SmCode;

/**
 * 
 * 类: SmCodeMapper <br>
 * 描述: 系统统一编码维护表数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月23日 上午11:15:58
 */
public interface SmCodeMapper extends BaseMapper<SmCode, SmCodeDto> {

	String getCode(String prefix);
}
