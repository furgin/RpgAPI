package com.vartala.soulofw0lf.rpgapi.mobcommandapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import de.kumpelblase2.remoteentities.api.RemoteEntity;
import de.kumpelblase2.remoteentities.api.thinking.goals.DesireFollowSpecific;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created by: tennyson.holloway
 * Date: 7/1/13
 * Time: 10:08 AM
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
public class MobCommandProcessor {
    /**
     * Processes command. To have user input, use rp.chatLock = "hookName:mobID" and see MobEditingChatListener
     *
     * @param cmd   [commandName, clicktype, sender (console, player), (args)]
     * @param mobID the id of the RemoteEntity mob
     */
   /* public static void process(String[] cmd, int mobID, Player p) {
        RemoteEntity rm = RpgAPI.entityManager.getRemoteEntityByID(mobID);
        RpgPlayer rp = RpgAPI.rpgPlayers.get(RpgAPI.activeNicks.get(p.getName()));
        switch (cmd[0].toLowerCase()) {
            case "followme":
                rm.getMind().addMovementDesire(new DesireFollowSpecific(rm, p, 1F, 2F), rm.getMind().getHighestMovementPriority() + 1);
                break;
            case "unfollowme":
                rm.getMind().getMovementDesire(DesireFollowSpecific.class).stopExecuting();
                break;
            case "setname":
                p.sendMessage(ChatColor.YELLOW + "Enter the name of the NPC:");
                rp.chatLock = "setname:" + mobID;
                break;
        }
    }*/
}
