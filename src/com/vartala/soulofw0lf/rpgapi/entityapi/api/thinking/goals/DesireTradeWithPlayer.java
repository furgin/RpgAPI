package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import net.minecraft.server.v1_6_R2.EntityHuman;
import net.minecraft.server.v1_6_R2.EntityVillager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireBase;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireType;
import com.vartala.soulofw0lf.rpgapi.entityapi.exceptions.NotAVillagerException;

/**
 * Using this desire the villager will stop moving when a player is trading with him.
 */
public class DesireTradeWithPlayer extends DesireBase
{
	protected EntityVillager m_villager;

	@Deprecated
	public DesireTradeWithPlayer(RemoteEntity inEntity)
	{
		super(inEntity);
		if(!(this.getEntityHandle() instanceof EntityVillager))
			throw new NotAVillagerException();

		this.m_villager = (EntityVillager)this.getEntityHandle();
		this.m_type = DesireType.OCCASIONAL_URGE;
	}

	public DesireTradeWithPlayer()
	{
		super();
		this.m_type = DesireType.OCCASIONAL_URGE;
	}

	@Override
	public void onAdd(RemoteEntity inEntity)
	{
		super.onAdd(inEntity);
		if(!(this.getEntityHandle() instanceof EntityVillager))
			throw new NotAVillagerException();

		this.m_villager = (EntityVillager)this.getEntityHandle();
	}

	@Override
	public boolean shouldExecute()
	{
		if(this.getEntityHandle() == null)
			return false;

		if(!this.getEntityHandle().isAlive())
			return false;
		else if(this.getEntityHandle().G())
			return false;
		else if(!this.getEntityHandle().onGround)
			return false;
		else if(this.getEntityHandle().velocityChanged)
			return false;
		else
		{
			EntityHuman trader = this.m_villager.m_();
			if(trader == null)
				return false;

			return this.m_villager.e(trader) <= 16 && trader.activeContainer != null;
		}
	}

	@Override
	public void startExecuting()
	{
		this.m_villager.getNavigation().g();
	}

	@Override
	public void stopExecuting()
	{
		this.m_villager.a((EntityHuman)null);
	}
}