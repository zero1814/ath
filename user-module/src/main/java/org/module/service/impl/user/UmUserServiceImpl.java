package org.module.service.impl.user;

import org.module.dto.UmUserDto;
import org.module.mapper.user.UmUserMapper;
import org.module.model.user.UmUser;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.user.IUmUserService;
import org.springframework.stereotype.Service;

@Service
public class UmUserServiceImpl extends BaseServiceImpl<UmUser, UmUserMapper, UmUserDto> implements IUmUserService {

}
