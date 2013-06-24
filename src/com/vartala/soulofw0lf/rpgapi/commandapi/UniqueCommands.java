package com.vartala.soulofw0lf.rpgapi.commandapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.enumapi.PlayerStat;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayerBuilder;
import com.vartala.soulofw0lf.rpgapi.speedapi.SpeedHandler;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
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
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

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
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Test Command"))){
            String activeNick = RpgAPI.activeNicks.get(p.getName());
            RpgPlayer rp = RpgAPI.rpgPlayers.get(activeNick);
            Map<PlayerStat, Integer> statMap = rp.getStats();
            Integer speed = statMap.get(PlayerStat.SPEED_LAND);
            speed += 5;
            statMap.put(PlayerStat.SPEED_LAND, speed);
            statMap.put(PlayerStat.SPEED_FLY, speed);
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
            Map<PlayerStat, Integer> statMap = rp.getStats();
            statMap.put(PlayerStat.SPEED_LAND, 0);
            statMap.put(PlayerStat.SPEED_FLY, 0);
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
}
