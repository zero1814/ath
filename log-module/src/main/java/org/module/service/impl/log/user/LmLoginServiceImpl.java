package org.module.service.impl.log.user;

import org.module.dto.BaseDto;
import org.module.mapper.log.user.LmLoginMapper;
import org.module.model.log.user.LmLogin;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.log.user.ILmLoginService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: LmLoginServiceImpl <br>
 * 描述: 登录日志业务处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月10日 下午3:40:35
 */
@Service
public class LmLoginServiceImpl extends BaseServiceImpl<LmLogin, LmLoginMapper, BaseDto> implements ILmLoginService {

}
