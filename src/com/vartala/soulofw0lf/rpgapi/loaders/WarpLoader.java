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
        warpLocaleConfig.set("Warp Commands.Set Warp.Permission", "warp.set");

        warpLocaleConfig.set("Warp Commands.Delete Warp.Alias", "delwarp");
        warpLocaleConfig.set("Warp Commands.Delete Warp.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Delete Warp.Description", "&fDelete a Warp Point. &2Usage: &f/delwarp warpname");
        warpLocaleConfig.set("Warp Commands.Delete Warp.Permission", "warp.delete");

        warpLocaleConfig.set("Warp Commands.Use Warp.Alias", "warp");
        warpLocaleConfig.set("Warp Commands.Use Warp.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Use Warp.Description", "&fUse a Warp Point. &2Usage: &f/warp warpname");
        warpLocaleConfig.set("Warp Commands.Use Warp.Permission", "warp");

        warpLocaleConfig.set("Warp Commands.Warp Back.Alias", "back");
        warpLocaleConfig.set("Warp Commands.Warp Back.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Warp Back.Description", "&fGo back to your last Location. &2Usage: &f/back");
        warpLocaleConfig.set("Warp Commands.Warp Back.Permission", "warp.back");
        warpLocaleConfig.set("Warp Commands.Warp Back On Death.Permission", "warp.back.death");

        warpLocaleConfig.set("Warp Commands.Save Warp.Alias", "savewarp");
        warpLocaleConfig.set("Warp Commands.Save Warp.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Save Warp.Description", "&fSave a specific Warp Point to config. &2Usage: &f/savewarp warpname");
        warpLocaleConfig.set("Warp Commands.Save Warp.Permission", "warp.save");

        warpLocaleConfig.set("Warp Commands.Edit Warp.Alias", "editwarp");
        warpLocaleConfig.set("Warp Commands.Edit Warp.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Edit Warp.Description", "&fEdit the attributes of a Warp Point. &2Usage: &f/editwarp warpname <Cd | World | Level | Perm | Variance | item> <true/false>");
        warpLocaleConfig.set("Warp Commands.Edit Warp.Permission", "warp.edit");

        warpLocaleConfig.set("Warp Commands.Edit Set.Alias", "editset");
        warpLocaleConfig.set("Warp Commands.Edit Set.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Edit Set.Description", "&fEdit the attributes of a Warp Set. &2Usage: &f/editset setname <perm | random> <permission | true/false");
        warpLocaleConfig.set("Warp Commands.Edit Set.Permission", "warpset.edit");

        warpLocaleConfig.set("Warp Commands.Make Set.Alias", "makeset");
        warpLocaleConfig.set("Warp Commands.Make Set.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Make Set.Description", "&fMake a new Warp Set. &2Usage: &f/makeset setname");
        warpLocaleConfig.set("Warp Commands.Make Set.Permission", "warpset.new");

        warpLocaleConfig.set("Warp Commands.Delete Set.Alias", "delset");
        warpLocaleConfig.set("Warp Commands.Delete Set.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Delete Set.Description", "&fdelete a warp set &4Warning!!! This moves all Warps in the set to the default set!!!. &2Usage: &f/delset setname");
        warpLocaleConfig.set("Warp Commands.Delete Set.Permission", "warpset.delete");

        warpLocaleConfig.set("Warp Commands.Load Warps.Alias", "loadwarps");
        warpLocaleConfig.set("Warp Commands.Load Warps.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Load Warps.Description", "&fLoad all warps and sets from config: &f/loadwarps");
        warpLocaleConfig.set("Warp Commands.Load Warps.Permission", "warps.load");

        warpLocaleConfig.set("Warp Commands.List Warps.Alias", "listwarps");
        warpLocaleConfig.set("Warp Commands.List Warps.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.List Warps.Description", "&fList all warps that are saved: &f/listwarps");
        warpLocaleConfig.set("Warp Commands.List Warps.Permission", "warps.list");

        warpLocaleConfig.set("Warp Commands.Edit Warp Values.Alias", "warpvalues");
        warpLocaleConfig.set("Warp Commands.Edit Warp Values.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Edit Warp Values.Description", "Edit the attributes of a Warp Point. &2Usage: &f/editwarp warpname <Cd |Level | Perm | Variance | Material | iName | iLore> <Value_settings>");
        warpLocaleConfig.set("Warp Commands.Edit Warp Values.Permission", "warp.values");

        warpLocaleConfig.set("Warp Commands.Teleport Self.Alias", "tp");
        warpLocaleConfig.set("Warp Commands.Teleport Self.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Self.Description", "Teleport yourself to another user or location. &2Usage: &f/tp <Rpg Player Name | X Y Z>");
        warpLocaleConfig.set("Warp Commands.Teleport Self.Permission", "warp.teleport");

        warpLocaleConfig.set("Warp Commands.Teleport Other.Alias", "tpo");
        warpLocaleConfig.set("Warp Commands.Teleport Other.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Other.Description", "Teleport someone else to another user or location. &2Usage: &f/tpo <Rpg player name > <target Rpg Player Name | X Y Z>");
        warpLocaleConfig.set("Warp Commands.Teleport Other.Permission", "warp.teleport.other");

        warpLocaleConfig.set("Warp Commands.Teleport All.Alias", "tpall");
        warpLocaleConfig.set("Warp Commands.Teleport All.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport All.Description", "Teleport everyone to another user or location. &2Usage: &f/tpall <Rpg Player Name | X Y Z>");
        warpLocaleConfig.set("Warp Commands.Teleport All.Permission", "warp.teleport.all");

        warpLocaleConfig.set("Warp Commands.Teleport Here.Alias", "tphere");
        warpLocaleConfig.set("Warp Commands.Teleport Here.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Here.Description", "Teleport someone to you. &2Usage: &f/tphere <Rpg Player Name>");
        warpLocaleConfig.set("Warp Commands.Teleport Here.Permission", "warp.teleport.here");

        warpLocaleConfig.set("Warp Commands.Teleport Request.Alias", "tpr");
        warpLocaleConfig.set("Warp Commands.Teleport Request.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Requst.Description", "Request to teleport to another player. &2Usage: &f/tpr <Rpg Player Name>");
        warpLocaleConfig.set("Warp Commands.Teleport Request.Permission", "warp.teleport");

        warpLocaleConfig.set("Warp Commands.Teleport Summon.Alias", "summon");
        warpLocaleConfig.set("Warp Commands.Teleport Summon.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Summon.Description", "Summon someone to your location. &2Usage: &f/summon <Rpg Player Name>");
        warpLocaleConfig.set("Warp Commands.Teleport Summon.Permission", "warp.teleport.summon");

        warpLocaleConfig.set("Warp Commands.Teleport Summon All.Alias", "summonall");
        warpLocaleConfig.set("Warp Commands.Teleport Summon All.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Summon All.Description", "Summon everyone to your location. &2Usage: &f/summonall");
        warpLocaleConfig.set("Warp Commands.Teleport Summon All.Permission", "warp.teleport.summon.all");

        warpLocaleConfig.set("Warp Commands.Teleport Accept.Alias", "tpa");
        warpLocaleConfig.set("Warp Commands.Teleport Accept.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Accept.Description", "Accept a teleport request or summons. &2Usage: &f/tpa");
        warpLocaleConfig.set("Warp Commands.Teleport Accept.Permission", "warp.teleport.accept");

        warpLocaleConfig.set("Warp Commands.Teleport Deny.Alias", "tpdeny");
        warpLocaleConfig.set("Warp Commands.Teleport Deny.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Deny.Description", "Deny an incomming teleport or summons request. &2Usage: &f/tpdeny");
        warpLocaleConfig.set("Warp Commands.Teleport Deny.Permission", "warp.teleport.deny");

        warpLocaleConfig.set("Warp Commands.Teleport Toggle.Alias", "tptoggle");
        warpLocaleConfig.set("Warp Commands.Teleport Toggle.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Toggle.Description", "toggle peoples ability to teleport you. &2Usage: &f/tptoggle");
        warpLocaleConfig.set("Warp Commands.Teleport Toggle.Permission", "warp.teleport.toggle");

        warpLocaleConfig.set("Warp Commands.Teleport Override.Alias", "tpov");
        warpLocaleConfig.set("Warp Commands.Teleport Override.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport Override.Description", "toggle whether you override another players tpToggle. &2Usage: &f/tpov");
        warpLocaleConfig.set("Warp Commands.Teleport Override.Permission", "warp.teleport.override");

        warpLocaleConfig.set("Warp Commands.Teleport World.Alias", "world");
        warpLocaleConfig.set("Warp Commands.Teleport World.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport World.Description", "teleport to your current location on another world. &2Usage: &f/world <world name>");
        warpLocaleConfig.set("Warp Commands.Teleport World.Permission", "warp.world");

        warpLocaleConfig.set("Warp Commands.Teleport World Spawn.Alias", "worldspawn");
        warpLocaleConfig.set("Warp Commands.Teleport World Spawn.Help Color", "&2");
        warpLocaleConfig.set("Warp Commands.Teleport World Spawn.Description", "Teleport to the spawn point of another world. &2Usage: &f/worldspawn <world name>");
        warpLocaleConfig.set("Warp Commands.Teleport World Spawn.Permission", "warp.worldspawn");

        warpLocaleConfig.set("Warp Messages.Warp Stub", "&f[&4Rpg Warps&f]&2");
        warpLocaleConfig.set("Warp Messages.Warps Loaded", "All warps have been loaded!");
        warpLocaleConfig.set("Warp Messages.Warp Placed", "You have made a warp named @w");
        warpLocaleConfig.set("Warp Messages.Save Warp Error", "Proper formatting /saveWarpCommand <warp name>");
        warpLocaleConfig.set("Warp Messages.No Warp By That Name", "That warp does not exist!");
        warpLocaleConfig.set("Warp Messages.Warp Saved", "You have saved a warp named @w");
        warpLocaleConfig.set("Warp Messages.Warp Deleted", "You have deleted a warp named @w");
        warpLocaleConfig.set("Warp Messages.Warp On Cooldown", "You must wait longer before using that warp!");
        warpLocaleConfig.set("Warp Messages.Warp Item Missing", "You do not have the required item to use that warp.");
        warpLocaleConfig.set("Warp Messages.Warp Value Set", "@v has been set for warp @w.");
        warpLocaleConfig.set("Warp Messages.Warp Requirements", "@w now has @v set to @b");
        warpLocaleConfig.set("Warp Messages.Warp No Perms", "You don't have the required permission to use that command!");
        warpLocaleConfig.set("Warp Messages.Set Exists", "That warp set already exists!");
        warpLocaleConfig.set("Warp Messages.Set Deleted", "You have deleted the Warp set @s. All warps belonging to that set have been moved to your default set!");
        warpLocaleConfig.set("Warp Messages.Set Saved", "You have saved a warp set named @s");
        warpLocaleConfig.set("Warp Messages.Set Edited", "Set settings have been edited");
        warpLocaleConfig.set("Warp Messages.No Back Location", "You do not have a back location saved");
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
            RpgAPI.permissionSettings.put(command, warpLocaleConfig.getString("Warp Commands." + command + ".Permission"));
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
        WarpSetBuilder.buildSets();
        new BukkitRunnable() {
            @Override
            public void run() {
                WarpBuilder.warpLoader();
            }
        }.runTaskLater(RpgAPI.getInstance(), 5);
    }
}
