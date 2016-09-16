package org.module.commons.file;

/**
 * 
 * 类: FileResponse <br>
 * 描述: 文件操作响应参数类 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月15日 下午7:29:47
 */
public class FileResponse {

	/**
	 * 文件操作响应编码
	 */
	private Integer code;

	/**
	 * 文件响应消息
	 */
	private String message;

	/**
	 * 文件存储全路径
	 */
	private String filePath;

	/**
	 * 文件存储大小
	 */
	private String size;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
