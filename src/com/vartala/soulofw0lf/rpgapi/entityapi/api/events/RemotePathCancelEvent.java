package com.vartala.soulofw0lf.rpgapi.entityapi.api.events;

import org.bukkit.event.HandlerList;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.pathfinding.CancelReason;

public class RemotePathCancelEvent extends RemoteEvent
{
	private static final HandlerList handlers = new HandlerList();
	private final CancelReason m_reason;

	public RemotePathCancelEvent(RemoteEntity inEntity, CancelReason inReason)
	{
		super(inEntity);
		this.m_reason = inReason;
	}

	public CancelReason getReason()
	{
		return this.m_reason;
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