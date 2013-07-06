package com.vartala.soulofw0lf.rpgapi.tradeapi;

import com.vartala.soulofw0lf.rpgapi.guiapi.InventoryMaker;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 * Created with IntelliJ IDEA.
 * User: Mothma
 * Date: 7/2/13
 * Time: 11:45 AM
 */
public class RpgTrade {
    private RpgPlayer initiator;
    private RpgPlayer receiver;
    private String recName;
    private String iniName;

    public RpgTrade(RpgPlayer initiator, RpgPlayer receiver, String iniName, String recName) {
        this.initiator = initiator;
        this.receiver = receiver;
        this.iniName = iniName;
        this.recName = recName;
    }

    public void startTrade() {
        Player ini = Bukkit.getPlayer(initiator.getRealName());
        Player rec = Bukkit.getPlayer(receiver.getRealName());

        initiator.setInTrade(true);
        receiver.setInTrade(true);

        Inventory iniInv = new TradeInventory("Trading with " + recName).getInv();
        Inventory recInv = new TradeInventory("Trading with " + iniName).getInv();

        ini.openInventory(iniInv);
        rec.openInventory(recInv);
    }

}

