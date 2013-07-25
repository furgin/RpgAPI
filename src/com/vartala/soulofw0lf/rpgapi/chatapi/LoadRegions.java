package com.vartala.soulofw0lf.rpgapi.chatapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 6/28/13
 * Time: 7:09 PM
 * <p/>
 * This file is part of the Rpg Suite Created by Soulofw0lf and Linksy.
 * <p/>
 * The Rpg Suite is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * <p/>
 * The Rpg Suite is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * <p/>
 * You should have received a copy of the GNU General Public License
 * along with The Rpg Suite Plugin you have downloaded.  If not, see <http://www.gnu.org/licenses/>.
 */
public class LoadRegions {
    /**
     *
     */
    public static void FromFile() {
        File f = new File("plugins/RpgChat/Regions");
        File[] files = f.listFiles();
        if (files != null) {
            for (File regions : files) {
                YamlConfiguration region = YamlConfiguration.loadConfiguration(regions);
                ChatRegions rpC = new ChatRegions();
                rpC.setRegionName(region.getName());
                rpC.setRegionRadius(region.getInt("Rpg Regions." + region + ".Radius"));
                rpC.setRegionX(region.getDouble("Rpg Regions." + region + ".X"));
                rpC.setRegionY(region.getDouble("Rpg Regions." + region + ".Y"));
                rpC.setRegionZ(region.getDouble("Rpg Regions." + region + ".Z"));
                rpC.setRegionWorld(region.getString("Rpg Regions." + region + ".World"));
                RpgAPI.chatRegions.add(rpC);
            }
        }
    }

    /**
     *
     */
    public static void ToFile() {
        for (ChatRegions rpC : RpgAPI.chatRegions) {
            YamlConfiguration region = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Regions/"+rpC.getRegionName()+".yml"));
            region.set("Rpg Regions." + rpC.getRegionName() + ".Radius", rpC.getRegionRadius());
            region.set("Rpg Regions." + rpC.getRegionName() + ".X", rpC.getRegionX());
            region.set("Rpg Regions." + rpC.getRegionName() + ".Y", rpC.getRegionY());
            region.set("Rpg Regions." + rpC.getRegionName() + ".Z", rpC.getRegionZ());
            region.set("Rpg Regions." + rpC.getRegionName() + ".World", rpC.getRegionWorld());
            try {
                region.save(new File("plugins/RpgChat/Regions/"+rpC.getRegionName()+".yml"));
            } catch (IOException e){

            }
        }
    }
}
