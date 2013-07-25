package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireBase;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireType;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.NMSUtil;

/**
 * Using this desire the entity will move upwards when its in water.
 */
public class DesireSwim extends DesireBase
{
	@Deprecated
	public DesireSwim(RemoteEntity inEntity)
	{
		super(inEntity);
		this.m_type = DesireType.MOVEMENT_ADDITION;
		this.getNavigation().e(true);
	}

	public DesireSwim()
	{
		super();
		this.m_type = DesireType.MOVEMENT_ADDITION;
	}

	@Override
	public void onAdd(RemoteEntity inEntity)
	{
		super.onAdd(inEntity);
		this.getNavigation().e(true);
	}

	@Override
	public boolean shouldExecute()
	{
		return this.getEntityHandle() != null && (this.getEntityHandle().G() || this.getEntityHandle().I());
	}

	@Override
	public boolean update()
	{
		if(this.getEntityHandle().aC().nextFloat() < 0.8F)
			NMSUtil.getControllerJump(this.getEntityHandle()).a();

		return true;
	}
}