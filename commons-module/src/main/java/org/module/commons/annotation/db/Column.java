package org.module.commons.annotation.db;

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
	 * 方法: property <br>
	 * 描述: 列对应java类属性 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:06:06
	 * 
	 * @return
	 */
	public String property() default "";

	/**
	 * 
	 * 方法: jdbcType <br>
	 * 描述: 列jdbc类型 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:06:32
	 * 
	 * @return
	 */
	public String jdbcType() default "";

	/**
	 * 
	 * 方法: length <br>
	 * 描述: 数据表字段长度 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:16:32
	 * 
	 * @return
	 */
	public int length() default 0;

	/**
	 * 
	 * 方法: defaultVal <br>
	 * 描述: 默认值 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:14:18
	 * 
	 * @return
	 */
	public String defaultVal() default "";

	/**
	 * 
	 * 方法: key <br>
	 * 描述: 列索引 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:06:54
	 * 
	 * @return
	 */
	public String key() default "";

	/**
	 * 
	 * 方法: isNull <br>
	 * 描述: 是否允许为空 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:15:12
	 * 
	 * @return
	 */
	public boolean isNull() default true;

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
