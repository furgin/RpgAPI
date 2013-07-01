package com.vartala.soulofw0lf.rpgapi.guiapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ClickInvListener implements Listener {
	RpgAPI Rpga;
	public ClickInvListener(RpgAPI rpga){
		this.Rpga = rpga;
	}
    //this method handles the actual listener for inventory clicks
	@EventHandler(priority = EventPriority.HIGHEST)
	public void clickListener(InventoryClickEvent event){
        if (!RpgAPI.clickOn){
            return;
        }
        //grab the name of the inventory and assign it to a string
		String name = event.getInventory().getName();

        //setting a null enum placeholder for the type of click that is used
        ClickType click = null;

        //initializing a boolean that we will use to determine if the inventory
        //is actually one we should listen for
		Boolean isAClick = false;

        //initializing a null inventory to replace with our inventory later
		RpgClickInv rci = null;

        //check through all click inventories for the current inventory name
		for (RpgClickInv rc : RpgAPI.rpgClicks){

            //if the current inventory is a click inventory set it to our initiliazed inventory
            //and set the Aclick booean to true
			if (rc.getInvName().equalsIgnoreCase(name)){
				isAClick = true;
				rci = rc;
			}
		}
        //after all inventory's have been gone through, if the name of this inventory is not a clickinventory
        //exit out of the listener
		if (!isAClick){
			return;
		}
        //set the player that is using the inventory
		Player player = (Player)event.getWhoClicked();

        //get the current item stack clicked on
		ItemStack is = event.getCurrentItem();

        //if the click event was not an item stack exit out of the listener
		if (is == null){
			return;
		}

        //get the item meta of the current itemstack
		ItemMeta im = is.getItemMeta();

        //if the item has no metadata exit out of the listener
		if (im == null){
			return;
		}
        /*
         * set the click enum to the appropriate type of click used
         */
        click = event.getClick();

        //process each click behavior saved to this inventory
		for(InventoryClickBehavior behavior : rci.getBehavior()){
			behavior.onClick(rci, player, is, click);
		}
	}
}
