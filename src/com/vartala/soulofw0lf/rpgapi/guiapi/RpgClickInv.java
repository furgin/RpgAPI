package com.vartala.soulofw0lf.rpgapi.guiapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class RpgClickInv {
    RpgAPI Rpga;

    public RpgClickInv(RpgAPI rpga) {
        this.Rpga = rpga;
    }        //

    //a map saving the itemstack with commands in the format
    //Command:player/console:shift/left/right
    private Map<ItemStack, List<String>> itemCommands = new HashMap<>();

    //name of the inventory
    private String invName = "";

    //declare the invnentory without initializing it
    private Inventory clickInv;

    //extra behaviors to be added to inventory's you can add BasicInventoryClickBehavior to make it function just like
    //rpg click does by default
    private List<InventoryClickBehavior> behaviorList = new ArrayList<InventoryClickBehavior>();


    /*
     * all getters and setters
     */


    public RpgClickInv() {

    }

    public void addBehavior(InventoryClickBehavior behavior) {

        behaviorList.add(behavior);
    }

    public void clearBehavior() {
        behaviorList.clear();
    }

    public List<InventoryClickBehavior> getBehavior() {
        return behaviorList;
    }

    public Map<ItemStack, List<String>> getItemCommands() {
        return itemCommands;
    }

    public void setItemCommands(Map<ItemStack, List<String>> itemCommands) {
        this.itemCommands = itemCommands;
    }

    public String getInvName() {
        return invName;
    }

    public void setInvName(String invName) {
        this.invName = invName;
    }

    public Inventory getClickInv() {
        return clickInv;
    }

    public void setClickInv(Inventory clickInv) {
        this.clickInv = clickInv;
    }
}
