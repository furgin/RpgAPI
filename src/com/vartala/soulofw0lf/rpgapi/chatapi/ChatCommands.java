package com.vartala.soulofw0lf.rpgapi.chatapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.guiapi.*;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
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
    /**
     *
     * @param p
     * @param command
     * @return
     */
    public static Boolean ChatHandler(Player p, String[] command){
        RpgPlayer rp = RpgAPI.getRp(p.getName());
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Chat Command"))){
            if (command.length == 1){
                Short wc = 0;
                List<ItemStack> lIS = new ArrayList<ItemStack>();
                List<String> cNames = new ArrayList<>();
                for (String invC : rp.getInvitedChats()){
                    cNames.add(invC);
                    ItemStack iS = new ItemStack(Material.WEB, 1);
                    ItemMeta iM = iS.getItemMeta();
                    iM.setDisplayName(invC);
                    List<String> lores = new ArrayList<String>();
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Left Click Line 1")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Left Click Line 2")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Right Click Line 1")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Right Click Line 2")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Shift Click Line 1")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Shift Click Line 2")));
                    iM.setLore(lores);
                    iS.setItemMeta(iM);
                    iS.setDurability(wc);
                    lIS.add(iS);
                }

                for (String chat : rp.getChannelColor().keySet()){
                    cNames.add(chat);
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
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Left Click Line 1")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Left Click Line 2")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Right Click Line 1")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Right Click Line 2")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Shift Click Line 1")));
                    lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Shift Click Line 2")));
                    iM.setLore(lores);
                    iS.setItemMeta(iM);
                    iS.setDurability(wc);
                    lIS.add(iS);
                }
                for (ChatClass cC : RpgAPI.chatClasses){
                    if (!cNames.contains(cC.getChannelName())){
                        if (cC.getPrivateChat()){
                            continue;
                        }
                            ItemStack iS = new ItemStack(Material.WEB, 1);
                            ItemMeta iM = iS.getItemMeta();
                            iM.setDisplayName(cC.getChannelName());
                            List<String> lores = new ArrayList<String>();
                        lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Left Click Line 1")));
                        lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Left Click Line 2")));
                        lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Right Click Line 1")));
                        lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Right Click Line 2")));
                        lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Shift Click Line 1")));
                        lores.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Shift Click Line 2")));
                            iM.setLore(lores);
                            iS.setItemMeta(iM);
                            iS.setDurability(wc);
                            lIS.add(iS);
                    }
                }
                RpgClickInv cInv = new RpgClickInv();
                Inventory inv = InventoryMaker.invMaker(null, ChatColors.ChatString(RpgAPI.activeNicks.get(p.getName()) + RpgAPI.localeSettings.get("Chat Inventory Name")), lIS);
                cInv.setInvName(inv.getName());
                cInv.setClickInv(inv);
                ChatInventoryBehavior cIb = new ChatInventoryBehavior();
                cInv.addBehavior(cIb);
                RpgAPI.rpgClicks.add(cInv);
                RpgAPI.deleteOnClose.add(cInv);
                p.openInventory(inv);
                return true;
            }
            if (command[1].equalsIgnoreCase(RpgAPI.commandSettings.get("Chat New"))){
                if (!(rp.hasPermission(RpgAPI.permissionSettings.get("Create Chat")))){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat No Create Perms")));
                    return true;
                }
                if (command.length != 4){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Wrong Create Command")));
                    return true;
                }
                for (ChatClass ch : RpgAPI.chatClasses){
                    if (ch.getChannelName().equalsIgnoreCase(command[2])){
                        p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Channel Exists").replace("@c", command[2])));
                        return true;
                    }
                    if (ch.getChannelNick().equalsIgnoreCase(command[3])){
                        p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Nick Exists").replace("@n", command[3])));
                        return true;
                    }
                }

                ChatClass ch = new ChatClass();
                ch.setChannelOwner(RpgAPI.activeNicks.get(p.getName()));
                ch.setChannelNick(command[3]);
                ch.setChatSpy(true);
                ch.setChannelName(command[2]);
                ch.setPrivateChat(false);
                ch.addBehavior(new BasicChatBehavior());
                RpgAPI.chatClasses.add(ch);
                List<ItemStack> itemStackList = new ArrayList<>();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Create Left Click")));
                lore.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Create Right Click")));
                Short s = 14;
                ItemStack iC = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat City Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iC);
                ItemStack iR = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Region Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iR);
                ItemStack iGld = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Guild Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iGld);
                ItemStack iL = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Language Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iL);
                ItemStack iP = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Party Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iP);
                ItemStack iW = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat World Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iW);
                lore.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Create Shift Left Click")));
                lore.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Create Shift Right Click")));
                ItemStack iD = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Distance Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iD);
                String name = command[2];
                Inventory inv = InventoryMaker.invMaker(null, name, itemStackList);
                RpgClickInv rC = new RpgClickInv();
                rC.setClickInv(inv);
                rC.setInvName(name);
                rC.addBehavior(new ChatCreateBehavior());
                RpgAPI.deleteOnClose.add(rC);
                RpgAPI.rpgClicks.add(rC);
                rp.getChannelColor().put(command[2], "&f");
                rp.setActiveChannel(command[2]);
                p.openInventory(inv);
                return true;
            }
            if (command[1].equalsIgnoreCase(RpgAPI.commandSettings.get("Create Private"))){
                if (!(rp.hasPermission(RpgAPI.permissionSettings.get("Create Private Chat")))){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat No Create Perms")));
                    return true;
                }
                if (command.length != 5){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Wrong Private Create Command")));
                    return true;
                }
                for (ChatClass ch : RpgAPI.chatClasses){
                    if (ch.getChannelName().equalsIgnoreCase(command[2])){
                        p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Channel Exists").replace("@c", command[2])));
                        return true;
                    }
                    if (ch.getChannelNick().equalsIgnoreCase(command[3])){
                        p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Nick Exists").replace("@n", command[3])));
                        return true;
                    }
                }

                ChatClass ch = new ChatClass();
                ch.setChannelOwner(RpgAPI.activeNicks.get(p.getName()));
                ch.setChannelNick(command[3]);
                ch.setChatSpy(true);
                ch.setChannelName(command[2]);
                ch.setPrivateChat(true);
                ch.setChannelPassword(command[4]);
                ch.addBehavior(new BasicChatBehavior());
                RpgAPI.chatClasses.add(ch);
                List<ItemStack> itemStackList = new ArrayList<>();
                List<String> lore = new ArrayList<>();
                lore.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Create Left Click")));
                lore.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Create Right Click")));
                Short s = 14;
                ItemStack iC = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat City Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iC);
                ItemStack iR = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Region Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iR);
                ItemStack iGld = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Guild Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iGld);
                ItemStack iL = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Language Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iL);
                ItemStack iP = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Party Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iP);
                ItemStack iW = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat World Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iW);
                lore.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Create Shift Left Click")));
                lore.add(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Create Shift Right Click")));
                ItemStack iD = InventoryMaker.itemStackMaker(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Distance Behavior")), Material.WOOL, 1, s, lore);
                itemStackList.add(iD);
                String name = command[2];
                Inventory inv = InventoryMaker.invMaker(null, name, itemStackList);
                RpgClickInv rC = new RpgClickInv();
                rC.setClickInv(inv);
                rC.setInvName(name);
                rC.addBehavior(new ChatCreateBehavior());
                RpgAPI.deleteOnClose.add(rC);
                RpgAPI.rpgClicks.add(rC);
                rp.getChannelColor().put(command[2], "&f");
                rp.setActiveChannel(command[2]);
                p.openInventory(inv);
                return true;
            }
            if (command[1].equalsIgnoreCase(RpgAPI.commandSettings.get("Chat Help"))){
                p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Help")).replace("@h", RpgAPI.commandSettings.get("Chat Help")).replace("@n", RpgAPI.commandSettings.get("Chat New")).replace("@p", RpgAPI.commandSettings.get("Create Private")).replace("@r", RpgAPI.commandSettings.get("Create Region")).replace("@c", RpgAPI.commandSettings.get("Create City")).replace("@i", RpgAPI.commandSettings.get("Chat Invite")).replace("@a", RpgAPI.commandSettings.get("Chat Accept")).replace("@k", RpgAPI.commandSettings.get("Chat Kick")).replace("@m", RpgAPI.commandSettings.get("Chat Mute")).replace("@v", RpgAPI.commandSettings.get("Chat Voice")).replace("@b", RpgAPI.commandSettings.get("Chat Ban")).replace("@u", RpgAPI.commandSettings.get("Chat Unban")).replace("@d", RpgAPI.commandSettings.get("Chat Delete")).replace("@l", RpgAPI.commandSettings.get("Chat Channel List")).replace("@w", RpgAPI.commandSettings.get("Chat Who")).replace("@o", RpgAPI.commandSettings.get("Chat Owner")).replace("@t", RpgAPI.commandSettings.get("Chat Take")).replace("@s",RpgAPI.commandSettings.get("Chat Supervisor")).replace("@x", RpgAPI.commandSettings.get("Chat XSupervisor")));
                return true;
            }
            if (command[1].equalsIgnoreCase(RpgAPI.commandSettings.get("Create Region"))){
                if (!rp.hasPermission(RpgAPI.permissionSettings.get("Create Region"))){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Region No Create Perms")));
                    return true;
                }
                if (command.length != 4){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Wrong Region Create Command")));
                    return true;
                }
                ChatRegions cR = new ChatRegions();
                cR.setRegionName(command[2]);
                cR.setRegionRadius(Integer.parseInt(command[3]));
                cR.setRegionLoc(p.getLocation());
                RpgAPI.chatRegions.add(cR);
                p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Region Created")));
                return true;
            }
            if (command[1].equalsIgnoreCase(RpgAPI.commandSettings.get("Create City"))){
                if (!rp.hasPermission(RpgAPI.permissionSettings.get("Create City"))){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("City No Create Perms")));
                    return true;
                }
                if (command.length != 4){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Wrong City Create Command")));
                    return true;
                }
                RpgCities cR = new RpgCities();
                cR.setRegionName(command[2]);
                cR.setRegionRadius(Integer.parseInt(command[3]));
                cR.setRegionLoc(p.getLocation());
                RpgAPI.rpgCities.add(cR);
                p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("City Created")));
                return true;
            }
            if (command[1].equalsIgnoreCase(RpgAPI.commandSettings.get("Chat Invite"))){
                if (!rp.hasPermission(RpgAPI.permissionSettings.get("Chat Invite"))){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("No Chat Invite Perms")));
                }
                if (command.length != 4){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Wrong Invite Command")));
                    return true;
                }
                if (RpgAPI.getChatByName(command[3]) == null){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("No Such Channel")));
                    return true;
                }
                ChatClass cH = RpgAPI.getChatByName(command[3]);

                if (!cH.getChannelOwner().equalsIgnoreCase(RpgAPI.activeNicks.get(p.getName()))){
                     p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Not Channel Owner")));
                    return true;
                }
                RpgPlayer rpl = RpgAPI.rpgPlayers.get(command[2]);
                if (rpl == null){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Player Not Found")));
                    return true;
                }
                if (!rpl.hasPermission(RpgAPI.permissionSettings.get("Chat Accept"))){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Can Not Be Invited").replace("@p", command[2])));
                    return true;
                }
                if (rpl.getChannelColor().containsKey(command[3])){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Player In Chat").replace("@p", command[2])));
                    return true;
                }
                if (rpl.getBannedChats().contains(command[3])){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Player Banned From Chat").replace("@p", command[2])));
                    return true;
                }
                if (rpl.getInvitedChats().contains(command[3])){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Player Already Invited").replace("@p", command[2])));
                    return true;
                }
                rpl.getInvitedChats().add(command[3]);
                Bukkit.getPlayer(rpl.getRealName()).sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Invite Received").replace("@p", rp.getName()).replace("@c", command[3])));
                p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Invite Sent").replace("@p", command[2])));
                return true;
            }
            if (command[1].equalsIgnoreCase(RpgAPI.commandSettings.get("Chat Accept"))){
                if (!rp.hasPermission(RpgAPI.permissionSettings.get("Chat Accept"))){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Can Not Accept")));
                    return true;
                }
                if (command.length != 3){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Wrong Accept Command")));
                    return true;
                }
                if (rp.getInvitedChats().isEmpty()){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("No Pending Invites")));
                    return true;
                }
                if (command[2].equalsIgnoreCase(RpgAPI.commandSettings.get("Chat Accept List"))){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat List All")));
                    for (String chat : rp.getInvitedChats()){
                        p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + chat));
                    }
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Chat Wrong Accept Command")));
                    return true;
                }
                if (command[2].equalsIgnoreCase(RpgAPI.commandSettings.get("Chat Accept All"))){
                    for (String chat : rp.getInvitedChats()){
                        if (RpgAPI.getChatByName(chat) == null){
                            continue;
                        }
                        ChatClass ch = RpgAPI.getChatByName(chat);
                        rp.getChannelColor().put(chat, "&f");
                        for (String pic : ch.getPlayersInChat()){
                            Bukkit.getPlayer(pic).sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Player Joined Channel").replace("@p", rp.getName())));
                        }
                        ch.addPlayerToChat(rp.getName());
                        p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Joined Chat").replace("@c", chat)));
                        rp.getInvitedChats().remove(chat);
                    }
                }
                if (!rp.getInvitedChats().contains(command[2])){
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("No Such Channel")));
                    return true;
                }
                String chat = command[2];
                ChatClass ch = RpgAPI.getChatByName(chat);
                rp.getChannelColor().put(chat, "&f");
                for (String pic : ch.getPlayersInChat()){
                    Bukkit.getPlayer(pic).sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Player Joined Channel").replace("@p", rp.getName())));
                }
                ch.addPlayerToChat(rp.getName());
                p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Chat Stub") + RpgAPI.localeSettings.get("Joined Chat").replace("@c", chat)));
                rp.getInvitedChats().remove(chat);
                return true;
            }


            return true;
        }

        return false;
    }
}
