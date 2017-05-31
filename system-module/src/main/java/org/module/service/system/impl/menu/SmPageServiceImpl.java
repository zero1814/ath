package org.module.service.system.impl.menu;

import org.module.dto.system.menu.SmPageDto;
import org.module.mapper.system.menu.SmPageMapper;
import org.module.model.system.menu.SmPage;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.menu.ISmPageService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmPageServiceImpl <br>
 * 描述: 页面业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:11:55
 */
@Service
public class SmPageServiceImpl extends BaseServiceImpl<SmPage, SmPageMapper, SmPageDto> implements ISmPageService {

}
