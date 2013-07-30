package com.vartala.soulofw0lf.rpgapi.warpsapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.guiapi.InventoryMaker;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 6/24/13
 * Time: 6:29 PM
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
public class WarpBuilder {
    /**
     *
     */

    @SuppressWarnings("unchecked")
    public static void WarpLoader() {
        File f = new File("plugins/RpgWarps");
        File[] files = f.listFiles();
        if (files != null) {
            for (File warpSets : files) {
                if (warpSets.getName().equalsIgnoreCase("Locale")){
                    continue;
                }
                File r = new File("plugins/RpgWarps/" + warpSets.getName());
                File[] files1 = r.listFiles();
                if (files1 != null) {
                    for (File warpFiles : files1) {
                        if (warpFiles.exists()){
                        YamlConfiguration warpConfig = YamlConfiguration.loadConfiguration(warpFiles);
                        RpgWarp newWarp = new RpgWarp();
                        newWarp.setWarpSet(warpConfig.getString("Warp Data.Warp Set"));
                        newWarp.setUseCD(warpConfig.getBoolean("Warp Data.Use Cool Down"));
                        newWarp.setWarpName(warpConfig.getString("Warp Data.Warp Name"));
                        newWarp.setWarpCoolDown(warpConfig.getInt("Warp Data.Cool Down"));
                        newWarp.setWarpX(warpConfig.getDouble("Warp Data.Warp X"));
                        newWarp.setWarpY(warpConfig.getDouble("Warp Data.Warp Y"));
                        newWarp.setWarpZ(warpConfig.getDouble("Warp Data.Warp Z"));
                        newWarp.setWorldName(warpConfig.getString("Warp Data.Warp World"));
                        newWarp.setWarpYaw(Float.parseFloat(warpConfig.getString("Warp Data.Warp Yaw")));
                        newWarp.setWarpPitch(Float.parseFloat(warpConfig.getString("Warp Data.Warp Pitch")));
                        newWarp.setSameWorld(warpConfig.getBoolean("Warp Data.Same World Only"));
                        newWarp.setLevelNeeded(warpConfig.getBoolean("Warp Data.Is Level Required"));
                        if (newWarp.getLevelNeeded()) {
                            newWarp.setWarpLevel(warpConfig.getInt("Warp Data.Warp Level"));
                        }
                        newWarp.setSinglePerm(warpConfig.getBoolean("Warp Data.Needs Individual Permission"));
                        if (newWarp.getSinglePerm()) {
                            newWarp.setPermNeeded(warpConfig.getString("Warp Data.Permission"));
                        }
                        newWarp.setVariance(warpConfig.getBoolean("Warp Data.Use Variance"));
                        if (newWarp.getVariance()) {
                            newWarp.setWarpVariance(warpConfig.getInt("Warp Data.Radius For Variance"));
                        }
                        newWarp.setItemNeeded(warpConfig.getBoolean("Warp Data.Is Item Needed"));
                        if (newWarp.getItemNeeded()) {
                            newWarp.setUseItemForWarp(warpConfig.getBoolean("Warp Data.Use Item For Warp"));
                            newWarp.setNeedsLore(warpConfig.getBoolean("Warp Data.Is Lore Needed"));
                            if (newWarp.getNeedsLore()) {
                                List<String> neededLores = (List<String>) warpConfig.getList("Warp Data.Lore List");
                                newWarp.setLoreNeeded(neededLores);
                            }
                            newWarp.setItemNeedsName(warpConfig.getBoolean("Warp Data.Is Item Name Needed"));
                            if (newWarp.getItemNeedsName()) {
                                List<String> namesNeeded = (List<String>) warpConfig.getList("Warp Data.Names Needed");
                                newWarp.setItemNames(namesNeeded);
                            }
                            List<Material> itemMats = (List<Material>) warpConfig.getList("Warp Data.Item Materials");
                            newWarp.setItemMaterial(itemMats);
                            newWarp.setItemConsumed(warpConfig.getBoolean("Warp Data.Is Item Consumed"));
                        }
                        RpgAPI.savedWarps.put(newWarp.getWarpName(), newWarp);
                        WarpSets thisSet = RpgAPI.savedSets.get(newWarp.getWarpSet());
                        List<RpgWarp> setList = new ArrayList<>();
                        if (thisSet.getSetWarps() != null) {
                            setList = thisSet.getSetWarps();
                        }
                        setList.add(newWarp);
                        thisSet.setSetWarps(setList);
                        for (String itemName : newWarp.getItemNames()) {
                            for (Material itemMaterial : newWarp.getItemMaterial()) {
                                for (String itemLore : newWarp.getLoreNeeded()) {
                                    List<String> tempLore = new ArrayList<>();
                                    tempLore.add(itemLore);
                                    Short dura = 0;
                                    ItemStack is = InventoryMaker.itemStackMaker(itemName, itemMaterial, 0, dura, tempLore);
                                    RpgAPI.warpItems.add(is);
                                }
                            }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param thisWarp - save the warp object specified to config
     */
    public static void deleteWarp(String thisWarp){
        RpgWarp saveWarp = RpgAPI.savedWarps.get(thisWarp);
        new File("plugins/RpgWarps/" + saveWarp.getWarpSet() + "/" + saveWarp.getWarpName() + ".yml").delete();
        RpgAPI.savedWarps.remove(thisWarp);
    }
    public static void SaveWarp(String thisWarp) {

        RpgWarp saveWarp = RpgAPI.savedWarps.get(thisWarp);
        YamlConfiguration warpYml = YamlConfiguration.loadConfiguration(new File("plugins/RpgWarps/" + saveWarp.getWarpSet() + "/" + saveWarp.getWarpName() + ".yml"));
        warpYml.set("Warp Data.Warp Name", saveWarp.getWarpName());
        warpYml.set("Warp Data.Warp Set", saveWarp.getWarpSet());
        warpYml.set("Warp Data.Warp X", saveWarp.getWarpX());
        warpYml.set("Warp Data.Warp Y", saveWarp.getWarpY());
        warpYml.set("Warp Data.Warp Z", saveWarp.getWarpZ());
        warpYml.set("Warp Data.Warp Yaw", saveWarp.getWarpYaw());
        warpYml.set("Warp Data.Warp Pitch", saveWarp.getWarpPitch());
        warpYml.set("Warp Data.Same World Only", saveWarp.getSameWorld());
        warpYml.set("Warp Data.Warp World", saveWarp.getWorldName());
        warpYml.set("Warp Data.Use Cool Down", saveWarp.getUseCD());
        warpYml.set("Warp Data.Cool Down", saveWarp.getWarpCoolDown());
        warpYml.set("Warp Data.Is Level Required", saveWarp.getLevelNeeded());
        if (saveWarp.getLevelNeeded()) {
            warpYml.set("Warp Data.Warp Level", saveWarp.getWarpLevel());
        } else {
            warpYml.set("Warp Data.Warp Level", 0);
        }
        warpYml.set("Warp Data.Needs Individual Permission", saveWarp.getSinglePerm());
        if (saveWarp.getSinglePerm()) {
            warpYml.set("Warp Data.Permission", saveWarp.getPermNeeded());
        } else {
            warpYml.set("Warp Data.Permission", "");
        }
        warpYml.set("Warp Data.Use Variance", saveWarp.getVariance());
        if (saveWarp.getVariance()) {
            warpYml.set("Warp Data.Radius For Variance", saveWarp.getWarpVariance());
        } else {
            warpYml.set("Warp Data.Radius For Variance", 0);
        }
        warpYml.set("Warp Data.Is Item Needed", saveWarp.getItemNeeded());
        if (saveWarp.getItemNeeded()) {
            warpYml.set("Warp Data.Item Materials.", saveWarp.getItemMaterial());
            warpYml.set("Warp Data.Is Lore Needed", saveWarp.getNeedsLore());
            if (saveWarp.getNeedsLore()) {
                warpYml.set("Warp Data.Lore List.", saveWarp.getLoreNeeded());
            } else {
                warpYml.set("Warp Data.Lore List", "");
            }
            warpYml.set("Warp Data.Is Item Name Needed", saveWarp.getItemNeedsName());
            if (saveWarp.getItemNeedsName()) {
                warpYml.set("Warp Data.Names Needed.", saveWarp.getItemNames());
            } else {
                warpYml.set("Warp Data.Names Needed", "");
            }
            warpYml.set("Warp Data.Is Item Consumed", saveWarp.getItemConsumed());
            warpYml.set("Warp Data.Use Item For Warp", saveWarp.getUseItemForWarp());
        } else {
            warpYml.set("Warp Data.Item Materials", "");
            warpYml.set("Warp Data.Is Lore Needed", false);
            warpYml.set("Warp Data.Lore List", "");
            warpYml.set("Warp Data.Is Item Name Needed", false);
            warpYml.set("Warp Data.Names Needed", "");
            warpYml.set("Warp Data.Is Item Consumed", false);
            warpYml.set("Warp Data.Use Item For Warp", false);
        }
        try {
            warpYml.save(new File("plugins/RpgWarps/" + saveWarp.getWarpSet() + "/" + saveWarp.getWarpName() + ".yml"));
        } catch (IOException e) {
            System.out.print(e);
        }
    }
}
