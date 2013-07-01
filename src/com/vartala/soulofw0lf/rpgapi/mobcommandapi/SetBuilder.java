package com.vartala.soulofw0lf.rpgapi.mobcommandapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 6/19/13
 * Time: 8:04 PM
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
public class SetBuilder {
    public static void minionCommand() {
        List<String> itemLores = new ArrayList<String>();
        List<String> itemCommands = new ArrayList<String>();
        Map<String, List<String>> itemCommandMap = new HashMap<>();
        Map<String, List<String>> itemLoreMap = new HashMap<>();
        Map<String, Integer> itemIDS = new HashMap<>();
        for (String key : RpgAPI.mobCommand.getConfigurationSection("Mob Commands").getKeys(false)) {
            MobCommand newMC = new MobCommand();
            newMC.setSetName(key);
            itemCommands.clear();
            itemLores.clear();
            for (String subKey : RpgAPI.mobCommand.getConfigurationSection("Mob Commands." + key).getKeys(false)) {
                String itemName = RpgAPI.mobCommand.getString("Mob Commands." + key + "." + subKey + ".Name");
                Integer itemID = RpgAPI.mobCommand.getInt("Mob Commands." + key + "." + subKey + ".Item ID");
                for (String lore : RpgAPI.mobCommand.getConfigurationSection("Mob Commands." + key + "." + subKey + ".Lores").getKeys(false)) {
                    String itemLore = RpgAPI.mobCommand.getString("Mob Commands." + key + "." + subKey + ".Lores." + lore);
                    itemLores.add(itemLore);
                }
                for (String command : RpgAPI.mobCommand.getConfigurationSection("Mob Commands." + key + "." + subKey + ".Commands").getKeys(false)) {
                    String itemCommand = RpgAPI.mobCommand.getString("Mob Commands." + key + "." + subKey + ".Commands." + command + ".Command") + ":" + RpgAPI.mobCommand.getString("Mob Commands." + key + "." + subKey + ".Commands." + command + ".Click Type") + ":" + RpgAPI.mobCommand.getString("Mob Commands." + key + "." + subKey + ".Commands." + command + ".Sender") + ":" + RpgAPI.mobCommand.getString("Mob Commands." + key + "." + subKey + ".Commands." + command + ".Args");
                    itemCommands.add(itemCommand);
                }
                itemCommandMap.put(itemName, itemCommands);
                itemLoreMap.put(itemName, itemLores);
                itemIDS.put(itemName, itemID);
            }
            newMC.setCommandMap(itemCommandMap);
            newMC.setIdMap(itemIDS);
            newMC.setLoreMap(itemLoreMap);
            RpgAPI.minionCommands.put(key, newMC);
        }
    }
}
