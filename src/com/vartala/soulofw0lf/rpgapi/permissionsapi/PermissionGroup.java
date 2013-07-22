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
    private double rank = 0.0;
    private String rankColor = "";
    private List<String> inheritances = new ArrayList<>();

    public List<String> getInheritances() {
        return inheritances;
    }
    public void addInheritance(String s){
        inheritances.add(s);
    }
    public void removeInheritence(String s){
        inheritances.remove(s);
    }
    public void addPerm(String s){
        for (Player p : Bukkit.getOnlinePlayers()){
            RpgPlayer rp = RpgAPI.getRp(p.getName());
            if (rp.getPermGroups().contains(groupName)){
                PermissionAttachment attach = RpgAPI.permAttachments.get(RpgAPI.activeNicks.get(p.getName()));
                attach.setPermission(s, true);
                PermissionAttachment pAttach = RpgAPI.permAttachments.get(p.getName());
                pAttach.setPermission(s, true);
            }

        }
        permissions.add(s);
    }
    public void removePerm(String s){
        for (Player p : Bukkit.getOnlinePlayers()){
            RpgPlayer rp = RpgAPI.getRp(p.getName());
            if (rp.getPermGroups().contains(groupName)){
                PermissionAttachment attach = RpgAPI.permAttachments.get(RpgAPI.activeNicks.get(p.getName()));
                attach.setPermission(s, false);
                PermissionAttachment pAttach = RpgAPI.permAttachments.get(p.getName());
                pAttach.setPermission(s, false);
            }

        }
        permissions.remove(s);
    }

    public void setInheritances(List<String> inheritances) {
        this.inheritances = inheritances;
    }

    public String getRankColor() {
        return rankColor;
    }

    public void setRankColor(String rankColor) {
        this.rankColor = rankColor;
    }

    public double getRank() {
        return rank;
    }

    public void setRank(double rank) {
        this.rank = rank;
    }

    public boolean isDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(boolean defaultGroup) {
        this.defaultGroup = defaultGroup;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public List<String> getDeniedPerms() {
        return deniedPerms;
    }

    public void setDeniedPerms(List<String> deniedPerms) {
        this.deniedPerms = deniedPerms;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }
}
