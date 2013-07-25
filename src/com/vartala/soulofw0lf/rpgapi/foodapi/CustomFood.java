package com.vartala.soulofw0lf.rpgapi.foodapi;

import com.vartala.soulofw0lf.rpgapi.foodapi.FoodBehavior;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulof
 * Date: 6/10/13
 * Time: 9:37 AM
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
public class CustomFood {
    //
    //display name of custom food
    private String foodName = "";

    //food material
    private String foodMaterial = "";

    //food health
    private Integer foodHealth = 0;

    //food time to eat
    private Double timeToEat = 0.0;

    //custom food behaviors
    private List<FoodBehavior> foodBehaviors = new ArrayList<FoodBehavior>();

    //food has a buff?
    private boolean hasBuff = false;

    //food buff potion effects
    private String foodBuff = "";

    //food buff duration
    private Integer buffDuration = 0;

    //food buff strength
    private Integer buffAmp = 0;

    /**
     *
     */
    public CustomFood() {

    }

    /**
     *
     * @return
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     *
     * @param foodName
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     *
     * @return
     */
    public String getFoodMaterial() {
        return foodMaterial;
    }

    /**
     *
     * @param foodMaterial
     */
    public void setFoodMaterial(String foodMaterial) {
        this.foodMaterial = foodMaterial;
    }

    /**
     *
     * @return
     */
    public Integer getFoodHealth() {
        return foodHealth;
    }

    /**
     *
     * @param foodHealth
     */
    public void setFoodHealth(Integer foodHealth) {
        this.foodHealth = foodHealth;
    }

    /**
     *
     * @return
     */
    public Double getTimeToEat() {
        return timeToEat;
    }

    /**
     *
     * @param timeToEat
     */
    public void setTimeToEat(Double timeToEat) {
        this.timeToEat = timeToEat;
    }

    /**
     *
     * @return
     */
    public List<FoodBehavior> getFoodBehaviors() {
        return foodBehaviors;
    }

    /**
     *
     * @param foodBehaviors
     */
    public void setFoodBehaviors(List<FoodBehavior> foodBehaviors) {
        this.foodBehaviors = foodBehaviors;
    }

    /**
     *
     * @return
     */
    public String getFoodBuff() {
        return foodBuff;
    }

    /**
     *
     * @param foodBuff
     */
    public void setFoodBuff(String foodBuff) {
        this.foodBuff = foodBuff;
    }

    /**
     *
     * @return
     */
    public Integer getBuffDuration() {
        return buffDuration;
    }

    /**
     *
     * @param buffDuration
     */
    public void setBuffDuration(Integer buffDuration) {
        this.buffDuration = buffDuration;
    }

    /**
     *
     * @return
     */
    public Integer getBuffAmp() {
        return buffAmp;
    }

    /**
     *
     * @param buffAmp
     */
    public void setBuffAmp(Integer buffAmp) {
        this.buffAmp = buffAmp;
    }

    /**
     *
     * @return
     */
    public boolean isHasBuff() {
        return hasBuff;
    }

    /**
     *
     * @param hasBuff
     */
    public void setHasBuff(boolean hasBuff) {
        this.hasBuff = hasBuff;
    }
}
