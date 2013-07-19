package com.vartala.soulofw0lf.rpgapi.guiapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.chatapi.ChatClass;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by: soulofw0lf
 * Date: 7/19/13
 * Time: 1:59 AM
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
public class ChatInventoryBehavior implements InventoryClickBehavior {
    @SuppressWarnings("deprecation")
    @Override
    public void onClick(RpgClickInv inv, Player player, ItemStack item, ClickType click) {
        RpgPlayer rp = RpgAPI.getRp(player.getName());
        if (item.equals(null) || item.getType().equals(Material.AIR)){
            return;
        }
        ItemMeta im = item.getItemMeta();
        if (im == null){
            return;
        }
        String displayName = im.getDisplayName();
        if (displayName == null){
            return;
        }
        Short i = item.getDurability();
        ChatClass ch = RpgAPI.getChatByName(displayName);
        if (click.isLeftClick()){
            if (item.getType().equals(Material.WEB)){
                item.setType(Material.WOOL);
                rp.getChannelColor().put(displayName, "&f");
                player.updateInventory();
                return;
            }
            String color = "&f";
            i++;
            if (i > 15){
                i = 0;
            }
            item.setDurability(i);
            if (i == 15){
                color = "&0";
            }
            if (i == 11){
                color = "&1";
            }
            if (i == 13){
                color = "&2";
            }
            if (i == 13){
                color = "&3";
            }
            if (i == 14){
                color = "&4";
            }
            if (i == 10){
                color = "&5";
            }
            if (i == 1){
                color = "&6";
            }
            if (i == 8){
                color = "&7";
            }
            if (i == 7){
                color = "&8";
            }
            if (i == 9){
                color = "&9";
            }
            if (i == 5){
                color = "&a";
            }
            if (i == 3){
                color = "&b";
            }
            if (i == 6){
                color = "&c";
            }
            if (i == 2){
                color = "&d";
            }
            if (i == 4){
                color = "&e";
            }
            if (i == 0){
                color = "&f";
            }
            if (rp.getChannelColor().containsKey(displayName)){
                rp.getChannelColor().remove(displayName);
            }
            rp.getChannelColor().put(displayName, color);
        }
        if (click.isRightClick()){
            if (rp.getChannelColor().containsKey(displayName)){
                rp.getChannelColor().remove(displayName);
                if (rp.getModChats().contains(displayName)){
                    rp.getModChats().remove(displayName);
                }
                if (rp.getOwnedChats().contains(displayName)){
                    rp.getOwnedChats().remove(displayName);
                    ch.setChannelOwner("");
                }
                item.setType(Material.WEB);

            }
        }
        if (click.isShiftClick()){
            if (item.getType().equals(Material.WEB)){
                item.setType(Material.WOOL);
                rp.getChannelColor().put(displayName, "&f");
            }
             rp.setActiveChannel(displayName);
        }
        player.updateInventory();
    }
}
