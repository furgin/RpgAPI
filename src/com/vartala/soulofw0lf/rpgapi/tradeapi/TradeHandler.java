package com.vartala.soulofw0lf.rpgapi.tradeapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

/**
 * Created with IntelliJ IDEA.
 * User: Mothma
 * Date: 7/2/13
 * Time: 11:49 AM
 */
public class TradeHandler {
    RpgAPI rpgApi;

    /**
     *
     * @param rpgApi
     */
    public TradeHandler(RpgAPI rpgApi) {
        this.rpgApi = rpgApi;
    }

    /**
     *
     * @param sender
     * @param receiver
     */
    public void sendRequest(RpgPlayer sender, RpgPlayer receiver) {
        // Get bukkit players
        Player sen = Bukkit.getPlayer(sender.getRealName());
        Player rec = Bukkit.getPlayer(receiver.getRealName());

        // Make sure they are ready
        if (sender.isInTrade()) {
            sen.sendMessage(ChatColor.RED + "You are already in a trade.");
            return;
        }
        if (receiver.isInTrade()) {
            sen.sendMessage(ChatColor.RED + "That person is already trading with someone.");
            return;
        }

        // Get their nicknames
        String name1 = rpgApi.activeNicks.get(sen.getName());
        String name2 = rpgApi.activeNicks.get(rec.getName());

        rec.sendMessage(name1 + " wishes to trade with you.");
        rec.sendMessage("Type /trade accept or /trade deny.");
        sen.sendMessage("Sent trade request to " + name2);
        receiver.setWaitTrade(sender.getRealName());
    }

    /**
     *
     * @param receiver
     * @param accept
     */
    public void answerRequest(RpgPlayer receiver, boolean accept) {
        RpgPlayer sender = rpgApi.rpgPlayers.get(receiver.getWaitTrade());

        Player sen = Bukkit.getPlayer(sender.getRealName());
        Player rec = Bukkit.getPlayer(receiver.getRealName());

        if (sender == null) {
            rec.sendMessage(ChatColor.RED + "That player is no longer online.");
        } else if (accept) {

            // Must be close together or have permissions
            if (sen.getLocation().distance(rec.getLocation()) > 15) {
                if (!sen.hasPermission("rpgapi.trade.distance") && !rec.hasPermission("rpgapi.trade.distance")) {
                    sen.sendMessage(ChatColor.RED + "You must closer to trade!");
                    rec.sendMessage(ChatColor.RED + "You must closer to trade!");
                    return;
                }
            }

            sen.sendMessage(ChatColor.GREEN + "Your trade request was accepted.");
            rec.sendMessage(ChatColor.GREEN + "Trade request accepted.");

            String name1 = rpgApi.activeNicks.get(sen.getName());
            String name2 = rpgApi.activeNicks.get(rec.getName());
            RpgTrade trade = new RpgTrade(sender, receiver, name1, name2);
            trade.startTrade();
            return;
        } else if (!accept) {
            sen.sendMessage(ChatColor.RED + "Your trade request was denied.");
            rec.sendMessage(ChatColor.RED + "Trade request denied.");
        }

        //Only reset waiting if the trade did not go through
        sender.setWaitTrade("");
    }
}
