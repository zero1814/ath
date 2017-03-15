package org.module.service.impl.db;

import org.module.dto.db.DmColumnTypeDto;
import org.module.mapper.db.DmColumnTypeMapper;
import org.module.model.db.DmColumnType;
import org.module.service.db.IDmColumnTypeService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: IDmColumnTypeService <br>
 * 描述: 数据表列类型维护表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午5:32:59
 */
@Service
public class DmColumnTypeServiceImpl extends BaseServiceImpl<DmColumnType, DmColumnTypeMapper, DmColumnTypeDto>
		implements IDmColumnTypeService {

}
