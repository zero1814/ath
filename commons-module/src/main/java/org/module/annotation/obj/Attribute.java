package org.module.annotation.obj;

/**
 * 
 * 类: AttributeExplain <br>
 * 描述: 类属性描述 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 上午7:43:32
 */
public @interface Attribute {

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
	 * 方法: isNull <br>
	 * 描述: 是否允许为空 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月7日 下午9:01:00
	 * 
	 * @return
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

	/**
	 * 
	 * 方法: defaultValue <br>
	 * 描述: 默认值 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月7日 下午8:51:47
	 * 
	 * @return
	 */
	public String defaultValue() default "";
}
