package com.vartala.soulofw0lf.rpgapi.entityapi;

import java.util.HashMap;
import java.util.Map;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.DespawnReason;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.exceptions.PluginNotEnabledException;

public class RemoteEntities
{





	/**
	 * Creates a manager for your plugin
	 *
	 * @param inPlugin	plugin using that manager
	 * @return			instance of a manager
	 */
	public static EntityManager createManager(Plugin inPlugin) throws PluginNotEnabledException
	{
		if(RpgAPI.getInstance() == null)
			throw new PluginNotEnabledException();

		return createManager(inPlugin, false);
	}

	/**
	 * Creates a manager for your plugin
	 * You can also specify whether despawned entities should be removed or not
	 *
	 * @param inPlugin				plugin using that manager
	 * @param inRemoveDespawned		automatically removed despawned entities
	 * @return						instance of a manager
	 */
	public static EntityManager createManager(Plugin inPlugin, boolean inRemoveDespawned)
	{
		if(RpgAPI.getInstance() == null)
			throw new PluginNotEnabledException();

		EntityManager manager = new EntityManager(inPlugin, inRemoveDespawned);
		registerCustomManager(manager, inPlugin.getName());
		return manager;
	}

	/**
	 * Adds custom created manager to internal map
	 *
	 * @param inManager custom manager
	 * @param inName	name of the plugin using it
	 */
	public static void registerCustomManager(EntityManager inManager, String inName)
	{
		if(RpgAPI.getInstance() == null)
			return;

		RpgAPI.getInstance().m_managers.put(inName, inManager);
	}

	/**
	 * Gets the manager of a specific plugin
	 *
	 * @param inName	name of the plugin
	 * @return			EntityManager of that plugin
	 */
	public static EntityManager getManagerOfPlugin(String inName)
	{
		if(RpgAPI.getInstance() == null)
			return null;

		return RpgAPI.getInstance().m_managers.get(inName);
	}

	/**
	 * Checks if a specific plugin has registered a manager
	 *
	 * @param inName	name of the plugin
	 * @return			true if the given plugin has a manager, false if not
	 */
	public static boolean hasManagerForPlugin(String inName)
	{
		return RpgAPI.getInstance() != null && RpgAPI.getInstance().m_managers.containsKey(inName);
	}

	/**
	 * Checks if the given entity is a RemoteEntity created by any manager.
	 *
	 * @param inEntity	entity to check
	 * @return			true if it is a RemoteEntity, false if not
	 */
	public static boolean isRemoteEntity(LivingEntity inEntity)
	{
		if(RpgAPI.getInstance() == null)
			return false;

		for(EntityManager manager : RpgAPI.getInstance().m_managers.values())
		{
			if(manager.isRemoteEntity(inEntity))
				return true;
		}
		return false;
	}

	/**
	 * Gets the RemoteEntity from a given entity which can be created by any manager.
	 *
	 * @param inEntity	entity
	 * @return			RemoteEntity
	 */
	public static RemoteEntity getRemoteEntityFromEntity(LivingEntity inEntity)
	{
		if(RpgAPI.getInstance() == null)
			return null;

		for(EntityManager manager : RpgAPI.getInstance().m_managers.values())
		{
			RemoteEntity entity = manager.getRemoteEntityFromEntity(inEntity);
			if(entity != null)
				return entity;
		}
		return null;
	}

	/**
	 * Returns the minecraft version this version of remote entities is compatible with.
	 *
	 * @return  A string representing the version
	 */
	public static String getCompatibleMinecraftVersion()
	{
		return RpgAPI.COMPATIBLE_VERSION;
	}


}