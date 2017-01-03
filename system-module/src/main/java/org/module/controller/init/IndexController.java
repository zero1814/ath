package org.module.controller.init;

import org.module.result.index.IndexResult;
import org.module.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

	@Autowired
	private IndexService service;

	@RequestMapping("index")
	public IndexResult index(ModelMap model, String userCode) {
		IndexResult result = service.init(userCode);
		return result;
	}
}
