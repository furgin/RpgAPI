package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.MagmaCube;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteLavaSlime extends RemoteAttackingBaseEntity<MagmaCube>
{
	public RemoteLavaSlime(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteLavaSlime(int inID, RemoteLavaSlimeEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.LavaSlime, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "LavaSlime";
	}
}