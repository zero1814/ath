package org.module.service.impl.db;

import org.module.dto.db.DmTableSqlDto;
import org.module.mapper.db.DmTableSqlMapper;
import org.module.model.db.DmTableSql;
import org.module.service.db.IDmTableSqlService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: IDmTableSqlService <br>
 * 描述: 数据表操作sql维护表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午5:39:08
 */
@Service
public class DmTableSqlServiceImpl extends BaseServiceImpl<DmTableSql, DmTableSqlMapper, DmTableSqlDto>
		implements IDmTableSqlService {

}
