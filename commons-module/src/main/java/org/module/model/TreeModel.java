package org.module.model;

import java.util.List;

/**
 * 
 * 类: TreeModel <br>
 * 描述: 树型对象 <br>
 * 作者: zhy<br>
 * 时间: 2017年5月22日 上午11:10:23
 */
public class TreeModel extends BaseModel {

	private String text;

	private List<TreeModel> nodes;

	public List<TreeModel> getNodes() {
		return nodes;
	}

	public void setNodes(List<TreeModel> nodes) {
		this.nodes = nodes;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
