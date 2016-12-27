package org.system.module.model;

import org.module.commons.annotation.ModelExplain;
import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.base.BaseModel;

/**
 * 
 * 类: SmMenu <br>
 * 描述: 系统菜单类 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月27日 上午9:33:14
 */
@Table(name = "sm_menu", database = "systemodule", comment = "系统菜单表")
public class SmMenu extends BaseModel {

	@ModelExplain(name = "parentCode", description = "父级编码")
	@Column(name = "parent_code", property = "parentCode", length = 50, jdbcType = "VARCHAR", comment = "父级编码")
	private String parentCode;
	@ModelExplain(name = "name", description = "菜单名称")
	@Column(name = "name", property = "name", jdbcType = "VARCHAR", length = 20, comment = "菜单名称", isNull = false)
	private String name;
	@Column(name = "url", property = "url", jdbcType = "VARCHAR", length = 100, comment = "菜单链接地址")
	@ModelExplain(name = "url", description = "菜单链接地址")
	private String url;
	@ModelExplain(name = "flagAble", description = "是否可用 0 可用 1 不可用", defaultVal = "0")
	@Column(name = "flag_able", property = "flagAble", jdbcType = "int", length = 2, comment = "是否可用 0 可用 1 不可用", defaultVal = "0")
	private String flagAble;

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFlagAble() {
		return flagAble;
	}

	public void setFlagAble(String flagAble) {
		this.flagAble = flagAble;
	}
}
