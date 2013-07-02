package com.vartala.soulofw0lf.rpgapi.listenersapi;

import java.sql.SQLException;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.enumapi.PlayerStat;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayerBuilder;
import com.vartala.soulofw0lf.rpgapi.speedapi.SpeedHandler;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.scheduler.BukkitRunnable;


public class playerLogIn implements Listener {
    RpgAPI Rpgapi;

    public playerLogIn(RpgAPI rpga) {
        this.Rpgapi = rpga;
        Bukkit.getPluginManager().registerEvents(this, this.Rpgapi);
    }


    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        String pName = player.getName();
        String p = RpgAPI.activeNicks.get(pName);
        if (p == null) {
            p = pName;
            RpgAPI.activeNicks.put(p, p);
        }

        player.setPlayerListName(p);
        player.setDisplayName(p);
        player.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Active Character") + p));
        RpgPlayer rp = RpgPlayerBuilder.RpgBuilder(p);
        RpgAPI.rpgPlayers.put(p, rp);
        PermissionAttachment attach = rp.addAttachment(RpgAPI.plugin);
        if (!(RpgAPI.playerColors.containsKey(pName))) {
            if (player.isOp()) {
                RpgAPI.playerColors.put(pName, "&4");
            } else {
                RpgAPI.playerColors.put(pName, "&2");
            }
        }
        final String playerN = pName;
        new BukkitRunnable() {

            @Override
            public void run() {
                RpgPlayer r = RpgAPI.rpgPlayers.get(RpgAPI.activeNicks.get(playerN));
                SpeedHandler.SetWalkSpeed(r, playerN);
                SpeedHandler.SetFlySpeed(r, playerN);
                //Bukkit.getPlayer(playerN).setMaxHealth((double)r.getStats().get(PlayerStat.TOTAL_HIT_POINTS.toString()));
                //Bukkit.getPlayer(playerN).setHealth((double)r.getStats().get(PlayerStat.HIT_POINTS.toString()));
                Bukkit.getPlayer(playerN).setLevel(r.getStats().get(PlayerStat.CHARACTER_LEVEL.toString()));
            }
        }.runTaskLater(RpgAPI.plugin, 4);

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
    public void onPlayerKick(PlayerKickEvent event) {
        Player p = event.getPlayer();
        String pName = p.getName();
        String rpname = RpgAPI.activeNicks.get(pName);
        RpgPlayer rp = RpgAPI.rpgPlayers.get(rpname);
        RpgPlayerBuilder.RpgSaver(rpname, rp);
        final String rName = rpname;
        new BukkitRunnable() {

            @Override
            public void run() {
                RpgAPI.rpgPlayers.remove(rName);
            }
        }.runTaskLater(RpgAPI.plugin, 40);

		/*
         * save active nickname to table
		 */
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        String pName = p.getName();
        String rpName = RpgAPI.activeNicks.get(pName);
        RpgPlayer rp = RpgAPI.rpgPlayers.get(rpName);
        RpgPlayerBuilder.RpgSaver(rpName, rp);
        final String rName = rpName;
        new BukkitRunnable() {

            @Override
            public void run() {
                RpgAPI.rpgPlayers.remove(rName);
            }
        }.runTaskLater(RpgAPI.plugin, 40);
		/*
		 * save active nickname to table
		 */
    }

}
