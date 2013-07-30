package com.vartala.soulofw0lf.rpgapi.diseaseapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.Misc;
import org.bukkit.Bukkit;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 7/29/13
 * Time: 8:13 PM
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
public class DiseaseListeners implements Listener {
    RpgAPI Rpga;

    /**
     * This class handles all disease spread and damage listeners as well as all disease timers
     *
     * @param rpga - initialised with a reference to the main class
     */

    public DiseaseListeners(RpgAPI rpga) {
        this.Rpga = rpga;
        Bukkit.getPluginManager().registerEvents(this, rpga);
        new BukkitRunnable(){
            @Override
            public void run(){
                for (Player p : Bukkit.getOnlinePlayers()){
                    RpgPlayer rP = RpgAPI.getRp(p);
                    if (!rP.isDiseased()){
                        continue;
                    }
                    for (Disease dis : rP.getDiseases()){
                        if (!dis.isSpreadable() || !dis.isAirSpread()){
                            continue;
                        }
                        double Spread = dis.getAirSpreadChance();
                        double dist = dis.getSpreadDistance();
                        for (Entity nB : p.getNearbyEntities(dist, dist, dist)){
                            if (!(nB instanceof Player)){
                            continue;
                            }
                            double i = (Math.random() * 100);
                            if (i >= Spread + 0.1){
                                continue;
                            }
                            Player pl = (Player) nB;
                            RpgPlayer rp = RpgAPI.getRp(pl);
                            if (rp.getImmuneDiseases().contains(dis)){
                                continue;
                            }
                            boolean diseasedApplied = false;
                            if (rp.isDiseased()){
                                for (Disease diss : rp.getDiseases()){
                                    if (!diss.isStackable()){
                                        if (dis.getSeverity() >= diss.getSeverity() + 1){
                                            rp.getDiseases().remove(diss);
                                            applyDisease(pl, rp, dis);
                                        }
                                        diseasedApplied = true;
                                        continue;
                                    }
                                    if (!diss.isGetsWorse()){
                                        continue;
                                    }
                                    if (diss.getDiseaseName().equalsIgnoreCase(dis.getDiseaseName())){
                                        Disease stackDis = Misc.getDiseaseByName(dis.getProgressiveDisease());
                                        applyDisease(pl, rp, stackDis);
                                        diseasedApplied = true;
                                    }
                                }
                                if (!diseasedApplied){
                                    applyDisease(pl, rp, dis);
                                    diseasedApplied = true;
                                }
                            }
                            if (!diseasedApplied){
                                applyDisease(pl, rp, dis);
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(RpgAPI.getInstance(), 180, 300);
    }
    public static void applyDisease(Player p, RpgPlayer rp, Disease dis){
        rp.getDiseases().add(dis);
        for (PotionEffect pE : dis.getDiseasePots()){
            if (pE == null){
                continue;
            }
            p.addPotionEffect(pE);
        }
        if (dis.isGetsWorse()){
            if (rp.getDiseases().contains(Misc.getDiseaseByName(dis.getRegressiveDisease()))){
                rp.getDiseases().remove(Misc.getDiseaseByName(dis.getRegressiveDisease()));
            }
            final int time = dis.getProgressionTime() * 20;
            final String name = rp.getName();
            final String disName = dis.getDiseaseName();
            new BukkitRunnable(){
                @Override
                public void run(){
                    RpgPlayer rp = RpgAPI.rpgPlayers.get(name);
                    if (rp.getDiseases().contains(Misc.getDiseaseByName(disName))){
                        Disease dis = Misc.getDiseaseByName(Misc.getDiseaseByName(disName).getProgressiveDisease());
                        applyDisease(Bukkit.getPlayer(rp.getRealName()), rp, dis);
                    }
                }
            }.runTaskLater(RpgAPI.getInstance(), time);
        }
        if (dis.hasHealthEffect()){
            double chn = rp.getMaxHealth() + dis.getHealthChange();
            p.setMaxHealth(chn);
        }
        for (DiseaseBehavior behavior : dis.getBehaviors()){
            behavior.diseased(p, dis.getDiseaseTime());
        }
        if (dis.isDot()){
            final String name = p.getName();
            final Disease disName = dis;
            final int time = dis.getDotTimer() * 20;
            final double damage = dis.getDotDamage();

            new BukkitRunnable(){
                int ticks = disName.getTicksBeforeDeath();
                @Override
                public void run(){
                    RpgPlayer rp = RpgAPI.getRp(name);
                    if (!rp.getDiseases().contains(disName)){
                        cancel();
                        return;
                    }
                    Bukkit.getPlayer(name).setHealth(-damage);
                    if (disName.isFatal()){
                        ticks--;
                        if (ticks <= 0){
                            Bukkit.getPlayer(name).setHealth(0.0);
                            cancel();
                         }
                    }
                }
            }.runTaskTimer(RpgAPI.getInstance(), 20, time);
        }
    }
    @EventHandler
    public void playerDiseasedStrike(EntityDamageByEntityEvent e){
        if (e.getEntity() instanceof Player){
            Player p = (Player) e.getEntity();
            RpgPlayer rp = RpgAPI.getRp(p.getName());
            if (!rp.isDiseased()){
                return;
            }
            for (Disease dis : rp.getDiseases()){
                if(!dis.isEffectDamageTaken()){
                    continue;
                }
                e.setDamage(+dis.getAdjustDamageTaken());
            }
        }
    }
    @EventHandler
    public void playerDiseaseStrike(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player){
            Player p = (Player)e.getDamager();
            RpgPlayer rp = RpgAPI.getRp(p.getName());
            if (!rp.isDiseased()){
                return;
            }
            for (Disease dis : rp.getDiseases()){
                if (dis.isMiss()){
                    double i = (Math.random() * 100);
                    if (i <= dis.getMissChance()){
                        e.setDamage(0.0);
                        e.setCancelled(true);
                        return;
                    }
                }
                if (!dis.isEffectDamage()){
                    continue;
                }
                e.setDamage(+dis.getAdjustDamage());
            }
        }
        if (e.getDamager() instanceof Arrow){
            Arrow arrow = (Arrow)e.getDamager();
            if (!(arrow.getShooter() instanceof Player)){
                 return;
            }
            Player p = (Player)arrow.getShooter();
            RpgPlayer rp = RpgAPI.getRp(p.getName());
            if (!rp.isDiseased()){
                return;
            }
            for (Disease dis : rp.getDiseases()){
                if (dis.isMiss()){
                    double i = (Math.random() * 100);
                    if (i <= dis.getMissChance()){
                        e.setCancelled(true);
                        return;
                    }
                }
                if (!dis.isEffectDamage()){
                    continue;
                }
                e.setDamage(+dis.getAdjustDamage());
            }
        }
    }
    @EventHandler
    public void playerHit(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof Player)
        if (e.getDamager() instanceof Player && e.getEntity() instanceof Player){
            Player p = (Player) e.getDamager();
            Player pl = (Player) e.getEntity();
            RpgPlayer rp = RpgAPI.getRp(p);
            RpgPlayer rp2 = RpgAPI.getRp(pl);
            if (rp.isDiseased()){
                for (Disease dis : rp.getDiseases()){
                    if (!dis.isHitSpread()){
                        continue;
                    }
                    double spread = dis.getHitSpreadChance();
                    double i = (Math.random() * 100);
                    if (i >= spread + 0.1){
                        continue;
                    }
                    if (rp2.getImmuneDiseases().contains(dis)){
                        continue;
                    }
                    boolean diseasedApplied = false;
                    if (rp2.isDiseased()){
                        for (Disease diss : rp2.getDiseases()){
                            if (!diss.isStackable()){
                                if (dis.getSeverity() >= diss.getSeverity() + 1){
                                    rp.getDiseases().remove(diss);
                                    applyDisease(pl, rp, dis);
                                }
                                diseasedApplied = true;
                                continue;
                            }
                            if (!diss.isGetsWorse()){
                                continue;
                            }
                            if (diss.getDiseaseName().equalsIgnoreCase(dis.getDiseaseName())){
                                Disease stackDis = Misc.getDiseaseByName(dis.getProgressiveDisease());
                                applyDisease(pl, rp2, stackDis);
                                diseasedApplied = true;
                            }
                        }
                        if (!diseasedApplied){
                            applyDisease(pl, rp2, dis);
                            diseasedApplied = true;
                        }
                    }
                    if (!diseasedApplied){
                        applyDisease(pl, rp2, dis);
                    }

                }
            }
            if (rp2.isDiseased()){
                for (Disease dis : rp2.getDiseases()){
                    if (!dis.isHitSpread()){
                        continue;
                    }
                    double spread = dis.getHitSpreadChance();
                    double i = (Math.random() * 100);
                    if (i >= spread + 0.1){
                        continue;
                    }
                    if (rp.getImmuneDiseases().contains(dis)){
                        continue;
                    }
                    boolean diseasedApplied = false;
                    if (rp.isDiseased()){
                        for (Disease diss : rp.getDiseases()){
                            if (!diss.isStackable()){
                                if (dis.getSeverity() >= diss.getSeverity() + 1){
                                    rp.getDiseases().remove(diss);
                                    applyDisease(pl, rp, dis);
                                }
                                diseasedApplied = true;
                                continue;
                            }
                            if (!diss.isGetsWorse()){
                                continue;
                            }
                            if (diss.getDiseaseName().equalsIgnoreCase(dis.getDiseaseName())){
                                Disease stackDis = Misc.getDiseaseByName(dis.getProgressiveDisease());
                                if (stackDis == null){
                                    continue;
                                }
                                applyDisease(p, rp, stackDis);
                                diseasedApplied = true;
                            }
                        }
                        if (!diseasedApplied){
                            applyDisease(p, rp, dis);
                            diseasedApplied = true;
                        }
                    }
                    if (!diseasedApplied){
                        applyDisease(p, rp, dis);
                    }

                }
            }
        }
    }
}
