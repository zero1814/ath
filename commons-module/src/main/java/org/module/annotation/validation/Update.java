package org.module.annotation.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Update {

	/**
	 * 
	 * 方法: upateFlag <br>
	 * 描述: 是否可以修改 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月27日 下午5:53:09
	 * @return
	 */
	public boolean flag() default true;
	
	/**
	 * 
	 * 方法: alert <br>
	 * 描述: 提示语 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月27日 下午5:53:19
	 * @return
	 */
	public String alert() default "";

	/**
	 * 
	 * 方法: notNull <br>
	 * 描述: 是否可以为空 <br>
	 * 作者: zhy<br>
	 * 时间: 2017年10月27日 下午5:53:33
	 * @return
	 */
	public boolean notNull() default false;
}