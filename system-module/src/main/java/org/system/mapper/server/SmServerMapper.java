package org.system.mapper.server;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseMapper;
import org.system.dto.server.SmServerDto;
import org.system.model.server.SmServer;

@ObjectExplain(name = "系统服务器数据库访问接口", description = "对于systemmodudel库的sm_server表进行数据库操作")
public interface SmServerMapper extends BaseMapper<SmServer, SmServerDto> {
}