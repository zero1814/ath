package org.module.commons.annotation.model;

/**
 * 
 * 类: ModelExplain <br>
 * 描述: model属性说明 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月27日 上午9:35:47
 */
public @interface ModelExplain {

	/**
	 * 
	 * 方法: name <br>
	 * 描述: 属性名称 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午9:36:40
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 
	 * 方法: description <br>
	 * 描述: 属性说明 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午9:37:07
	 * 
	 * @return
	 */
	public String description() default "";

}
