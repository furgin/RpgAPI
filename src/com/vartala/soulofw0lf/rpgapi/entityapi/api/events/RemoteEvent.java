package com.vartala.soulofw0lf.rpgapi.entityapi.api.events;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;

public abstract class RemoteEvent extends BaseEvent
{
	protected final RemoteEntity m_remoteEntity;

	public RemoteEvent(RemoteEntity inEntity)
	{
		this.m_remoteEntity = inEntity;
	}

	/**
	 * Gets the entity that's associated with this event
	 *
	 * @return entity
	 */
	public RemoteEntity getRemoteEntity()
	{
		return this.m_remoteEntity;
	}
}