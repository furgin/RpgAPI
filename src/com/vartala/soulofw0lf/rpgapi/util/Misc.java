package com.vartala.soulofw0lf.rpgapi.util;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.diseaseapi.Disease;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

/**
 * Created with IntelliJ IDEA.
 * User: links
 * Date: 7/13/13
 * Time: 3:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Misc {
    /**
     * Serializes a location in the form of worldname|x|y|z or worldname|x|y|z|yaw|pitch if either is not equal to zero
     * @param l location
     * @return serilized string
     */
    public static String locToString(Location l) {
        if (l.getPitch() == 0 && l.getYaw() == 0)
            return l.getWorld().getName()+"@"+l.getX()+"@"+l.getY()+"@"+l.getZ();
        else
            return l.getWorld().getName()+"@"+l.getX()+"@"+l.getY()+"@"+l.getZ()+"@"+l.getYaw()+"@"+l.getPitch();
    }
    public static String vecToString(Vector vec){
        return vec.getX()+"@"+vec.getY()+"@"+vec.getZ();
    }
    public static Vector stringToVec(String s){
        String[] vc = s.split("@");
        return new Vector(Double.parseDouble(vc[0]), Double.parseDouble(vc[1]),Double.parseDouble(vc[2]));
    }

    /**
     * Un-serializes a location in the form of worldname|x|y|z or worldname|x|y|z|yaw|pitch
     * @param s string
     * @return location
     */
    public static Location stringToLoc(String s) {
        String[] arr = s.split("@");
        if (arr.length == 4)
            return new Location(Bukkit.getWorld(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]));
        else
            return new Location(Bukkit.getWorld(arr[0]), Double.parseDouble(arr[1]), Double.parseDouble(arr[2]), Double.parseDouble(arr[3]), Float.parseFloat(arr[4]), Float.parseFloat(arr[5]));
    }
    public static Disease getDiseaseByName(String s){
        for (Disease dis : RpgAPI.diseases){
            if (dis.getDiseaseName().equalsIgnoreCase(s)){
                return dis;
            }
        }
        return null;
    }
}
