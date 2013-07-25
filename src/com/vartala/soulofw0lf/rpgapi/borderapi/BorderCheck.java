package com.vartala.soulofw0lf.rpgapi.borderapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created with IntelliJ IDEA.
 * User: links
 * Date: 6/18/13
 * Time: 5:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class BorderCheck {

    /**
     *
     * @param rpgAPI
     * @param loc
     * @param rad
     */
    public static void cycleCheck(RpgAPI rpgAPI, Location loc, Integer rad) {
        final JavaPlugin plugin = rpgAPI;
        final String worldName = loc.getWorld().getName();
        final double X = loc.getX();
        final double Y = loc.getY();
        final double Z = loc.getZ();
        final Integer radius = rad;

        new BukkitRunnable() {
            @Override
            public void run() {
                for (Player player : Bukkit.getOnlinePlayers()) {
                    if (player.getLocation().getWorld().getName().equalsIgnoreCase(worldName)) {
                        Location loc = player.getLocation();
                        loc.setY(Y);
                        Location Center = new Location(Bukkit.getWorld(worldName), X, Y, Z);
                        if (loc.distance(Center) >= radius) {
                            loc.setX(loc.getX() * -0.995);
                            loc.setY(player.getLocation().getY() + 1);
                            loc.setZ(loc.getZ() * -0.995);
                            loc.setPitch(loc.getPitch());
                            loc.setYaw(loc.getYaw());
                            player.teleport(loc);
                        }
                    }
                }
            }
        }.runTaskTimer(plugin, 60, 60);
    }
}