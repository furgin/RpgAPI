package com.vartala.soulofw0lf.rpgapi.guiapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.mobcommandapi.MobCommandProcessor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by: tennyson.holloway
 * Date: 7/1/13
 * Time: 9:29 AM
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
public class MinionGuiBehavior implements InventoryClickBehavior {
    @Override
    public void onClick(RpgClickInv inv, Player player, ItemStack item, ClickType click) {
        if (!inv.getInvName().contains("MOB EDITING ID:")) { //only proceed if the opened GUI is a mob editing GUI
            return;
        }
        List<String> command = inv.getItemCommands().get(item); //list of command associcated with the itemstack
        int commandIndex = -1; //index of which command matches which click, determined in the for loop
        //all this to determine which command matches which click
        for (int i = 0; i < command.size(); i++) {
            String s = command.get(i);
            String[] cArr = s.split(":");
            ClickType clickType = null;
            switch (cArr[1].toUpperCase()) {
                case "LEFT":
                    clickType = ClickType.LEFT;
                    break;
                case "RIGHT":
                    clickType = ClickType.RIGHT;
                    break;
                case "SHIFT":
                    clickType = ClickType.SHIFT_LEFT;
                    break;
            }
            if (clickType == click) {
                commandIndex = i;
                break;
            }
        }
        if (commandIndex == -1) {
            RpgAPI.logger.severe("Couldn't process customClick, commandInt == -1");
        }
        String[] cArr = command.get(commandIndex).split(":");
        int mobID = Integer.parseInt(inv.getInvName().substring(inv.getInvName().indexOf(":")+1).trim());
        MobCommandProcessor.process(cArr,mobID, player);


    }
}
