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
    //
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

    public MinionEntity(){

    }

    public Location getMinionSpawn() {
        return minionSpawn;
    }

    public void setMinionSpawn(Location minionSpawn) {
        this.minionSpawn = minionSpawn;
    }

    public List<MinionBehavior> getBehavior() {
        return behavior;
    }

    public void setBehavior(List<MinionBehavior> behavior) {
        this.behavior = behavior;
    }

    public Map<PlayerStat, Integer> getStats() {
        return stats;
    }

    public void setStats(Map<PlayerStat, Integer> stats) {
        this.stats = stats;
    }

    public Map<DamageType, Boolean> getDrTypes() {
        return drTypes;
    }

    public void setDrTypes(Map<DamageType, Boolean> drTypes) {
        this.drTypes = drTypes;
    }

    public Map<DamageType, Boolean> getDmgType() {
        return dmgType;
    }

    public void setDmgType(Map<DamageType, Boolean> dmgType) {
        this.dmgType = dmgType;
    }

    public Map<ElementalType, Boolean> getElemDmgtype() {
        return elemDmgtype;
    }

    public void setElemDmgtype(Map<ElementalType, Boolean> elemDmgtype) {
        this.elemDmgtype = elemDmgtype;
    }

    public Map<ElementalType, Boolean> getElemRestype() {
        return elemRestype;
    }

    public void setElemRestype(Map<ElementalType, Boolean> elemRestype) {
        this.elemRestype = elemRestype;
    }

    public List<Feat> getHasFeats() {
        return hasFeats;
    }

    public void setHasFeats(List<Feat> hasFeats) {
        this.hasFeats = hasFeats;
    }

    public Map<PlayerSkill, Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<PlayerSkill, Integer> skills) {
        this.skills = skills;
    }

    public Map<Spell, Boolean> getSpells() {
        return spells;
    }

    public void setSpells(Map<Spell, Boolean> spells) {
        this.spells = spells;
    }

    public Map<Integer, Integer> getSpellsPerCombat() {
        return spellsPerCombat;
    }

    public void setSpellsPerCombat(Map<Integer, Integer> spellsPerCombat) {
        this.spellsPerCombat = spellsPerCombat;
    }

    public Integer getMinionTimer() {
        return minionTimer;
    }

    public void setMinionTimer(Integer minionTimer) {
        this.minionTimer = minionTimer;
    }

    public String getMinionOwner() {
        return minionOwner;
    }

    public void setMinionOwner(String minionOwner) {
        this.minionOwner = minionOwner;
    }

    public boolean isFriendly() {
        return isFriendly;
    }

    public void setFriendly(boolean friendly) {
        isFriendly = friendly;
    }

    public boolean isSpawned() {
        return isSpawned;
    }

    public void setSpawned(boolean spawned) {
        isSpawned = spawned;
    }

    public List<RpgPlayer> getAgroList() {
        return agroList;
    }

    public void setAgroList(List<RpgPlayer> agroList) {
        this.agroList = agroList;
    }

    public boolean isHasOwner() {
        return hasOwner;
    }

    public void setHasOwner(boolean hasOwner) {
        this.hasOwner = hasOwner;
    }

    public String getMinionType() {
        return minionType;
    }

    public void setMinionType(String minionType) {
        this.minionType = minionType;
    }
}
