package com.vartala.soulofw0lf.rpgapi.commandapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.enumapi.PlayerStat;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayerBuilder;
import com.vartala.soulofw0lf.rpgapi.speedapi.SpeedHandler;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import com.vartala.soulofw0lf.rpgapi.warpsapi.*;
import de.kumpelblase2.remoteentities.api.RemoteEntity;
import de.kumpelblase2.remoteentities.api.RemoteEntityType;
import de.kumpelblase2.remoteentities.api.thinking.Desire;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireFollowSpecific;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireLookAtSpecific;
import de.kumpelblase2.remoteentities.entities.RemotePlayer;
import de.kumpelblase2.remoteentities.api.thinking.DamageBehavior;
import de.kumpelblase2.remoteentities.api.thinking.InteractBehavior;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireLookAtNearest;
import de.kumpelblase2.remoteentities.persistence.EntityData;
import de.kumpelblase2.remoteentities.persistence.serializers.PreparationSerializer;
import de.kumpelblase2.remoteentities.persistence.serializers.YMLSerializer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 6/14/13
 * Time: 12:56 AM
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
public class UniqueCommands {
    //my testing class atm
    /*
    entity.getMind().addBehaviour(new InteractBehavior(entity)
    {
        @Override
        public void onInteract(Player inPlayer)
        {
            if ((inPlayer.isOP()) && (inPlayer.isSneaking())){
            inPlayer.openInventory(baseInvName);
            }

        }
     */
    public static void BaseCommandHandler(Player p, String[] command){
        command[0] = command[0].replace("/","");
        if(command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Load Warps"))){
            WarpSetBuilder.BuildSets();WarpBuilder.WarpLoader();
            p.sendMessage("you have loaded all warps");
        }

        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Set Warp"))){
            RpgWarp rWarp = new RpgWarp();
            rWarp.setWarpName(command[1]);
            rWarp.setWarpSet("Default");
            if (!(RpgAPI.savedSets.containsKey("Default"))){
                WarpSets wSet = new WarpSets();
                wSet.setSetName("Default");
                wSet.setWarpsRandom(false);
                wSet.setSetPermission("default.warp");
                RpgAPI.savedSets.put(wSet.getSetName(), wSet);
            }
            rWarp.setWarpX(p.getLocation().getX());
            rWarp.setWarpY(p.getLocation().getY());
            rWarp.setWarpZ(p.getLocation().getZ());
            rWarp.setWorldName(p.getWorld().getName());
            rWarp.setWarpYaw(p.getLocation().getYaw());
            rWarp.setWarpPitch(p.getLocation().getPitch());
            RpgAPI.savedWarps.put(command[1], rWarp);
            WarpSets thisSet = RpgAPI.savedSets.get("Default");
            List<RpgWarp> thisList = thisSet.getSetWarps();
            thisList.add(rWarp);
            thisSet.setSetWarps(thisList);
            p.sendMessage("you have set a warp named " + command[1] + ".");
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Save Warp"))){
            if (command.length != 2){
                p.sendMessage("Proper formatting /saveWarpCommand <warp name>");
                return;
            }
            if (!(RpgAPI.savedWarps.containsKey(command[1]))){
                p.sendMessage("That Warp Doesn't Exist!!!");
                return;
            }
            WarpBuilder.SaveWarp(command[1]);
            p.sendMessage("you have saved a warp named " + command[1] + ".");
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Use Warp"))){
            if (command.length != 2){
                p.sendMessage("Proper formatting /useWarpCommand <warp name>");
                return;
            }
            if (!(RpgAPI.savedWarps.containsKey(command[1]))){
                p.sendMessage("That Warp Doesn't Exist!!!");
                return;
            }
            if (RpgAPI.warpCds.containsKey(p.getName())){
                for (String warpName : RpgAPI.warpCds.get(p.getName())){
                    if (warpName.equalsIgnoreCase(command[1])){
                        p.sendMessage("You must wait longer before using that Warp");
                        return;
                    }
                }
            }
            if (RpgAPI.savedWarps.get(command[1]).getItemNeeded()){
                Boolean useWarp = ItemProcessor(p, RpgAPI.savedWarps.get(command[1]));
                if (!(useWarp)){
                    p.sendMessage("You do not have the required item to use this warp");
                    return;
                }

            }
            WarpProcessor.WarpHandler(p.getName(), RpgAPI.savedWarps.get(command[1]));
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Edit Warp Values"))){
            if (command.length != 4){
                p.sendMessage("Proper use /" + RpgAPI.commandSettings.get("Edit Warp Values") + " <warp name> <Cd |Level | Perm | Variance | Material | iName | iLore> <Value_settings>");
                return;
            }
            if (!(RpgAPI.savedWarps.containsKey(command[1]))){
                p.sendMessage("That warp does not exist!");
                return;
            }
            if (command[2].equalsIgnoreCase("level")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Integer i = Integer.parseInt(command[3]);
                rWarp.setWarpLevel(i);
            }
            if (command[2].equalsIgnoreCase("perm")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                rWarp.setPermNeeded(command[3]);
            }
            if (command[2].equalsIgnoreCase("Variance")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Integer i = Integer.parseInt(command[3]);
                rWarp.setWarpVariance(i);
            }
            if (command[2].equalsIgnoreCase("Material")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Material mat = Material.valueOf(command[3]);
                List<Material> mats = rWarp.getItemMaterial();
                mats.add(mat);
                rWarp.setItemMaterial(mats);
            }
            if (command[2].equalsIgnoreCase("iName")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                List<String> names = rWarp.getItemNames();
                names.add(command[3].replaceAll("_", " "));
                rWarp.setItemNames(names);
            }
            if (command[2].equalsIgnoreCase("iLore")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                List<String> lores = rWarp.getLoreNeeded();
                lores.add(command[3].replaceAll("_", " "));
                rWarp.setLoreNeeded(lores);
            }
            if (command[2].equalsIgnoreCase("cd")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Integer i = Integer.parseInt(command[3]);
                rWarp.setWarpCoolDown(i);
            }
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Edit Warp"))){
            if (command.length != 4){
                p.sendMessage("Proper use /" + RpgAPI.commandSettings.get("Edit Warp") + " <warp name> <Cd | World | Level | Perm | Variance | item> <true/false>");
                return;
            }
            if (!(RpgAPI.savedWarps.containsKey(command[1]))){
                p.sendMessage("That warp does not exist!");
                return;
            }
            if (command[2].equalsIgnoreCase("World")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")){
                    c3 = true;
                }
                rWarp.setSameWorld(c3);
                p.sendMessage("Warp " + command[1] + " now has Same world required set to " + c3 + ".");
            }
            if (command[2].equalsIgnoreCase("level")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")){
                    c3 = true;
                }
                rWarp.setLevelNeeded(c3);
                p.sendMessage("Warp " + command[1] + " now has Level Needed set to " + c3 + ".");
            }
            if (command[2].equalsIgnoreCase("Perm")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")){
                    c3 = true;
                }
                rWarp.setSinglePerm(c3);
                p.sendMessage("Warp " + command[1] + " now has Same world required set to " + c3 + ".");
            }
            if (command[2].equalsIgnoreCase("Variance")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")){
                    c3 = true;
                }
                rWarp.setVariance(c3);
                p.sendMessage("Warp " + command[1] + " now has Variance set to " + c3 + ".");
            }
            if (command[2].equalsIgnoreCase("cd")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")){
                    c3 = true;
                }
                rWarp.setUseCD(c3);
                p.sendMessage("Warp " + command[1] + " now has Use Cool down set to " + c3 + ".");
            }
            if (command[2].equalsIgnoreCase("Item")){
                RpgWarp rWarp = RpgAPI.savedWarps.get(command[1]);
                Boolean c3 = false;
                if (command[3].equalsIgnoreCase("true")){
                    c3 = true;
                }

                rWarp.setItemNeeded(c3);
                p.sendMessage("Warp " + command[1] + " now has Item required set to " + c3 + ".");
            }
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Test Command"))){
            String activeNick = RpgAPI.activeNicks.get(p.getName());
            RpgPlayer rp = RpgAPI.rpgPlayers.get(activeNick);
            Map<String, Integer> statMap = rp.getStats();
            Integer speed = statMap.get(PlayerStat.SPEED_LAND.toString());
            speed += 5;
            statMap.put(PlayerStat.SPEED_LAND.toString(), speed);
            statMap.put(PlayerStat.SPEED_FLY.toString(), speed);
            rp.setStats(statMap);
            SpeedHandler.SetWalkSpeed(rp, p.getName());
            SpeedHandler.SetFlySpeed(rp, p.getName());
            p.sendMessage("You are going " + p.getWalkSpeed() + " fast, with a movement speed of " + speed + ".");
            RpgAPI.commands.add("nick");
            return;
        }
        if (command[0].equalsIgnoreCase("nick")){
            String name = p.getName();
            String newName = command[1];
            RpgAPI.activeNicks.remove(name);
            RpgAPI.activeNicks.put(name, newName);
            RpgPlayer rp = RpgPlayerBuilder.RpgBuilder(newName);
            RpgAPI.rpgPlayers.remove(newName);
            RpgAPI.rpgPlayers.put(newName, rp);
            SpeedHandler.SetWalkSpeed(rp, name);
            SpeedHandler.SetFlySpeed(rp, name);
        }
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Player Info"))){
            String activeNick = RpgAPI.activeNicks.get(p.getName());
            RpgPlayer rp = RpgAPI.rpgPlayers.get(activeNick);
            Map<String, Integer> statMap = rp.getStats();
            statMap.put(PlayerStat.SPEED_LAND.toString(), 0);
            statMap.put(PlayerStat.SPEED_FLY.toString(), 0);
            rp.setStats(statMap);
            SpeedHandler.SetWalkSpeed(rp, p.getName());
            SpeedHandler.SetFlySpeed(rp, p.getName());

            return;
        }
        switch(command[0])
        {
            case "body":
                p.sendMessage(ChatColors.ChatString("&2sup man, &4 how's it going?"));

                break;
            case "addnpc":
                RemoteEntity ed = RpgAPI.entityManager.createNamedEntity(RemoteEntityType.Human, p.getLocation(), "soulofw0lf", false);
                //ed.getMind().addMovementDesire(new DesireLookAtSpecific(ed, p, 8), 10);
                ed.getMind().addMovementDesire(new DesireLookAtNearest(ed, Player.class, 8F), 10);
                ed.getMind().addBehaviour(new InteractBehavior(ed) {
                    @Override
                    public void onInteract(Player inPlayer) {
                        inPlayer.sendMessage("yo");
                    }
                });
                ed.getMind().addBehaviour(new DamageBehavior(ed) {
                    @Override
                    public void onDamage(EntityDamageEvent entityDamageEvent) {
                        entityDamageEvent.setCancelled(true);
                    }
                });
                ed.getMind().addMovementDesire(new DesireFollowSpecific(ed, p, 2, 3), 9);
                p.sendMessage("" + ed.getID());
                ed.getBukkitEntity().getEquipment().setBoots(new ItemStack(309, 1));
                ed.getBukkitEntity().getEquipment().setLeggings(new ItemStack(308, 1));
                ed.getBukkitEntity().getEquipment().setChestplate(new ItemStack(307, 1));
                ed.getBukkitEntity().getEquipment().setHelmet(new ItemStack(306, 1));
                ed.getBukkitEntity().getEquipment().setItemInHand(new ItemStack(267, 1));
                //RpgAPI.entityManager.saveEntities();
                break;
            case "removenpc":
                RpgAPI.entityManager.removeEntity(Integer.parseInt(command[1]));
                break;
            case "addtochain":
                RemoteEntity ed2 = RpgAPI.entityManager.createNamedEntity(RemoteEntityType.Human, p.getLocation(), "Skahl"+command[1], false);
                ed2.getMind().addMovementDesire(new DesireLookAtSpecific(ed2, RpgAPI.entityManager.getRemoteEntityByID(Integer.parseInt(command[1])).getBukkitEntity(), 8), 10);
                ed2.getMind().addMovementDesire(new DesireFollowSpecific(ed2, RpgAPI.entityManager.getRemoteEntityByID(Integer.parseInt(command[1])).getBukkitEntity(), 2, 3), 9);
                ed2.getBukkitEntity().getEquipment().setBoots(new ItemStack(309, 1));
                ed2.getBukkitEntity().getEquipment().setLeggings(new ItemStack(308, 1));
                ed2.getBukkitEntity().getEquipment().setChestplate(new ItemStack(307, 1));
                ed2.getBukkitEntity().getEquipment().setHelmet(new ItemStack(306, 1));
                ed2.getBukkitEntity().getEquipment().setItemInHand(new ItemStack((int)(Math.random()*200), 1));
                break;
            case "movetome":
                RemoteEntity re = RpgAPI.entityManager.getRemoteEntityByID(Integer.parseInt(command[1]));
                re.setStationary(false, false);
                re.move(p);
                re.setStationary(true, false);
                break;
            case "savenpc":
               RemoteEntity rm = RpgAPI.entityManager.getRemoteEntityByID(Integer.parseInt(command[1]));
                rm.getMind().clearBehaviours();
                rm.getMind().clearMovementDesires();
                rm.getMind().clearTargetingDesires();
                rm.save();
                p.sendMessage("Saved? ");
                break;
            case "loadnpc":
                RpgAPI.entityManager.loadEntities();
                break;
            case "infonpc":
                RemoteEntity rm2 = RpgAPI.entityManager.getRemoteEntityByID(Integer.parseInt(command[1]));
                p.sendMessage(rm2.getNativeEntityName());
                p.sendMessage(""+rm2.isSpawned());
                break;


        }
    }

    private static Boolean ItemProcessor(Player p, RpgWarp rpgWarp) {
        Boolean useWarp = false;
        Inventory inv = p.getInventory();
        for (ItemStack is : inv.getContents()){
            for (Material mat : rpgWarp.getItemMaterial()){
                if (is == null || is.getType().equals(Material.AIR)){
                    continue;
                }
                if (!(is.getType().equals(mat))){
                    continue;
                }
                ItemMeta im = is.getItemMeta();
                if ((rpgWarp.getItemNeedsName() || rpgWarp.getNeedsLore()) && im == null){
                    continue;
                }
                if (rpgWarp.getNeedsLore() && im.getLore() == null){
                    continue;
                }
                if (rpgWarp.getItemNeedsName() && im.getDisplayName() == null){
                    continue;
                }
                if (rpgWarp.getItemNeedsName() || rpgWarp.getNeedsLore()){
                    if (rpgWarp.getNeedsLore()){
                        Boolean lorePresent = false;
                        for (String lore : rpgWarp.getLoreNeeded()){
                             for (String lores : im.getLore()){
                                 if(lore.equalsIgnoreCase(lores)){
                                     lorePresent = true;
                                 }
                             }
                        }
                        if (lorePresent == false){
                            continue;
                        }
                    }
                    if (rpgWarp.getItemNeedsName()){
                        Boolean namePresent = false;
                        for (String iName : rpgWarp.getItemNames()){
                            if (iName.equalsIgnoreCase(im.getDisplayName())){
                               namePresent = true;
                            }
                        }
                        if (namePresent == false){
                            continue;
                        }
                    }
                }
                if (rpgWarp.getItemConsumed()){
                    Integer a = is.getAmount();
                    if (a <= 1){
                        p.getInventory().remove(is);
                    }
                    is.setAmount(a-1);
                }
                useWarp = true;
                return useWarp;
            }
        }
        return useWarp;
    }
}