package com.gx.inf;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注
 * @author win10
 *
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) 
public @interface InfoFool {
	public String isEnable() default JdType.SELECT;
}
