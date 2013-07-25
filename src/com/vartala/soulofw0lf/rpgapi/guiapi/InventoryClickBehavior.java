package com.vartala.soulofw0lf.rpgapi.guiapi;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

//
public interface InventoryClickBehavior {
    /**
     *
     * @param inv
     * @param player
     * @param item
     * @param click
     */
    public void onClick(RpgClickInv inv, Player player, ItemStack item, ClickType click);
}
