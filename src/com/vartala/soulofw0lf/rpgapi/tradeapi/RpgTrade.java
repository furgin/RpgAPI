package com.vartala.soulofw0lf.rpgapi.tradeapi;

import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created with IntelliJ IDEA.
 * User: Mothma
 * Date: 7/2/13
 * Time: 11:45 AM
 * To change this template use File | Settings | File Templates.
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

    private void startTrade() {
        Player ini = Bukkit.getPlayer(initiator.getRealName());
        Player rec = Bukkit.getPlayer(receiver.getRealName());

        initiator.setInTrade(true);
        receiver.setInTrade(true);
    }

}

