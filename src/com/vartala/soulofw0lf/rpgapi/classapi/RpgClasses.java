package com.vartala.soulofw0lf.rpgapi.classapi;

import com.vartala.soulofw0lf.rpgapi.enumapi.Spell;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulof
 * Date: 6/5/13
 * Time: 8:49 PM
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
public class RpgClasses {

    //class name
    private String className = "";
    //
    //base attack bonus by level
    private Map<Integer, Integer> babList = new HashMap<>();

    //fortitude saves by level
    private Map<Integer, Integer> fortSaves = new HashMap<>();

    //reflex saves by level
    private Map<Integer, Integer> reflexSaves = new HashMap<>();

    //will saves by level
    private Map<Integer, Integer> willSaves = new HashMap<>();

    //slass features by level (listed by name only)
    private Map<Integer, List<String>> classFeatures = new HashMap<>();

    //base hit die
    private Integer hitDie = 0;

    //ammount of skill points per level
    private Integer skillsPerLevel = 0;

    //total spells per combat sorted by class level and spell level
    private Map<Integer, Map<Integer, Integer>> spellsPerCombat = new HashMap<>();

    //total spells known sorted by class level and spell level
    private Map<Integer, Map<Integer, Integer>> spellsKnown = new HashMap<>();

    //which armor types is this class proficient with
    private List<String> armorProficiencies = new ArrayList<String>();

    //which weapon types is this class proficient with
    private List<String> weaponProficiencies = new ArrayList<String>();

    //what skills are in class skills
    private List<String> classSkills = new ArrayList<String>();

    //what speels sorted by level does this class get access to
    private Map<Integer, List<Spell>> classSpells = new HashMap<>();

    //classes text description
    private String classDescription = "";

    //class help file (t.b.d.)
    private Map<String, String> classHelpFile = new HashMap<>();

    /*
     * all getters and setters
     */

    public RpgClasses(){

    }

    public Map<String, String> getClassHelpFile() {
        return classHelpFile;
    }

    public void setClassHelpFile(Map<String, String> classHelpFile) {
        this.classHelpFile = classHelpFile;
    }

    public String getClassDescription() {
        return classDescription;
    }

    public void setClassDescription(String classDescription) {
        this.classDescription = classDescription;
    }

    public Map<Integer, List<Spell>> getClassSpells() {
        return classSpells;
    }

    public void setClassSpells(Map<Integer, List<Spell>> classSpells) {
        this.classSpells = classSpells;
    }

    public List<String> getClassSkills() {
        return classSkills;
    }

    public void setClassSkills(List<String> classSkills) {
        this.classSkills = classSkills;
    }

    public List<String> getWeaponProficiencies() {
        return weaponProficiencies;
    }

    public void setWeaponProficiencies(List<String> weaponProficiencies) {
        this.weaponProficiencies = weaponProficiencies;
    }

    public List<String> getArmorProficiencies() {
        return armorProficiencies;
    }

    public void setArmorProficiencies(List<String> armorProficiencies) {
        this.armorProficiencies = armorProficiencies;
    }

    public Map<Integer, Map<Integer, Integer>> getSpellsKnown() {
        return spellsKnown;
    }

    public void setSpellsKnown(Map<Integer, Map<Integer, Integer>> spellsKnown) {
        this.spellsKnown = spellsKnown;
    }

    public Map<Integer, Map<Integer, Integer>> getSpellsPerCombat() {
        return spellsPerCombat;
    }

    public void setSpellsPerCombat(Map<Integer, Map<Integer, Integer>> spellsPerCombat) {
        this.spellsPerCombat = spellsPerCombat;
    }

    public Integer getSkillsPerLevel() {
        return skillsPerLevel;
    }

    public void setSkillsPerLevel(Integer skillsPerLevel) {
        this.skillsPerLevel = skillsPerLevel;
    }

    public Integer getHitDie() {
        return hitDie;
    }

    public void setHitDie(Integer hitDie) {
        this.hitDie = hitDie;
    }

    public Map<Integer, List<String>> getClassFeatures() {
        return classFeatures;
    }

    public void setClassFeatures(Map<Integer, List<String>> classFeatures) {
        this.classFeatures = classFeatures;
    }

    public Map<Integer, Integer> getWillSaves() {
        return willSaves;
    }

    public void setWillSaves(Map<Integer, Integer> willSaves) {
        this.willSaves = willSaves;
    }

    public Map<Integer, Integer> getReflexSaves() {
        return reflexSaves;
    }

    public void setReflexSaves(Map<Integer, Integer> reflexSaves) {
        this.reflexSaves = reflexSaves;
    }

    public Map<Integer, Integer> getFortSaves() {
        return fortSaves;
    }

    public void setFortSaves(Map<Integer, Integer> fortSaves) {
        this.fortSaves = fortSaves;
    }

    public Map<Integer, Integer> getBabList() {
        return babList;
    }

    public void setBabList(Map<Integer, Integer> babList) {
        this.babList = babList;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
