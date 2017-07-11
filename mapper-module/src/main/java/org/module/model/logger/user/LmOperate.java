package org.module.model.logger.user;

import org.module.annotation.mapper.db.Column;
import org.module.annotation.mapper.db.Table;
import org.module.model.BaseModel;

@Table(name = "lm_operate", database = "loggermodule", comment = "用户操作日志表")
public class LmOperate extends BaseModel {

	private static final long serialVersionUID = 8293860240498574792L;

	@Column(name = "operate_type", isNull = false, comment = "操作类型")
	private String operateType;

	@Column(name = "class_path", isNull = false, comment = "操作类及方法路径")
	private String classPath;

	@Column(name = "request_data", isNull = false, comment = "请求参数")
	private String requestData;

	@Column(name = "response_data", isNull = false, comment = "响应参数")
	private String responseData;

	public String getOperateType() {
		return operateType;
	}

	public void setOperateType(String operateType) {
		this.operateType = operateType;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String getResponseData() {
		return responseData;
	}

	public void setResponseData(String responseData) {
		this.responseData = responseData;
	}

}