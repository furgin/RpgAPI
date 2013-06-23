package com.vartala.soulofw0lf.rpgapi.listenersapi;

import java.sql.SQLException;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayerBuilder;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;


public class playerLogIn implements Listener {
    RpgAPI Rpgapi;
    public playerLogIn(RpgAPI rpga){
        this.Rpgapi = rpga;
        Bukkit.getPluginManager().registerEvents(this, this.Rpgapi);
    }


	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJoin(PlayerJoinEvent event)
	{    //
		String pName = event.getPlayer().getName();
        String p = RpgAPI.activeNicks.get(pName);
        if (p == null){
            p = pName;
        }
        RpgPlayer rp = RpgPlayerBuilder.RpgBuilder(p);
        RpgAPI.rpgPlayers.put(p, rp);
        /*
         * Commented out until sql loading is fixed
         */


		//try {
		//	String nick = SQLLoading.getActiveNick(p);
		//	RpgPlayer rp = new RpgPlayer();
		//	if(SQLLoading.loadNick(rp, nick))
		//	{
		//		//RpgAPI.playerList.put(p,rp);
		//	}
		//	else
		//	{
		//		//kick player..loading went wrong
		//		event.getPlayer().kickPlayer("Error Logging in. Please try again later.");
		//	}
		//} catch (SQLException e) {
		//	e.printStackTrace();
		//}
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerKick(PlayerKickEvent event){
		/*
		 * save active nickname to table
		 */
	}
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerQuit(PlayerQuitEvent event)
	{
		/*
		 * save active nickname to table
		 */
	}
	
}
