package org.module.controller.system.menu;

import org.module.model.system.menu.SmMenuGroup;
import org.module.result.RootResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * 类: SmMenuGroupController <br>
 * 描述: 菜单组管理controller <br>
 * 作者: zhy<br>
 * 时间: 2017年1月3日 上午8:40:39
 */
@Controller
@RequestMapping("system/menugroup/")
public class SmMenuGroupController {

	@RequestMapping("index")
	public String index() {
		return null;
	}

	@RequestMapping("data")
	public JSONArray data() {
		return null;
	}

	@RequestMapping("addindex")
	public String addIndex() {
		return null;
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmMenuGroup entity) {
		RootResult result = new RootResult();
		return result;
	}

	@RequestMapping("editindex")
	public String editIndex(String code) {
		return null;
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenuGroup entity) {
		RootResult result = new RootResult();
		return result;
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult delete(String code) {
		RootResult result = new RootResult();
		return result;
	}
}
