package com.vartala.soulofw0lf.rpgapi.loaders;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.util.HelpFile;
import com.vartala.soulofw0lf.rpgapi.warpsapi.WarpBuilder;
import com.vartala.soulofw0lf.rpgapi.warpsapi.WarpSetBuilder;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 7/8/13
 * Time: 6:20 PM
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
public class WarpLoader{
    /**
     *
     */
    public WarpLoader(){
        YamlConfiguration warpLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgWarps/Locale/WarpConfig.yml"));
        warpLocaleConfig.set("Warp Commands.Set Warp.Alias", "setwarp");
        warpLocaleConfig.set("Warp Commands.Set Warp.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Set Warp.Description", "&fSet a new Warp Point. &2Usage: &f/setwarp warpname");

        warpLocaleConfig.set("Warp Commands.Delete Warp.Alias", "delwarp");
        warpLocaleConfig.set("Warp Commands.Delete Warp.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Delete Warp.Description", "&fDelete a Warp Point. &2Usage: &f/delwarp warpname");

        warpLocaleConfig.set("Warp Commands.Use Warp.Alias", "warp");
        warpLocaleConfig.set("Warp Commands.Use Warp.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Use Warp.Description", "&fUse a Warp Point. &2Usage: &f/warp warpname");

        warpLocaleConfig.set("Warp Commands.Save Warp.Alias", "savewarp");
        warpLocaleConfig.set("Warp Commands.Save Warp.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Save Warp.Description", "&fSave a specific Warp Point to config. &2Usage: &f/savewarp warpname");

        warpLocaleConfig.set("Warp Commands.Edit Warp.Alias", "editwarp");
        warpLocaleConfig.set("Warp Commands.Edit Warp.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Edit Warp.Description", "&fEdit the attributes of a Warp Point. &2Usage: &f/editwarp warpname <Cd | World | Level | Perm | Variance | item> <true/false>");

        warpLocaleConfig.set("Warp Commands.Edit set.Alias", "editset");
        warpLocaleConfig.set("Warp Commands.Edit set.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Edit set.Description", "&fEdit the attributes of a Warp Set. &2Usage: &f/editset setname <values coming soon>");

        warpLocaleConfig.set("Warp Commands.Make Set.Alias", "makeset");
        warpLocaleConfig.set("Warp Commands.Make Set.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Make Set.Description", "&fMake a new Warp Set. &2Usage: &f/makeset setname");

        warpLocaleConfig.set("Warp Commands.Delete set.Alias", "delset");
        warpLocaleConfig.set("Warp Commands.Delete set.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Delete set.Description", "&fdelete a warp set &4Warning!!! This deletes all Warps in the set!!!. &2Usage: &f/delset setname");

        warpLocaleConfig.set("Warp Commands.Load Warps.Alias", "loadwarps");
        warpLocaleConfig.set("Warp Commands.Load Warps.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Load Warps.Description", "&fLoad all warps and sets from config: &f/loadwarps");

        warpLocaleConfig.set("Warp Commands.List Warps.Alias", "listwarps");
        warpLocaleConfig.set("Warp Commands.List Warps.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.List Warps.Description", "&fList all warps that are saved: &f/listwarps");

        warpLocaleConfig.set("Warp Commands.Edit Warp Values.Alias", "warpvalues");
        warpLocaleConfig.set("Warp Commands.Edit Warp Values.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Edit Warp Values.Description", "Edit the attributes of a Warp Point. &2Usage: &f/editwarp warpname <Cd |Level | Perm | Variance | Material | iName | iLore> <Value_settings>");

        warpLocaleConfig.set("Warp Messages.Warp Stub", "&f[&4Rpg Warps&f]&2");
        warpLocaleConfig.set("Warp Messages.Warps Loaded", "All warps have been loaded!");
        warpLocaleConfig.set("Warp Messages.Warp Placed", "You have made a warp named @w");

    try {
        warpLocaleConfig.save(new File("plugins/RpgWarps/Locale/WarpConfig.yml"));
    } catch (IOException e) {
        System.out.print(e);
    }
    //after file is saved
        for (String message : warpLocaleConfig.getConfigurationSection("Warp Messages").getKeys(false)){
            RpgAPI.localeSettings.put(message, warpLocaleConfig.getString("Warp Messages." + message));
        }
        List<String> warpCommands = new ArrayList<>();
        for (String command : warpLocaleConfig.getConfigurationSection("Warp Commands").getKeys(false)) {
            String commandRT = warpLocaleConfig.getString("Warp Commands." + command + ".Alias");
            String helpColor = warpLocaleConfig.getString("Warp Commands." + command + ".Help Color");
            String descText = warpLocaleConfig.getString("Warp Commands." + command + ".Description");
            HelpFile cmd = new HelpFile();
            cmd.setCmdAlias(commandRT);
            cmd.setAliasColor(helpColor);
            cmd.setDescription(descText);
            cmd.setHelpGroup("Warp Commands");
            RpgAPI.helpMap.add(cmd);
            RpgAPI.commands.add(commandRT);
            RpgAPI.commandSettings.put(command, commandRT);
            warpCommands.add(commandRT);
        }
        RpgAPI.pluginCommand.put("Warp Commands", warpCommands);
        WarpSetBuilder.BuildSets();
        new BukkitRunnable() {
            @Override
            public void run() {
                WarpBuilder.WarpLoader();
            }
        }.runTaskLater(RpgAPI.getInstance(), 5);
    }
}
