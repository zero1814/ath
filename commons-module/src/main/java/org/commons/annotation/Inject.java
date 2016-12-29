package org.commons.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * 
 * 类: InitCache <br>
 * 描述: 初始化缓存注解 <br>
 * 作者: zhy<br>
 * 时间: 2016年8月30日 上午11:02:23
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {

	/**
	 * 
	 * 方法: className <br>
	 * 描述: 初始化类的class名称 <br>
	 * 作者: zhy<br>
	 * 时间: 2016年8月30日 上午11:32:53
	 * 
	 * @return
	 */
	public String className() default "";
}
