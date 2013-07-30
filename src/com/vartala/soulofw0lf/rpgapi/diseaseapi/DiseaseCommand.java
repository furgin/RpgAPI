package com.vartala.soulofw0lf.rpgapi.diseaseapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.Misc;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by: soulofw0lf
 * Date: 7/30/13
 * Time: 12:52 AM
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
public class DiseaseCommand {
    public static boolean handler(Player p, String[] command) {
        if (command[0].equalsIgnoreCase(RpgAPI.commandSettings.get("Add Disease"))){
            if (command.length <= 2){
                p.sendMessage("use /disadd diseasename Rpgplayername");
                return true;
            }
            String disName = command[1].replace("_", " ");
            if (Misc.getDiseaseByName(disName) == null){
                p.sendMessage("That disease does not exist!");
                return true;
            }
            RpgPlayer rp = RpgAPI.rpgPlayers.get(command[2]);
            if (rp == null){
                p.sendMessage("Player not found!");
            }
            if (Bukkit.getPlayer(rp.getRealName()) == null){
                p.sendMessage("Player not found!");
            }
            Disease dis = Misc.getDiseaseByName(disName);
            Player pl = Bukkit.getPlayer(rp.getRealName());
            DiseaseListeners.applyDisease(pl, rp, dis);
            p.sendMessage("Disease " + dis.getDiseaseName() + " applied to " + rp.getName() + ".");
            return true;
        }
        return false;
    }
}
