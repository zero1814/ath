package org.module.controller.cms;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.module.controller.BaseController;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenu;
import org.module.model.system.user.SmUser;
import org.module.result.EntityResult;
import org.module.service.cms.IndexService;
import org.module.service.system.user.ISmUserService;
import org.module.shiro.token.manager.TokenManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UrlPathHelper;


@Controller
public class IndexController extends BaseController{

	@Autowired
	private IndexService service;
	@Autowired
	private ISmUserService userService;

	/**
	 * 方法: index <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月19日 上午8:26:58
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("index")
	public String index(ModelMap model) {
		List<SmMenu> menus = service.initMenus();
		model.addAttribute("menus", menus);
		return "index";
	}

	@RequestMapping("subindex")
	public String index() {
		return "jsp/index";
	}

	@RequestMapping("login")
	@ResponseBody
	public EntityResult login(String userName, String password) {
		EntityResult result = userService.login(userName, password);
		SmUser user = (SmUser) result.getEntity();
		TokenManager.login(user, false);
		return result;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(value="kickedOut",method=RequestMethod.GET)
	public ModelAndView kickedOut(HttpServletRequest request,UrlPathHelper pp){
		//如果是踢出后，来源地址是：http://shiro.itboy.net/u/login.shtml;JSESSIONID=4f1538d9-df19-48c8-b4b1-aadacadde23a
		//如果来源是null，那么就重定向到首页。这个时候，如果首页是要登录，那就会跳转到登录页
		if(StringUtils.isBlank(request.getHeader("Referer"))){
			return redirect("/");
		}
		return new ModelAndView("jsp/system/user/kicked_out");
	}

	@RequestMapping("register")
	@ResponseBody
	public EntityResult register(SmUser entity) {
		entity.setCode(CodeHelper.getUniqueCode("SU"));
		return userService.register(entity);
	}
}
