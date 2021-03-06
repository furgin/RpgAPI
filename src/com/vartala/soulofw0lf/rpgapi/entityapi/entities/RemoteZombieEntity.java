package com.vartala.soulofw0lf.rpgapi.entityapi.entities;

import net.minecraft.server.v1_6_R2.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.util.Vector;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityHandle;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.features.InventoryFeature;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.DesireItem;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.Mind;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals.*;
import com.vartala.soulofw0lf.rpgapi.entityapi.nms.PathfinderGoalSelectorHelper;

public class RemoteZombieEntity extends EntityZombie implements RemoteEntityHandle
{
	private final RemoteEntity m_remoteEntity;
	protected int m_lastBouncedId;
	protected long m_lastBouncedTime;

	public RemoteZombieEntity(World world)
	{
		this(world, null);
	}

	public RemoteZombieEntity(World world, RemoteEntity inEntity)
	{
		super(world);
		this.m_remoteEntity = inEntity;
		new PathfinderGoalSelectorHelper(this.goalSelector).clearGoals();
		new PathfinderGoalSelectorHelper(this.targetSelector).clearGoals();
	}

	@Override
	public Inventory getInventory()
	{
		if(!this.m_remoteEntity.getFeatures().hasFeature(InventoryFeature.class))
			return null;

		return this.m_remoteEntity.getFeatures().getFeature(InventoryFeature.class).getInventory();
	}

	@Override
	public RemoteEntity getRemoteEntity()
	{
		return this.m_remoteEntity;
	}

	@Override
	public void setupStandardGoals()
	{
		Mind mind = this.getRemoteEntity().getMind();
		mind.addMovementDesires(getDefaultMovementDesires());
		mind.addTargetingDesires(getDefaultTargetingDesires());
	}

	@Override
	public boolean be()
	{
		return true;
	}

	@Override
	public void l_()
	{
		super.l_();
		if(this.getRemoteEntity() != null)
			this.getRemoteEntity().getMind().tick();
	}

	@Override
	public void g(double x, double y, double z)
	{
		if(this.m_remoteEntity == null)
		{
			super.g(x, y, z);
			return;
		}

		Vector vector = ((RemoteBaseEntity)this.m_remoteEntity).onPush(x, y, z);
		if(vector != null)
			super.g(vector.getX(), vector.getY(), vector.getZ());
	}

	@Override
	public void move(double d0, double d1, double d2)
	{
		if(this.m_remoteEntity != null && this.m_remoteEntity.isStationary())
			return;

		super.move(d0, d1, d2);
	}

	@Override
	public void collide(Entity inEntity)
	{
		if(this.getRemoteEntity() == null)
		{
			super.collide(inEntity);
			return;
		}

		if(((RemoteBaseEntity)this.m_remoteEntity).onCollide(inEntity.getBukkitEntity()))
			super.collide(inEntity);
	}

	@Override
	public boolean a(EntityHuman entity)
	{
		if(this.getRemoteEntity() == null)
			return super.a(entity);

		if(!(entity.getBukkitEntity() instanceof Player))
			return super.a(entity);

		return ((RemoteBaseEntity)this.m_remoteEntity).onInteract((Player)entity.getBukkitEntity()) && super.a(entity);
	}

	@Override
	public void die(DamageSource damagesource)
	{
		((RemoteBaseEntity)this.m_remoteEntity).onDeath();
		super.die(damagesource);
	}

	@Override
	public Entity findTarget()
	{
		return this.getGoalTarget();
	}

	public static DesireItem[] getDefaultMovementDesires()
	{
		return new DesireItem[] {
				new DesireItem(new DesireSwim(), 0),
				new DesireItem(new DesireDestroyDoor(false), 1),
				new DesireItem(new DesireMoveAndMeleeAttack(EntityHuman.class, false), 2),
				new DesireItem(new DesireMoveAndMeleeAttack(EntityVillager.class, true), 3),
				new DesireItem(new DesireMoveTowardsRestriction(), 4),
				new DesireItem(new DesireMoveThroughVillage(false), 5),
				new DesireItem(new DesireWanderAround(), 6),
				new DesireItem(new DesireLookAtNearest(EntityHuman.class, 8), 7),
				new DesireItem(new DesireLookRandomly(), 7)
		};
	}

	public static DesireItem[] getDefaultTargetingDesires()
	{
		return new DesireItem[] {
				new DesireItem(new DesireFindAttackingTarget(16, false, false), 1),
				new DesireItem(new DesireFindNearestTarget(EntityHuman.class, 16, false, true, 0), 2),
				new DesireItem(new DesireFindNearestTarget(EntityVillager.class, 16, false, true, 0), 2)
		};
	}
}