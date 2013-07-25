package com.vartala.soulofw0lf.rpgapi.entityapi.api.features;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.ParameterData;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.ReflectionUtil;

public class RemoteFeature implements Feature
{
	protected final String NAME;
	protected RemoteEntity m_entity;

	@Deprecated
	public RemoteFeature(String inName, RemoteEntity inEntity)
	{
		this(inName);
		this.m_entity = inEntity;
	}

	public RemoteFeature(String inName)
	{
		this.NAME = inName;
	}

	@Override
	public String getName()
	{
		return this.NAME;
	}

	@Override
	public RemoteEntity getEntity()
	{
		return this.m_entity;
	}

	@Override
	public void onAdd()
	{
	}

	@Override
	public void onAdd(RemoteEntity inEntity)
	{
		this.m_entity = inEntity;
		this.onAdd();
	}

	@Override
	public void onRemove()
	{
	}

	public ParameterData[] getSerializableData()
	{
		return ReflectionUtil.getParameterDataForClass(this).toArray(new ParameterData[0]);
	}
}