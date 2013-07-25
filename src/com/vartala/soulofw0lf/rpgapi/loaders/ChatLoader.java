package com.vartala.soulofw0lf.rpgapi.loaders;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.chatapi.*;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 7/8/13
 * Time: 5:59 PM
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
public class ChatLoader {
    RpgAPI rpg;
    public ChatLoader(RpgAPI Rpg){
        this.rpg = Rpg;
    this.rpg.chatListener = new ChatListener(this.rpg);
        YamlConfiguration chatLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Locale/RpgChat.yml"));
        YamlConfiguration chatConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/RpgChat.yml"));
        YamlConfiguration cityLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Locale/RpgCities.yml"));
        YamlConfiguration regionLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Locale/RpgRegions.yml"));
    if (chatLocaleConfig.get("Translations") == null){
        chatLocaleConfig.set("Translations.Chat Left Click", "&2Left click to join this channel or switch it's color");
        chatLocaleConfig.set("Translations.Chat Right Click", "&4Right click to leave this channel");
        chatLocaleConfig.set("Translations.Chat Shift Click", "&9Shift click to set this as your active channel");
        chatLocaleConfig.set("Translations.Chat Inventory Name", "&9Chat Channels");
        chatLocaleConfig.set("Translations.Chat No Create Perms", "&9You do not have permission to create a chat!");
        chatLocaleConfig.set("Translations.Chat Wrong Create Command", "&9Wrong command usage. Please use &2/chat create <Channel Name> <Channel Nick>");
        chatLocaleConfig.set("Translations.Chat Wrong Create Private Command", "&9Wrong command usage. Please use &2/chat create <Channel Name> <Channel Nick> <password>");
        chatLocaleConfig.set("Translations.Chat Channel Exists", "&9A channel named @c already exists!");
        chatLocaleConfig.set("Translations.Chat Nick Exists", "&9A channel nicknamed @n already exists!");
        chatLocaleConfig.set("Translations.Chat Stub", "&f[&4Rpg Chat&f]");
        chatLocaleConfig.set("Translations.Chat City Behavior", "&2City Chat");
        chatLocaleConfig.set("Translations.Chat Region Behavior", "&2Region Chat");
        chatLocaleConfig.set("Translations.Chat Guild Behavior", "&2Guild Chat");
        chatLocaleConfig.set("Translations.Chat Language Behavior", "&2Language In Chat");
        chatLocaleConfig.set("Translations.Chat Party Behavior", "&2Party Chat");
        chatLocaleConfig.set("Translations.Chat World Behavior", "&2World Chat");
        chatLocaleConfig.set("Translations.Chat Distance Behavior", "&2Distance Chat");
        chatLocaleConfig.set("Translations.Chat Create Left Click", "&2Left click to turn on this behavior");
        chatLocaleConfig.set("Translations.Chat Create Right Click", "&2Right click to turn off this behavior");
        chatLocaleConfig.set("Translations.Chat Create Shift Left Click", "&2Shift Left click to increase distance");
        chatLocaleConfig.set("Translations.Chat Create Shift Right Click", "&2Shift Right click to reduce distance");
        chatLocaleConfig.set("Translations.Chat Help", "&2Possible chat commands, @h, @n, @p, @r, @c, @i, @a, @k, @m, @v, @b, @u, @d, @l, @w, @o, @t, @s, @x");
        chatLocaleConfig.set("Commands.Chat Command", "chat");
        chatLocaleConfig.set("Sub Commands.Chat Help", "help");
        chatLocaleConfig.set("Sub Commands.Chat New", "create");
        chatLocaleConfig.set("Sub Commands.Create Private", "createp");
        chatLocaleConfig.set("Sub Commands.Create Region", "region");
        chatLocaleConfig.set("Sub Commands.Create City", "city");
        chatLocaleConfig.set("Sub Commands.Chat Invite", "invite");
        chatLocaleConfig.set("Sub Commands.Chat Accept", "accept");
        chatLocaleConfig.set("Sub Commands.Chat Kick", "kick");
        chatLocaleConfig.set("Sub Commands.Chat Mute", "mute");
        chatLocaleConfig.set("Sub Commands.Chat Voice", "unmute");
        chatLocaleConfig.set("Sub Commands.Chat Ban", "ban");
        chatLocaleConfig.set("Sub Commands.Chat Unban", "unban");
        chatLocaleConfig.set("Sub Commands.Chat Delete", "delete");
        chatLocaleConfig.set("Sub Commands.Chat Channel List", "list");
        chatLocaleConfig.set("Sub Commands.Chat Who", "who");
        chatLocaleConfig.set("Sub Commands.Chat Supervisor", "mod");
        chatLocaleConfig.set("Sub Commands.Chat XSupervisor", "unmod");
        chatLocaleConfig.set("Sub Commands.Chat Owner", "promote");
        chatLocaleConfig.set("Sub Commands.Chat Take", "claim");
        chatLocaleConfig.set("Permissions.Create Chat", "chat.create");
        chatLocaleConfig.set("Permissions.Create Private Chat", "chat.private");
        chatLocaleConfig.set("Permissions.Ban Immune", "chat.noban");
        chatLocaleConfig.set("Permissions.Kick Immune", "chat.noKick");
        chatLocaleConfig.set("Permissions.Mute Immune", "chat.noMute");
        chatLocaleConfig.set("Permissions.Create City", "chat.city");
        chatLocaleConfig.set("Permissions.Create Chat", "chat.create");
    }

    if (chatConfig.get("Titles and Names") == null) {
        chatConfig.set("Titles and Names", "&7[@World]&2[@Guild]&3[@Channel]&r[@Prefix @Pname @Suffix&F]");
        chatConfig.set("Default Active Channel", "General");
        List<String> channels = new ArrayList<>();
        channels.add("Whisper");
        channels.add("Local");
        channels.add("Shout");
        channels.add("World");
        channels.add("General");
        channels.add("Party");
        channels.add("Guild");
        channels.add("Region");
        channels.add("Trade");
        chatConfig.set("Default Channels", channels);
        chatConfig.set("No Leave Channels", channels);
        //whisper Chat
        YamlConfiguration whisper = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/Whisper.yml"));
        whisper.set("Channel.Whisper.Name", "Whisper");
        whisper.set("Channel.Whisper.Nick Name", "W");
        whisper.set("Channel.Whisper.Enabled", true);
        whisper.set("Channel.Whisper.Spy Enabled", true);
        whisper.set("Channel.Whisper.Use Basic", true);
        whisper.set("Channel.Whisper.Use Language", true);
        whisper.set("Channel.Whisper.Use Distance", true);
        whisper.set("Channel.Whisper.Distance", 5);
        whisper.set("Channel.Whisper.Use Party", false);
        whisper.set("Channel.Whisper.Use Guild", false);
        whisper.set("Channel.Whisper.Use Region", false);
        whisper.set("Channel.Whisper.Use City", false);
        whisper.set("Channel.Whisper.Use World", false);

        //local chat
        YamlConfiguration local = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/Local.yml"));
        local.set("Channel.Local.Name", "Local");
        local.set("Channel.Local.Nick Name", "L");
        local.set("Channel.Local.Enabled", true);
        local.set("Channel.Local.Spy Enabled", true);
        local.set("Channel.Local.Use Basic", true);
        local.set("Channel.Local.Use Language", true);
        local.set("Channel.Local.Use Distance", true);
        local.set("Channel.Local.Distance", 50);
        local.set("Channel.Local.Use Party", false);
        local.set("Channel.Local.Use Guild", false);
        local.set("Channel.Local.Use Region", false);
        local.set("Channel.Local.Use City", false);
        local.set("Channel.Local.Use World", false);

        //shout Chat
        YamlConfiguration shout = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/Shout.yml"));
        shout.set("Channel.Shout.Name", "Shout");
        shout.set("Channel.Shout.Nick Name", "Yell");
        shout.set("Channel.Shout.Enabled", true);
        shout.set("Channel.Shout.Spy Enabled", true);
        shout.set("Channel.Shout.Use Basic", true);
        shout.set("Channel.Shout.Use Language", true);
        shout.set("Channel.Shout.Use Distance", true);
        shout.set("Channel.Shout.Distance", 150);
        shout.set("Channel.Shout.Use Party", false);
        shout.set("Channel.Shout.Use Guild", false);
        shout.set("Channel.Shout.Use Region", false);
        shout.set("Channel.Shout.Use City", false);
        shout.set("Channel.Shout.Use World", false);

        //General chat
        YamlConfiguration general = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/General.yml"));
        general.set("Channel.General.Name", "General");
        general.set("Channel.General.Nick Name", "Gen");
        general.set("Channel.General.Enabled", true);
        general.set("Channel.General.Spy Enabled", true);
        general.set("Channel.General.Use Basic", true);
        general.set("Channel.General.Use Language", true);
        general.set("Channel.General.Use Distance", false);
        general.set("Channel.General.Use Party", false);
        general.set("Channel.General.Use Guild", false);
        general.set("Channel.General.Use Region", false);
        general.set("Channel.General.Use City", false);
        general.set("Channel.General.Use World", false);

        //party Chat
        YamlConfiguration party = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/Party.yml"));
        party.set("Channel.Party.Name", "Party");
        party.set("Channel.Party.Nick Name", "Pc");
        party.set("Channel.Party.Enabled", true);
        party.set("Channel.Party.Spy Enabled", true);
        party.set("Channel.Party.Use Basic", true);
        party.set("Channel.Party.Use Language", true);
        party.set("Channel.Party.Use Distance", false);
        party.set("Channel.Party.Use Party", true);
        party.set("Channel.Party.Use Guild", false);
        party.set("Channel.Party.Use Region", false);
        party.set("Channel.Party.Use City", false);
        party.set("Channel.Party.Use World", false);

        //guild chat
        YamlConfiguration guild = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/Guild.yml"));
        guild.set("Channel.Guild.Name", "Guild");
        guild.set("Channel.Guild.Nick Name", "G");
        guild.set("Channel.Guild.Enabled", true);
        guild.set("Channel.Guild.Spy Enabled", true);
        guild.set("Channel.Guild.Use Basic", true);
        guild.set("Channel.Guild.Use Language", true);
        guild.set("Channel.Guild.Use Distance", false);
        guild.set("Channel.Guild.Use Party", false);
        guild.set("Channel.Guild.Use Guild", true);
        guild.set("Channel.Guild.Use Region", false);
        guild.set("Channel.Guild.Use City", false);
        guild.set("Channel.Guild.Use World", false);

        //world chat
        YamlConfiguration world = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/World.yml"));
        world.set("Channel.World.Name", "World");
        world.set("Channel.World.Nick Name", "world");
        world.set("Channel.World.Enabled", true);
        world.set("Channel.World.Spy Enabled", true);
        world.set("Channel.World.Use Basic", true);
        world.set("Channel.World.Use Language", true);
        world.set("Channel.World.Use Distance", false);
        world.set("Channel.World.Use Party", false);
        world.set("Channel.World.Use Guild", false);
        world.set("Channel.World.Use Region", false);
        world.set("Channel.World.Use City", false);
        world.set("Channel.World.Use World", true);

        //region Chat
        YamlConfiguration region = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/Region.yml"));
        region.set("Channel.Region.Name", "Region");
        region.set("Channel.Region.Nick Name", "Reg");
        region.set("Channel.Region.Enabled", true);
        region.set("Channel.Region.Spy Enabled", true);
        region.set("Channel.Region.Use Basic", true);
        region.set("Channel.Region.Use Language", true);
        region.set("Channel.Region.Use Distance", false);
        region.set("Channel.Region.Use Party", false);
        region.set("Channel.Region.Use Guild", false);
        region.set("Channel.Region.Use Region", true);
        region.set("Channel.Region.Use City", false);
        region.set("Channel.Region.Use World", true);

        //trade chat
        YamlConfiguration trade = YamlConfiguration.loadConfiguration(new File("plugins/RpgChat/Channels/Trade.yml"));
        trade.set("Channel.Trade.Name", "Trade");
        trade.set("Channel.Trade.Nick Name", "Tr");
        trade.set("Channel.Trade.Enabled", true);
        trade.set("Channel.Trade.Spy Enabled", true);
        trade.set("Channel.Trade.Use Basic", true);
        trade.set("Channel.Trade.Use Language", true);
        trade.set("Channel.Trade.Use Distance", false);
        trade.set("Channel.Trade.Use Party", false);
        trade.set("Channel.Trade.Use Guild", false);
        trade.set("Channel.Trade.Use Region", false);
        trade.set("Channel.Trade.Use City", true);
        trade.set("Channel.Trade.Use World", false);
        try {
            whisper.save(new File("plugins/RpgChat/Channels/Whisper.yml"));
            local.save(new File("plugins/RpgChat/Channels/Local.yml"));
            shout.save(new File("plugins/RpgChat/Channels/Shout.yml"));
            general.save(new File("plugins/RpgChat/Channels/General.yml"));
            party.save(new File("plugins/RpgChat/Channels/Party.yml"));
            guild.save(new File("plugins/RpgChat/Channels/Guild.yml"));
            world.save(new File("plugins/RpgChat/Channels/World.yml"));
            region.save(new File("plugins/RpgChat/Channels/Region.yml"));
            trade.save(new File("plugins/RpgChat/Channels/Trade.yml"));
        } catch (IOException e){
            
        }
        }
        try {

            chatLocaleConfig.save(new File("plugins/RpgChat/Locale/RpgChat.yml"));
            chatConfig.save(new File("plugins/RpgChat/RpgChat.yml"));
            cityLocaleConfig.save(new File("plugins/RpgChat/Locale/RpgCities.yml"));
            regionLocaleConfig.save(new File("plugins/RpgChat/Locale/RpgRegions.yml"));
        } catch (IOException e) {
        }
        //after file is saved
        LoadCities.FromFile();
        LoadRegions.FromFile();
        RpgAPI.nameDisplays = chatConfig.getString("Titles and Names");
        for (String locale : chatLocaleConfig.getConfigurationSection("Translations").getKeys(false)){
            RpgAPI.localeSettings.put(locale, chatLocaleConfig.getString("Translations." + locale));
        }
        for (String command : chatLocaleConfig.getConfigurationSection("Commands").getKeys(false)){
            RpgAPI.commandSettings.put(command, chatLocaleConfig.getString("Commands." + command));
            RpgAPI.commands.add(chatLocaleConfig.getString("Commands." + command));
        }
        for (String command : chatLocaleConfig.getConfigurationSection("Sub Commands").getKeys(false)){
            RpgAPI.commandSettings.put(command, chatLocaleConfig.getString("Sub Commands." + command));
        }
        for (String perm : chatLocaleConfig.getConfigurationSection("Permissions").getKeys(false)){
            RpgAPI.permissionSettings.put(perm, chatLocaleConfig.getString("Permissions." + perm));
        }
        File f = new File("plugins/RpgChat/Channels");
        File[] files = f.listFiles();
        if (files != null) {
            for (File channels : files) {
                YamlConfiguration chan = YamlConfiguration.loadConfiguration(channels);
                String channel = channels.getName();
            if (chan.getBoolean("Channel." + channel + ".Enabled")) {

                ChatClass chatClass = new ChatClass();
                chatClass.setEnabled(true);
                chatClass.setChannelName(channel);
                chatClass.setChannelNick(chan.getString("Channel." + channel + ".Nick Name"));
                RpgAPI.chatRealNames.put(chan.getString("Channel." + channel + ".Nick Name"), channel);
                RpgAPI.commands.add(chatClass.getChannelNick());
                chatClass.setChatSpy(chan.getBoolean("Channel." + channel + ".Spy Enabled"));
                if (chan.getBoolean("Channel." + channel + ".Use Basic")) {
                    chatClass.addBehavior(new BasicChatBehavior());
                }
                if (chan.getBoolean("Channel." + channel + ".Use Language")) {
                    chatClass.setUseLanguage(true);
                    chatClass.addBehavior(new LanguageBehavior());
                }
                if (chan.getBoolean("Channel." + channel + ".Use Distance")) {
                    chatClass.setUseDistance(true);
                    chatClass.setDistance(chan.getInt("Channel." + channel + ".Distance"));
                    chatClass.addBehavior(new DistanceChatBehavior());
                    RpgAPI.chatDistances.put(channel, chan.getInt("Channel." + channel + ".Distance"));
                }
                if (chan.getBoolean("Channel." + channel + ".Use Party")) {
                    chatClass.setUseParty(true);
                    chatClass.addBehavior(new PartyChatBehavior());
                }
                if (chan.getBoolean("Channel." + channel + ".Use Guild")) {
                    chatClass.setUseGuild(true);
                    chatClass.addBehavior(new GuildChatBehavior());
                }
                if (chan.getBoolean("Channel." + channel + ".Use Region")) {
                    chatClass.setUseRegion(true);
                    chatClass.addBehavior(new RegionChatBehavior());
                }
                if (chan.getBoolean("Channel." + channel + ".Use City")) {
                    chatClass.setUseCity(true);
                    chatClass.addBehavior(new CityChatBehavior());
                }
                if (chan.getBoolean("Channel." + channel + ".Use World")) {
                    chatClass.setUseWorld(true);
                    chatClass.addBehavior(new WorldChatBehavior());
                }
                RpgAPI.chatClasses.add(chatClass);
            }
            }
        }
    }
}
