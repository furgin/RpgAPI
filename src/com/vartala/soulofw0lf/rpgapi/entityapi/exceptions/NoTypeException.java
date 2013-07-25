package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

@SuppressWarnings("serial")
public class NoTypeException extends RuntimeException
{
	public NoTypeException()
	{
		super("No entity type specified");
	}
}