package com.vartala.soulofw0lf.rpgapi.loaders;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.borderapi.BorderCheck;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 7/8/13
 * Time: 5:57 PM
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
public class BorderLoader {
    public BorderLoader(){
        RpgAPI.worldBorder = YamlConfiguration.loadConfiguration(new File("plugins/RpgBorders/RpgBorders.yml"));
        RpgAPI.worldLocaleBorder = YamlConfiguration.loadConfiguration(new File("plugins/RpgBorders/Locale/RpgBorders.yml"));
        if (RpgAPI.worldBorder.get("Worlds") == null) {
            RpgAPI.worldBorder.set("Worlds.World.X", 0);
            RpgAPI.worldBorder.set("Worlds.World.Y", 0);
            RpgAPI.worldBorder.set("Worlds.World.Z", 0);
            RpgAPI.worldBorder.set("Worlds.World.Radius", 1000);
        }
        try {
            RpgAPI.worldBorder.save(new File("plugins/RpgBorders/RpgBorders.yml"));
            RpgAPI.worldLocaleBorder.save(new File("plugins/RpgBorders/Locale/RpgBorders.yml"));
        } catch (IOException e) {
        }
        Double X = 0.0;
        Double Y = 0.0;
        Double Z = 0.0;
        Location loc = null;
        Integer radius = 0;
        for (String worlds : RpgAPI.worldBorder.getConfigurationSection("Worlds").getKeys(false)) {
            X = RpgAPI.worldBorder.getDouble("Worlds." + worlds + ".X");
            Y = RpgAPI.worldBorder.getDouble("Worlds." + worlds + ".Y");
            Z = RpgAPI.worldBorder.getDouble("Worlds." + worlds + ".Z");
            radius = RpgAPI.worldBorder.getInt("Worlds." + worlds + ".Radius");
            World world = Bukkit.getWorld(worlds);
            if (world != null) {
                loc = new Location(world, X, Y, Z);
                BorderCheck.cycleCheck(RpgAPI.getInstance(), loc, radius);
            }
        }
    }
}
