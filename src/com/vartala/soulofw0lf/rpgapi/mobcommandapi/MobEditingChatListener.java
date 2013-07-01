package com.vartala.soulofw0lf.rpgapi.mobcommandapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import de.kumpelblase2.remoteentities.api.RemoteEntity;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by: tennyson.holloway
 * Date: 7/1/13
 * Time: 10:51 AM
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
public class MobEditingChatListener implements Listener {
    public MobEditingChatListener(RpgAPI rpgAPI) {
        Bukkit.getPluginManager().registerEvents(this, rpgAPI);
    }

    /**
     * Chat listener for mob editing. Only executed if chatLock isn't empty.
     *
     * @param event
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent event) {
        RpgPlayer rp = RpgAPI.rpgPlayers.get(RpgAPI.activeNicks.get(event.getPlayer().getName()));
        if (!rp.chatLock.equals("")) {
            Player p = event.getPlayer();
            String[] chatLockArr = rp.chatLock.split(":");
            switch (chatLockArr[0].toLowerCase()) {
                case "setname":
                    RemoteEntity rm = RpgAPI.entityManager.getRemoteEntityByID(Integer.parseInt(chatLockArr[1]));
                    rm.getBukkitEntity().setCustomName(event.getMessage());
                    rm.getBukkitEntity().setCustomNameVisible(true);
                    p.sendMessage(ChatColor.YELLOW + "Set mob " + chatLockArr[1] + " name to " + event.getMessage());
                    rp.chatLock = "";
                    event.setCancelled(true);
                    break;
            }

        }
    }
}

