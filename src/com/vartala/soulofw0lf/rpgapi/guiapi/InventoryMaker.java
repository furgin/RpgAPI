package com.vartala.soulofw0lf.rpgapi.guiapi;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryMaker {
    //

    /**
     *
     * @param name
     * @param Id
     * @param size
     * @param dura
     * @param lores
     * @return
     */
    //this method is to construct an item stack
    public static ItemStack itemStackMaker(String name, Material Id, Integer size, Short dura, List<String> lores) {
        ItemStack is = new ItemStack(Id, size);
        ItemMeta im = is.getItemMeta();
        im.setDisplayName(name);
        im.setLore(lores);
        is.setItemMeta(im);
        is.setDurability(dura);
        return is;
    }

    /**
     *
     * @param Owner
     * @param name
     * @param items
     * @return
     */
    //this method constructs the actual inventory
    public static Inventory invMaker(InventoryHolder Owner, String name, List<ItemStack> items) {
        Integer i = 0;
        Integer mapSize = 0;
        i = items.size();

        if (i <= 9) {
            mapSize = 9;
        }
        if (i >= 10) {
            mapSize = 18;
        }
        if (i >= 19) {
            mapSize = 27;
        }
        if (i >= 28) {
            mapSize = 36;
        }
        if (i >= 37) {
            mapSize = 45;
        }
        Integer place = 0;
        Inventory inv = Bukkit.createInventory(Owner, mapSize, name);
        for (ItemStack is : items) {
            inv.setItem(place, is);
            place++;
        }
        return inv;
    }
}
