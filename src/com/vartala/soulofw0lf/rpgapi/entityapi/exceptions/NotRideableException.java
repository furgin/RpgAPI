package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

public class NotRideableException extends RuntimeException
{
	public NotRideableException()
	{
		super("The entity can't be ridden.");
	}
}