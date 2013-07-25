package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.selectors;

import net.minecraft.server.v1_6_R2.Entity;
import net.minecraft.server.v1_6_R2.IEntitySelector;

public class EntitySelectorLiving implements IEntitySelector
{
	@Override
	public boolean a(Entity inEntity)
	{
		return inEntity.isAlive();
	}
}