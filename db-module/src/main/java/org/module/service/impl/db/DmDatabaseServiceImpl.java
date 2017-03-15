package org.module.service.impl.db;

import org.module.dto.db.DmDatabaseDto;
import org.module.mapper.db.DmDatabaseMapper;
import org.module.model.db.DmDatabase;
import org.module.service.db.IDmDatabaseService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: IDmDatabaseService <br>
 * 描述: 数据库维护表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午5:33:30
 */
@Service
public class DmDatabaseServiceImpl extends BaseServiceImpl<DmDatabase, DmDatabaseMapper, DmDatabaseDto>
		implements IDmDatabaseService {

}
