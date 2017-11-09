package org.module.service.system.impl.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.module.base.result.BaseResult;
import org.module.base.service.impl.BaseServiceImpl;
import org.module.dto.system.user.SmUserRoleDto;
import org.module.helper.WebHelper;
import org.module.mapper.system.user.SmUserRoleMapper;
import org.module.model.system.user.SmUserRole;
import org.module.service.system.user.ISmUserRoleService;
import org.module.system.factory.UserFactory;
import org.module.util.Constant;
import org.module.util.DateUtil;
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

	/**
	 * 
	 * 方法: deleteUserRole <br>
	 * 
	 * @param dto
	 * @return
	 * @see org.module.service.system.user.ISmUserRoleService#deleteUserRole(org.module.dto.system.user.SmUserRoleDto)
	 */
	@Override
	public BaseResult deleteUserRole(SmUserRoleDto dto) {
		BaseResult result = new BaseResult();
		try {
			mapper.deleteUserRole(dto);
			result.setCode(Constant.RESULT_SUCCESS);
			result.setMessage("删除成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("删除报错，错误原因:" + e.getMessage());
		}
		return result;
	}

	@Override
	public BaseResult batchInsert(SmUserRole entity) {
		BaseResult result = new BaseResult();
		if (StringUtils.isBlank(entity.getUserCode())) {
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("用户编码为空");
			return result;
		}
		if (StringUtils.isBlank(entity.getRoleCode())) {
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("角色为空");
			return result;
		}
		try {
			List<SmUserRole> list = new ArrayList<SmUserRole>();
			String[] roles = entity.getRoleCode().split(",");
			String createUser = UserFactory.userInfo().getCode();
			for (int i = 0; i < roles.length; i++) {
				SmUserRole ur = new SmUserRole();
				ur.setUid(WebHelper.genUuid());
				ur.setUserCode(entity.getUserCode());
				ur.setRoleCode(roles[i]);
				ur.setCreateUser(createUser);
				ur.setCreateTime(DateUtil.getSysDateTime());
				list.add(ur);
			}
			mapper.batchInsert(list);
			result.setCode(Constant.RESULT_SUCCESS);
			result.setMessage("批量添加角色成功");
		} catch (Exception e) {
			e.printStackTrace();
			result.setCode(Constant.RESULT_ERROR);
			result.setMessage("批量添加报错，错误原因:" + e.getMessage());
		}
		return result;
	}
}
