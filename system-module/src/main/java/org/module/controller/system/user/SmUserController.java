package org.module.controller.system.user;

import javax.servlet.http.HttpServletRequest;

import org.module.commons.controller.BaseController;
import org.module.commons.helper.CodeHelper;
import org.module.commons.helper.FileHelper;
import org.module.commons.helper.PropHelper;
import org.module.commons.result.BaseResult;
import org.module.commons.result.EntityResult;
import org.module.commons.result.FileResult;
import org.module.commons.result.PageResult;
import org.module.commons.util.Constant;
import org.module.dto.system.user.SmUserDto;
import org.module.model.system.user.SmUser;
import org.module.service.system.user.ISmUserService;
import org.module.system.factory.UserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/user/")
public class SmUserController extends BaseController {

	@Autowired
	private ISmUserService service;

	@RequestMapping("index")
	public String inex() {
		return "jsp/system/user/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public PageResult data(SmUserDto dto) {
		return service.findEntityToPage(dto);
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return "jsp/system/user/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public EntityResult add(SmUser entity) {
		String code = CodeHelper.getCode(PropHelper.getConfig("system.code.user"));
		entity.setCode(code);
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(String code, ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == Constant.RESULT_SUCCESS) {
			model.addAttribute("entity", result.getEntity());
			return "jsp/system/user/edit";
		} else if (result.getCode() == Constant.RESULT_NULL) {
			return NULL_URL;
		} else {
			return ERROR_URL;
		}
	}

	@RequestMapping("edit")
	@ResponseBody
	public EntityResult edit(SmUser entity) {
		entity.setUpdateUser(UserFactory.userInfo().getCode());
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public BaseResult del(String code) {
		return service.deleteByCode(code);
	}

	/**
	 * 
	 * 方法: uploadHeadPic <br>
	 * 描述: 头像上传 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年11月7日 下午3:45:48
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping("upload")
	@ResponseBody
	public FileResult uploadHeadPic(HttpServletRequest request) {
		String path = PropHelper.getConfig("web.user_pic_path");
		String url = PropHelper.getConfig("web.user_pic_url");
		FileResult result = FileHelper.instance().upload(request, path, url, 0);
		return result;
	}
}
