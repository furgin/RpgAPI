package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

@SuppressWarnings("serial")
public class PluginNotEnabledException extends RuntimeException
{
	public PluginNotEnabledException()
	{
		super("RemoteEntities needs to be enable in order to use this operation");
	}
}