package com.vartala.soulofw0lf.rpgapi.util;

import java.util.Iterator;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;


public final class PlayerUtil {
	
	private static RpgAPI RPG;
	
	public PlayerUtil(RpgAPI rpg)
	{
		RPG = rpg;
	}
    //
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
