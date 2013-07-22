package com.vartala.soulofw0lf.rpgapi.savers;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.chatapi.ChatBehavior;
import com.vartala.soulofw0lf.rpgapi.chatapi.ChatClass;
import com.vartala.soulofw0lf.rpgapi.chatapi.LanguageBehavior;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

/**
 * Created by: soulofw0lf
 * Date: 7/21/13
 * Time: 11:17 AM
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
public class ChatSaver {
    public ChatSaver(){
    RpgAPI.chatConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat.yml"));
         for (ChatClass ch : RpgAPI.chatClasses){
             String name = ch.getChannelName();
             RpgAPI.chatConfig.set("Chats."+name+".Name", name);
             RpgAPI.chatConfig.set("Chats."+name+".Nick Name", ch.getChannelNick());
             RpgAPI.chatConfig.set("Chats."+name+".Enabled", ch.isEnabled());
             RpgAPI.chatConfig.set("Chats."+name+".Spy Enabled", ch.isChatSpy());
             RpgAPI.chatConfig.set("Chats."+name+".Use Basic", ch.isUseBasic());
             RpgAPI.chatConfig.set("Chats."+name+".Use Language", ch.isUseLanguage());
             RpgAPI.chatConfig.set("Chats."+name+".Use Distance", ch.isUseDistance());
             RpgAPI.chatConfig.set("Chats."+name+".Distance", ch.getDistance());
             RpgAPI.chatConfig.set("Chats."+name+".Use Party", ch.isUseParty());
             RpgAPI.chatConfig.set("Chats."+name+".Use Guild", ch.isUseGuild());
             RpgAPI.chatConfig.set("Chats."+name+".Use Region", ch.isUseRegion());
             RpgAPI.chatConfig.set("Chats."+name+".Use City", ch.isUseCity());
             RpgAPI.chatConfig.set("Chats."+name+".Use World", ch.isUseWorld());
         }
    }
}
