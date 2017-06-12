package org.module.service.system.impl.page;

import org.module.dto.system.page.SmPageTableColumnDto;
import org.module.mapper.system.page.SmPageTableColumnMapper;
import org.module.model.system.page.SmPageTableColumn;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.page.ISmPageTableColumnService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmPageTableColumnServiceImpl <br>
 * 描述: 页面列表显示字段设置表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月12日 下午5:05:36
 */
@Service
public class SmPageTableColumnServiceImpl
		extends BaseServiceImpl<SmPageTableColumn, SmPageTableColumnMapper, SmPageTableColumnDto>
		implements ISmPageTableColumnService {

}
