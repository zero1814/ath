package org.module.service.impl.logger.user;

import org.module.dto.BaseDto;
import org.module.mapper.logger.user.LmLoginMapper;
import org.module.model.logger.user.LmLogin;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.logger.user.ILmLoginService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: LmLoginServiceImpl <br>
 * 描述: 用户登录日志业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月10日 下午5:40:20
 */
@Service
public class LmLoginServiceImpl extends BaseServiceImpl<LmLogin, LmLoginMapper, BaseDto> implements ILmLoginService {

}
