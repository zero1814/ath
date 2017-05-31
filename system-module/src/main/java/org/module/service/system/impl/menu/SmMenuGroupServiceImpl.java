package org.module.service.system.impl.menu;

import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.mapper.system.menu.SmMenuGroupMapper;
import org.module.model.system.menu.SmMenuGroup;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmMenuGroupServiceImpl <br>
 * 描述: 菜单分组业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:09:25
 */
@Service
public class SmMenuGroupServiceImpl extends BaseServiceImpl<SmMenuGroup, SmMenuGroupMapper, SmMenuGroupDto>
		implements ISmMenuGroupService {

}
