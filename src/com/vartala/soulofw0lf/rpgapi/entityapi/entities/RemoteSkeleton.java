package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import net.minecraft.server.v1_6_R2.EntityLiving;
import org.bukkit.entity.Skeleton;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class RemoteSkeleton extends RemoteAttackingBaseEntity<Skeleton>
{
	public RemoteSkeleton(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteSkeleton(int inID, EntityLiving inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Skeleton, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Skeleton";
	}
}