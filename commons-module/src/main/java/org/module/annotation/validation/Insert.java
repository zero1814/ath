package org.module.annotation.validation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Insert {

	public String alert() default "";

	public boolean notNull() default false;
}
