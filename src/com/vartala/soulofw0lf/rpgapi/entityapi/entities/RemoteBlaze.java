package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Blaze;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteBlaze extends RemoteAttackingBaseEntity<Blaze>
{
	public RemoteBlaze(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteBlaze(int inID, RemoteBlazeEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Blaze, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Blaze";
	}
}