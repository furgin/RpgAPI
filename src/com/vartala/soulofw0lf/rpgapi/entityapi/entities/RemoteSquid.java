package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteSquid extends RemoteBaseEntity
{
	public RemoteSquid(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteSquid(int inID, RemoteSquidEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Squid, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Squid";
	}
}