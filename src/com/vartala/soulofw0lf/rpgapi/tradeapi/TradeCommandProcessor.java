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
 * Time: 2:25 PM
 */
public class TradeCommandProcessor {
    public static void process(Player p, String[] command) {
        if (command[0].equalsIgnoreCase("trade")) {
            // Too short? Show usage
            if (command.length == 1) {
                p.sendMessage("Usage: /trade <accept/deny/send> player");
                return;
            } else { // Else it must be at least 2 arguments
                RpgPlayer rpgPlayer = RpgAPI.rpgPlayers.get(p.getName());

                // If its accept or deny answer the request
                if (command[1].equals("accept")) {
                    RpgAPI.tradeHandler.answerRequest(rpgPlayer, true);
                    return;
                } else if (command[1].equals("deny")){
                    RpgAPI.tradeHandler.answerRequest(rpgPlayer, false);
                    return;
                } else { // Try sending a request
                    RpgPlayer player = RpgAPI.rpgPlayers.get(command[1]);
                    if (player == null || rpgPlayer.getRealName().equals(player.getRealName())) {
                        p.sendMessage(ChatColor.RED + "That player is not online or does not exist!");
                        return;
                    } else {
                        RpgAPI.tradeHandler.sendRequest(rpgPlayer, player);
                        return;
                    }
                }
            }
        }
    }
}
