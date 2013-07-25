package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

@SuppressWarnings("serial")
public class CantBreedException extends RuntimeException
{
	public CantBreedException()
	{
		super("Entity can't breed.");
	}
}