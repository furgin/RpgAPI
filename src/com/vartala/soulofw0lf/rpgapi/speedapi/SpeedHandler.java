package com.vartala.soulofw0lf.rpgapi.speedapi;

import com.vartala.soulofw0lf.rpgapi.enumapi.PlayerStat;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by: soulofw0lf
 * Date: 6/23/13
 * Time: 4:24 PM
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
public class SpeedHandler {
    public static void SetWalkSpeed(RpgPlayer rp){
        Player p = Bukkit.getPlayer(rp.getRealName());
        Integer walkingSpeed = rp.getStats().get(PlayerStat.SPEED_LAND);
        Integer encumberedSpeed = rp.getStats().get(PlayerStat.SPEED_LAND_WITH_ARMOR);
        Integer speed = 0;
        if (rp.getEncumbered()){
           speed = encumberedSpeed;
        } else {
            speed = walkingSpeed;
        }
        if (speed >= 110){
            p.setWalkSpeed(0.84f);
        }
        if (speed == 105){
            p.setWalkSpeed(0.80f);
        }
        if (speed == 100){
            p.setWalkSpeed(0.76f);
        }
        if (speed == 95){
            p.setWalkSpeed(0.72f);
        }
        if (speed == 90){
            p.setWalkSpeed(0.68f);
        }
        if (speed == 85){
            p.setWalkSpeed(0.64f);
        }
        if (speed == 80){
            p.setWalkSpeed(0.60f);
        }
        if (speed == 75){
            p.setWalkSpeed(0.56f);
        }
        if (speed == 70){
            p.setWalkSpeed(0.52f);
        }
        if (speed == 65){
            p.setWalkSpeed(0.48f);
        }
        if (speed == 60){
            p.setWalkSpeed(0.44f);
        }
        if (speed == 55){
            p.setWalkSpeed(0.40f);
        }
        if (speed == 50){
            p.setWalkSpeed(0.36f);
        }
        if (speed == 45){
            p.setWalkSpeed(0.32f);
        }
        if (speed == 40){
            p.setWalkSpeed(0.28f);
        }
        if (speed == 35){
            p.setWalkSpeed(0.24f);
        }
        if (speed == 30){
            p.setWalkSpeed(0.2f);
        }
        if (speed == 25){
            p.setWalkSpeed(0.16f);
        }
        if (speed == 20){
            p.setWalkSpeed(0.12f);
        }
        if (speed == 15){
            p.setWalkSpeed(0.8f);
        }
        if (speed == 10){
            p.setWalkSpeed(0.4f);
        }
        if (speed == 5){
            p.setWalkSpeed(0.1f);
        }
        if (speed == 0){
            p.setWalkSpeed(0.0f);
        }
    }
}
