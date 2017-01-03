package org.module.controller.system.menu;

import org.module.dto.system.menu.SmMenuDto;
import org.module.model.system.menu.SmMenu;
import org.module.result.DataResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONArray;

/**
 * 
 * 类: SmMenuController <br>
 * 描述: 菜单管理controller <br>
 * 作者: zhy<br>
 * 时间: 2017年1月3日 上午8:40:11
 */
@Controller
@RequestMapping("system/menu/")
public class SmMenuController {

	@Autowired
	private ISmMenuService service;

	/**
	 * 
	 * 方法: index <br>
	 * 描述: 列表页 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午9:12:50
	 * 
	 * @return
	 */
	@RequestMapping("index")
	public String index() {
		return "jsp/system/menu/index";
	}

	/**
	 * 
	 * 方法: data <br>
	 * 描述: ajax数据加载 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午9:12:56
	 * 
	 * @param dto
	 * @return
	 */
	@RequestMapping("data")
	public DataResult data(SmMenuDto dto) {
		return service.findDataAll(dto);
	}

	/**
	 * 
	 * 方法: addIndex <br>
	 * 描述: 数据添加页面 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午9:13:04
	 * 
	 * @return
	 */
	@RequestMapping("addindex")
	public String addIndex() {
		return null;
	}

	/**
	 * 
	 * 方法: add <br>
	 * 描述: ajax添加 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午9:13:12
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public RootResult add(SmMenu entity) {
		RootResult result = new RootResult();
		return result;
	}

	/**
	 * 
	 * 方法: editIndex <br>
	 * 描述: 修改页 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午9:13:24
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("editindex")
	public String editIndex(String code) {
		return null;
	}

	/**
	 * 
	 * 方法: edit <br>
	 * 描述: ajax修改 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午9:13:31
	 * 
	 * @param entity
	 * @return
	 */
	@RequestMapping("edit")
	@ResponseBody
	public RootResult edit(SmMenu entity) {
		RootResult result = new RootResult();
		return result;
	}

	/**
	 * 
	 * 方法: delete <br>
	 * 描述: ajax删除 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月3日 上午9:13:38
	 * 
	 * @param code
	 * @return
	 */
	@RequestMapping("del")
	@ResponseBody
	public RootResult delete(String code) {
		RootResult result = new RootResult();
		return result;
	}
}
