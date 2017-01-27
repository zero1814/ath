package org.module.commons.annotation.db;

/**
 * 
 * 类: table <br>
 * 描述: 表标注 <br>
 * 作者: zhy<br>
 * 时间: 2016年12月27日 上午9:59:57
 */
public @interface Table {

	/**
	 * 
	 * 方法: name <br>
	 * 描述: 表名称 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:00:42
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 
	 * 方法: database <br>
	 * 描述: 表所在数据库名称 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:00:49
	 * 
	 * @return
	 */
	public String database() default "";


	/**
	 * 
	 * 方法: engine <br>
	 * 描述: 表引擎 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年1月27日 下午10:28:03
	 * 
	 * @return
	 */
	public String engine() default "InnoDB";
	
	/**
	 * 
	 * 方法: comment <br>
	 * 描述: 表描述 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年12月27日 上午10:00:59
	 * 
	 * @return
	 */
	public String comment() default "";

}
