package org.module.controller.system.menu;


import org.module.commons.annotation.obj.Object;
import org.module.dto.system.menu.SmMenuDto;
import org.module.helper.commons.CodeHelper;
import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
import org.module.result.EntityResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("system/menu/")
@Object(name = "系统菜单控制器", description = "系统菜单前台交互相关操作")
public class SmMenuController {

	@Autowired
	private ISmMenuService service;

	@RequestMapping("index")
	public String index(String groupCode, ModelMap model) {
		model.addAttribute("groupCode", groupCode);
		return "jsp/system/menu/index";
	}

	@RequestMapping("data")
	@ResponseBody
	public DataResult data(String groupCode) {
		return service.tree(groupCode);
	}

	/**
	 * 
	 * 方法: detail <br>
	 * 描述: 获取菜单信息 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年5月22日 上午10:58:08
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("detail")
	public String detail(String code,ModelMap model) {
		EntityResult result = service.selectByCode(code);
		if(result.getCode()==0){
			model.addAttribute("menu",result.getEntity());
		}else{
			model.addAttribute("menu",new SmMenu());
		}
		return "jsp/system/menu/detail";
	}

	@RequestMapping("addindex")
	public String addIndex(String code,ModelMap model) {
		model.addAttribute("parentCode", code);
		return "jsp/system/menu/add";
	}

	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmMenu entity) {
		entity.setCode(CodeHelper.getUniqueCode("SM"));
		entity.setCreateUser("admin");
		return service.insertSelective(entity);
	}

	@RequestMapping("editindex")
	public String editIndex(ModelMap model, String code) {
		EntityResult result = service.selectByCode(code);
		if (result.getCode() == 0) {
			model.addAttribute("menu", result.getEntity());
		} else {
			model.addAttribute("menu", new SmMenu());
		}
		return "jsp/system/menu/edit";
	}

	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenu entity) {
		entity.setUpdateUser("admin");
		return service.updateByCode(entity);
	}

	@RequestMapping("del")
	@ResponseBody
	public RootResult del(String code) {
		return service.deleteByCode(code);
	}

	/**
	 * 
	 * 方法: getMenusByGroup <br>
	 * 描述: 根据菜单组编码获取对应菜单数据列表 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月17日 下午5:02:25
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping("getparentmenus")
	@ResponseBody
	public DataResult getMenusByGroup(SmMenuDto dto) {
		return service.findDataAll(dto);
	}
}
