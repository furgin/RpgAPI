package com.vartala.soulofw0lf.rpgapi.diseaseapi;

import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 7/29/13
 * Time: 7:49 PM
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
public class Disease {
    private List<PotionEffect> diseasePots = new ArrayList<>();
    private String diseaseName = "";
    private boolean spreadable = false;
    private boolean airSpread = false;
    private double airSpreadChance = 0.0;
    private double spreadDistance = 0.0;
    private boolean hitSpread = false;
    private double hitSpreadChance = 0.0;
    private boolean stackable = false;
    private boolean fatal = false;
    private int ticksBeforeDeath = 0;
    private boolean getsWorse = false;
    private boolean effectDamage = false;
    private double adjustDamage = 0.0;
    private boolean miss = false;
    private double missChance = 0.0;
    private boolean effectDamageTaken = false;
    private double adjustDamageTaken = 0.0;
    private String progressiveDisease = "";
    private int diseaseTime = 0;
    private boolean dot = false;
    private double dotDamage = 0.0;
    private int dotTimer = 0;
    private int progressionTime = 0;
    private String regressiveDisease = "";
    private int severity = 0;
    private boolean healthEffect = false;
    private double healthChange = 0.0;
    private List<DiseaseBehavior> behaviors = new ArrayList<>();
    public Disease(){

    }

    public List<PotionEffect> getDiseasePots() {
        return diseasePots;
    }

    public void setDiseasePots(List<PotionEffect> diseasePots) {
        this.diseasePots = diseasePots;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public boolean isSpreadable() {
        return spreadable;
    }

    public void setSpreadable(boolean spreadable) {
        this.spreadable = spreadable;
    }

    public boolean isAirSpread() {
        return airSpread;
    }

    public void setAirSpread(boolean airSpread) {
        this.airSpread = airSpread;
    }

    public boolean isHitSpread() {
        return hitSpread;
    }

    public void setHitSpread(boolean hitSpread) {
        this.hitSpread = hitSpread;
    }

    public boolean isStackable() {
        return stackable;
    }

    public void setStackable(boolean stackable) {
        this.stackable = stackable;
    }

    public boolean isFatal() {
        return fatal;
    }

    public void setFatal(boolean fatal) {
        this.fatal = fatal;
    }

    public boolean isGetsWorse() {
        return getsWorse;
    }

    public void setGetsWorse(boolean getsWorse) {
        this.getsWorse = getsWorse;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public double getHealthChange() {
        return healthChange;
    }

    public void setHealthChange(double healthChange) {
        this.healthChange = healthChange;
    }

    public List<DiseaseBehavior> getBehaviors() {
        return behaviors;
    }

    public void setBehaviors(List<DiseaseBehavior> behaviors) {
        this.behaviors = behaviors;
    }

    public String getRegressiveDisease() {
        return regressiveDisease;
    }

    public void setRegressiveDisease(String regressiveDisease) {
        this.regressiveDisease = regressiveDisease;
    }

    public String getProgressiveDisease() {
        return progressiveDisease;
    }

    public void setProgressiveDisease(String progressiveDisease) {
        this.progressiveDisease = progressiveDisease;
    }

    public int getProgressionTime() {
        return progressionTime;
    }

    public void setProgressionTime(int progressionTime) {
        this.progressionTime = progressionTime;
    }

    public double getHitSpreadChance() {
        return hitSpreadChance;
    }

    public void setHitSpreadChance(double hitSpreadChance) {
        this.hitSpreadChance = hitSpreadChance;
    }

    public double getAirSpreadChance() {
        return airSpreadChance;
    }

    public void setAirSpreadChance(double airSpreadChance) {
        this.airSpreadChance = airSpreadChance;
    }

    public double getSpreadDistance() {
        return spreadDistance;
    }

    public void setSpreadDistance(double spreadDistance) {
        this.spreadDistance = spreadDistance;
    }

    public boolean hasHealthEffect() {
        return healthEffect;
    }

    public void setHealthEffect(boolean healthEffect) {
        this.healthEffect = healthEffect;
    }

    public int getDiseaseTime() {
        return diseaseTime;
    }

    public void setDiseaseTime(int diseaseTime) {
        this.diseaseTime = diseaseTime;
    }

    public boolean isDot() {
        return dot;
    }

    public void setDot(boolean dot) {
        this.dot = dot;
    }

    public double getDotDamage() {
        return dotDamage;
    }

    public void setDotDamage(double dotDamage) {
        this.dotDamage = dotDamage;
    }

    public int getDotTimer() {
        return dotTimer;
    }

    public void setDotTimer(int dotTimer) {
        this.dotTimer = dotTimer;
    }

    public int getTicksBeforeDeath() {
        return ticksBeforeDeath;
    }

    public void setTicksBeforeDeath(int ticksBeforeDeath) {
        this.ticksBeforeDeath = ticksBeforeDeath;
    }

    public boolean isEffectDamage() {
        return effectDamage;
    }

    public void setEffectDamage(boolean effectDamage) {
        this.effectDamage = effectDamage;
    }

    public double getAdjustDamage() {
        return adjustDamage;
    }

    public void setAdjustDamage(double adjustDamage) {
        this.adjustDamage = adjustDamage;
    }

    public boolean isMiss() {
        return miss;
    }

    public void setMiss(boolean miss) {
        this.miss = miss;
    }

    public double getMissChance() {
        return missChance;
    }

    public void setMissChance(double missChance) {
        this.missChance = missChance;
    }

    public boolean isEffectDamageTaken() {
        return effectDamageTaken;
    }

    public void setEffectDamageTaken(boolean effectDamageTaken) {
        this.effectDamageTaken = effectDamageTaken;
    }

    public double getAdjustDamageTaken() {
        return adjustDamageTaken;
    }

    public void setAdjustDamageTaken(double adjustDamageTaken) {
        this.adjustDamageTaken = adjustDamageTaken;
    }
}
