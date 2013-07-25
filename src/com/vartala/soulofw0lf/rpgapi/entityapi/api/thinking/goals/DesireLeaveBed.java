package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireBase;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireType;
import com.vartala.soulofw0lf.rpgapi.entityapi.entities.RemotePlayer;

/**
 * Using this desire the player will leave the bed once the sun comes out.
 */
public class DesireLeaveBed extends DesireBase
{
	@Deprecated
	public DesireLeaveBed(RemotePlayer inEntity)
	{
		super(inEntity);
		this.m_isContinuous = false;
		this.m_type = DesireType.PRIMAL_INSTINCT;
	}

	public DesireLeaveBed()
	{
		super();
		this.m_isContinuous = false;
		this.m_type = DesireType.PRIMAL_INSTINCT;
	}

	@Override
	public boolean shouldExecute()
	{
		return this.getEntityHandle().world.v() && ((RemotePlayer)this.m_entity).isSleeping();
	}

	@Override
	public void startExecuting()
	{
		((RemotePlayer)this.m_entity).leaveBed();
	}
}