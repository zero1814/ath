package org.module.service.system.impl;

import java.util.List;

import org.module.base.result.TreeResult;
import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.SmDefineDto;
import org.module.helper.PropHelper;
import org.module.mapper.system.SmDefineMapper;
import org.module.model.system.SmDefine;
import org.module.service.system.ISmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmCodeServiceImpl <br>
 * 描述: 系统参数业务处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月23日 上午10:34:08
 */
@Service
public class SmDefineServiceImpl extends BaseServiceImpl<SmDefine, SmDefineMapper, SmDefineDto>
		implements ISmDefineService {

	@Autowired
	private SmDefineMapper mapper;

	@Override
	public TreeResult tree() {
		TreeResult result = new TreeResult();
		try {
			String text = PropHelper.getConfig("system.define.tree.text");
			result.setCode(0);
			result.setTreeText(text);
			result.setTreeCode("");
			List<SmDefine> list = findDefineByParentCode("0");
			result.setData(list);
			result.setMessage("查询菜单成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("查询参数列表失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	private List<SmDefine> findDefineByParentCode(String parentCode) {
		List<SmDefine> data = mapper.selectByParentCode(parentCode);
		if (data != null && data.size() > 0) {
			for (SmDefine sd : data) {
				List<SmDefine> childs = findDefineByParentCode(sd.getCode());
				if (childs != null && childs.size() > 0) {
					sd.setChilds(childs);
				}
			}
		}
		return data;
	}

}
