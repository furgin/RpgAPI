package com.vartala.soulofw0lf.rpgapi.eventsapi;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;


import com.vartala.soulofw0lf.rpgapi.enumapi.Movement;

public abstract class RegionEvent extends Event
{
	
	private static final HandlerList Handler = new HandlerList();
	private Player Player;
	private Movement Movement;
	
	/*public RegionEvent(ProtectedRegion region, Player player, Movement movement)
	{
		this.Region = region;
		this.Player = player;
		this.Movement = movement;
	}*/

    //
	//Getters
	public HandlerList getHandlers(){ return Handler; }
	public Player getPlayer(){ return this.Player; }
	public Movement getMovement(){ return this.Movement; }
	public static HandlerList getHandlerList(){ return Handler; }
}
