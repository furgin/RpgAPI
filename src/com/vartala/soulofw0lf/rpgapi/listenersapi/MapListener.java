package com.vartala.soulofw0lf.rpgapi.listenersapi;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.server.MapInitializeEvent;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.eventsapi.MapLeftClickEvent;
import com.vartala.soulofw0lf.rpgapi.eventsapi.MapRightClickEvent;
import com.vartala.soulofw0lf.rpgapi.mapsapi.ScrollMap;


public class MapListener implements Listener
{
	
	private RpgAPI RPG;
    //
	public MapListener(RpgAPI rpg)
	{
		this.RPG = rpg;
		Bukkit.getPluginManager().registerEvents(this, this.RPG);
	}
	
	@EventHandler
	public void onMap(MapInitializeEvent event)
	{
		if(!ScrollMap.containsScrollMap(event.getMap().getId()))
		{
			ScrollMap.addScrollMap(event.getMap().getId());
		}
	}
	
	@EventHandler
	public void onClick(PlayerInteractEvent event)
	{
		if((event.getAction().equals(Action.RIGHT_CLICK_AIR) ||
				event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) &&
				event.getPlayer().getItemInHand().getType().equals(Material.MAP))
		{
			Bukkit.getPluginManager().callEvent(new MapRightClickEvent(event.getPlayer(), event.getPlayer().getItemInHand().getDurability()));
		}
		
		if((event.getAction().equals(Action.LEFT_CLICK_AIR) ||
				event.getAction().equals(Action.LEFT_CLICK_BLOCK)) &&
				event.getPlayer().getItemInHand().getType().equals(Material.MAP))
		{
			Bukkit.getPluginManager().callEvent(new MapLeftClickEvent(event.getPlayer(), event.getPlayer().getItemInHand().getDurability()));
		}
	}

}
