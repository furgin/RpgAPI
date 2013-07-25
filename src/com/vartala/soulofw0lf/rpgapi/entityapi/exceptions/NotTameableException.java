package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

@SuppressWarnings("serial")
public class NotTameableException extends RuntimeException
{
	public NotTameableException()
	{
		super("Entity is not tameable.");
	}
}