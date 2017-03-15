package org.module.service.impl.db;

import org.module.dto.db.DmTableDto;
import org.module.mapper.db.DmTableMapper;
import org.module.model.db.DmTable;
import org.module.service.db.IDmTableService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: IDmTableService <br>
 * 描述: 数据表维护表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午5:38:46
 */
@Service
public class DmTableServiceImpl extends BaseServiceImpl<DmTable, DmTableMapper, DmTableDto> implements IDmTableService {

}
