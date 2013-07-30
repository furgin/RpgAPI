package com.vartala.soulofw0lf.rpgapi.warpsapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by: soulofw0lf
 * Date: 6/25/13
 * Time: 1:32 PM
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
public class WarpProcessor {
    /**
     *
     * @param p
     * @param rpgWarp
     */
    public static void WarpHandler(String p, RpgWarp rpgWarp) {
        WarpSets wSet = RpgAPI.savedSets.get(rpgWarp.getWarpSet());
        RpgWarp thisWarp = rpgWarp;
        Integer i = 0;
        if (wSet.getWarpsRandom()) {
            Player pl = Bukkit.getPlayer(p);
            List<RpgWarp> newList = wSet.getSetWarps();
            Boolean warpPerms = false;
            for (RpgWarp warp1 : newList) {
                Bukkit.getPlayer(p).sendMessage(warp1.getWarpName());
            }
            while (warpPerms == false) {
                i = (int) (Math.random() * newList.size());
                thisWarp = newList.get(i);
                warpPerms = WarpRequirements(Bukkit.getPlayer(p), thisWarp);
            }

        }
        Double X = thisWarp.getWarpX();
        Double Y = thisWarp.getWarpY();
        Double Z = thisWarp.getWarpZ();
        String world = thisWarp.getWorldName();
        Float yaw = thisWarp.getWarpYaw();
        Float pitch = thisWarp.getWarpPitch();
        Location l = new Location(Bukkit.getWorld(world), X, Y, Z, yaw, pitch);
        if (thisWarp.getVariance()) {
            Integer variance = thisWarp.getWarpVariance();
            l.setX(X - variance + ((Math.random() * ((variance * 2) + 1))));
            l.setZ(Z - variance + ((Math.random() * ((variance * 2) + 1))));
            Boolean aboveGround = false;
            while (aboveGround == false) {
                Block b = l.getBlock();
                if (!(b.getType().equals(Material.AIR))) {
                    l.setY(l.getY() + 3);
                } else {
                    aboveGround = true;
                }
            }
        }
        Player pl = Bukkit.getPlayer(p);
        pl.teleport(l);
        if (thisWarp.getUseCD()) {
            if (RpgAPI.warpCds.containsKey(p)) {
                List<String> warps = RpgAPI.warpCds.get(p);
                warps.add(thisWarp.getWarpName());
                RpgAPI.warpCds.remove(p);
                RpgAPI.warpCds.put(p, warps);
            } else {
                List<String> warps = new ArrayList<String>();
                warps.add(thisWarp.getWarpName());
                RpgAPI.warpCds.put(p, warps);
            }
            final String warpName = thisWarp.getWarpName();
            final Integer cdTimer = thisWarp.getWarpCoolDown() * 20;
            final String playerName = p;
            new BukkitRunnable() {

                @Override
                public void run() {
                    List<String> warps = RpgAPI.warpCds.get(playerName);
                    warps.remove(warpName);
                    RpgAPI.warpCds.remove(playerName);
                    RpgAPI.warpCds.put(playerName, warps);
                }
            }.runTaskLater(RpgAPI.getInstance(), cdTimer);
        }
        for (WarpBehavior behavior : thisWarp.getWarpBehaviors()) {
            behavior.onWarp(p);
        }

    }

    /**
     *
     * @param p
     * @param rWarp
     * @return
     */
    public static Boolean WarpRequirements(Player p, RpgWarp rWarp) {
        Boolean requirements = true;
        if (rWarp.getLevelNeeded()) {
            if (p.getLevel() < rWarp.getWarpLevel()) {
                requirements = false;
            }

        }
        if (rWarp.getSinglePerm()) {
            if (!(p.hasPermission(rWarp.getPermNeeded()))) {
                requirements = false;
            }
        }
        if (RpgAPI.warpCds.containsKey(p.getName())) {
            for (String warpName : RpgAPI.warpCds.get(p.getName())) {
                if (warpName.equalsIgnoreCase(rWarp.getWarpName())) {
                    requirements = false;
                }
            }
        }
        return requirements;
    }
}
