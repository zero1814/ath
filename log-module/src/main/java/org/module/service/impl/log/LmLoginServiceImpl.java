package org.module.service.impl.log;

import org.module.dto.log.user.LmLoginDto;
import org.module.mapper.log.user.LmLoginMapper;
import org.module.model.log.user.LmLogin;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.log.ILmLoginService;
import org.springframework.stereotype.Service;

@Service
public class LmLoginServiceImpl extends BaseServiceImpl<LmLogin, LmLoginMapper, LmLoginDto> implements ILmLoginService {

}
