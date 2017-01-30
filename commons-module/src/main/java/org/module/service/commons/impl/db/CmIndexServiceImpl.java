package org.module.service.commons.impl.db;

import org.module.dto.commons.db.CmIndexDto;
import org.module.mapper.commons.db.CmIndexMapper;
import org.module.model.commons.db.CmIndex;
import org.module.service.commons.db.ICmIndexService;
import org.module.service.impl.BaseServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class CmIndexServiceImpl extends BaseServiceImpl<CmIndex, CmIndexMapper, CmIndexDto> implements ICmIndexService{

}
