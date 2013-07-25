package com.vartala.soulofw0lf.rpgapi.tradeapi;

import com.vartala.soulofw0lf.rpgapi.guiapi.InventoryMaker;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: Mothma
 * Date: 7/4/13
 * Time: 4:58 PM
 */
public class TradeInventory {
    // HashMap to store design
    private HashMap<Integer, ItemStack> items = new HashMap<Integer, ItemStack>();
    // Bukkit inventory produced
    private Inventory inv;

    /**
     *
     * @param name
     */
    public TradeInventory(String name) {
        ItemStack divider = new ItemStack(102);
        nameItem(divider, "Divider");

        // Divider down
        items.put(4, new ItemStack(divider));
        items.put(13, new ItemStack(divider));
        items.put(22, new ItemStack(divider));
        items.put(31, new ItemStack(divider));
        items.put(40, new ItemStack(divider));
        // Divider across
        for (int i = 0; i < 9; i++) {
            items.put(27+i, new ItemStack(divider));
        }
        // Help strings
        ArrayList<String> instructions = new ArrayList<String>();
        instructions.add("Left click to add 1");
        instructions.add("Right click to remove 1");
        instructions.add("Shift click to add 10");
        ArrayList<String> status = new ArrayList<String>();
        status.add("Left click to confirm trade");
        status.add("Right click to reset confirmation");
        // Your items
        ItemStack plat = new ItemStack(155);
        ItemStack gold = new ItemStack(41);
        ItemStack silver = new ItemStack(42);
        ItemStack copper = new ItemStack(159);
        copper.setDurability((short) 1);
        // Offer money
        nameItem(plat, "You offer 0 platinum");
        addStringsItems(plat, instructions);
        items.put(36, plat);
        nameItem(gold, "You offer 0 gold");
        addStringsItems(gold, instructions);
        items.put(37, gold);
        nameItem(silver, "You offer 0 silver");
        addStringsItems(silver, instructions);
        items.put(38, silver);
        nameItem(copper, "You offer 0 copper");
        addStringsItems(copper, instructions);
        items.put(39, copper);
        // Their items
        ItemStack otherPlat = new ItemStack(155);
        ItemStack otherGold = new ItemStack(41);
        ItemStack otherSilver = new ItemStack(42);
        ItemStack otherCopper = new ItemStack(159);
        otherCopper.setDurability((short) 1);
        // Display offer
        nameItem(otherPlat, "They offer 0 platinum");
        items.put(41, otherPlat);
        nameItem(otherGold, "They offer 0 gold");
        items.put(42, otherGold);
        nameItem(otherSilver, "They offer 0 silver");
        items.put(43, otherSilver);
        nameItem(otherCopper, "They offer 0 copper");
        items.put(44, otherCopper);

        // Status
        ItemStack wool = new ItemStack(35);
        nameItem(wool, "Your Status: Waiting...");
        addStringsItems(wool, status);
        items.put(0, wool);
        ItemStack otherWool = new ItemStack(35);
        nameItem(otherWool, "Their Status: Waiting...");
        items.put(5, otherWool);

        // Map any items into an arraylist, if there are none add null (blank item)
        ArrayList<ItemStack> itemStacks = new ArrayList<ItemStack>();
        for (int i = 0; i<45; i++) {
            if (items.get(i) != null) {
                itemStacks.add(items.get(i));
            } else {
                itemStacks.add(null);
            }
        }

        inv = InventoryMaker.invMaker(null, name, itemStacks);
    }

    /**
     *
     * @param stack
     * @param name
     */
    private void nameItem(ItemStack stack, String name) {
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(name);
        stack.setItemMeta(meta);
    }

    /**
     *
     * @param stack
     * @param strings
     */
    private void addStringsItems(ItemStack stack, ArrayList<String> strings) {
        ItemMeta meta = stack.getItemMeta();
        meta.setLore(strings);
        stack.setItemMeta(meta);
    }

    /**
     *
     * @return
     */
    public Inventory getInv() {
        return inv;
    }
}
