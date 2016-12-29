package org.commons.result;

import org.commons.base.BaseResult;

/**
 * 
 * 类: EntityResult <br>
 * 描述: 查询对象结果类 <br>
 * 作者: zhy<br>
 * 时间: 2016年10月24日 上午7:33:41
 * @param <T>
 */
public class EntityResult<T> extends BaseResult {

	private T entity;

	public T getEntity() {
		return entity;
	}

	public void setEntity(T entity) {
		this.entity = entity;
	}

}
