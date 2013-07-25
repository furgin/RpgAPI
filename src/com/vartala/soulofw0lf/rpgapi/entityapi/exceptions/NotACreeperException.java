package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

@SuppressWarnings("serial")
public class NotACreeperException extends RuntimeException
{
	public NotACreeperException()
	{
		super("Entity is not a creeper.");
	}
}