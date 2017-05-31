package org.module.service.system.impl.user;

import org.module.dto.system.user.SmUserDto;
import org.module.mapper.system.user.SmUserMapper;
import org.module.model.system.user.SmUser;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.user.ISmUserService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmUserServiceImpl <br>
 * 描述: 用户业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:14:25
 */
@Service
public class SmUserServiceImpl extends BaseServiceImpl<SmUser, SmUserMapper, SmUserDto> implements ISmUserService {

}
