package com.vartala.soulofw0lf.rpgapi.chatapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by: soulof
 * Date: 6/10/13
 * Time: 1:54 AM
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
public class ChatListener implements Listener {
    RpgAPI Rpgapi;
    public ChatListener (RpgAPI rpgapi){
        this.Rpgapi = rpgapi;
        Bukkit.getPluginManager().registerEvents(this, this.Rpgapi);
    }
    //
    @EventHandler(priority = EventPriority.HIGHEST)
    public void channelChat(AsyncPlayerChatEvent event){
        Player p = event.getPlayer();
        String m = event.getMessage();
        event.setCancelled(true);
        for (Player r : event.getRecipients()){
            r.sendMessage(ChatProcessor.TitleString(RpgAPI.nameDisplays, p.getName()) + ChatColors.ChatString(m));
        }
       /* if (!(RpgAPI.chatOn)){
            return;
        }
        String senderName = event.getPlayer().getName();
        RpgPlayer sendPlayer = this.Rpgapi.rpgPlayers.get(this.Rpgapi.activeNicks.get(senderName));
        if (sendPlayer.getActiveChannel().isEmpty()){
            return;
        }
        String activeChat = sendPlayer.getActiveChannel();
        ChatClass thisChat = null;
        if (!(RpgAPI.chatClasses.contains(activeChat))){
            return;
        }
        String language = "";
        if (sendPlayer.getActiveLanguage().isEmpty()){
            language = "Common";
        } else {
            language = sendPlayer.getActiveLanguage();
        }
        for (ChatClass cl : RpgAPI.chatClasses){
         if(cl.getChannelName().equalsIgnoreCase(activeChat)){
            thisChat = cl;
         }
        }
        Boolean spyChat = thisChat.isChatSpy();
        event.setCancelled(true);
        for (Player p : event.getRecipients()){
             RpgPlayer receivePlayer = this.Rpgapi.rpgPlayers.get(this.Rpgapi.activeNicks.get(p.getName()));
             String receiveName = this.Rpgapi.activeNicks.get(p.getName());
             for (ChatBehavior behavior : thisChat.getChannelBehaviors()){
                 behavior.chatChannel(activeChat, receiveName, language, event.getMessage(), spyChat);
             }
        }
        */
        }

}
