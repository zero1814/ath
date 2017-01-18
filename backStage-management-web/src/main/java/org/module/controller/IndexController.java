package org.module.controller;

import org.module.result.DataResult;
import org.module.result.index.IndexResult;
import org.module.service.IndexService;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	public ISmMenuGroupService menuGroupService;

	@Autowired
	private IndexService service;

	@RequestMapping("index")
	public String index(ModelMap model) {
		String userCode = "";
		DataResult result = menuGroupService.getMenuData(userCode);
		String url = "";
		if (result.getCode() == 0) {
			model.addAttribute("menugroups", result.getData());
			url = "jsp/index";
		} else {
			url = "jsp/commons/500";
		}
		return url;
	}

	/**
	 * 
	 * 方法: index <br>
	 * 描述: 首页加载 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午9:16:10
	 * 
	 * @param model
	 * @param userCode
	 * @return
	 */
	@RequestMapping("index2")
	public String index(ModelMap model, String userCode) {
		String url = "";
		IndexResult result = service.init(userCode);
		if (result.getCode() == 0) {
			url = "jsp/index/index";
		} else {
			url = "jsp/commons/500";
		}
		return url;
	}
}
