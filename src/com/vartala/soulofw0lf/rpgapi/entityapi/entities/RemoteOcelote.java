package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Ocelot;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteOcelote extends RemoteAttackingBaseEntity<Ocelot>
{
	public RemoteOcelote(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteOcelote(int inID, RemoteOceloteEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Ocelot, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Ozelot";
	}
}