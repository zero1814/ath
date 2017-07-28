package org.module.annotation.db;

/**
 * 
 * 类: column <br>
 * 描述: 数据表列标注 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月27日 上午10:04:33
 */
public @interface Column {

	/**
	 * 
	 * 方法: name <br>
	 * 描述: 列名 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:05:56
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
	 * @return
	 */
	public boolean isNull() default true;

	/**
	 * 
	 * 方法: defaultVal <br>
	 * 描述: 默认值 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:14:18
	 * 
	 * @return
	 */
	public String defaultValue() default "";

	/**
	 * 
	 * 方法: comment <br>
	 * 描述: 列描述 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:06:47
	 * 
	 * @return
	 */
	public String comment() default "";

}
