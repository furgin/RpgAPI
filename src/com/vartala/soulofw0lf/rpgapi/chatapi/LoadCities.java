package com.vartala.soulofw0lf.rpgapi.chatapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;

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
    public static void FromFile() {
        for (String city : RpgAPI.cityConfig.getConfigurationSection("Rpg Cities").getKeys(false)) {
            RpgCities rpC = new RpgCities();
            rpC.setRegionName(city);
            rpC.setRegionRadius(RpgAPI.cityConfig.getInt("Rpg Cities." + city + ".Radius"));
            rpC.setRegionX(RpgAPI.cityConfig.getDouble("Rpg Cities." + city + ".X"));
            rpC.setRegionY(RpgAPI.cityConfig.getDouble("Rpg Cities." + city + ".Y"));
            rpC.setRegionZ(RpgAPI.cityConfig.getDouble("Rpg Cities." + city + ".Z"));
            rpC.setRegionWorld(RpgAPI.cityConfig.getString("Rpg Cities." + city + ".World"));
            RpgAPI.rpgCities.add(rpC);
        }
    }

    public static void ToFile() {
        for (RpgCities rpC : RpgAPI.rpgCities) {
            RpgAPI.cityConfig.set("Rpg Cities." + rpC.getRegionName() + ".Radius", rpC.getRegionRadius());
            RpgAPI.cityConfig.set("Rpg Cities." + rpC.getRegionName() + ".X", rpC.getRegionX());
            RpgAPI.cityConfig.set("Rpg Cities." + rpC.getRegionName() + ".Y", rpC.getRegionY());
            RpgAPI.cityConfig.set("Rpg Cities." + rpC.getRegionName() + ".Z", rpC.getRegionZ());
            RpgAPI.cityConfig.set("Rpg Cities." + rpC.getRegionName() + ".World", rpC.getRegionWorld());
        }
    }
}
