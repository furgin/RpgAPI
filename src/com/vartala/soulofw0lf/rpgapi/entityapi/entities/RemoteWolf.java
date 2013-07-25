package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Wolf;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteWolf extends RemoteAttackingBaseEntity<Wolf>
{
	public RemoteWolf(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteWolf(int inID, RemoteWolfEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Wolf, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Wolf";
	}
}