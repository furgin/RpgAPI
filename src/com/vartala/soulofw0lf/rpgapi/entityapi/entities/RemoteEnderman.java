package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Enderman;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteEnderman extends RemoteAttackingBaseEntity<Enderman>
{
	protected boolean m_hadAttackDesire;

	public RemoteEnderman(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteEnderman(int inID, RemoteEndermanEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Enderman, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Enderman";
	}
}