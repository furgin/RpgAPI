package com.vartala.soulofw0lf.rpgapi.foodapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by: soulof
 * Date: 6/10/13
 * Time: 11:57 AM
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
public class basicFoodBehavior implements FoodBehavior {
    /**
     *
     * @param player
     * @param foodItem
     */
    @Override
    public void ConsumptionEffect(RpgPlayer player, CustomFood foodItem) {
        final RpgPlayer p = player;
        Bukkit.getPlayer(p.getRealName()).setFoodLevel(0);
        final Double addHunger = 20 / foodItem.getTimeToEat();
        Integer addhealth = foodItem.getFoodHealth();
        final Integer smallAdd = (int) (addhealth / foodItem.getTimeToEat());
        final CustomFood itemEaten = foodItem;
        new BukkitRunnable() {
            Double count = itemEaten.getTimeToEat();
            Boolean locset = false;
            Double addFood = 0.00;
            Double oldX = 0.00;
            Double oldZ = 0.00;

            @Override
            public void run() {
                if (locset != null && !locset) {
                    oldX = Bukkit.getPlayer(p.getRealName()).getLocation().getX();
                    oldZ = Bukkit.getPlayer(p.getRealName()).getLocation().getZ();
                }
                locset = true;
                double newFood = addFood + addHunger;
                Integer currentFood = (int) newFood;
                if (currentFood <= 1) {
                    currentFood = 1;
                }
                if (count <= 0) {
                    Bukkit.getPlayer(p.getRealName()).setFoodLevel(20);
                    if (itemEaten.isHasBuff()) {
                        String buff = itemEaten.getFoodBuff();
                        Integer dura = itemEaten.getBuffDuration() * 20;
                        Integer amp = itemEaten.getBuffAmp();
                        if (buff.equalsIgnoreCase("Blindness")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Confusion")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Damage_Resistance")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Fast_Digging")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Fire_Resistance")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Harm")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.HARM, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Heal")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.HEAL, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Increase_Damage")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Invisibility")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Jump")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.JUMP, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Night_Vision")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Poison")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.POISON, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Regeneration")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Slow")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Slow_Digging")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Speed")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.SPEED, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Water_Breathing")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Weakness")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, dura, amp), true);
                        }
                        if (buff.equalsIgnoreCase("Wither")) {
                            Bukkit.getPlayer(p.getRealName()).addPotionEffect(new PotionEffect(PotionEffectType.WITHER, dura, amp), true);
                        }
                    }
                    locset = false;
                    p.setEating(false);
                    cancel();
                } else {
                    if (Bukkit.getPlayer(p.getRealName()).getFoodLevel() == 20) {
                        Bukkit.getPlayer(p.getRealName()).setFoodLevel(20);
                        p.setEating(false);
                        locset = false;
                        cancel();
                    } else {
                        if ((Bukkit.getPlayer(p.getRealName()).getLocation().getX() != oldX) || (Bukkit.getPlayer(p.getRealName()).getLocation().getZ() != oldZ)) {
                            Bukkit.getPlayer(p.getRealName()).sendMessage(ChatColor.DARK_PURPLE + "[Rpg Food]" + ChatColor.YELLOW + " You must stand still to eat!");
                            Bukkit.getPlayer(p.getRealName()).setFoodLevel(20);
                            p.setEating(false);
                            locset = false;
                            cancel();
                        } else {

                            if (Bukkit.getPlayer(p.getRealName()).getHealth() + smallAdd >= Bukkit.getPlayer(p.getRealName()).getMaxHealth()) {
                                Bukkit.getPlayer(p.getRealName()).setHealth(Bukkit.getPlayer(p.getRealName()).getMaxHealth());
                                Bukkit.getPlayer(p.getRealName()).setFoodLevel(currentFood);
                                addFood = newFood;
                                count--;
                            } else {
                                Bukkit.getPlayer(p.getRealName()).setFoodLevel(currentFood);
                                Bukkit.getPlayer(p.getRealName()).setHealth(Bukkit.getPlayer(p.getRealName()).getHealth() + smallAdd);
                                addFood = newFood;
                                count--;
                            }
                        }
                    }
                }
            }
        }.runTaskTimer(RpgAPI.getInstance(), 0, 20);
    }
}
