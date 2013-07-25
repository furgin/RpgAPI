package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteChicken extends RemoteBaseEntity
{
	public RemoteChicken(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}
	
	public RemoteChicken(int inID, RemoteChickenEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Chicken, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Chicken";
	}
}