package com.vartala.soulofw0lf.rpgapi.util;

import java.lang.reflect.Field;

public class ReflectionUtil
{
    //
	public static Object getPrivateField(Object obj, String fieldname)
	{
		try
		{
			Field field = obj.getClass().getDeclaredField(fieldname);
			field.setAccessible(true);
			return field.get(obj);
		}
		catch(Exception e)
		{
			return null;
		}
	}

}
