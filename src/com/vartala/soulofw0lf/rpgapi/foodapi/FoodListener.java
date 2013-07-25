package com.vartala.soulofw0lf.rpgapi.foodapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.enumapi.PlayerStat;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.util.ChatColors;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by: soulof
 * Date: 6/10/13
 * Time: 10:12 AM
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
public class FoodListener implements Listener {
    RpgAPI Rpgapi;

    /**
     *
     * @param rpgapi
     */
    public FoodListener(RpgAPI rpgapi) {
        this.Rpgapi = rpgapi;
    }

    /**
     *
     * @param event
     */
    @EventHandler
    public void onRestore(EntityRegainHealthEvent event) {
        if (!RpgAPI.foodOn) {
            return;
        }
        if ((event.getRegainReason() == EntityRegainHealthEvent.RegainReason.REGEN) ||
                (event.getRegainReason() == EntityRegainHealthEvent.RegainReason.SATIATED)) {
            if ((event.getEntity() instanceof Player)) {
                if (RpgAPI.rpgStyleFood) {
                    event.setCancelled(true);
                }
            }
        }
    }

    /**
     *
     * @param event
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityDamage(EntityDamageEvent event) {
        if (!RpgAPI.foodOn) {
            return;
        }
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        if (event.getCause() == EntityDamageEvent.DamageCause.STARVATION) {
            if (RpgAPI.rpgStyleFood) {
                event.setCancelled(true);
                return;
            }
        }
    }

    /**
     *
     * @param event
     */
    @EventHandler(priority = EventPriority.LOW)
    public void onFoodLevelChange(FoodLevelChangeEvent event) {
        if (!RpgAPI.foodOn) {
            return;
        }
        Player p = (Player) event.getEntity();
        if (RpgAPI.rpgStyleFood) {
            event.setCancelled(true);
            p.setSaturation(5.0F);
        }
    }

    /**
     *
     * @param event
     */
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerUse(PlayerInteractEvent event) {
        if (!RpgAPI.foodOn) {
            return;
        }
        Player p = event.getPlayer();
        ItemStack item = p.getItemInHand();
        if (item == null || item.getTypeId() == 0) {
            return;
        } else {
            ItemMeta im = item.getItemMeta();
            if (im == null) {
                return;
            }
            if (!(im.hasDisplayName())) {
                return;
            }
            String foodName = im.getDisplayName();
            if (!(this.Rpgapi.foodItems.containsKey(foodName))) {
                return;
            }
            event.setCancelled(true);
            String senderName = event.getPlayer().getName();
            RpgPlayer sendPlayer = this.Rpgapi.rpgPlayers.get(this.Rpgapi.activeNicks.get(senderName));
            Integer health = sendPlayer.getCurrentHealth();
            Integer maxHealth = sendPlayer.getStats().get(PlayerStat.TOTAL_HIT_POINTS);
            if ((event.getAction() == Action.RIGHT_CLICK_AIR) || (event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
                if (health.equals(maxHealth)) {
                    p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Eating Health Full")));
                    return;
                } else {
                    if (sendPlayer.isEating()) {
                        p.sendMessage(ChatColors.ChatString(RpgAPI.localeSettings.get("Already Eating")));
                        return;
                    } else {
                        sendPlayer.setEating(true);
                        Integer inHand = item.getAmount() - 1;
                        ItemStack newItem = new ItemStack(item.getType(), inHand);
                        newItem.setItemMeta(im);
                        p.setItemInHand(newItem);
                        CustomFood thisFood = this.Rpgapi.foodItems.get(im.getDisplayName());
                        for (FoodBehavior behavior : thisFood.getFoodBehaviors()) {
                            behavior.ConsumptionEffect(sendPlayer, thisFood);
                        }
                    }
                }
            }
        }
    }


}
