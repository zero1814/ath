package org.module.service.impl.system;

import java.util.ArrayList;
import java.util.List;

import org.module.dto.system.SmDefineDto;
import org.module.mapper.system.SmDefineMapper;
import org.module.model.TreeModel;
import org.module.model.system.SmDefine;
import org.module.result.DataResult;
import org.module.result.RootResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.system.ISmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmDefineServiceImpl extends BaseServiceImpl<SmDefine, SmDefineMapper, SmDefineDto>
		implements ISmDefineService {

	@Autowired
	private SmDefineMapper mapper;

	@Override
	public DataResult findDataByParentCode(String parentCode) {
		DataResult result = new DataResult();
		List<SmDefine> list = mapper.findDataByParentCode(parentCode);
		if (!list.isEmpty()) {
			result.setCode(0);
			result.setData(list);
			result.setMessage("查询成功");
		} else {
			result.setCode(-1);
			result.setData(new ArrayList<SmDefine>());
			result.setMessage("查询失败");
		}
		return null;
	}

	private List<TreeModel> getData(String parentCode) {
		List<TreeModel> trees = new ArrayList<TreeModel>();
		List<SmDefine> list = mapper.findDataByParentCode(parentCode);
		if (list != null && list.size() > 0) {
			for (SmDefine define : list) {
				List<TreeModel> sub = getData(define.getCode());
				TreeModel tree = new TreeModel();
				tree.setId(define.getId());
				tree.setCode(define.getCode());
				tree.setText(define.getName());
				if (sub != null && sub.size() > 0) {
					tree.setNodes(sub);
				}
				trees.add(tree);
			}
		}
		return trees;
	}

	/**
	 * 
	 * 方法: treeData <br>
	 * @return 
	 * @see org.module.service.system.ISmDefineService#treeData()
	 */
	@Override
	public DataResult treeData() {
		DataResult result = new DataResult();
		try {
			List<TreeModel> list = getData("0");
			if (list != null && list.size() > 0) {
				result.setData(list);
				result.setCode(0);
				result.setMessage("查询成功");
			} else {
				result.setCode(-1);
				result.setMessage("查询参数列表为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("查询参数列表失败，失败原因：" + e.getMessage());
		}
		return result;
	}

	@Override
	public RootResult deleteByCode(String code) {
		RootResult result = new RootResult();
		List<SmDefine> list = mapper.findDataByParentCode(code);
		if (list != null && list.size() > 0) {
			result.setCode(-1);
			result.setMessage("参数包含子项，请先删除其子项信息");
		} else {
			result = super.deleteByCode(code);
		}
		return result;
	}

}
