package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals;

import net.minecraft.server.v1_6_R2.EntityLiving;
import net.minecraft.server.v1_6_R2.EntityTameableAnimal;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.features.TamingFeature;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireType;
import com.vartala.soulofw0lf.rpgapi.entityapi.exceptions.NotTameableException;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.NMSUtil;

/**
 * Using this desire the entity will help attacking the target of the tamer.
 */
public class DesireHelpAttacking extends DesireTamedBase
{
	protected EntityLiving m_ownerTarget;
	protected int m_lastAttackTick;

	@Deprecated
	public DesireHelpAttacking(RemoteEntity inEntity, float inDistance, boolean inShouldCheckSight)
	{
		super(inEntity, inDistance, inShouldCheckSight);
		if(!(this.getEntityHandle() instanceof EntityTameableAnimal) && !this.getRemoteEntity().getFeatures().hasFeature(TamingFeature.class))
			throw new NotTameableException();

		this.m_animal = this.getEntityHandle();
		this.m_type = DesireType.PRIMAL_INSTINCT;
	}

	public DesireHelpAttacking(float inDistance, boolean inShouldCheckSight)
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
		if(this.m_animal == null)
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
				this.m_ownerTarget = owner.aF();
				int lastAttackTick = owner.aG();
				return lastAttackTick != this.m_lastAttackTick && this.isSuitableTarget(this.m_ownerTarget, false);
			}
		}
	}

	@Override
	public void startExecuting()
	{
		NMSUtil.setGoalTarget(this.getEntityHandle(), this.m_ownerTarget);
		this.m_lastAttackTick = this.getTamer().aG();
		super.startExecuting();
	}
}