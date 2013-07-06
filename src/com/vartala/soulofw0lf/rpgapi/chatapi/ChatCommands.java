package com.vartala.soulofw0lf.rpgapi.chatapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 7/4/13
 * Time: 2:29 AM
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
public class ChatCommands {
    public static Boolean ChatHandler(RpgPlayer rp, String[] command){
        if (command.length == 0){
            Short wc = 0;
            List<ItemStack> lIS = new ArrayList<ItemStack>();
            for (String chat : rp.getChannelColor().keySet()){
                String color = rp.getChannelColor().get(chat);
                if (color.equalsIgnoreCase("&0")){
                    wc = 15;
                }
                if (color.equalsIgnoreCase("&1")){
                    wc = 11;
                }
                if (color.equalsIgnoreCase("&2")){
                    wc = 13;
                }
                if (color.equalsIgnoreCase("&3")){
                    wc = 12;
                }
                if (color.equalsIgnoreCase("&4")){
                    wc = 14;
                }
                if (color.equalsIgnoreCase("&5")){
                    wc = 10;
                }
                if (color.equalsIgnoreCase("&6")){
                    wc = 1;
                }
                if (color.equalsIgnoreCase("&7")){
                    wc = 8;
                }
                if (color.equalsIgnoreCase("&8")){
                    wc = 7;
                }
                if (color.equalsIgnoreCase("&9")){
                    wc = 9;
                }
                if (color.equalsIgnoreCase("&a")){
                    wc = 5;
                }
                if (color.equalsIgnoreCase("&b")){
                    wc = 3;
                }
                if (color.equalsIgnoreCase("&c")){
                    wc = 6;
                }
                if (color.equalsIgnoreCase("&d")){
                    wc = 2;
                }
                if (color.equalsIgnoreCase("&e")){
                    wc = 4;
                }
                if (color.equalsIgnoreCase("&f")){
                    wc = 0;
                }
                ItemStack iS = new ItemStack(Material.WOOL, 1);
                ItemMeta iM = iS.getItemMeta();
                iM.setDisplayName(chat);
                List<String> lores = new ArrayList<String>();
                lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Left Click")));
                lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Right Click")));
                lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Shift Click")));
                iM.setLore(lores);
                iS.setItemMeta(iM);
                iS.setDurability(wc);
                lIS.add(iS);
            }

        }

        return false;
    }
}
