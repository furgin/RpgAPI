package com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking;

import org.bukkit.entity.Player;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;

public abstract class TouchBehavior extends BaseBehavior
{
	public TouchBehavior(RemoteEntity inEntity)
	{
		super(inEntity);
		this.m_name = "Touch";
	}

	/**
	 * Gets called when the entity gets touched by a player
	 *
	 * @param inPlayer player
	 */
	public abstract void onTouch(Player inPlayer);
}