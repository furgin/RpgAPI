package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.selectors;

import net.minecraft.server.v1_6_R2.*;

public class EntitySelectorNotUndead implements IEntitySelector
{
	@Override
	public boolean a(Entity inEntity)
	{
		return inEntity instanceof EntityLiving && ((EntityLiving)inEntity).getMonsterType() != EnumMonsterType.UNDEAD;
	}
}