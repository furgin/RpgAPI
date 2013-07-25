package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Snowman;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteSnowman extends RemoteAttackingBaseEntity<Snowman>
{
	public RemoteSnowman(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteSnowman(int inID, RemoteSnowmanEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Snowman, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "SnowMan";
	}
}