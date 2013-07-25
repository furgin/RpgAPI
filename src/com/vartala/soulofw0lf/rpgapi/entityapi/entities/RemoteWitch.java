package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Witch;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteWitch extends RemoteAttackingBaseEntity<Witch>
{
	public RemoteWitch(int inID, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Witch, inManager);
	}

	@Override
	public String getNativeEntityName()
	{
		return "Witch";
	}
}