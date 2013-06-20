package com.vartala.soulofw0lf.rpgapi.minionapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.guiapi.InventoryMaker;
import com.vartala.soulofw0lf.rpgapi.guiapi.RpgClickInv;
import com.vartala.soulofw0lf.rpgapi.mobcommandapi.MobCommand;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: links
 * Date: 6/19/13
 * Time: 4:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class MinionGui {
    //for the player p, creates entity config with id
    public void createGui(Player p, int id, int mobid)
    {
        MobCommand mc = RpgAPI.minionCommands.get("Set "+id);
        RpgClickInv rpgClickInv = new RpgClickInv(RpgAPI.plugin);
        Inventory inv = InventoryMaker.invMaker(null, ""+mobid, mc.toItemStack());
        rpgClickInv.setInvName(""+mobid);
        rpgClickInv.setClickInv(inv);

    }

}