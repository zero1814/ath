package org.system.mapper;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseMapper;
import org.system.dto.SmDefineDto;
import org.system.model.SmDefine;

@ObjectExplain(name = "系统参数数据库访问接口", description = "对于systemmodudel库的sm_define表进行数据库操作")
public interface SmDefineMapper extends BaseMapper<SmDefine, SmDefineDto> {
}