package org.module.mapper.system.server;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseMapper;
import org.module.dto.system.server.SmServerGroupDto;
import org.module.model.system.server.SmServerGroup;

/**
 * 
 * 类: SmServerGroupMapper <br>
 * 描述: 系统服务器数据库访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:27:25
 */
@ObjectExplain(name = "系统服务器组数据库访问接口", description = "对于systemmodudel库的sm_server_group表进行数据库操作")
public interface SmServerGroupMapper extends BaseMapper<SmServerGroup, SmServerGroupDto> {
}