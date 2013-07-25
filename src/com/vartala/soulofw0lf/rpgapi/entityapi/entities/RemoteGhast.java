package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Ghast;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteGhast extends RemoteAttackingBaseEntity<Ghast>
{
	public RemoteGhast(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteGhast(int inID, RemoteGhastEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Ghast, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Ghast";
	}
}