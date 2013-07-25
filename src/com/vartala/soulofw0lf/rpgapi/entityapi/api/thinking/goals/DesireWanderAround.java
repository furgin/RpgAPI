package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import net.minecraft.server.v1_6_R2.EntityTameableAnimal;
import net.minecraft.server.v1_6_R2.Vec3D;
import org.bukkit.Location;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireBase;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireType;
import com.vartala.soulofw0lf.rpgapi.entityapi.nms.RandomPositionGenerator;

/**
 * Using this desire the entity will move around randomly.
 */
public class DesireWanderAround extends DesireBase
{
	protected double m_xPos;
	protected double m_yPos;
	protected double m_zPos;

	@Deprecated
	public DesireWanderAround(RemoteEntity inEntity)
	{
		super(inEntity);
		this.m_type = DesireType.PRIMAL_INSTINCT;
	}

	public DesireWanderAround()
	{
		super();
		this.m_type = DesireType.PRIMAL_INSTINCT;
	}

	@Override
	public boolean shouldExecute()
	{
		if(this.getEntityHandle() == null)
			return false;

		if(this.getEntityHandle().aE() >= 100)
			return false;
		else if(this.getEntityHandle().aC().nextInt(120) != 0)
			return false;
		else if(this.getEntityHandle() instanceof EntityTameableAnimal && ((EntityTameableAnimal)this.getEntityHandle()).isSitting())
			return false;
		else
		{
			Vec3D vector = RandomPositionGenerator.a(this.getEntityHandle(), 10, 7);
			if(vector == null)
				return false;
			else
			{
				this.m_xPos = vector.c;
				this.m_yPos = vector.d;
				this.m_zPos = vector.e;
				Vec3D.a.release(vector);
				return true;
			}
		}
	}

	@Override
	public boolean canContinue()
	{
		return !this.getNavigation().g();
	}

	@Override
	public void startExecuting()
	{
		this.getRemoteEntity().move(new Location(this.getRemoteEntity().getBukkitEntity().getWorld(), this.m_xPos, this.m_yPos, this.m_zPos));
	}
}