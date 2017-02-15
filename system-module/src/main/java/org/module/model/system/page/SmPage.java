package org.module.model.system.page;

import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Object(name = "页面维护", description = "页面维护")
public class SmPage extends BaseModel {

	@Attribute(name = "名称", isNull = false)
	private String name;

	@Attribute(name = "名称", isNull = false)
	private String url;

	@Attribute(name = "描述")
	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

}