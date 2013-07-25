package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteMushroom extends RemoteBaseEntity
{
	public RemoteMushroom(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteMushroom(int inID, RemoteMushroomEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Mushroom, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "MushroomCow";
	}
}