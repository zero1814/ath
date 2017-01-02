package org.module.service.impl.system.server;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.dto.system.server.SmServerGroupDto;
import org.module.mapper.system.server.SmServerGroupMapper;
import org.module.model.system.server.SmServerGroup;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.server.ISmServerGroupService;

/**
 * 
 * 类: SmServerGroupServiceImpl <br>
 * 描述: 系统服务器组业务逻辑访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:50:23
 */
@ObjectExplain(name = "系统服务器组业务逻辑访问接口", description = "对系统服务器组相关业务逻辑操作接口")
public class SmServerGroupServiceImpl extends BaseServiceImpl<SmServerGroup, SmServerGroupMapper, SmServerGroupDto>
		implements ISmServerGroupService {

}
