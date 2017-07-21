package org.module.service.user.impl;

import org.module.dto.user.UmUserAddressDto;
import org.module.mapper.user.UmUserAddressMapper;
import org.module.model.user.UmUserAddress;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.user.IUmUserAddressService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: UmUserAddressServiceImpl <br>
 * 描述: 用户地址管理业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 下午3:12:15
 */
@Service
public class UmUserAddressServiceImpl extends BaseServiceImpl<UmUserAddress, UmUserAddressMapper, UmUserAddressDto>
		implements IUmUserAddressService {

}
