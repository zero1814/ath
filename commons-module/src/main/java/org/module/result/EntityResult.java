package org.module.result;


/**
 * 
 * 类: EntityResult <br>
 * 描述: 查询对象结果类 <br>
 * 作者: zhy<br>
 * 时间: 2016年10月24日 上午7:33:41
 * @param <T>
 */
public class EntityResult extends RootResult {

	private Object entity;

	public Object getEntity() {
		return entity;
	}

	public void setEntity(Object entity) {
		this.entity = entity;
	}

	
}
