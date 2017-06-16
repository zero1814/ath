package org.module.service.system.impl.page;

import java.util.List;

import org.module.dto.system.page.SmPageTableColumnDto;
import org.module.dto.system.page.SmPageTableDto;
import org.module.mapper.system.page.SmPageMapper;
import org.module.mapper.system.page.SmPageTableColumnMapper;
import org.module.mapper.system.page.SmPageTableMapper;
import org.module.model.system.page.SmPage;
import org.module.model.system.page.SmPageTable;
import org.module.model.system.page.SmPageTableColumn;
import org.module.result.RootResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.page.ISmPageTableService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private SmPageMapper pageMapper;
	@Autowired
	private SmPageTableColumnMapper columnMapper;

	@Override
	public List<SmPage> findPageAll() {
		return pageMapper.findPages(null);
	}

	@Override
	public RootResult deleteByCode(String code) {
		RootResult result = new RootResult();
		SmPageTableColumnDto dto = new SmPageTableColumnDto();
		dto.setTableCode(code);
		List<SmPageTableColumn> list = columnMapper.findEntityAll(dto);
		if (list != null && list.size() > 0) {
			result.setCode(-1);
			result.setMessage("列表包含显示字段，请先删除显示字段后再删除显示列表");
		} else {
			result = super.deleteByCode(code);
		}
		return result;
	}

}
