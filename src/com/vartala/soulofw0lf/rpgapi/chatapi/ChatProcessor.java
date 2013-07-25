package com.vartala.soulofw0lf.rpgapi.chatapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.regex.Pattern;


/**
 * Created by: soulofw0lf
 * Date: 6/26/13
 * Time: 7:27 PM
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
public class ChatProcessor {
    /**
     *
     * @param s
     * @param name
     * @param rName
     * @return
     */
    public static String TitleString(String s, String name, String rName) {
        Player p = Bukkit.getPlayer(name);
        RpgPlayer rp = RpgAPI.rpgPlayers.get(RpgAPI.activeNicks.get(name));
        RpgPlayer rp2 = RpgAPI.rpgPlayers.get(RpgAPI.activeNicks.get(rName));
        String q = ChatColors.ChatString(s);
        if (rp2.isShowingWorldNames()) {
            q = q.replaceAll("@World", p.getWorld().getName());
        } else {
            q = q.replaceAll("@World", "");
        }
        if (RpgAPI.guildsOn) {
            if (rp.isInGuild() && rp2.isShowingGuildTags()) {
                q = q.replaceAll("@Guild", RpgAPI.guilds.get(rp.getGuild()).getDisplayName());
            } else {
                q = q.replace("@Guild", "");
            }
        }

        if (RpgAPI.achievementsOn) {
            if (!(rp.getActivePrefix().equalsIgnoreCase("None")) && rp2.isShowingAchieveTitles()) {
                q = q.replaceAll("@Prefix", rp.getActivePrefix());
            } else {
                q = q.replaceAll("@Prefix", "");
            }
            if (!(rp.getActiveSuffix().equalsIgnoreCase("None")) && rp2.isShowingAchieveTitles()) {
                q = q.replaceAll("@Suffix", rp.getActiveSuffix());
            } else {
                q = q.replaceAll(" @Suffix", "");
            }
        }
        q = q.replaceAll("@Pname", RpgAPI.playerColors.get(name) + RpgAPI.activeNicks.get(name) + "&F");
        if (RpgAPI.chatOn) {
            if (rp2.isShowingChannelNames()) {
                q = q.replaceAll("@Channel", rp.getActiveChannel());
            } else {
                q = q.replaceAll("@Channel", "");
            }
            if (RpgAPI.languagesOn && rp2.isShowingLanguageNames()) {
                q = q.replaceAll("@Language", rp.getActiveLanguage());
            } else {
                q = q.replaceAll("@Language", "");
            }
        }
        String r = ChatColors.ChatString(q);
        String m = r.replace("[]", "");
        return m + ": ";
    }
}
