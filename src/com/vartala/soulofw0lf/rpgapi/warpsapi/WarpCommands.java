package com.vartala.soulofw0lf.rpgapi.warpsapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.commandapi.UniqueCommands;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import com.vartala.soulofw0lf.rpgapi.util.HelpFile;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 7/4/13
 * Time: 2:32 AM
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
public class WarpCommands {
    /**
     *
     * @param p
     * @param command
     * @return
     */
    public static Boolean handler(Player p, String[] command){
        String stub = RpgAPI.localeSettings.get("Warp Stub");
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Load Warps"))) {
            WarpSetBuilder.BuildSets();
            WarpBuilder.WarpLoader();
            p.sendMessage(ChatColors.ChatString(stub + RpgAPI.localeSettings.get("Warps Loaded")));
            return true;
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Set Warp"))) {
            RpgWarp rWarp = new RpgWarp();
            if (command.length <= 1){
                HelpFile hF = RpgAPI.helpByName(command[0]);
                p.sendMessage(ChatColors.ChatString(stub + hF.getDescription()));
                return true;
            }
            rWarp.setWarpName(command[1]);
            if (command.length == 3){
                rWarp.setWarpSet(command[2]);
            } else {
            rWarp.setWarpSet("Default");
            }
            if (!(RpgAPI.savedSets.containsKey(rWarp.getWarpSet()))) {
                WarpSets wSet = new WarpSets();
                wSet.setSetName(rWarp.getWarpSet());
                wSet.setWarpsRandom(false);
                wSet.setSetPermission(rWarp.getWarpSet()+".warp");
                RpgAPI.savedSets.put(wSet.getSetName(), wSet);
            }
            rWarp.setWarpX(p.getLocation().getX());
            rWarp.setWarpY(p.getLocation().getY());
            rWarp.setWarpZ(p.getLocation().getZ());
            rWarp.setWorldName(p.getWorld().getName());
            rWarp.setWarpYaw(p.getLocation().getYaw());
            rWarp.setWarpPitch(p.getLocation().getPitch());
            RpgAPI.savedWarps.put(command[1], rWarp);
            WarpSets thisSet = RpgAPI.savedSets.get(rWarp.getWarpSet());
            List<RpgWarp> thisList = thisSet.getSetWarps();
            thisList.add(rWarp);
            thisSet.setSetWarps(thisList);
            p.sendMessage(ChatColors.ChatString(stub + RpgAPI.localeSettings.get("Warp Placed").replace("@w", rWarp.getWarpName())));
            return true;
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Save Warp"))) {
            if (command.length != 2) {
                HelpFile hF = RpgAPI.helpByName(command[0]);
                p.sendMessage(ChatColors.ChatString(stub + hF.getDescription()));
                return true;
            }
            if (!(RpgAPI.savedWarps.containsKey(command[1]))) {
                p.sendMessage(ChatColors.ChatString(stub + RpgAPI.localeSettings.get("No Warp By That Name")));
                return true;
            }
            WarpBuilder.SaveWarp(command[1]);
            p.sendMessage(ChatColors.ChatString(stub + RpgAPI.localeSettings.get("Warp Saved").replace("@w", command[1])));
            return true;
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Use Warp"))) {
            if (command.length != 2) {
                HelpFile hF = RpgAPI.helpByName(command[0]);
                p.sendMessage(ChatColors.ChatString(stub + hF.getDescription()));
                return true;
            }
            if (!(RpgAPI.savedWarps.containsKey(command[1]))) {
                p.sendMessage(ChatColors.ChatString(stub + RpgAPI.localeSettings.get("No Warp By That Name")));
                return true;
            }
            if (RpgAPI.warpCds.containsKey(p.getName())) {
                for (String warpName : RpgAPI.warpCds.get(p.getName())) {
                    if (warpName.equalsIgnoreCase(command[1])) {
                        p.sendMessage("You must wait longer before using that Warp");
                        return true;
                    }
                }
            }
            if (RpgAPI.savedWarps.get(command[1]).getItemNeeded()) {
                Boolean useWarp = ItemProcessor(p, RpgAPI.savedWarps.get(command[1]));
                if (!(useWarp)) {
                    p.sendMessage("You do not have the required item to use this warp");
                    return true;
                }

            }
            WarpProcessor.WarpHandler(p.getName(), RpgAPI.savedWarps.get(command[1]));
            return true;
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Edit Warp Values"))) {
            if (command.length != 4) {
                HelpFile hF = RpgAPI.helpByName(command[0]);
                p.sendMessage(ChatColors.ChatString(stub + hF.getDescription()));
                return true;
            }
            if (!(RpgAPI.savedWarps.containsKey(command[1]))) {
                p.sendMessage(ChatColors.ChatString(stub + RpgAPI.localeSettings.get("No Warp By That Name")));
                return true;
            }
            if (command[2].equalsIgnoreCase("level")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Integer i = Integer.parseInt(command[3]);
                rWarp.setWarpLevel(i);
                return true;
            }
            if (command[2].equalsIgnoreCase("perm")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                rWarp.setPermNeeded(command[3]);
                return true;
            }
            if (command[2].equalsIgnoreCase("Variance")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Integer i = Integer.parseInt(command[3]);
                rWarp.setWarpVariance(i);
                return true;
            }
            if (command[2].equalsIgnoreCase("Material")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Material mat = Material.valueOf(command[3]);
                List<Material> mats = rWarp.getItemMaterial();
                mats.add(mat);
                rWarp.setItemMaterial(mats);
                return true;
            }
            if (command[2].equalsIgnoreCase("iName")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                List<String> names = rWarp.getItemNames();
                names.add(command[3].replaceAll("_", " "));
                rWarp.setItemNames(names);
                return true;
            }
            if (command[2].equalsIgnoreCase("iLore")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                List<String> lores = rWarp.getLoreNeeded();
                lores.add(command[3].replaceAll("_", " "));
                rWarp.setLoreNeeded(lores);
                return true;
            }
            if (command[2].equalsIgnoreCase("cd")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Integer i = Integer.parseInt(command[3]);
                rWarp.setWarpCoolDown(i);
                return true;
            }
            p.sendMessage("Proper use /" + RpgAPI.commandSettings.get("Edit Warp Values") + " <warp name> <Cd |Level | Perm | Variance | Material | iName | iLore> <Value_settings>");
            return true;
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Edit Warp"))) {
            if (command.length != 4) {
                HelpFile hF = RpgAPI.helpByName(command[0]);
                p.sendMessage(ChatColors.ChatString(stub + hF.getDescription()));
                return true;
            }
            if (!(RpgAPI.savedWarps.containsKey(command[1]))) {
                p.sendMessage(ChatColors.ChatString(stub + RpgAPI.localeSettings.get("No Warp By That Name")));
                return true;
            }
            if (command[2].equalsIgnoreCase("World")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")) {
                    c3 = true;
                }
                rWarp.setSameWorld(c3);
                p.sendMessage("Warp " + command[1] + " now has Same world required set to " + c3 + ".");
                return true;
            }
            if (command[2].equalsIgnoreCase("level")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")) {
                    c3 = true;
                }
                rWarp.setLevelNeeded(c3);
                p.sendMessage("Warp " + command[1] + " now has Level Needed set to " + c3 + ".");
                return true;
            }
            if (command[2].equalsIgnoreCase("Perm")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")) {
                    c3 = true;
                }
                rWarp.setSinglePerm(c3);
                p.sendMessage("Warp " + command[1] + " now has Same world required set to " + c3 + ".");
                return true;
            }
            if (command[2].equalsIgnoreCase("Variance")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")) {
                    c3 = true;
                }
                rWarp.setVariance(c3);
                p.sendMessage("Warp " + command[1] + " now has Variance set to " + c3 + ".");
                return true;
            }
            if (command[2].equalsIgnoreCase("cd")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")) {
                    c3 = true;
                }
                rWarp.setUseCD(c3);
                p.sendMessage("Warp " + command[1] + " now has Use Cool down set to " + c3 + ".");
                return true;
            }
            if (command[2].equalsIgnoreCase("Item")) {
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")) {
                    c3 = true;
                }

                rWarp.setItemNeeded(c3);
                p.sendMessage("Warp " + command[1] + " now has Item required set to " + c3 + ".");
                return true;
            }
            p.sendMessage("Proper use /" + RpgAPI.commandSettings.get("Edit Warp") + " <warp name> <Cd | World | Level | Perm | Variance | item> <true/false>");
            return true;
        }


        return false;
    }

    /**
     *
     * @param p
     * @param rpgWarp
     * @return
     */
    private static Boolean ItemProcessor(Player p, RpgWarp rpgWarp) {
        Boolean useWarp = false;
        Inventory inv = p.getInventory();
        for (ItemStack is : inv.getContents()) {
            for (Material mat : rpgWarp.getItemMaterial()) {
                if (is == null || is.getType().equals(Material.AIR)) {
                    continue;
                }
                if (!(is.getType().equals(mat))) {
                    continue;
                }
                ItemMeta im = is.getItemMeta();
                if ((rpgWarp.getItemNeedsName() || rpgWarp.getNeedsLore()) && im == null) {
                    continue;
                }
                if (rpgWarp.getNeedsLore() && im.getLore() == null) {
                    continue;
                }
                if (rpgWarp.getItemNeedsName() && im.getDisplayName() == null) {
                    continue;
                }
                if (rpgWarp.getItemNeedsName() || rpgWarp.getNeedsLore()) {
                    if (rpgWarp.getNeedsLore()) {
                        Boolean lorePresent = false;
                        for (String lore : rpgWarp.getLoreNeeded()) {
                            for (String lores : im.getLore()) {
                                if (lore.equalsIgnoreCase(lores)) {
                                    lorePresent = true;
                                }
                            }
                        }
                        if (lorePresent == false) {
                            continue;
                        }
                    }
                    if (rpgWarp.getItemNeedsName()) {
                        Boolean namePresent = false;
                        for (String iName : rpgWarp.getItemNames()) {
                            if (iName.equalsIgnoreCase(im.getDisplayName())) {
                                namePresent = true;
                            }
                        }
                        if (namePresent == false) {
                            continue;
                        }
                    }
                }
                if (rpgWarp.getItemConsumed()) {
                    Integer a = is.getAmount();
                    if (a <= 1) {
                        p.getInventory().remove(is);
                    }
                    is.setAmount(a - 1);
                }
                useWarp = true;
                return useWarp;
            }
        }
        return useWarp;
    }
}
