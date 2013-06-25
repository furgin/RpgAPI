package com.vartala.soulofw0lf.rpgapi.minionapi;

import com.vartala.soulofw0lf.rpgapi.enumapi.*;
import com.vartala.soulofw0lf.rpgapi.enumapi.Spell;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulof
 * Date: 6/4/13
 * Time: 3:59 AM
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
public class MinionEntity {

    //location a minion should spawn at
    private Location minionSpawn;

    //timer after death for a minion to respawn
    private Integer minionTimer = 0;

    //who owns the minion
    private String minionOwner = "";

    //is the minion friendly
    private boolean isFriendly = false;

    //is the minion currently spawned in
    private boolean isSpawned = false;

    //does the minion have an owner
    private boolean hasOwner = false;

    //what is the minions creature type
    private String minionType = "";

    //all players on a minions agro list
    private List<RpgPlayer> agroList = new ArrayList<RpgPlayer>();

    //extra behaviors a minion has
    private List<MinionBehavior> behavior = new ArrayList<MinionBehavior>();

    //a minions list of player stats
    private Map<PlayerStat, Integer> stats = new HashMap<>();

    //a minions damage resistance types
    private Map<DamageType, Boolean> drTypes = new HashMap<>();

    //a minions damage types
    private Map<DamageType, Boolean> dmgType = new HashMap<>();

    //a minions elemental damage types
    private Map<ElementalType, Boolean> elemDmgtype = new HashMap<>();

    //a minions elemental resistance types
    private Map<ElementalType, Boolean> elemRestype = new HashMap<>();

    //all feats a minion has
    private List<Feat> hasFeats = new ArrayList<Feat>();

    //a minions skill levels
    private Map<PlayerSkill, Integer> skills = new HashMap<>();

    //a minions spells known
    private Map<Spell, Boolean> spells = new HashMap<>();

    //a minions spells per combat
    private Map<Integer, Integer> spellsPerCombat = new HashMap<>();

    /**
     *
     * @return returns the Location of the minion's spawn
     */
    public Location getMinionSpawn() {
        return minionSpawn;
    }

    /**
     * Used to set a minion's spawn location
     *
     * @param minionSpawn Location to set to minion's spawn
     */
    public void setMinionSpawn(Location minionSpawn) {
        this.minionSpawn = minionSpawn;
    }

    /**
     * Returns a list of all MinionBehaviors
     *
     * @return a list of all MinionBehaviors
     */
    public List<MinionBehavior> getBehavior() {
        return behavior;
    }

    /**
     * Sets the list the minion's behaviors
     *
     * @param behavior list all of the minion's behaviors
     */
    public void setBehavior(List<MinionBehavior> behavior) {
        this.behavior = behavior;
    }

    /**
     *
     * @return a map of the minion's stats
     */
    public Map<PlayerStat, Integer> getStats() {
        return stats;
    }

    /**
     * Used to set a minion's stats
     *
     * @param stats Map of playerstats and values
     */
    public void setStats(Map<PlayerStat, Integer> stats) {
        this.stats = stats;
    }

    /**
     *
     * @return drTypes
     */
    public Map<DamageType, Boolean> getDrTypes() {
        return drTypes;
    }

    /**
     * Used to set a minion's DR types
     *
     * @param drTypes map with DamageType and value
     */
    public void setDrTypes(Map<DamageType, Boolean> drTypes) {
        this.drTypes = drTypes;
    }

    /**
     *
     * @return map of DamageType and value
     */
    public Map<DamageType, Boolean> getDmgType() {
        return dmgType;
    }

    /**
     * Sets the Damage types for the minion
     *
     * @param dmgType Map of DamageTypes and values
     */
    public void setDmgType(Map<DamageType, Boolean> dmgType) {
        this.dmgType = dmgType;
    }

    /**
     *
     * @return map of elemental damage types and values
     */
    public Map<ElementalType, Boolean> getElemDmgtype() {
        return elemDmgtype;
    }

    /**
     * Used to set the elemental damaage type of a minion
     * 
     * @param elemDmgtype Map of elemental damage types and values
     */
    public void setElemDmgtype(Map<ElementalType, Boolean> elemDmgtype) {
        this.elemDmgtype = elemDmgtype;
    }

