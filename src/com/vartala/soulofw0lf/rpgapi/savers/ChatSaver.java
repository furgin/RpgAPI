package com.vartala.soulofw0lf.rpgapi.savers;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.chatapi.ChatBehavior;
import com.vartala.soulofw0lf.rpgapi.chatapi.ChatClass;
import com.vartala.soulofw0lf.rpgapi.chatapi.LanguageBehavior;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

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

         for (ChatClass ch : RpgAPI.chatClasses){
             String name = ch.getChannelName();
             YamlConfiguration chatConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/"+name+".yml"));
             chatConfig.set("Channel."+name+".Name", name);
             chatConfig.set("Channel."+name+".Nick Name", ch.getChannelNick());
             chatConfig.set("Channel."+name+".Enabled", ch.isEnabled());
             chatConfig.set("Channel."+name+".Spy Enabled", ch.isChatSpy());
             chatConfig.set("Channel."+name+".Use Basic", ch.isUseBasic());
             chatConfig.set("Channel."+name+".Use Language", ch.isUseLanguage());
             chatConfig.set("Channel."+name+".Use Distance", ch.isUseDistance());
             chatConfig.set("Channel."+name+".Distance", ch.getDistance());
             chatConfig.set("Channel."+name+".Use Party", ch.isUseParty());
             chatConfig.set("Channel."+name+".Use Guild", ch.isUseGuild());
             chatConfig.set("Channel."+name+".Use Region", ch.isUseRegion());
             chatConfig.set("Channel."+name+".Use City", ch.isUseCity());
             chatConfig.set("Channel."+name+".Use World", ch.isUseWorld());
             try {
                 chatConfig.save(new File("plugins/RpgChat/Channels/"+name+".yml"));
             } catch (IOException e){

             }
         }
    }
}
