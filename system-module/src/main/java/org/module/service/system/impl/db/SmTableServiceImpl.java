package org.module.service.system.impl.db;

import org.module.dto.system.db.SmTableDto;
import org.module.mapper.system.db.SmTableMapper;
import org.module.model.system.db.SmTable;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.db.ISmTableService;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmTableServiceImpl <br>
 * 描述: 数据表维护表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月11日 下午4:42:12
 */
@Service
public class SmTableServiceImpl extends BaseServiceImpl<SmTable, SmTableMapper, SmTableDto> implements ISmTableService {

}
