package cn.com.leader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {


	/**
	 * 
	 * 方法: index <br>
	 * 描述: 初始化加载页 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年4月10日 上午9:54:00
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index(ModelMap model) {
		return null;
	}
}
