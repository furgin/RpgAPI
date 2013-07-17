package com.vartala.soulofw0lf.rpgapi.respawnapi;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created with IntelliJ IDEA.
 * User: links
 * Date: 7/17/13
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class RespawnListerner implements Listener {
    public static void rezCommandListener(PlayerCommandPreprocessEvent event) {
        //oncommand "rez"
        //if RespawnHandler.getInstance().rezQueue.contains(p) -> this player is already being rezzed
        //else add player to queue
    }

    public static void respawnListener(PlayerRespawnEvent event) {
        event.setRespawnLocation(RespawnHandler.getInstance().getPlayerSpawnLocation(event.getPlayer()));
    }
}
