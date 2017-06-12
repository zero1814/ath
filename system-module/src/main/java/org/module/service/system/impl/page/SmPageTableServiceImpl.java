package org.module.service.system.impl.page;

import org.module.dto.system.page.SmPageTableDto;
import org.module.mapper.system.page.SmPageTableMapper;
import org.module.model.system.page.SmPageTable;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.page.ISmPageTableService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmPageTableServiceImpl <br>
 * 描述: 页面列表显示设置表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月12日 下午5:05:26
 */
@Service
public class SmPageTableServiceImpl extends BaseServiceImpl<SmPageTable, SmPageTableMapper, SmPageTableDto>
		implements ISmPageTableService {

}
