package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteVillager extends RemoteBaseEntity
{
	public RemoteVillager(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteVillager(int inID, RemoteVillagerEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Villager, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Villager";
	}
}