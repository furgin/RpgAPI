package com.vartala.soulofw0lf.rpgapi.permissionsapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 7/21/13
 * Time: 3:28 PM
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
public class PermHandler {
    public Boolean permCommands(){

        return false;
    }
    @SuppressWarnings("unchecked")
    public void loadPerms(){
        YamlConfiguration groupConfig =  YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Permissions/Groups.yml"));
        if (groupConfig.getString("Groups") == null){
            groupConfig.set("Groups.Default.Default", true);
            List<String> perms = new ArrayList<>();
            groupConfig.set("Groups.Default.Permissions", perms);
            List<String> deniedPerms = new ArrayList<>();
            groupConfig.set("Groups.Default.Denied Permissions", deniedPerms);
            List<String> inheritances = new ArrayList<>();
            groupConfig.set("Groups.Default.Inheritances", inheritances);
            groupConfig.set("Groups.Default.Rank Number", 0.01);
            groupConfig.set("Groups.Default.Rank Color", "&f");
        }
        try {
            groupConfig.save(new File("plugins/RpgAPI/Permissions/Groups.yml"));
        } catch (IOException e){

        }
        for (String key : groupConfig.getConfigurationSection("Groups").getKeys(false)){
            PermissionGroup pG = new PermissionGroup();
            pG.setDefaultGroup(groupConfig.getBoolean("Groups." + key + ".Defalut"));
            if (groupConfig.getList("Groups." + key + ".Denied Permissions") != null){
                pG.setDeniedPerms((List<String>)groupConfig.getList("Groups." + key + ".Denied Permissions"));
            }
            if (groupConfig.getList("Groups." + key + ".Permissions") != null){
                pG.setPermissions((List<String>)groupConfig.getList("Groups." + key + ".Permissions"));
            }
            pG.setRank(groupConfig.getDouble("Groups." + key + ".Rank.Number"));
            pG.setRankColor(groupConfig.getString("Groups." + key + ".Rank.Color"));
            RpgAPI.permGroups.put(key, pG);
        }
        System.out.print("Permissions loaded.");

    }
    public void savePerms(){
        YamlConfiguration groupConfig =  YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Permissions/Groups.yml"));
        for (String group : RpgAPI.permGroups.keySet()){
            PermissionGroup pG = RpgAPI.permGroups.get(group);
            groupConfig.set("Groups." + pG.getGroupName() + ".Default", pG.isDefaultGroup());
            groupConfig.set("Groups." + pG.getGroupName() + ".Permissions", pG.getPermissions());
            groupConfig.set("Groups." + pG.getGroupName() + ".Denied Permissions", pG.getDeniedPerms());
            groupConfig.set("Groups." + pG.getGroupName() + ".Inheritances", pG.getInheritances());
            groupConfig.set("Groups." + pG.getGroupName() + ".Rank.Number", pG.getRank());
            groupConfig.set("Groups." + pG.getGroupName() + ".Rank.Color", pG.getRankColor());
        }
        try {
            groupConfig.save(new File("plugins/RpgAPI/Permissions/Groups.yml"));
        } catch (IOException e){

        }
    }
}
