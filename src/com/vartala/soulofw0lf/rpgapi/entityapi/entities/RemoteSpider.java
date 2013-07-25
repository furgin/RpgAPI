package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import org.bukkit.entity.Spider;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;

public class  RemoteSpider extends RemoteAttackingBaseEntity<Spider>
{
	public RemoteSpider(int inID, EntityManager inManager)
	{
		this(inID, null, inManager);
	}

	public RemoteSpider(int inID, RemoteSpiderEntity inEntity, EntityManager inManager)
	{
		super(inID, RemoteEntityType.Spider, inManager);
		this.m_entity = inEntity;
	}

	@Override
	public String getNativeEntityName()
	{
		return "Spider";
	}
}