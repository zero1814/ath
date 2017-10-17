package org.module.base.model;

import java.util.List;

/**
 * 
 * 类: TreeModel <br>
 * 描述: 树型对象 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月22日 上午11:10:23
 */
public class TreeModel extends BaseModel {

	private static final long serialVersionUID = -7978315041625771262L;

	private String text;

	private List<? extends TreeModel> nodes;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public List<? extends TreeModel> getNodes() {
		return nodes;
	}

	public void setNodes(List<? extends TreeModel> nodes) {
		this.nodes = nodes;
	}

}
