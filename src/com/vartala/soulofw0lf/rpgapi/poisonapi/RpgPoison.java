package com.vartala.soulofw0lf.rpgapi.poisonapi;

import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 6/20/13
 * Time: 8:03 PM
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
public class RpgPoison {
    //world for poison effect
    private String worldName = "";
    private String poisonName = "";
    private double poisonRadius = 0;
    private double poisonY = 0;
    private double poisonX = 0;
    private double poisonZ = 0;
    private boolean aboveY = false;
    private Integer poisonTickLength = 0;
    private List<PoisonBehavior> poisonBehaviors = new ArrayList<PoisonBehavior>();
    private Map<PotionEffectType, PoisonEffects> effectStats = new HashMap<>();

    public void RpgPoison() {

    }

    public Integer getPoisonTickLength() {
        return poisonTickLength;
    }

    public void setPoisonTickLength(Integer poisonTickLength) {
        this.poisonTickLength = poisonTickLength;
    }


    public boolean isAboveY() {
        return aboveY;
    }

    public void setAboveY(boolean aboveY) {
        this.aboveY = aboveY;
    }

    public double getPoisonY() {
        return poisonY;
    }

    public void setPoisonY(double poisonY) {
        this.poisonY = poisonY;
    }

    public double getPoisonRadius() {
        return poisonRadius;
    }

    public void setPoisonRadius(double poisonRadius) {
        this.poisonRadius = poisonRadius;
    }

    public String getWorldName() {
        return worldName;
    }

    public void setWorldName(String worldName) {
        this.worldName = worldName;
    }

    public String getPoisonName() {
        return poisonName;
    }

    public void setPoisonName(String poisonName) {
        this.poisonName = poisonName;
    }

    public double getPoisonX() {
        return poisonX;
    }

    public void setPoisonX(double poisonX) {
        this.poisonX = poisonX;
    }

    public double getPoisonZ() {
        return poisonZ;
    }

    public void setPoisonZ(double poisonZ) {
        this.poisonZ = poisonZ;
    }


    public List<PoisonBehavior> getPoisonBehaviors() {
        return poisonBehaviors;
    }

    public void setPoisonBehaviors(List<PoisonBehavior> poisonBehaviors) {
        this.poisonBehaviors = poisonBehaviors;
    }

    public Map<PotionEffectType, PoisonEffects> getEffectStats() {
        return effectStats;
    }

    public void setEffectStats(Map<PotionEffectType, PoisonEffects> effectStats) {
        this.effectStats = effectStats;
    }
}
