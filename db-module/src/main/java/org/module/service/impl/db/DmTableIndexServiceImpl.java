package org.module.service.impl.db;

import org.module.dto.db.DmTableIndexDto;
import org.module.mapper.db.DmTableIndexMapper;
import org.module.model.db.DmTableIndex;
import org.module.service.db.IDmTableIndexService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: IDmTableIndexService <br>
 * 描述: 数据表索引维护表业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年3月15日 下午5:34:06
 */
@Service
public class DmTableIndexServiceImpl extends BaseServiceImpl<DmTableIndex, DmTableIndexMapper, DmTableIndexDto>
		implements IDmTableIndexService {

}
