package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

@SuppressWarnings("serial")
public class NoAgeException extends RuntimeException
{
	public NoAgeException()
	{
		super("Entity needs an age.");
	}
}