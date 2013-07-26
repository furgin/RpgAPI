package com.vartala.soulofw0lf.rpgapi.util;

import org.bukkit.ChatColor;

/**
 * Created with IntelliJ IDEA.
 * User: Mothma
 * Date: 7/6/13
 * Time: 8:02 PM
 */
public class TradeUtil {
    // Show money as plat,gold,silver,bronze

    /**
     * Show money as Platinum Gold Silver and Bronze
     *
     * @param money
     * @param omitZeros
     * @return
     */
    public static String expandedMoney(int money, boolean omitZeros) {
        int copper = 0, silver = 0, gold = 0, plat = 0;
        copper = money % 10;
        if (money > 10) {
            silver = (money%100 - copper) / 10;
            if (money > 100) {
                gold = (money%1000 - silver - copper) / 100;
                if (money > 1000) {
                    plat = (money - gold - silver - copper) / 1000;
                }
            }
        }

        if (!omitZeros) {
            return String.format("Plat: %d Gold: %d Silver: %d Copper: %d", plat, gold, silver, copper);
        }
        String s = "";
        if (copper != 0){
            s += ChatColor.GOLD + String.valueOf(copper) + " Copper ";
        }
        if (silver != 0) {
            s += ChatColor.GRAY + String.valueOf(silver) + " Silver ";
        }
        if (gold != 0) {
            s += ChatColor.YELLOW + String.valueOf(gold) + " Gold ";
        }
        if (plat != 0) {
            s += ChatColor.DARK_AQUA + String.valueOf(plat) + " Platinum ";
        }
        return s;
    }
}
