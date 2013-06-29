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
public class LoadRegions {
    public static void FromFile(){
        for (String region : RpgAPI.regionConfig.getConfigurationSection("Rpg Regions").getKeys(false)){
            ChatRegions rpC = new ChatRegions();
            rpC.setRegionName(region);
            rpC.setRegionRadius(RpgAPI.regionConfig.getInt("Rpg Regions." + region + ".Radius"));
            rpC.setRegionX(RpgAPI.regionConfig.getDouble("Rpg Regions." + region + ".X"));
            rpC.setRegionY(RpgAPI.regionConfig.getDouble("Rpg Regions." + region + ".Y"));
            rpC.setRegionZ(RpgAPI.regionConfig.getDouble("Rpg Regions." + region + ".Z"));
            rpC.setRegionWorld(RpgAPI.regionConfig.getString("Rpg Regions." + region + ".World"));
            RpgAPI.chatRegions.add(rpC);
        }
    }
    public static void ToFile(){
        for (ChatRegions rpC : RpgAPI.chatRegions){
            RpgAPI.regionConfig.set("Rpg Regions." + rpC.getRegionName() + ".Radius", rpC.getRegionRadius());
            RpgAPI.regionConfig.set("Rpg Regions." + rpC.getRegionName() + ".X", rpC.getRegionX());
            RpgAPI.regionConfig.set("Rpg Regions." + rpC.getRegionName() + ".Y", rpC.getRegionY());
            RpgAPI.regionConfig.set("Rpg Regions." + rpC.getRegionName() + ".Z", rpC.getRegionZ());
            RpgAPI.regionConfig.set("Rpg Regions." + rpC.getRegionName() + ".World", rpC.getRegionWorld());
        }
    }
}
