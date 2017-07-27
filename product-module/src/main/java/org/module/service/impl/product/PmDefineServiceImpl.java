package org.module.service.impl.product;

import java.util.List;

import org.module.dto.product.PmDefineDto;
import org.module.mapper.product.PmDefineMapper;
import org.module.model.product.PmDefine;
import org.module.result.RootResult;
import org.module.result.TreeResult;
import org.module.service.impl.BaseServiceImpl;
import org.module.service.product.IPmDefineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: PmDefineServiceImpl <br>
 * 描述: 商品参数业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年7月27日 上午9:41:17
 */
@Service
public class PmDefineServiceImpl extends BaseServiceImpl<PmDefine, PmDefineMapper, PmDefineDto>
		implements IPmDefineService {

	@Autowired
	private PmDefineMapper mapper;

	@Override
	public RootResult deleteByCode(String code) {
		RootResult result = new RootResult();
		List<PmDefine> list = mapper.findDefineByParentCode(code);
		if (list != null && list.size() > 0) {
			result.setCode(-1);
			result.setMessage("此项中包含子项，请先删除子项后再进行操作");
		} else {
			result = super.deleteByCode(code);
		}
		return result;
	}

	/**
	 * 
	 * 方法: tree <br>
	 * 
	 * @param groupCode
	 * @return
	 * @see org.module.service.product.IPmDefineService#tree(java.lang.String)
	 */
	@Override
	public TreeResult tree() {
		TreeResult result = new TreeResult();
		try {
			result.setTreeText("参数列表");
			result.setTreeCode("");
			List<PmDefine> list = data("0");
			result.setData(list);
			result.setMessage("查询菜单成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(-1);
			result.setMessage("查询菜单失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: data <br>
	 * 描述: 根据父级编码查询参数列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年6月1日 上午10:47:22
	 * 
	 * @param parentCode
	 * @param groupCode
	 * @return
	 */
	private List<PmDefine> data(String parentCode) {
		List<PmDefine> list = mapper.findDefineByParentCode(parentCode);
		if (list != null && list.size() > 0) {
			for (PmDefine d : list) {
				List<PmDefine> sub = mapper.findDefineByParentCode(d.getCode());
				if (sub != null && sub.size() > 0) {
					d.setNodes(sub);
				}
			}
		}
		return list;
	}
}
