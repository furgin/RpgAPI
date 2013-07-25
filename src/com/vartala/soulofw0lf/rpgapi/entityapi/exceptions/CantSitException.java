package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

@SuppressWarnings("serial")
public class CantSitException extends RuntimeException
{
	public CantSitException()
	{
		super("Entity is not able to sit.");
	}
}