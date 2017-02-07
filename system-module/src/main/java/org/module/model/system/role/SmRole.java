package org.module.model.system.role;

import org.module.commons.annotation.db.Column;
import org.module.commons.annotation.db.Table;
import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Table(database = "systemmodule", name = "sm_role", comment = "角色表")
@Object(name="系统角色",description="管理系统角色")
public class SmRole extends BaseModel {

	@Column(name = "name", comment = "名称",isNull=false)
	@Attribute(name = "name", description = "名称",isNull=false)
	private String name;

	@Column(name = "flag_able", comment = "是否可用", defaultValue = "0")
	@Attribute(name = "flagAble", description = "是否可用", defaultValue = "0")
	private Integer flagAble;

	@Column(name = "intro", comment = "角色描述")
	@Attribute(name = "intro", description = "角色描述")
	private String intro;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getFlagAble() {
		return flagAble;
	}

	public void setFlagAble(Integer flagAble) {
		this.flagAble = flagAble;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

}