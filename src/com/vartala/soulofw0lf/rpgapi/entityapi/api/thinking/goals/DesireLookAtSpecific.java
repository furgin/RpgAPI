package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import java.util.List;
import net.minecraft.server.v1_6_R2.EntityLiving;
import org.bukkit.craftbukkit.v1_6_R2.entity.CraftLivingEntity;
import org.bukkit.entity.LivingEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.ParameterData;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.SerializeAs;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.ReflectionUtil;

/**
 * Using this desire the entity will try and look at the given entity when it's near.
 */
public class DesireLookAtSpecific extends DesireLookAtNearest
{
	@SerializeAs(pos = 4)
	private final EntityLiving m_specificTarget;

	@Deprecated
	public DesireLookAtSpecific(RemoteEntity inEntity, EntityLiving inTarget, float inMinDistance)
	{
		super(inEntity, inTarget.getClass(), inMinDistance);
		this.m_specificTarget = inTarget;
	}

	@Deprecated
	public DesireLookAtSpecific(RemoteEntity inEntity, LivingEntity inTarget, float inMinDistance)
	{
		this(inEntity, ((CraftLivingEntity)inTarget).getHandle(), inMinDistance);
	}

	@Deprecated
	public DesireLookAtSpecific(RemoteEntity inEntity, Class<?> inTarget, float inMinDistance, float inPossibility, EntityLiving inTargetEntity)
	{
		this(inEntity, inTargetEntity, inMinDistance);
		this.m_lookPossibility = inPossibility;
	}

	public DesireLookAtSpecific(EntityLiving inTarget, float inMinDistance)
	{
		super(inTarget.getClass(), inMinDistance);
		this.m_specificTarget = inTarget;
	}

	public DesireLookAtSpecific(LivingEntity inTarget, float inMinDistance)
	{
		this(((CraftLivingEntity)inTarget).getHandle(), inMinDistance);
	}

	@Deprecated
	public DesireLookAtSpecific(Class<?> inTarget, float inMinDistance, float inPossibility, EntityLiving inTargetEntity)
	{
		this(inTargetEntity, inMinDistance);
		this.m_lookPossibility = inPossibility;
	}

	@Override
	public boolean shouldExecute()
	{
		if(!super.shouldExecute())
			return false;

		if(this.m_target != this.m_specificTarget)
			this.m_target = this.m_specificTarget;

		return true;
	}

	@Override
	public ParameterData[] getSerializableData()
	{
		List<ParameterData> thisData = ReflectionUtil.getParameterDataForClass(this);
		return thisData.toArray(new ParameterData[thisData.size()]);
	}
}