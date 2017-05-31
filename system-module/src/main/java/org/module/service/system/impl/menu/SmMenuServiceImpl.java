package org.module.service.system.impl.menu;

import org.module.dto.system.menu.SmMenuDto;
import org.module.mapper.system.menu.SmMenuMapper;
import org.module.model.system.menu.SmMenu;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmMenuServiceImpl <br>
 * 描述: 菜单业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:11:28
 */
@Service
public class SmMenuServiceImpl extends BaseServiceImpl<SmMenu, SmMenuMapper, SmMenuDto> implements ISmMenuService {

}
