package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import org.bukkit.Location;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.*;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.ParameterData;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.SerializeAs;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.ReflectionUtil;

/**
 * Using this desire the entity will move to a specific location.
 * Once it reached that location the desire will be removed.
 */
public class DesireMoveToLocation extends DesireBase implements OneTimeDesire
{
	@SerializeAs(pos = 1)
	private Location m_targetLocation;

	@Deprecated
	public DesireMoveToLocation(RemoteEntity inEntity, Location inTargetLocation)
	{
		super(inEntity);
		this.m_targetLocation = inTargetLocation;
		this.m_type = DesireType.FULL_CONCENTRATION;
	}

	public DesireMoveToLocation(Location inTargetLocation)
	{
		super();
		this.m_targetLocation = inTargetLocation;
		this.m_type = DesireType.FULL_CONCENTRATION;
	}

	@Override
	public boolean shouldExecute()
	{
		return this.getRemoteEntity().getBukkitEntity().getLocation().distanceSquared(this.m_targetLocation) > 1.15;
	}

	@Override
	public boolean canContinue()
	{
		return !this.getNavigation().g();
	}

	@Override
	public void startExecuting()
	{
		this.m_entity.move(this.m_targetLocation);
	}

	@Override
	public boolean isFinished()
	{
		return !this.canContinue() && this.getRemoteEntity().getBukkitEntity().getLocation().distance(this.m_targetLocation) < 2;
	}

	@Override
	public ParameterData[] getSerializableData()
	{
		return ReflectionUtil.getParameterDataForClass(this).toArray(new ParameterData[0]);
	}
}