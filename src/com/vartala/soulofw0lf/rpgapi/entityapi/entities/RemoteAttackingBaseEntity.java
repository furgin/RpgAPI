package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import net.minecraft.server.v1_6_R2.EntityLiving;
import org.bukkit.entity.LivingEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.Fightable;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.NMSUtil;
import com.vartala.soulofw0lf.rpgapi.entityapi.utilities.WorldUtilities;

public abstract class RemoteAttackingBaseEntity<T extends LivingEntity> extends RemoteBaseEntity<T> implements Fightable
{
	public RemoteAttackingBaseEntity(int inID, RemoteEntityType inType, EntityManager inManager)
	{
		super(inID, inType, inManager);
	}

	@Override
	public void attack(LivingEntity inTarget)
	{
		if(this.m_entity == null)
			return;

		NMSUtil.setGoalTarget(this.m_entity, WorldUtilities.getNMSEntity(inTarget));
	}

	@Override
	public void loseTarget()
	{
		if(this.m_entity == null)
			return;

		NMSUtil.setGoalTarget(this.m_entity, null);
	}

	@Override
	public LivingEntity getTarget()
	{
		if(this.m_entity == null)
			return null;

		EntityLiving target = NMSUtil.getGoalTarget(this.m_entity);
		if(target != null)
			return (LivingEntity)target.getBukkitEntity();

		return null;
	}
}