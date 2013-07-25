package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.ParameterData;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.SerializeAs;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.ReflectionUtil;

/**
 * Using this desire the entity will open doors which are in its path and might also close them afterwards.
 */
public class DesireOpenDoor extends DesireInteractDoor
{
	@SerializeAs(pos = 2)
	protected boolean m_closeDoor;
	protected int m_closeTick;

	@Deprecated
	public DesireOpenDoor(RemoteEntity inEntity, boolean inIronDoor, boolean inCloseDoor)
	{
		super(inEntity, inIronDoor);
		this.m_closeDoor = inCloseDoor;
	}

	public DesireOpenDoor( boolean inIronDoor, boolean inCloseDoor)
	{
		super(inIronDoor);
		this.m_closeDoor = inCloseDoor;
	}

	@Override
	public boolean canContinue()
	{
		return this.m_closeDoor && this.m_closeTick > 0 && super.canContinue();
	}

	@Override
	public void startExecuting()
	{
		this.m_closeTick = 20;
		this.m_door.setDoor(this.getEntityHandle().world, this.m_x, this.m_y, this.m_z, true);
	}

	@Override
	public void stopExecuting()
	{
		if(this.m_closeDoor)
			this.m_door.setDoor(this.getEntityHandle().world, this.m_x, this.m_y, this.m_z, false);
	}

	@Override
	public boolean update()
	{
		this.m_closeTick--;
		return super.update();
	}

	@Override
	public ParameterData[] getSerializableData()
	{
		return ReflectionUtil.getParameterDataForClass(this).toArray(new ParameterData[0]);
	}
}