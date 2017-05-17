package org.module.service.impl.user;

import org.module.dto.UmDefineDto;
import org.module.mapper.user.UmDefineMapper;
import org.module.model.user.UmDefine;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.user.IUmDefineService;
import org.springframework.stereotype.Service;

@Service
public class UmDefineServiceImpl extends BaseServiceImpl<UmDefine, UmDefineMapper, UmDefineDto>
		implements IUmDefineService {

}
