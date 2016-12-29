package org.system.model.server;

import org.module.commons.annotation.model.AttributeExplain;
import org.module.commons.annotation.model.ModelExplain;
import org.module.commons.base.BaseModel;

@ModelExplain(name = "系统服务器维护", description = "系统服务器维护")
public class SmServer extends BaseModel {

	@AttributeExplain(name = "code", isNull = false, description = "服务器编码")
	private String code;

	@AttributeExplain(name = "name", isNull = false, description = "服务器名称")
	private String name;

	@AttributeExplain(name = "ip", isNull = false, description = "服务器ip")
	private String ip;

	@AttributeExplain(name = "groupCode", isNull = false, description = "服务器分组")
	private String groupCode;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getGroupCode() {
		return groupCode;
	}

	public void setGroupCode(String groupCode) {
		this.groupCode = groupCode;
	}

}