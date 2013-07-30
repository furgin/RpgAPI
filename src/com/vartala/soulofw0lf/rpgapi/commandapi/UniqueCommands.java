package com.vartala.soulofw0lf.rpgapi.commandapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.chatapi.*;
import com.vartala.soulofw0lf.rpgapi.diseaseapi.DiseaseCommand;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntityType;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.InteractBehavior;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.Mind;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals.DesireGoToBed;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals.DesireLookAtNearest;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals.DesireMoveThroughVillage;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.thinking.goals.DesireWanderAroundArea;
import com.vartala.soulofw0lf.rpgapi.loaders.VectorLoader;
import com.vartala.soulofw0lf.rpgapi.particleapi.ParticleEffect;
import com.vartala.soulofw0lf.rpgapi.permissionsapi.PermHandler;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayerBuilder;
import com.vartala.soulofw0lf.rpgapi.speedapi.SpeedHandler;
import com.vartala.soulofw0lf.rpgapi.tradeapi.TradeCommandProcessor;
import com.vartala.soulofw0lf.rpgapi.warpsapi.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;

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
    /**
     *
     * @param p
     * @param command
     */
    public static void BaseCommandHandler(Player p, String[] command) {
        command[0] = command[0].replace("/", "").toLowerCase().trim();

        //Pass the command info to the warp command handler
        if (RpgAPI.warpsOn){if (WarpCommands.handler(p, command)){return;}}
        //Pass the command info to the disease command handler
        if (RpgAPI.diseasesOn){if (DiseaseCommand.handler(p, command)){return;}}
        //pass the command info to the chat command handler
        if (RpgAPI.chatOn){if (ChatCommands.ChatHandler(p, command)){return;}}
        //pass the command info to the permission handler
        if (RpgAPI.permsOn){if (PermHandler.permCommands(p, command)){return;}}
        // Pass the command info to the trading processor
        if (RpgAPI.tradeOn) TradeCommandProcessor.process(p, command);
        //pass the command info to the vector block handler
        if (RpgAPI.vectorOn){if (VectorLoader.vectorCommands(command, p)){return;}}
        if (command[0].equalsIgnoreCase("zomb")){
            RemoteEntity entity = RpgAPI.entityManager.createEntity(RemoteEntityType.Zombie, p.getLocation(), false);
            //entity.getMind().addTargetingDesire(new DesireGoToBed(50), 30);
            entity.getMind().addMovementDesire(new DesireWanderAroundArea(50, p.getLocation()), 10);
            entity.getMind().addTargetingDesire(new DesireLookAtNearest(Player.class, 5f), 20);
            entity.setSpeed(1.0);
            entity.getMind().addBehaviour(new InteractBehavior(entity) {
                @Override
                public void onInteract(Player inPlayer) {
                    inPlayer.sendMessage("Sup yo!");
                }
            });
            RpgAPI.entityManager.saveEntities();
            return;
        }


        if (command[0].equalsIgnoreCase("effect"))  {

            final Player pl = p;
            final String[] commands = command;
            new BukkitRunnable(){
                Integer i = 30;
                @Override

                public void run(){
                    if (i <= 0){
                        cancel();
                    }
                    Location loc = pl.getLocation();
                    loc.setY(pl.getLocation().getY() +1);
                ParticleEffect.fromId(Integer.parseInt(commands[1])).play(pl, loc, 0f, 0f, 0f, Float.parseFloat(commands[2]), Integer.parseInt(commands[3]));
                    i--;
                }
            }.runTaskTimer(RpgAPI.getInstance(), 20, 5);
        }



        if (command[0].equalsIgnoreCase("nick")) {
            String name = p.getName();
            String newName = command[1];
            String oldName = RpgAPI.activeNicks.get(name);
            RpgAPI.activeNicks.remove(name);
            RpgAPI.activeNicks.put(name, newName);
            RpgPlayer rp = RpgPlayerBuilder.RpgBuilder(newName);
            RpgAPI.rpgPlayers.remove(oldName);
            RpgAPI.rpgPlayers.put(newName, rp);
            SpeedHandler.SetWalkSpeed(rp, name);
            SpeedHandler.SetFlySpeed(rp, name);
        }

        if (command[0].equalsIgnoreCase("RpgHelp")) {

            p.sendMessage("Available commands are:");

        }




        /*
        *Leave this section below all other command codes!!!!! we don't want chat channels overwritting other commands!!!
         */
        Boolean subChat = false;

        for (String chatNames : RpgAPI.chatRealNames.keySet()) {
            if (chatNames == null) {
                continue;
            }
            if (chatNames.equalsIgnoreCase(command[0])) {
                command[0] = chatNames;
                subChat = true;
            }
        }

        if (subChat) {

            String activeChat = RpgAPI.chatRealNames.get(command[0]);

            ChatClass cC = new ChatClass();
            for (ChatClass chatClass : RpgAPI.chatClasses) {
                if (activeChat.equalsIgnoreCase(chatClass.getChannelName())) {
                    cC = chatClass;
                }
            }
            String senderName = p.getName();
            RpgPlayer sendPlayer = RpgAPI.rpgPlayers.get(RpgAPI.activeNicks.get(senderName));

            String language = "";
            if (sendPlayer.getActiveLanguage().isEmpty()) {
                language = "Common";
                sendPlayer.setActiveLanguage("Common");
            } else {
                language = sendPlayer.getActiveLanguage();
            }
            if (cC.getMutedPlayers().contains(senderName)) {
                Bukkit.getPlayer(senderName).sendMessage("You are muted in this chat.");
                return;
            }
            if (cC.getBannedPlayers().contains(senderName)) {
                Bukkit.getPlayer(senderName).sendMessage("You are banned from this chat.");
                return;
            }
            Boolean spyChat = cC.isChatSpy();
            String oldChat = sendPlayer.getActiveChannel();
            sendPlayer.setActiveChannel(activeChat);
            for (Player pl : Bukkit.getOnlinePlayers()) {
                String receiveName = pl.getName();
                StringBuilder buffer = new StringBuilder();
                for (int i = 1; i < command.length; i++) {
                    buffer.append(' ').append(command[i]);
                }
                String s = buffer.toString();
                Boolean canSee = true;
                for (ChatBehavior behavior : cC.getChannelBehaviors()) {
                    canSee = behavior.chatChannel(activeChat, receiveName, senderName, language, s, spyChat);
                }
                if (!canSee) {
                    continue;
                }
                pl.sendMessage(ChatProcessor.TitleString(RpgAPI.nameDisplays, RpgAPI.activeNicks.get(senderName), receiveName) + s);
            }

            sendPlayer.setActiveChannel(oldChat);
        }
    }



}