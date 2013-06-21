package com.vartala.soulofw0lf.rpgapi.poisonapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 6/20/13
 * Time: 11:31 PM
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
public class PoisonTimeChecker {
    RpgAPI Rpga;
    public PoisonTimeChecker(RpgAPI rpga){
        this.Rpga = rpga;
    }
    public static void PoisonRegionTimer(){
        final Map<String, RpgPoison> poisonRegions = RpgAPI.rpgPoisons;
        final Map<String, RpgPlayer> rPlayers = RpgAPI.rpgPlayers;
        final Map<String, String> playerNicks = RpgAPI.activeNicks;
        new BukkitRunnable(){
            @Override
            public void run(){
                for (Player p : Bukkit.getOnlinePlayers()){
                    RpgPlayer rp =  rPlayers.get(playerNicks.get(p.getName()));
                    Location pLoc = p.getLocation();
                    if (rp != null && (rp.isPoisonProof() || rp.isPoisoned())){
                        continue;
                    }
                    for (String poison : poisonRegions.keySet()){
                        RpgPoison rPoison = poisonRegions.get(poison);
                        Location Loc = new Location(Bukkit.getWorld(rPoison.getWorldName()), rPoison.getPoisonX(), rPoison.getPoisonY(), rPoison.getPoisonZ());
                        if ((Loc.getWorld().getName().equalsIgnoreCase(pLoc.getWorld().getName()) &&
                            ((rPoison.isAboveY() && pLoc.getY() >= rPoison.getPoisonY()&& Loc.distance(pLoc) <= rPoison.getPoisonRadius()) ||
                            (!(rPoison.isAboveY()) && pLoc.getY() <= rPoison.getPoisonY() && Loc.distance(pLoc) <= rPoison.getPoisonRadius())))){
                            PoisonAplicator(rPoison, p.getName());
                        }
                    }
                }
            }
        }.runTaskTimer(RpgAPI.plugin, 60, 180);
    }
    private static void PoisonAplicator(RpgPoison rPoison, String name) {
        RpgPlayer rp = RpgAPI.rpgPlayers.get(RpgAPI.activeNicks.get(name));
        rp.setPoisoned(true);
        Player p = Bukkit.getPlayer(name);
        for (PotionEffectType pType : rPoison.getEffectStats().keySet()){
            PoisonEffects effect = rPoison.getEffectStats().get(pType);
            p.addPotionEffect(new PotionEffect(pType, effect.getDuration() * 20, effect.getStrength()), true);
         }
        PoisonRemover(rPoison, rp);
        for (PoisonBehavior pBehavior : rPoison.getPoisonBehaviors()){
            pBehavior.poisonBehavior(p);
        }
    }

    private static void PoisonRemover(RpgPoison rPoison, final RpgPlayer rp) {
        final Integer poisonTicks = rPoison.getPoisonTickLength() * 20;
        new BukkitRunnable(){

            @Override
            public void run(){
                rp.setPoisoned(false);
            }
        }.runTaskLater(RpgAPI.plugin, poisonTicks);
    }
}
