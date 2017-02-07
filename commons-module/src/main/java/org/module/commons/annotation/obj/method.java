package org.module.commons.annotation.obj;

/**
 * 
 * 类: method <br>
 * 描述: 类方法说明 <br>
 * 作者: zhy<br>
 * 时间: 2017年2月7日 下午9:31:50
 */
public @interface method {

	/**
	 * 
	 * 方法: name <br>
	 * 描述: 方法名称 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月7日 下午9:31:19
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 
	 * 方法: description <br>
	 * 描述: 方法描述 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年2月7日 下午9:31:41
	 * 
	 * @return
	 */
	public String description() default "";
}
