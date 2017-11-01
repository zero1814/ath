package org.module.service.system.impl.user;

import java.util.List;

import org.module.base.result.BaseResult;
import org.module.base.result.DataResult;
import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.user.SmUserRoleDto;
import org.module.mapper.system.user.SmUserRoleMapper;
import org.module.model.system.user.SmUserRole;
import org.module.service.system.user.ISmUserRoleService;
import org.module.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 * 类: SmUserRoleServiceImpl <br>
 * 描述: 用户角色关系表业务逻辑处理接口实现类 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月31日 上午11:12:47
 */
@Service
public class SmUserRoleServiceImpl extends BaseServiceImpl<SmUserRole, SmUserRoleMapper, SmUserRoleDto>
		implements ISmUserRoleService {

	@Autowired
	private SmUserRoleMapper mapper;

	/**
	 * 
	 * 方法: selectByUserCode <br>
	 * 
	 * @param userCode
	 * @return
	 * @see org.module.service.system.user.ISmUserRoleService#selectByUserCode(java.lang.String)
	 */
	@Override
	public DataResult selectByUserCode(String userCode) {
		DataResult result = new DataResult();
		try {
			List<SmUserRole> list = mapper.selectByUserCode(userCode);
			if (list != null && list.size() > 0) {
				result.setCode(Constant.RESULT_SUCCESS);
				result.setMessage("查询成功");
				result.setData(list);
			} else {
				result.setCode(Constant.RESULT_NULL);
				result.setMessage("查询用户角色列表为空");
			}
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("查询用户角色列表失败，失败原因:" + e.getMessage());
		}
		return result;
	}

	/**
	 * 
	 * 方法: deleteByUserCode <br>
	 * 
	 * @param userCode
	 * @return
	 * @see org.module.service.system.user.ISmUserRoleService#deleteByUserCode(java.lang.String)
	 */
	@Override
	public BaseResult deleteByUserCode(String userCode) {
		BaseResult result = new BaseResult();
		try {
			mapper.deleteByUserCode(userCode);
			result.setCode(Constant.RESULT_SUCCESS);
			result.setMessage("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("删除失败，失败原因:" + e.getMessage());
		}
		return result;
	}

}
