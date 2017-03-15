package org.module.service.impl.db;

import org.module.dto.db.DmColumnDto;
import org.module.mapper.db.DmColumnMapper;
import org.module.model.db.DmColumn;
import org.module.service.db.IDmColumnService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: IDmColumnService <br>
 * 描述: 数据表列维护表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午5:32:30
 */
@Service
public class DmColumnServiceImpl extends BaseServiceImpl<DmColumn, DmColumnMapper, DmColumnDto>
		implements IDmColumnService {

}
