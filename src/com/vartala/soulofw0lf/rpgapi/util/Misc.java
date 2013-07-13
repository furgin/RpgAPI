package com.vartala.soulofw0lf.rpgapi.util;

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
            return l.getX()+"|"+l.getY()+"|"+l.getZ();
        else
            return l.getX()+"|"+l.getY()+"|"+l.getZ()+"|"+l.getYaw()+"|"+l.getPitch();
    }

    /**
     * Un-serializes a location
     * @param s string
     * @param w world
     * @return location
     */
    public static Location stringToLoc(String s, World w) {
        String[] arr = s.split("|");
        if (arr.length == 2)
            return new Location(w, Double.parseDouble(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]));
        else
            return new Location(w, Double.parseDouble(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Float.parseFloat(arr[3]), Float.parseFloat(arr[4]));
    }
}
