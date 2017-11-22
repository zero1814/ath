package org.module.commons.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * 类: SKipAuthPassport <br>
 * 描述: 跳过验证 <br>
 * 作者: zhy<br>
 * 时间: 2017年11月6日 下午5:02:23
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SKipAuthPassport {
	
	boolean validate() default true;
}
