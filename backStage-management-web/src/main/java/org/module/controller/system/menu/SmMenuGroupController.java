package org.module.controller.system.menu;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.module.commons.helper.CodeHelper;
import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.DataResult;
import org.module.result.PageResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

@Controller
@RequestMapping("system/menugroup")
public class SmMenuGroupController {

	@Autowired
	public ISmMenuGroupService service;

	@RequestMapping("index")
	public String index() {
		return "jsp/system/menugroup/index";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("data")
	@ResponseBody
	public JSONObject data(SmMenuGroupDto dto) {
		PageResult result = service.findEntityToPage(dto);
		List<SmMenuGroup> list = new ArrayList<SmMenuGroup>();
		JSONObject obj = new JSONObject();
		if (result.getCode() == 0) {
			list = (List<SmMenuGroup>) result.getData();
			JSONArray array = new JSONArray();
			for (SmMenuGroup smMenuGroup : list) {
				JSONObject group = (JSONObject) JSON.toJSON(smMenuGroup);
				group.put("edit_group", "<a href='javascript:void(0)' onclick='MenuGroup.openEdit(\""
						+ smMenuGroup.getCode() + "\",\"" + smMenuGroup.getName() + "\")'>编辑</a>");
				group.put("del_group", "<a href='javascript:void(0)' onclick='MenuGroup.del(\"" + smMenuGroup.getCode()
						+ "\")'>删除</a>");
				array.add(group);
			}
			obj.put("total", result.getTotal());
			obj.put("rows", array);
		}
		return obj;
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmMenuGroup entity) {
		RootResult root = new RootResult();
		if (StringUtils.isNotBlank(entity.getName())) {
			String userCode = "test";
			entity.setCode(CodeHelper.getUniqueCode("SM"));
			entity.setCreateUser(userCode);
			root = service.insertSelective(entity);
		} else {
			root.setCode(-1);
			root.setMessage("名称不能为空");
		}
		return root;
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenuGroup entity) {
		String userCode = "test";
		entity.setUpdateUser(userCode);
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}

	@RequestMapping("menus")
	@ResponseBody
	public DataResult getMenus() {
		String userCode = "";
		return service.getMenuData(userCode);
	}
}
