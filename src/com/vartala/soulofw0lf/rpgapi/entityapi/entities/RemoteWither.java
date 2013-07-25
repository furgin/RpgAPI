package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Wither;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteWither extends RemoteAttackingBaseEntity<Wither>
{
	public RemoteWither(int inID, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Wither, inManager);
	}

	@Override
	public String getNativeEntityName()
	{
		return "WitherBoss";
	}
}