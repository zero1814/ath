package org.module.service.system.impl.db;

import org.module.dto.system.db.SmColumnDto;
import org.module.mapper.system.db.SmColumnMapper;
import org.module.model.system.db.SmColumn;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.db.ISmColumnService;
import org.springframework.stereotype.Service;
/**
 * 
 * 类: SmColumnServiceImpl <br>
 * 描述: 数据表字段维护表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月11日 下午4:41:43
 */
@Service
public class SmColumnServiceImpl extends BaseServiceImpl<SmColumn, SmColumnMapper, SmColumnDto>
		implements ISmColumnService {

}
