package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import net.minecraft.server.v1_6_R2.EntityLiving;
import net.minecraft.server.v1_6_R2.EntityTameableAnimal;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.features.TamingFeature;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireType;
import com.vartala.soulofw0lf.rpgapi.entityapi.exceptions.NotTameableException;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.NMSUtil;

/**
 * Using this desire the entity will target the entity which is attacking the tamer of this entity.
 * However, this desire will not attack the target directly.
 */
public class DesireProtectOwner extends DesireTamedBase
{
	protected EntityLiving m_ownerAttacker;
	protected int m_lastAttackedTick;

	@Deprecated
	public DesireProtectOwner(RemoteEntity inEntity, float inDistance, boolean inShouldCheckSight)
	{
		super(inEntity, inDistance, inShouldCheckSight);
		if(!(this.getEntityHandle() instanceof EntityTameableAnimal) && !this.getRemoteEntity().getFeatures().hasFeature(TamingFeature.class))
			throw new NotTameableException();

		this.m_animal = this.getEntityHandle();
		this.m_type = DesireType.PRIMAL_INSTINCT;
	}

	public DesireProtectOwner(float inDistance, boolean inShouldCheckSight)
	{
		super(inDistance, inShouldCheckSight);
		this.m_type = DesireType.PRIMAL_INSTINCT;
	}

	@Override
	public void onAdd(RemoteEntity inEntity)
	{
		super.onAdd(inEntity);
		if(!(this.getEntityHandle() instanceof EntityTameableAnimal) && !this.getRemoteEntity().getFeatures().hasFeature(TamingFeature.class))
			throw new NotTameableException();

		this.m_animal = this.getEntityHandle();
	}

	@Override
	public boolean shouldExecute()
	{
		if(this.getEntityHandle() == null)
			return false;

		if(!this.isTamed())
			return false;
		else
		{
			EntityLiving owner = this.getTamer();
			if(owner == null)
				return false;
			else
			{
				this.m_ownerAttacker = owner.getLastDamager();
				int lastAttackedTick = owner.aE();
				return lastAttackedTick != this.m_lastAttackedTick && this.isSuitableTarget(this.m_ownerAttacker, false);
			}
		}
	}

	@Override
	public void startExecuting()
	{
		NMSUtil.setGoalTarget(this.getEntityHandle(), this.m_ownerAttacker);
		this.m_lastAttackedTick = this.getTamer().aE();
		super.startExecuting();
	}
}