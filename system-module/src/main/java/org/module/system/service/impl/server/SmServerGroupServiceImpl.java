package org.module.system.service.impl.server;

import org.module.commons.annotation.obj.ObjectExplain;
import org.module.commons.base.BaseServiceImpl;
import org.module.system.dto.server.SmServerGroupDto;
import org.module.system.mapper.server.SmServerGroupMapper;
import org.module.system.model.server.SmServerGroup;
import org.module.system.service.server.ISmServerGroupService;

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
