package cn.com.controller;

import org.module.base.result.TreeResult;
import org.module.helper.PropHelper;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private ISmMenuService service;

	@RequestMapping("index")
	private String index(ModelMap model) {
		String groupCode = PropHelper.getConfig("cms.menu.group");
		TreeResult result = service.tree(groupCode);
		if (result.getCode() == 0) {
			model.addAttribute("menu", result.getData());
			return "";
		} else {
			return "";
		}

	}
}
