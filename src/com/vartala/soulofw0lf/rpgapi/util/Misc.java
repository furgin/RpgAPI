package com.vartala.soulofw0lf.rpgapi.util;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

/**
 * Created with IntelliJ IDEA.
 * User: links
 * Date: 7/13/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Misc {
    /**
     * Serializes a location
     * @param l location
     * @return serilized string
     */
    public static String locToString(Location l) {
        if (l.getPitch() == 0 && l.getYaw() == 0)
            return l.getWorld().getName()+"|"+l.getX()+"|"+l.getY()+"|"+l.getZ();
        else
            return l.getWorld().getName()+"|"+l.getX()+"|"+l.getY()+"|"+l.getZ()+"|"+l.getYaw()+"|"+l.getPitch();
    }

    /**
     * Un-serializes a location
     * @param s string
     * @return location
     */
    public static Location stringToLoc(String s) {
        String[] arr = s.split("|");
        if (arr.length == 3)
            return new Location(Bukkit.getWorld(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]));
        else
            return new Location(Bukkit.getWorld(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Float.parseFloat(arr[4]), Float.parseFloat(arr[5]));
    }
}
