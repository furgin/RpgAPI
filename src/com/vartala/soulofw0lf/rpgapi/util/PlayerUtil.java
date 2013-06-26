package com.vartala.soulofw0lf.rpgapi.util;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;


public final class PlayerUtil {
	
	private static RpgAPI RPG;

    /**
     * Constructor for the PlayerUtil object
     * @param rpg instance of the plugin
     */
	public PlayerUtil(RpgAPI rpg)
	{
		RPG = rpg;
	}

    /**
     * Used as a short cut to get an online player by searching through <code>Bukkit.getOnlinePlayers()</code>
     * @param name Name of the player
     * @return Bukkit Player object
     */
	public static Player getPlayer(String name)
	{
		for(Player player : Bukkit.getOnlinePlayers())
		{
			if(player.getName().equals(name))
				
				return player;
		}
		return null;
	}
	
}
