package org.module.system.mapper.server;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseMapper;
import org.module.system.dto.server.SmServerDto;
import org.module.system.model.server.SmServer;

@ObjectExplain(name = "系统服务器数据库访问接口", description = "对于systemmodudel库的sm_server表进行数据库操作")
public interface SmServerMapper extends BaseMapper<SmServer, SmServerDto> {
}