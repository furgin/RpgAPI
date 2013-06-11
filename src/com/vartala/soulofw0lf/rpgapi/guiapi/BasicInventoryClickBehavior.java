package com.vartala.soulofw0lf.rpgapi.guiapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

public class BasicInventoryClickBehavior  implements InventoryClickBehavior{
    //
	@Override
	public void onClick(RpgClickInv inv, Player p, ItemStack item,
			ClickType click) {
		//make a map from the item commands stored in the click inventory
		Map<ItemStack, List<String>> itemCommands = inv.getItemCommands();
        //get the item meta from the item stack
		ItemMeta im = item.getItemMeta();
        //set the itemstacks name to a string
		String keyName = im.getDisplayName();
        //initialize strings for later use
		String actualCommand = "";
		String playerConsole = "";
		String leftRightShift = "";
        //initialize arrays for usage
		List<String> rightClick1 = new ArrayList<String>();
		List<String> leftClick1 = new ArrayList<String>();
		List<String> shiftClick1 = new ArrayList<String>();
        //setting i to 0 to use it to determine which string is which
		Integer i = 0;
        //iterate through the commands list for commands associated with the item clicked on
		for (String command : itemCommands.get(keyName)){
            //i is set to 0 to restart
			i = 0;
            //breaking the string up to get different arguments for it
			for (String breakString : command.split(":")){
                //actual command is the segment of the string that the command is stored in
				if (i==0){
					actualCommand = breakString;
				}
                /*player console is the segment of the string
                * that determines if it is a player command or a console command
                */
				if (i==1){
					playerConsole = breakString;
				}
                /*this segment of the string determines if the
                * command should be executed on left right or shift click
                */
 				if (i==2){
					leftRightShift = breakString;
				}
                //add the command and wether they should be player or console based to a list based on click type
				if (leftRightShift.equalsIgnoreCase("Left")){
					leftClick1.add(actualCommand + ":" + playerConsole);
				}
				if (leftRightShift.equalsIgnoreCase("Right")){
					rightClick1.add(actualCommand + ":" + playerConsole);
				}
				if (leftRightShift.equalsIgnoreCase("Shift")){
					shiftClick1.add(actualCommand + ":" + playerConsole);
				}
                 //increase i by 1
				i++;
			}
		}
        //make final lists  and player to pass inside the run functions
		final List<String> rightClick = rightClick1;
		final List<String> leftClick = leftClick1;
		final List<String> shiftClick = shiftClick1;
		final Player player = p;
        //check for which type of click the player performed
		if (click == ClickType.LEFT){
            //close the current inventory
			player.closeInventory();
            //run a task 4 ticks later to execute the commands
			new BukkitRunnable(){
				@Override
				public void run(){
					for (String leftCommand : leftClick){
						Integer a = 0;
						String pOrC = "";
						String exec = "";
                        //break the string again to seperate command from executor
						for (String breakLeft : leftCommand.split(":")){
							if (a == 0){
								exec = breakLeft;
							}
							if (a == 1){
								pOrC = breakLeft;
							}
							a++;
						}
                        //perform each command from console or player
						if (pOrC.equalsIgnoreCase("console")){
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),(exec));
						} else{
							player.performCommand(exec);
						}
					}
				}
			}.runTaskLater(RpgAPI.plugin,4);
		}
		if (click == ClickType.RIGHT){
			player.closeInventory();
			new BukkitRunnable(){
				@Override
				public void run(){
					for (String RightCommand : rightClick){
						Integer a = 0;
						String pOrC = "";
						String exec = "";
						for (String breakRight : RightCommand.split(":")){
							if (a == 0){
								exec = breakRight;
							}
							if (a == 1){
								pOrC = breakRight;
							}
							a++;
						}
						if (pOrC.equalsIgnoreCase("console")){
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),(exec));
						} else{
							player.performCommand(exec);
						}
					}
				}
			}.runTaskLater(RpgAPI.plugin,4);

		}
		if (click == ClickType.SHIFT){
			player.closeInventory();
			new BukkitRunnable(){
				@Override
				public void run(){
					for (String shiftCommand : shiftClick){
						Integer a = 0;
						String pOrC = "";
						String exec = "";
						for (String breakShift : shiftCommand.split(":")){
							if (a == 0){
								exec = breakShift;
							}
							if (a == 1){
								pOrC = breakShift;
							}
							a++;
						}
						if (pOrC.equalsIgnoreCase("console")){
							Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(),(exec));
						} else{
							player.performCommand(exec);
						}
					}
				}
			}.runTaskLater(RpgAPI.plugin,4);
		}

		
	}

}
