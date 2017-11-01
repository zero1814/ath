package org.module.base.result;

import org.module.util.Constant;

/**
 * 
 * 类: RootResult <br>
 * 描述: 处理结果基类 <br>
 * 作者: zhy<br>
 * 时间: 2016年9月17日 下午5:22:04
 */
public class BaseResult {

	/**
	 * 消息编码
	 */
	private Integer code = Constant.RESULT_SUCCESS;
	/**
	 * 消息信息
	 */
	private String message = "";

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

}
