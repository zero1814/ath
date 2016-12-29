package org.system.mapper.server;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseMapper;
import org.system.dto.server.SmServerGroupDto;
import org.system.model.server.SmServerGroup;

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