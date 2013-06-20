package com.vartala.soulofw0lf.rpgapi.listenersapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

/**
 * Created by: soulofw0lf
 * Date: 6/20/13
 * Time: 6:29 PM
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
public class PoisonListener implements Listener {
    RpgAPI Rpgapi;
    public PoisonListener(RpgAPI RpgApi){
        this.Rpgapi = RpgApi;
    }
    @EventHandler
    public void playerPoisonGround(PlayerMoveEvent event){
        Player p = event.getPlayer();
        if (p.getGameMode().equals(GameMode.getByValue(1))){
            return;
        }
        RpgPlayer rp =  this.Rpgapi.rpgPlayers.get(this.Rpgapi.activeNicks.get(p.getName()));
        if (rp.isPoisonProof()){
            return;
        }
        if (p.getLocation().getY() >= 31){
            return;
        }
        if (!(p.getWorld().getName().equalsIgnoreCase("Kardegah"))){
            return;
        }
        Location poisonLoc = new Location(Bukkit.getWorld("Kardegah"), 2485, 0, -2411);
        if (poisonLoc.distance(p.getLocation()) <= 100){
            p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 15, 6), true);
        }
    }
}
