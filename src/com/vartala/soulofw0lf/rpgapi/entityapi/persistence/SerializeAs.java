package com.vartala.soulofw0lf.rpgapi.entityapi.persistence;

import java.lang.annotation.*;

/**
 * Gives info about the variable where it is needed in the constructor
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Inherited
public @interface SerializeAs
{
	public int pos();
	public String special() default "";
}