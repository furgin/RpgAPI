package com.vartala.soulofw0lf.rpgapi.respawnapi;

import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created with IntelliJ IDEA.
 * User: links
 * Date: 7/17/13
 * Time: 2:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class SpawnPoint {


    public Location respawnPoint;
    public String perm, name;

    /**
     * Constructor
     *
     * @param l Respawn location
     * @param p Permission, if none pass an empty string
     * @param n Name of the respawn
     */
    public SpawnPoint(Location l, String p, String n) {
        this.respawnPoint = l;
        this.perm = p;
        this.name = n;
    }

    /**
     * Returns true if player p can respawn at this spawn point
     *
     * @param p
     * @return can respawn at this respawn point
     */
    public boolean canSpawn(Player p) {
        if (!perm.isEmpty())
            return p.hasPermission(perm);
        return true;
    }

    public Location getRespawnPoint() {
        return respawnPoint;
    }

    public void setRespawnPoint(Location respawnPoint) {
        this.respawnPoint = respawnPoint;
    }

    public String getPerm() {
        return perm;
    }

    public void setPerm(String perm) {
        this.perm = perm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
