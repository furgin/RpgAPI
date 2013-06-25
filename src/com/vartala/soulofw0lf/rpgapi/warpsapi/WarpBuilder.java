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

    public static void WarpLoader(){
        File f = new File("plugins/RpgAPI/RpgWarps");
        File[] files = f.listFiles();
        if (files != null){
            for (File warpSets : files){
                File r = new File("plugins/RpgAPI/RpgWarps/" + warpSets);
                File[] files1 = r.listFiles();
                if (files != null){
                    for (File warpFiles : files1){
                        YamlConfiguration warpConfig = YamlConfiguration.loadConfiguration(warpFiles);
                        RpgWarp newWarp = new RpgWarp();
                        newWarp.setWarpSet(warpSets.getName());
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
                        if (newWarp.getLevelNeeded()){
                            newWarp.setWarpLevel(warpConfig.getInt("Warp Data.Warp Level"));
                        }
                        newWarp.setSinglePerm(warpConfig.getBoolean("Warp Data.Needs Individual Permission"));
                        if (newWarp.getSinglePerm()){
                            newWarp.setPermNeeded(warpConfig.getString("Warp Data.Permission"));
                        }
                        newWarp.setVariance(warpConfig.getBoolean("Warp Data.Use Variance"));
                        if (newWarp.getVariance()){
                            newWarp.setWarpVariance(warpConfig.getInt("Warp Data.Radius For Variance"));
                        }
                        newWarp.setItemNeeded(warpConfig.getBoolean("Warp Data.Is Item Needed"));
                        if (newWarp.getItemNeeded()){
                            newWarp.setUseItemForWarp(warpConfig.getBoolean("Warp Data.Use Item For Warp"));
                            newWarp.setNeedsLore(warpConfig.getBoolean("Warp Data.Is Lore Needed"));
                            if (newWarp.getNeedsLore()){
                                List<String> neededLores = new ArrayList<String>();
                                for (String lores : warpConfig.getConfigurationSection("Warp Data.Lore List").getKeys(false)){
                                    neededLores.add(lores);
                                }
                                newWarp.setLoreNeeded(neededLores);
                            }
                            newWarp.setItemNeedsName(warpConfig.getBoolean("Warp Data.Is Item Name Needed"));
                            if (newWarp.getItemNeedsName()){
                                List<String> namesNeeded = new ArrayList<String>();
                                for (String itemName : warpConfig.getConfigurationSection("Warp Data.Names Needed").getKeys(false)){
                                    namesNeeded.add(itemName);
                                }
                                newWarp.setItemNames(namesNeeded);
                            }
                            List<Material> itemMats = new ArrayList<Material>();
                            for (String materials : warpConfig.getConfigurationSection("Warp Data.Item Materials").getKeys(false)){
                                itemMats.add(Material.valueOf(materials));
                            }
                            newWarp.setItemMaterial(itemMats);
                            newWarp.setItemConsumed(warpConfig.getBoolean("Warp Data.Is Item Consumed"));
                        }
                        RpgAPI.savedWarps.put(newWarp.getWarpName(), newWarp);
                        WarpSets thisSet = RpgAPI.savedSets.get(newWarp.getWarpSet());
                        List<RpgWarp> thisWarp = thisSet.getSetWarps();
                        thisWarp.add(newWarp);
                        thisSet.setSetWarps(thisWarp);
                        for (String itemName : newWarp.getItemNames()){
                            for (Material itemMaterial : newWarp.getItemMaterial()){
                                for (String itemLore : newWarp.getLoreNeeded()){
                                    List<String> tempLore = new ArrayList<String>();
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
    public static void SaveWarps(){
        for (String thisWarp : RpgAPI.savedWarps.keySet()){
            RpgWarp saveWarp = RpgAPI.savedWarps.get(thisWarp);
            YamlConfiguration warpYml = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgWarps/" + saveWarp.getWarpSet() + "/" + saveWarp.getWarpName() + ".yml"));
            warpYml.set("Warp Data.Warp Name", saveWarp.getWarpName());
            warpYml.set("Warp Data.Cool Down", saveWarp.getWarpCoolDown());
            warpYml.set("Warp Data.Warp X", saveWarp.getWarpX());
            warpYml.set("Warp Data.Warp Y", saveWarp.getWarpY());
            warpYml.set("Warp Data.Warp Z", saveWarp.getWarpZ());
            warpYml.set("Warp Data.Warp World", saveWarp.getWorldName());
            warpYml.set("Warp Data.Warp Yaw", saveWarp.getWarpYaw());
            warpYml.set("Warp Data.Warp Pitch", saveWarp.getWarpPitch());
            warpYml.set("Warp Data.Same World Only", saveWarp.getSameWorld());
            warpYml.set("Warp Data.Is Level Required", saveWarp.getLevelNeeded());
            if (saveWarp.getLevelNeeded()){
                warpYml.set("Warp Data.Warp Level", saveWarp.getWarpLevel());
            }
            warpYml.set("Warp Data.Needs Individual Permission", saveWarp.getSinglePerm());
            if(saveWarp.getSinglePerm()){
            warpYml.set("Warp Data.Permission", saveWarp.getPermNeeded());
            }
            warpYml.set("Warp Data.Use Variance", saveWarp.getVariance());
            if (saveWarp.getVariance()){
            warpYml.set("Warp Data.Radius For Variance", saveWarp.getWarpVariance());
            }
            warpYml.set("Warp Data.Is Item Needed", saveWarp.getItemNeeded());
            if (saveWarp.getItemNeeded()){
                warpYml.set("Warp Data.Use Item For Warp", saveWarp.getUseItemForWarp());
                warpYml.set("Warp Data.Is Lore Needed", saveWarp.getNeedsLore());
                if (saveWarp.getNeedsLore()){
                    List<String> neededLores = saveWarp.getLoreNeeded();
                    for (String lores : neededLores){
                        warpYml.set("Warp Data.Lore List." + lores, true);
                    }

                }
                warpYml.set("Warp Data.Is Item Name Needed", saveWarp.getItemNeedsName());
                if (saveWarp.getItemNeedsName()){
                    List<String> namesNeeded = saveWarp.getItemNames();
                    for (String itemName : namesNeeded){
                        warpYml.set("Warp Data.Names Needed." + itemName, true);
                    }

                }
                List<Material> itemMats = saveWarp.getItemMaterial();
                for (Material materials : itemMats){
                    warpYml.set("Warp Data.Item Material." + materials.toString(), true);
                }

                warpYml.set("Warp Data.Is Item Consumed", saveWarp.getItemConsumed());
                try {
                    warpYml.save(new File("plugins/RpgAPI/RpgWarps/" + saveWarp.getWarpSet() + "/" + saveWarp.getWarpName() + ".yml"));
                } catch (IOException e) {
                }
            }
        }
    }
}
