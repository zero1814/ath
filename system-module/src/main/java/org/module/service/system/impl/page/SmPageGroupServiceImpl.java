package org.module.service.system.impl.page;

import java.util.List;

import org.module.base.result.DataResult;
import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.page.SmPageGroupDto;
import org.module.mapper.system.page.SmPageGroupMapper;
import org.module.model.system.page.SmPageGroup;
import org.module.service.system.page.ISmPageGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmPageGroupServiceImpl <br>
 * 描述: 页面分组表业务逻辑处理接口 <br>
 * 作者: zhy<br>
 * 时间: 2017年6月1日 上午9:02:29
 */
@Service
public class SmPageGroupServiceImpl extends BaseServiceImpl<SmPageGroup, SmPageGroupMapper, SmPageGroupDto>
		implements ISmPageGroupService {

	@Autowired
	private SmPageGroupMapper mapper;

	/**
	 * 
	 * 方法: findDataAll <br>
	 * 
	 * @param parentCode
	 * @return
	 * @see org.module.service.system.page.ISmPageGroupService#findDataAll(java.lang.String)
	 */
	@Override
	public DataResult findDataAll() {
		DataResult result = new DataResult();
		try {
			result.setCode(0);
			result.setData(data("0"));
			result.setMessage("获取页面分组树型菜单列表成功");
		} catch (Exception e) {
			result.setCode(-1);
			result.setMessage("获取页面分组树型菜单列表失败，失败原因：" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: data <br>
	 * 描述: 根据父级编码查询子级列表集合 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月1日 上午10:11:49
	 * 
	 * @param parentCode
	 * @return
	 */
	private List<SmPageGroup> data(String parentCode) {
		List<SmPageGroup> list = mapper.findDataAll(parentCode);
		if (list != null && list.size() > 0) {
			for (SmPageGroup g : list) {
				List<SmPageGroup> sub = data(g.getCode());
				if (sub != null && sub.size() > 0) {
					g.setChilds(sub);
				}
			}
		}
		return list;
	}

}
