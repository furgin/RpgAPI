package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

@SuppressWarnings("serial")
public class NotAnOcelotException extends RuntimeException
{
	public NotAnOcelotException()
	{
		super("Entity is not an ocelot.");
	}
}