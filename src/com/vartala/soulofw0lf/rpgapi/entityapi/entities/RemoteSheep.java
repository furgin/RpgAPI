package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteSheep extends RemoteBaseEntity
{
	public RemoteSheep(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteSheep(int inID, RemoteSheepEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Sheep, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Sheep";
	}
}