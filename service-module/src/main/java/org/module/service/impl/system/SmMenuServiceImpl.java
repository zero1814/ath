package org.module.service.impl.system;

import org.module.dto.system.SmMenuDto;
import org.module.mapper.system.SmMenuMapper;
import org.module.model.system.SmMenu;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.ISmMenuService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmMenuServiceImpl <br>
 * 描述: 菜单维护表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月16日 下午7:15:43
 */
@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

}
