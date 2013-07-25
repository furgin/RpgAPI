package com.vartala.soulofw0lf.rpgapi.respawnapi;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: links
 * Date: 7/17/13
 * Time: 2:40 PM
 * To change this template use File | Settings | File Templates.
 */
public class RespawnHandler {
    public static ArrayList<SpawnPoint> spawns = new ArrayList<SpawnPoint>();
    public static Map<String, Location> rezQueue = new HashMap<>();
    public static RespawnHandler instance = new RespawnHandler();

    /**
     *
     */
    public RespawnHandler() {
        //TODO: Load from config soul0fwolf
        //SpawnPoint sp = new SpawnPoint(Location, Permission, Name) if no perm, just pass ""
    }

    /**
     *
     * @return
     */
    public static RespawnHandler getInstance() {
        return instance;
    }

    /**
     * Iterates through ArrayList spawns, selects the closest spawn which the player is in the same world and has permissions to spawn to.
     * Or if the player is in the rezQueue, he will be respawned at the location set in the queue
     *
     * @param p Player to check
     * @return Location that the player will spawn at
     */
    public Location getPlayerSpawnLocation(Player p) {
        if (rezQueue.containsKey(p.getName())) {
            return rezQueue.get(p.getName());
        } else if (spawns.size() > 0) {

            SpawnPoint shortestSpawn = spawns.get(0);
            for (SpawnPoint sp : spawns) {
                if (!sp.getRespawnPoint().getWorld().getName().equals(p.getLocation().getWorld().getName()) || !sp.canSpawn(p)) {
                    continue;
                }
                if (sp.getRespawnPoint().distance(p.getLocation()) < shortestSpawn.getRespawnPoint().distance(p.getLocation())) {
                    shortestSpawn = sp;
                }
            }
            return shortestSpawn.getRespawnPoint();
        }
        else
            return p.getWorld().getSpawnLocation();
    }

}
