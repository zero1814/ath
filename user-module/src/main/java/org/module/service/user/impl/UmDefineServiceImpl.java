package org.module.service.user.impl;

import java.util.List;

import org.module.dto.user.UmDefineDto;
import org.module.mapper.user.UmDefineMapper;
import org.module.model.user.UmDefine;
import org.module.result.TreeResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.user.IUmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: UmDefineServiceImpl <br>
 * 描述: 用户模块参数表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月21日 下午1:56:21
 */
@Service
public class UmDefineServiceImpl extends BaseServiceImpl<UmDefine, UmDefineMapper, UmDefineDto>
		implements IUmDefineService {

	@Autowired
	private UmDefineMapper mapper;

	@Override
	public TreeResult treeData() {
		TreeResult result = new TreeResult();
		try {
			result.setCode(0);
			result.setTreeText("参数列表");
			List<UmDefine> list = data("0");
			result.setData(list);
			result.setMessage("查询菜单成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("查询菜单失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	private List<UmDefine> data(String parentCode) {
		UmDefineDto dto = new UmDefineDto();
		dto.setParentCode(parentCode);
		List<UmDefine> list = mapper.findEntityAll(dto);
		if (list != null && list.size() > 0) {
			for (UmDefine m : list) {
				UmDefineDto sbDto = new UmDefineDto();
				sbDto.setParentCode(m.getCode());
				List<UmDefine> sub = mapper.findEntityAll(sbDto);
				if (sub != null && sub.size() > 0) {
					m.setNodes(sub);
				}
			}
		}
		return list;
	}
}
