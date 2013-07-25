package com.vartala.soulofw0lf.rpgapi.entityapi.api.events;

import org.bukkit.event.HandlerList;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;

public class RemoteEntityCreateEvent extends RemoteEvent
{
	private static final HandlerList handlers = new HandlerList();

	public RemoteEntityCreateEvent(RemoteEntity inEntity)
	{
		super(inEntity);
	}

	@Override
	public HandlerList getHandlers()
	{
		return handlers;
	}

	public static HandlerList getHandlerList()
	{
		return handlers;
	}
}