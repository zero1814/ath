package org.module.model.system.page;

import org.module.commons.annotation.obj.Attribute;
import org.module.commons.annotation.obj.Object;
import org.module.model.BaseModel;

@Object(name = "按钮样式", description = "按钮样式")
public class SmButtonStyle extends BaseModel {

	@Attribute(name = "名称", isNull = false)
	private String name;

	@Attribute(name = "图标")
	private String icon;

	@Attribute(name = "css样式", isNull = false)
	private String style;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

}