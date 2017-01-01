package org.module.commons.annotation.obj;

/**
 * 
 * 类: Method <br>
 * 描述: 类方法介绍 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月29日 下午3:47:00
 */
public @interface MethodExplain {

	/**
	 * 
	 * 方法: name <br>
	 * 描述: 方法名称 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月29日 下午4:15:53
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 
	 * 方法: param <br>
	 * 描述: 方法参数，json字符串存储 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月29日 下午4:16:55
	 * 
	 * @return
	 */
	public String param() default "";

	/**
	 * 
	 * 方法: isReturnVal <br>
	 * 描述: 是否有返回值 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月29日 下午4:17:56
	 * 
	 * @return
	 */
	public boolean isReturnVal() default false;

	/**
	 * 
	 * 方法: returnValType <br>
	 * 描述: 返回值类型 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月29日 下午4:17:29
	 * 
	 * @return
	 */
	public String returnValType() default "";
}
