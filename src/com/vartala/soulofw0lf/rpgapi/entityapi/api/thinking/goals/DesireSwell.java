package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import net.minecraft.server.v1_6_R2.EntityCreeper;
import net.minecraft.server.v1_6_R2.EntityLiving;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireBase;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireType;
import com.vartala.soulofw0lf.rpgapi.entityapi.exceptions.NotACreeperException;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.ParameterData;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.SerializeAs;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.ReflectionUtil;

/**
 * Using this desire the creeper will start to explode when it's near its target.
 */
public class DesireSwell extends DesireBase
{
	protected EntityCreeper m_creeper;
	protected EntityLiving m_target;
	@SerializeAs(pos = 1)
	protected int m_minDistance;
	protected int m_minDistanceSqr;
	@SerializeAs(pos = 2)
	protected int m_maxDistance;
	protected int m_maxDistanceSqr;

	@Deprecated
	public DesireSwell(RemoteEntity inEntity)
	{
		this(inEntity, 3, 7);
	}

	@Deprecated
	public DesireSwell(RemoteEntity inEntity, int inMinDistance, int inMaxDistance)
	{
		super(inEntity);
		if(!(this.getEntityHandle() instanceof EntityCreeper))
			throw new NotACreeperException();

		this.m_creeper = (EntityCreeper)this.getEntityHandle();
		this.m_type = DesireType.PRIMAL_INSTINCT;
		this.m_minDistance = inMinDistance;
		this.m_minDistanceSqr = inMinDistance * inMinDistance;
		this.m_maxDistance = inMaxDistance;
		this.m_maxDistanceSqr = inMaxDistance * inMaxDistance;
	}

	public DesireSwell()
	{
		this(3, 7);
	}

	public DesireSwell(int inMinDistance, int inMaxDistance)
	{
		super();
		this.m_type = DesireType.PRIMAL_INSTINCT;
		this.m_minDistance = inMinDistance;
		this.m_minDistanceSqr = inMinDistance * inMinDistance;
		this.m_maxDistance = inMaxDistance;
		this.m_maxDistanceSqr = inMaxDistance * inMaxDistance;
	}

	@Override
	public void onAdd(RemoteEntity inEntity)
	{
		super.onAdd(inEntity);
		if(!(this.getEntityHandle() instanceof EntityCreeper))
			throw new NotACreeperException();

		this.m_creeper = (EntityCreeper)this.getEntityHandle();
	}

	@Override
	public boolean shouldExecute()
	{
		if(this.m_creeper == null)
			return false;

		EntityLiving target = this.m_creeper.getGoalTarget();
		return this.m_creeper.o() > 0 || target != null && this.m_creeper.e(target) < this.m_minDistanceSqr;
	}

	@Override
	public void startExecuting()
	{
		this.m_creeper.getNavigation().g();
		this.m_target = this.m_creeper.getGoalTarget();
	}

	@Override
	public void stopExecuting()
	{
		this.m_target = null;
	}

	@Override
	public boolean update()
	{
		if(this.m_target == null)
			this.m_creeper.a(-1);
		else if(this.m_creeper.e(this.m_target) > this.m_maxDistanceSqr)
			this.m_creeper.a(-1);
		else if(!this.m_creeper.getEntitySenses().canSee(this.m_target))
			this.m_creeper.a(-1);
		else
			this.m_creeper.a(1);
		return true;
	}

	@Override
	public ParameterData[] getSerializableData()
	{
		return ReflectionUtil.getParameterDataForClass(this).toArray(new ParameterData[0]);
	}
}