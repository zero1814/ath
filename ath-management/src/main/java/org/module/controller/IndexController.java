package org.module.controller;

import org.module.service.index.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;

@Controller
public class IndexController {

	@Autowired
	private IndexService service;

	@RequestMapping("index")
	public String index(ModelMap model) {
		model.addAttribute("menugroups", service.getMenus());
		System.out.println(JSON.toJSON(service.getMenus()));
		return "jsp/index";
	}

	@RequestMapping("indexdata")
	public String indexData() {
		return "jsp/index/data";
	}
}
