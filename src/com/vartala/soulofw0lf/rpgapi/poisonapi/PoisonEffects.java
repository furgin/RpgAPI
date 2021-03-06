package com.vartala.soulofw0lf.rpgapi.poisonapi;

/**
 * Created by: soulofw0lf
 * Date: 6/21/13
 * Time: 1:39 AM
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
public class PoisonEffects {
    private String effectName = "";
    private Integer duration = 0;
    private Integer strength = 0;

    /**
     *
     */
    public PoisonEffects() {

    }

    /**
     *
     * @return
     */
    public Integer getStrength() {
        return strength;
    }

    /**
     *
     * @param strength
     */
    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    /**
     *
     * @return
     */
    public Integer getDuration() {
        return duration;
    }

    /**
     *
     * @param duration
     */
    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    /**
     *
     * @return
     */
    public String getEffectName() {
        return effectName;
    }

    /**
     *
     * @param effectName
     */
    public void setEffectName(String effectName) {
        this.effectName = effectName;
    }
}
