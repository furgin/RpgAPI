package com.vartala.soulofw0lf.rpgapi.eventsapi;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class MapLeftClickEvent extends Event {

    private Player EventPlayer;
    private short EventMapID;
    private static final HandlerList handler = new HandlerList();

    /**
     *
     * @param player
     * @param mapid
     */
    public MapLeftClickEvent(Player player, short mapid) {
        this.EventPlayer = player;
        this.EventMapID = mapid;
    }

    /**
     *
     * @return
     */
    public HandlerList getHandlers() {
        return handler;
    }

    /**
     *
     * @return
     */
    public static HandlerList getHandlerList() {
        return handler;
    }

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return this.EventPlayer;
    }

    /**
     *
     * @return
     */
    public short getMapID() {
        return this.EventMapID;
    }

    /**
     *
     * @return
     */
    public boolean isPlayerSneaking() {
        return this.EventPlayer.isSneaking();
    }

}
