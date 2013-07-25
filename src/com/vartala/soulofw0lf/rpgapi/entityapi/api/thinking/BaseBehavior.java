package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.ParameterData;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.SerializeAs;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.ReflectionUtil;

public abstract class BaseBehavior implements Behavior
{
	protected String m_name;
	@SerializeAs(pos = 0, special = "entity")
	protected final RemoteEntity m_entity;

	public BaseBehavior(RemoteEntity inEntity)
	{
		this.m_entity = inEntity;
	}

	@Override
	public void run()
	{
	}

	@Override
	public String getName()
	{
		return this.m_name;
	}

	@Override
	public void onAdd()
	{
	}

	@Override
	public void onRemove()
	{
	}

	@Override
	public RemoteEntity getRemoteEntity()
	{
		return this.m_entity;
	}

	@Override
	public ParameterData[] getSerializableData()
	{
		return ReflectionUtil.getParameterDataForClass(this).toArray(new ParameterData[0]);
	}
}