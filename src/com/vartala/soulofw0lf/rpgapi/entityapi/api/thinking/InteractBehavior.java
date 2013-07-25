package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking;

import org.bukkit.entity.Player;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;

public abstract class InteractBehavior extends BaseBehavior
{
	public InteractBehavior(RemoteEntity inEntity)
	{
		super(inEntity);
		this.m_name = "Interact";
	}

	/**
	 * Called when a player interacts with the entity
	 *
	 * @param inPlayer player
	 */
	public abstract void onInteract(Player inPlayer);
}