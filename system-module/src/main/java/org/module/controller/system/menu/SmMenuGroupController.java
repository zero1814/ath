package org.module.controller.system.menu;

import org.module.dto.system.menu.SmMenuGroupDto;
import org.module.model.system.menu.SmMenuGroup;
import org.module.result.DataResult;
import org.module.result.RootResult;
import org.module.service.system.menu.ISmMenuGroupService;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	private ISmMenuGroupService service;

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
		return null;
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
	public JSONArray data(SmMenuGroupDto dto) {
		return null;
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
	public RootResult add(SmMenuGroup entity) {
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
	public RootResult edit(SmMenuGroup entity) {
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

	/**
	 * 
	 * 方法: getSmMenuByUserCode <br>
	 * 描述: 获取左侧菜单栏 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月13日 下午2:30:53
	 * 
	 * @return
	 */
	@RequestMapping("menus")
	@ResponseBody
	public DataResult getSmMenuByUserCode() {
		String userCode = "";
		return service.getMenuData(userCode);
	}
}
