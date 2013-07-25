package com.vartala.soulofw0lf.rpgapi.achievementapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulof
 * Date: 6/4/13
 * Time: 7:13 AM
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
public class TitleAchievement {
    //
    //titles associated with an achievement
    private String Achievementtitle = "";

    //description of achievement
    private String Achievementdescription = "";

    //name of achievement
    private String AchievementName = "";

    //commands to be executed on equip, true for player commands, false for console
    private Map<String, Boolean> achievementEquipCommands = new HashMap<>();

    //commands to be executed on unequip, true for player commands, false for console
    private Map<String, Boolean> achievementUnEquipCommands = new HashMap<>();

    //is the title associated with this achievement a prefix true or suffix false
    private boolean isPrefix = true;

    //behaviors to add on equip other than commands?
    private List<EquipBehaviors> equipBehavior = new ArrayList<EquipBehaviors>();

    //behaviors to add on unequip other than commands?
    private List<UnEquipBehaviors> unEquipBehavior = new ArrayList<UnEquipBehaviors>();

    /*
     * all getters and setters
     */

    public TitleAchievement() {

    }

    /**
     *
     * @return
     */
    public List<UnEquipBehaviors> getUnEquipBehavior() {
        return unEquipBehavior;
    }

    /**
     *
     * @param unEquipBehavior
     */
    public void setUnEquipBehavior(List<UnEquipBehaviors> unEquipBehavior) {
        this.unEquipBehavior = unEquipBehavior;
    }

    /**
     *
     * @return
     */
    public List<EquipBehaviors> getEquipBehavior() {
        return equipBehavior;
    }

    /**
     *
     * @param equipBehavior
     */
    public void setEquipBehavior(List<EquipBehaviors> equipBehavior) {
        this.equipBehavior = equipBehavior;
    }

    /**
     *
     * @return
     */
    public boolean isPrefix() {
        return isPrefix;
    }

    /**
     *
     * @param prefix
     */
    public void setPrefix(boolean prefix) {
        isPrefix = prefix;
    }

    /**
     *
     * @return
     */
    public Map<String, Boolean> getAchievementUnEquipCommands() {
        return achievementUnEquipCommands;
    }

    /**
     *
     * @param achievementUnEquipCommands
     */
    public void setAchievementUnEquipCommands(Map<String, Boolean> achievementUnEquipCommands) {
        this.achievementUnEquipCommands = achievementUnEquipCommands;
    }

    /**
     *
     * @return
     */
    public Map<String, Boolean> getAchievementEquipCommands() {
        return achievementEquipCommands;
    }

    /**
     *
     * @param achievementEquipCommands
     */
    public void setAchievementEquipCommands(Map<String, Boolean> achievementEquipCommands) {
        this.achievementEquipCommands = achievementEquipCommands;
    }

    /**
     *
     * @return
     */
    public String getAchievementName() {
        return AchievementName;
    }

    /**
     *
     * @param achievementName
     */
    public void setAchievementName(String achievementName) {
        AchievementName = achievementName;
    }

    /**
     *
     * @return
     */
    public String getAchievementdescription() {
        return Achievementdescription;
    }

    /**
     *
     * @param achievementdescription
     */
    public void setAchievementdescription(String achievementdescription) {
        Achievementdescription = achievementdescription;
    }

    /**
     *
     * @return
     */
    public String getAchievementtitle() {
        return Achievementtitle;
    }

    /**
     *
     * @param achievementtitle
     */
    public void setAchievementtitle(String achievementtitle) {
        Achievementtitle = achievementtitle;
    }
}
