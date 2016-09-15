package org.module.commons.file;

import java.util.List;

/**
 * 
 * 类: FileRequest <br>
 * 描述: 文件操作请求参数类 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月15日 下午7:29:27
 */
public class FileRequest {

	/**
	 * 文件名称
	 */
	private String name;

	/**
	 * 文件类型 xls,xlsx,doc,docx等
	 */
	private String type;

	/**
	 * 文件存储路径
	 */
	private String path;

	/**
	 * 存储数据集合
	 */
	private List<?> data;

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

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}

}
