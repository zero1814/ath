package org.module.web.init;

import org.module.base.result.TreeResult;
import org.module.helper.CacheHelper;
import org.module.service.system.menu.ISmMenuService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

/**
 * 
 * 类: MenuInit <br>
 * 描述: 将菜单添加到缓存中 <br>
 * 作者: zhy<br>
 * 时间: 2017年10月20日 下午6:03:37
 */
public class MenuInit extends RootInit {

	@Autowired
	private ISmMenuService service;

	@Override
	public boolean onInit() {
		getLogger().logInfo("开始加载菜单列表");
		boolean flag = true;
		try {
			TreeResult result = service.treeData();
			if (result.getCode() == 1) {
				new CacheHelper().setValue("menu", JSON.toJSONString(result.getData()));
			}
			flag = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			getLogger().logInfo("加载菜单列表完成");
		}
		return flag;
	}

	@Override
	public boolean onDestory() {
		return false;
	}

}
