package com.vartala.soulofw0lf.rpgapi.spellapi;

import com.vartala.soulofw0lf.rpgapi.enumapi.Spell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulof
 * Date: 6/4/13
 * Time: 7:50 AM
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
 */         //
public class MagicSpell {
    private String spellName = "";
    private Integer spellLevel = 0;
    private List<MagicSchool> spellSchools = new ArrayList<MagicSchool>();
    private String spellDescription = "";
    private List<String> spellText = new ArrayList<String>();
    private Integer castingTime = 0;
    private boolean componentsNeeded = false;
    private Map<SpellComponentItem, Integer> spellComponents = new HashMap<>();
    private List<SpellComponent> spellComponentTypes = new ArrayList<SpellComponent>();
    private Integer spellRadius = 0;
    private List<SpellRange> spellRange = new ArrayList<SpellRange>();
    private Integer numberOfTargets = 0;
    private boolean selfOnly = false;
    private boolean friendlyFire = false;
    private boolean alliesOnly = false;
    private Integer spellDuration = 0;
    private List<SpellTarget> targetsOfSpell = new ArrayList<SpellTarget>();
    private List<SpellBehaviors> spellBehavior = new ArrayList<SpellBehaviors>();
    public MagicSpell(){

    }

    public List<SpellBehaviors> getSpellBehavior() {
        return spellBehavior;
    }

    public void setSpellBehavior(List<SpellBehaviors> spellBehavior) {
        this.spellBehavior = spellBehavior;
    }

    public List<SpellTarget> getTargetsOfSpell() {
        return targetsOfSpell;
    }

    public void setTargetsOfSpell(List<SpellTarget> targetsOfSpell) {
        this.targetsOfSpell = targetsOfSpell;
    }

    public Integer getSpellDuration() {
        return spellDuration;
    }

    public void setSpellDuration(Integer spellDuration) {
        this.spellDuration = spellDuration;
    }

    public boolean isAlliesOnly() {
        return alliesOnly;
    }

    public void setAlliesOnly(boolean alliesOnly) {
        this.alliesOnly = alliesOnly;
    }

    public boolean isFriendlyFire() {
        return friendlyFire;
    }

    public void setFriendlyFire(boolean friendlyFire) {
        this.friendlyFire = friendlyFire;
    }

    public boolean isSelfOnly() {
        return selfOnly;
    }

    public void setSelfOnly(boolean selfOnly) {
        this.selfOnly = selfOnly;
    }

    public Integer getNumberOfTargets() {
        return numberOfTargets;
    }

    public void setNumberOfTargets(Integer numberOfTargets) {
        this.numberOfTargets = numberOfTargets;
    }

    public List<SpellRange> getSpellRange() {
        return spellRange;
    }

    public void setSpellRange(List<SpellRange> spellRange) {
        this.spellRange = spellRange;
    }

    public Integer getSpellRadius() {
        return spellRadius;
    }

    public void setSpellRadius(Integer spellRadius) {
        this.spellRadius = spellRadius;
    }

    public List<SpellComponent> getSpellComponentTypes() {
        return spellComponentTypes;
    }

    public void setSpellComponentTypes(List<SpellComponent> spellComponentTypes) {
        this.spellComponentTypes = spellComponentTypes;
    }

    public Map<SpellComponentItem, Integer> getSpellComponents() {
        return spellComponents;
    }

    public void setSpellComponents(Map<SpellComponentItem, Integer> spellComponents) {
        this.spellComponents = spellComponents;
    }

    public boolean isComponentsNeeded() {
        return componentsNeeded;
    }

    public void setComponentsNeeded(boolean componentsNeeded) {
        this.componentsNeeded = componentsNeeded;
    }

    public Integer getCastingTime() {
        return castingTime;
    }

    public void setCastingTime(Integer castingTime) {
        this.castingTime = castingTime;
    }

    public Integer getSpellLevel() {
        return spellLevel;
    }

    public void setSpellLevel(Integer spellLevel) {
        this.spellLevel = spellLevel;
    }

    public List<String> getSpellText() {
        return spellText;
    }

    public void setSpellText(List<String> spellText) {
        this.spellText = spellText;
    }

    public String getSpellDescription() {
        return spellDescription;
    }

    public void setSpellDescription(String spellDescription) {
        this.spellDescription = spellDescription;
    }

    public List<MagicSchool> getSpellSchools() {
        return spellSchools;
    }

    public void setSpellSchools(List<MagicSchool> spellSchools) {
        this.spellSchools = spellSchools;
    }

    public String getSpellName() {
        return spellName;
    }

    public void setSpellName(String spellName) {
        this.spellName = spellName;
    }
}
