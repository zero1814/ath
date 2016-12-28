package org.module.commons.annotation.model;

/**
 * 
 * 类: AttributeExplain <br>
 * 描述: 类属性描述 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 上午7:43:32
 */
public @interface AttributeExplain {

	/**
	 * 
	 * 方法: name <br>
	 * 描述: 名称 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月29日 上午7:43:57
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 
	 * 方法: defaultVal <br>
	 * 描述: 默认值 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月29日 上午7:44:20
	 * 
	 * @return
	 */
	public String defaultVal() default "";

	/**
	 * 是否为空
	 */
	public boolean isNull() default true;

	/**
	 * 
	 * 方法: description <br>
	 * 描述: 属性描述 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月29日 上午7:45:12
	 * 
	 * @return
	 */
	public String description() default "";
}
