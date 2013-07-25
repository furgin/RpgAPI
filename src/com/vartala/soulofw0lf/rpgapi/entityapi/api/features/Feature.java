package com.vartala.soulofw0lf.rpgapi.entityapi.api.features;

import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.persistence.SerializableData;

public interface Feature extends SerializableData
{
	/**
	 * Gets the name of the feature
	 *
	 * @return name
	 */
	public String getName();

	/**
	 * Gets the entity that owns this feature
	 *
	 * @return entity
	 */
	public RemoteEntity getEntity();

	/**
	 * Method that gets executed when the feature gets added to the entity
	 */
	public void onAdd();

	/**
	 * Method that gets executed when the feature gets added to the given entity
	 *
	 * @param inEntity  Entity the feature gets added to
	 */
	public void onAdd(RemoteEntity inEntity);

	/**
	 * Method that gets executed when the feature gets removed from the entity
	 */
	public void onRemove();
}