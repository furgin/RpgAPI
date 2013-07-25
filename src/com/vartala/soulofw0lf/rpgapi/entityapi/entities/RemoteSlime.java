package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Slime;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteSlime extends RemoteAttackingBaseEntity<Slime>
{
	public RemoteSlime(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteSlime(int inID, RemoteSlimeEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Slime, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Slime";
	}
}