package org.module.file;

import java.util.List;

import org.module.commons.base.BaseResult;

public class File extends BaseResult {

	/**
	 * 文件名称
	 */
	private String name;
	/**
	 * 文件类型
	 */
	private String type;
	/**
	 * 文件路径
	 */
	private String path;
	/**
	 * 文件大小
	 */
	private String size;
	/**
	 * 文件数据
	 */
	private List<?> data;
	/**
	 * 文件数据总量
	 */
	private Integer total;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

}