    /**
     *
     * @return map of elemental damage types and values
     */
    public Map<ElementalType, Boolean> getElemRestype() {
        return elemRestype;
    }

    /**
     * Used to set the elemental damage resistances of a minion
     *
     * @param elemRestype map of resisted elemental damage types and values
     */
    public void setElemRestype(Map<ElementalType, Boolean> elemRestype) {
        this.elemRestype = elemRestype;
    }

    /**
     *
     * @return a list of all Feats the minion has
     */
    public List<Feat> getHasFeats() {
        return hasFeats;
    }

    /**
     * Used to set the feats the minion has
     *
     * @param hasFeats list of feats the minion has
     */
    public void setHasFeats(List<Feat> hasFeats) {
        this.hasFeats = hasFeats;
    }

    /**
     *
     * @return map of PlayerSkill and values
     */
    public Map<PlayerSkill, Integer> getSkills() {
        return skills;
    }

    /**
     * Used to set the skills of a minion
     *
     * @param skills Map of PlayerSkill and values
     */
    public void setSkills(Map<PlayerSkill, Integer> skills) {
        this.skills = skills;
    }

    /**
     *
     * @return spells and values
     */
    public Map<Spell, Boolean> getSpells() {
        return spells;
    }

    /**
     * Used to set the spells for a minion
     *
     * @param spells map of spells and values
     */
    public void setSpells(Map<Spell, Boolean> spells) {
        this.spells = spells;
    }

    /**
     *
     * @return map of spells per combat cycle
     */
    public Map<Integer, Integer> getSpellsPerCombat() {
        return spellsPerCombat;
    }

    /**
     * Used to set the spells per combat cycle
     *
     * @param spellsPerCombat map of spells per combat cycle
     */
    public void setSpellsPerCombat(Map<Integer, Integer> spellsPerCombat) {
        this.spellsPerCombat = spellsPerCombat;
    }

    /**
     *
     * @return the minion timer
     */
    public Integer getMinionTimer() {
        return minionTimer;
    }

    /**
     * Used to set the minion timer of a minon
     *
     * @param minionTimer the minionTimer
     */
    public void setMinionTimer(Integer minionTimer) {
        this.minionTimer = minionTimer;
    }

    /**
     *
     * @return the name of the minion owner
     */
    public String getMinionOwner() {
        return minionOwner;
    }

    /**
     * Used to set the name of the minion's owner
     *
     * @param minionOwner the name of the minion's owner
     */
    public void setMinionOwner(String minionOwner) {
        this.minionOwner = minionOwner;
    }

    /**
     *
     * @return if the minion is friendly or not
     */
    public boolean isFriendly() {
        return isFriendly;
    }

    /**
     * Used to set if the minion is friendly or not
     *
     * @param friendly value
     */
    public void setFriendly(boolean friendly) {
        isFriendly = friendly;
    }

    /**
     * checks to see if the minion is spawned
     *
     * @return true if is indeed spawned, false otherwise
     */
    public boolean isSpawned() {
        return isSpawned;
    }

    /**
     * Sets that the minion is spawned
     *
     * @param spawned true if spawned, false otherwise
     */
    public void setSpawned(boolean spawned) {
        isSpawned = spawned;
    }

    /**
     *
     * @return List of RpgPlayers the minion is currently aggroing
     */
    public List<RpgPlayer> getAgroList() {
        return agroList;
    }

    /**
     * Sets the agro list of this mob
     *
     * @param agroList list of RpgPlayers to be agro at
     */
    public void setAgroList(List<RpgPlayer> agroList) {
        this.agroList = agroList;
    }

    /**
     *
     * @return if the minion has an owner
     */
    public boolean isHasOwner() {
        return hasOwner;
    }

    /**
     * Sets if the minion has an owner
     *
     * @param hasOwner true if has an owner, false otherwise
     */
    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    /**
     *
     * @return the miniontype of the minion
     */
    public String getMinionType() {
        return minionType;
    }

    /**
     * Used to set the miniontype of the minion
     *
     * @param minionType the minionType
     */
    public void setMinionType(String minionType) {
        this.minionType = minionType;
    }
}
