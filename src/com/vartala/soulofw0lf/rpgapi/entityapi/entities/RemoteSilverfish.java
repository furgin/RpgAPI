package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Silverfish;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteSilverfish extends RemoteAttackingBaseEntity<Silverfish>
{
	public RemoteSilverfish(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteSilverfish(int inID, RemoteSilverfishEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Silverfish, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Silverfish";
	}
}