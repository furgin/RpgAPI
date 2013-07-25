package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteCow extends RemoteBaseEntity
{
	public RemoteCow(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteCow(int inID, RemoteCowEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Cow, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Cow";
	}
}