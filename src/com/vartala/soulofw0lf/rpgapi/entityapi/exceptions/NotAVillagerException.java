package com.vartala.soulofw0lf.rpgapi.entityapi.exceptions;

@SuppressWarnings("serial")
public class NotAVillagerException extends RuntimeException
{
	public NotAVillagerException()
	{
		super("Entity is not a villager.");
	}
}