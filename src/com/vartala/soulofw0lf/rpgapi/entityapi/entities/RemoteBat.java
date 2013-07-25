package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Bat;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteBat extends RemoteAttackingBaseEntity<Bat>
{
	public RemoteBat(int inID, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Bat, inManager);
	}

	public RemoteBat(int inID, RemoteBatEntity inEntity, EntityManager inManager)
	{
		this(inID, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Bat";
	}
}