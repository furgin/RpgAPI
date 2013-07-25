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
public class LoadCities {
    /**
     *
     */
    public static void FromFile() {
        File f = new File("plugins/RpgChat/Cities");
        File[] files = f.listFiles();
        if (files != null) {
            for (File regions : files) {
                YamlConfiguration region = YamlConfiguration.loadConfiguration(regions);
                RpgCities rpC = new RpgCities();
                String city = region.getName();
                rpC.setRegionName(city);
                rpC.setRegionRadius(region.getInt("Rpg City." + city + ".Radius"));
                rpC.setRegionX(region.getDouble("Rpg City." + city + ".X"));
                rpC.setRegionY(region.getDouble("Rpg City." + city + ".Y"));
                rpC.setRegionZ(region.getDouble("Rpg City." + city + ".Z"));
                rpC.setRegionWorld(region.getString("Rpg City." + city + ".World"));
                RpgAPI.rpgCities.add(rpC);
            }
        }
    }

    /**
     *
     */
    public static void ToFile() {
        for (RpgCities rpC : RpgAPI.rpgCities) {
            YamlConfiguration region = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Cities/"+rpC.getRegionName()+".yml"));
            region.set("Rpg City." + rpC.getRegionName() + ".Radius", rpC.getRegionRadius());
            region.set("Rpg City." + rpC.getRegionName() + ".X", rpC.getRegionX());
            region.set("Rpg City." + rpC.getRegionName() + ".Y", rpC.getRegionY());
            region.set("Rpg City." + rpC.getRegionName() + ".Z", rpC.getRegionZ());
            region.set("Rpg City." + rpC.getRegionName() + ".World", rpC.getRegionWorld());
            try {
                region.save(new File("plugins/RpgChat/Cities/"+rpC.getRegionName()+".yml"));
            } catch (IOException e){

            }
        }
    }
}
