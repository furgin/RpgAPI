package com.vartala.soulofw0lf.rpgapi.entityapi.api.features;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.ParameterData;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.SerializeAs;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.ReflectionUtil;

public class RemoteAgeFeature extends RemoteFeature implements AgeFeature
{
	@SerializeAs(pos = 1)
	protected int m_age;

	public RemoteAgeFeature()
	{
		this(0);
	}

	public RemoteAgeFeature(int inAge)
	{
		super("AGE");
		this.m_age = inAge;
	}

	@Deprecated
	public RemoteAgeFeature(RemoteEntity inEntity)
	{
		this(inEntity, 0);
	}

	@Deprecated
	public RemoteAgeFeature(RemoteEntity inEntity, int inAge)
	{
		super("AGE", inEntity);
		this.m_age = inAge;
	}

	@Override
	public int getAge()
	{
		return this.m_age;
	}

	@Override
	public void setAge(int inAge)
	{
		this.m_age = inAge;
	}

	@Override
	public ParameterData[] getSerializableData()
	{
		return ReflectionUtil.getParameterDataForClass(this).toArray(new ParameterData[0]);
	}
}