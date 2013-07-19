package com.vartala.soulofw0lf.rpgapi.chatapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.guiapi.InventoryClickBehavior;
import com.vartala.soulofw0lf.rpgapi.guiapi.RpgClickInv;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Created by: soulofw0lf
 * Date: 7/19/13
 * Time: 10:30 AM
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
public class ChatCreateBehavior implements InventoryClickBehavior{
    @SuppressWarnings("deprecation")
    @Override
    public void onClick(RpgClickInv inv, Player player, ItemStack item, ClickType click) {
        ChatClass ch = RpgAPI.getChatByName(inv.getInvName());
        ItemMeta iM = item.getItemMeta();
        String behavior = iM.getDisplayName();
        Short green = 13;
        Short red = 14;
        if (behavior.equalsIgnoreCase(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat City Behavior")))){
            ChatBehavior cB = new CityChatBehavior();
            if (click.isLeftClick()){
                ch.addBehavior(cB);
                item.setDurability(green);
                player.updateInventory();
            }
            if (click.isRightClick()){
                if (ch.getChannelBehaviors().contains(cB)){
                ch.removeBehavior(cB);
                }
                item.setDurability(red);
                player.updateInventory();
            }
        }
        if (behavior.equalsIgnoreCase(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Region Behavior")))){
            ChatBehavior cB = new RegionChatBehavior();
            if (click.isLeftClick()){
                ch.addBehavior(cB);
                item.setDurability(green);
                player.updateInventory();
            }
            if (click.isRightClick()){
                if (ch.getChannelBehaviors().contains(cB)){
                    ch.removeBehavior(cB);
                }
                item.setDurability(red);
                player.updateInventory();
            }
        }
        if (behavior.equalsIgnoreCase(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Guild Behavior")))){
            ChatBehavior cB = new GuildChatBehavior();
            if (click.isLeftClick()){
                ch.addBehavior(cB);
                item.setDurability(green);
                player.updateInventory();
            }
            if (click.isRightClick()){
                if (ch.getChannelBehaviors().contains(cB)){
                    ch.removeBehavior(cB);
                }
                item.setDurability(red);
                player.updateInventory();
            }
        }
        if (behavior.equalsIgnoreCase(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Language Behavior")))){
            ChatBehavior cB = new LanguageBehavior();
            if (click.isLeftClick()){
                ch.addBehavior(cB);
                item.setDurability(green);
                player.updateInventory();
            }
            if (click.isRightClick()){
                if (ch.getChannelBehaviors().contains(cB)){
                    ch.removeBehavior(cB);
                }
                item.setDurability(red);
                player.updateInventory();
            }
        }
        if (behavior.equalsIgnoreCase(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Party Behavior")))){
            ChatBehavior cB = new PartyChatBehavior();
            if (click.isLeftClick()){
                ch.addBehavior(cB);
                item.setDurability(green);
                player.updateInventory();
            }
            if (click.isRightClick()){
                if (ch.getChannelBehaviors().contains(cB)){
                    ch.removeBehavior(cB);
                }
                item.setDurability(red);
                player.updateInventory();
            }
        }
        if (behavior.equalsIgnoreCase(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat World Behavior")))){
            ChatBehavior cB = new WorldChatBehavior();
            if (click.isLeftClick()){
                ch.addBehavior(cB);
                item.setDurability(green);
                player.updateInventory();
            }
            if (click.isRightClick()){
                if (ch.getChannelBehaviors().contains(cB)){
                    ch.removeBehavior(cB);
                }
                item.setDurability(red);
                player.updateInventory();
            }
        }
        if (behavior.equalsIgnoreCase(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Distance Behavior")))){
            ChatBehavior cB = new DistanceChatBehavior();
            if (click.isLeftClick()){
                ch.addBehavior(cB);
                item.setDurability(green);
                player.updateInventory();
            }
            if (click.isRightClick()){
                if (ch.getChannelBehaviors().contains(cB)){
                    ch.removeBehavior(cB);
                }
                item.setDurability(red);
                player.updateInventory();
            }
            if (click.equals(ClickType.SHIFT_LEFT)){
                int i = item.getAmount() + 1;
                if (RpgAPI.chatDistances.containsKey(ch.getChannelName())){
                    RpgAPI.chatDistances.remove(ch.getChannelName());
                }
                RpgAPI.chatDistances.put(ch.getChannelName(), i);
                item.setAmount(i);
                player.updateInventory();
            }
            if (click.equals(ClickType.SHIFT_RIGHT)){
                int i = item.getAmount() - 1;
                if (i <= 1){
                    i = 1;
                }
                if (RpgAPI.chatDistances.containsKey(ch.getChannelName())){
                    RpgAPI.chatDistances.remove(ch.getChannelName());
                }
                RpgAPI.chatDistances.put(ch.getChannelName(), i);
                item.setAmount(i);
                player.updateInventory();
            }
        }
    }
}
