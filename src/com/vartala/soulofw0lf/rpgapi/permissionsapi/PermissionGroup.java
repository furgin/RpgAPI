package com.vartala.soulofw0lf.rpgapi.permissionsapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 7/21/13
 * Time: 2:01 PM
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
public class PermissionGroup {
    private List<String> permissions = new ArrayList<>();
    private List<String> deniedPerms = new ArrayList<>();
    private String groupName = "";
    private boolean defaultGroup = false;
    private boolean defaultPlayer = false;
    private boolean defaultDonator = false;
    private boolean defaultMediumDonator = false;
    private boolean defaultHighDonator = false;
    private boolean defaultModerator = false;
    private boolean defaultAdmin = false;
    private boolean defaultOp = false;
    private double rank = 0.0;
    private String rankColor = "";
    private List<String> worlds = new ArrayList<>();
    private List<String> inheritances = new ArrayList<>();

    /**
     *
     * @return
     */
    public List<String> getInheritances() {
        return inheritances;
    }

    /**
     *
     * @param s
     */
    public void addInheritance(String s){
        inheritances.add(s);
    }

    /**
     *
     * @param s
     */
    public void removeInheritence(String s){
        inheritances.remove(s);
    }

    /**
     *
     * @param s
     * @param world
     */
    public void addPerm(String s, String world){
        for (Player p : Bukkit.getOnlinePlayers()){
            RpgPlayer rp = RpgAPI.getRp(p.getName());
            if (rp.getPermGroups().get(world).contains(groupName)){
                PermissionAttachment attach = RpgAPI.permAttachments.get(RpgAPI.activeNicks.get(p.getName()));
                attach.setPermission(s, true);
                PermissionAttachment pAttach = RpgAPI.permAttachments.get(p.getName());
                pAttach.setPermission(s, true);
            }
        }
        permissions.add(s);
    }

    /**
     *
     * @param s
     * @param world
     */
    public void removePerm(String s, String world){
        for (Player p : Bukkit.getOnlinePlayers()){
            RpgPlayer rp = RpgAPI.getRp(p.getName());
            if (rp.getPermGroups().get(world).contains(groupName)){
                PermissionAttachment attach = RpgAPI.permAttachments.get(RpgAPI.activeNicks.get(p.getName()));
                attach.setPermission(s, false);
                PermissionAttachment pAttach = RpgAPI.permAttachments.get(p.getName());
                pAttach.setPermission(s, false);
            }

        }
        permissions.remove(s);
    }

    /**
     *
     * @param inheritances
     */
    public void setInheritances(List<String> inheritances) {
        this.inheritances = inheritances;
    }

    /**
     *
     * @return
     */
    public String getRankColor() {
        return rankColor;
    }

    /**
     *
     * @param rankColor
     */
    public void setRankColor(String rankColor) {
        this.rankColor = rankColor;
    }

    /**
     *
     * @return
     */
    public double getRank() {
        return rank;
    }

    /**
     *
     * @param rank
     */
    public void setRank(double rank) {
        this.rank = rank;
    }

    /**
     *
     * @return
     */
    public boolean isDefaultGroup() {
        return defaultGroup;
    }

    /**
     *
     * @param defaultGroup
     */
    public void setDefaultGroup(boolean defaultGroup) {
        this.defaultGroup = defaultGroup;
    }

    /**
     *
     * @return
     */
    public String getGroupName() {
        return groupName;
    }

    /**
     *
     * @param groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     *
     * @return
     */
    public List<String> getDeniedPerms() {
        return deniedPerms;
    }

    /**
     *
     * @param deniedPerms
     */
    public void setDeniedPerms(List<String> deniedPerms) {
        this.deniedPerms = deniedPerms;
    }

    /**
     *
     * @return
     */
    public List<String> getPermissions() {
        return permissions;
    }

    /**
     *
     * @param permissions
     */
    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    /**
     *
     * @return
     */
    public List<String> getWorlds() {
        return worlds;
    }

    /**
     *
     * @param worlds
     */
    public void setWorlds(List<String> worlds) {
        this.worlds = worlds;
    }

    /**
     *
     * @return
     */
    public boolean isDefaultOp() {
        return defaultOp;
    }

    /**
     *
     * @param defaultOp
     */
    public void setDefaultOp(boolean defaultOp) {
        this.defaultOp = defaultOp;
    }

    /**
     *
     * @return
     */
    public boolean isDefaultAdmin() {
        return defaultAdmin;
    }

    /**
     *
     * @param defaultAdmin
     */
    public void setDefaultAdmin(boolean defaultAdmin) {
        this.defaultAdmin = defaultAdmin;
    }

    /**
     *
     * @return
     */
    public boolean isDefaultModerator() {
        return defaultModerator;
    }

    /**
     *
     * @param defaultModerator
     */
    public void setDefaultModerator(boolean defaultModerator) {
        this.defaultModerator = defaultModerator;
    }

    /**
     *
     * @return
     */
    public boolean isDefaultHighDonator() {
        return defaultHighDonator;
    }

    /**
     *
     * @param defaultHighDonator
     */
    public void setDefaultHighDonator(boolean defaultHighDonator) {
        this.defaultHighDonator = defaultHighDonator;
    }

    /**
     *
     * @return
     */
    public boolean isDefaultMediumDonator() {
        return defaultMediumDonator;
    }

    /**
     *
     * @param defaultMediumDonator
     */
    public void setDefaultMediumDonator(boolean defaultMediumDonator) {
        this.defaultMediumDonator = defaultMediumDonator;
    }

    /**
     *
     * @return
     */
    public boolean isDefaultDonator() {
        return defaultDonator;
    }

    /**
     *
     * @param defaultDonator
     */
    public void setDefaultDonator(boolean defaultDonator) {
        this.defaultDonator = defaultDonator;
    }

    /**
     *
     * @return
     */
    public boolean isDefaultPlayer() {
        return defaultPlayer;
    }

    /**
     *
     * @param defaultPlayer
     */
    public void setDefaultPlayer(boolean defaultPlayer) {
        this.defaultPlayer = defaultPlayer;
    }
}
