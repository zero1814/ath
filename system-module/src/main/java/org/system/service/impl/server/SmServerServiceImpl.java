package org.system.service.impl.server;

import org.commons.annotation.obj.ObjectExplain;
import org.commons.base.BaseServiceImpl;
import org.system.dto.server.SmServerDto;
import org.system.mapper.server.SmServerMapper;
import org.system.model.server.SmServer;
import org.system.service.server.ISmServerService;

/**
 * 
 * 类: SmServerServiceImpl <br>
 * 描述: 系统服务器业务逻辑访问接口 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午5:50:44
 */
@ObjectExplain(name = "系统服务器业务逻辑访问接口", description = "对系统服务器相关业务逻辑操作接口")
public class SmServerServiceImpl extends BaseServiceImpl<SmServer, SmServerMapper, SmServerDto>
		implements ISmServerService {

}
