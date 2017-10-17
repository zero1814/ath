package org.module.service.system.impl.page;

import java.util.List;

import org.module.base.result.BaseResult;
import org.module.base.result.TreeResult;
import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.page.SmPageDto;
import org.module.mapper.system.page.SmPageGroupMapper;
import org.module.mapper.system.page.SmPageMapper;
import org.module.model.system.page.SmPage;
import org.module.model.system.page.SmPageGroup;
import org.module.service.system.page.ISmPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmPageServiceImpl <br>
 * 描述: 页面业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:11:55
 */
@Service
public class SmPageServiceImpl extends BaseServiceImpl<SmPage, SmPageMapper, SmPageDto> implements ISmPageService {

	@Autowired
	private SmPageMapper mapper;

	@Autowired
	private SmPageGroupMapper groupMapper;

	@Override
	public TreeResult treeData(String groupCode) {
		TreeResult result = new TreeResult();
		try {
			SmPageGroup group = groupMapper.selectByCode(groupCode);
			if (group != null) {
				result.setTreeText(group.getName());
				result.setTreeCode(group.getCode());
				result.setCode(0);
				result.setData(data("0", groupCode));
				result.setMessage("查询成功");
			} else {
				result.setCode(-1);
				result.setMessage("页面分组不存在");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("查询失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: data <br>
	 * 描述: 根据菜单分组编码和父级编码查询菜单列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月1日 上午10:47:22
	 * 
	 * @param parentCode
	 * @param groupCode
	 * @return
	 */
	private List<SmPage> data(String parentCode, String groupCode) {
		SmPageDto dto = new SmPageDto();
		dto.setGroupCode(groupCode);
		dto.setParentCode(parentCode);
		List<SmPage> list = mapper.findDataAll(dto);
		if (list != null && list.size() > 0) {
			for (SmPage p : list) {
				SmPageDto spDto = new SmPageDto();
				spDto.setGroupCode(groupCode);
				spDto.setParentCode(p.getCode());
				List<SmPage> sub = mapper.findDataAll(spDto);
				if (sub != null && sub.size() > 0) {
					p.setNodes(sub);
				}
			}
		}
		return list;
	}

	@Override
	public BaseResult deleteByCode(String code) {
		BaseResult result = new BaseResult();
		// 查询是否包含子页面
		Integer isExistsChild = mapper.isExistsChildPage(code);
		if (isExistsChild > 0) {
			result.setCode(-1);
			result.setMessage("页面包含子页面，请先删除子页面信息");
		} else {
			result = super.deleteByCode(code);
		}
		return result;
	}

}
