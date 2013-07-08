package com.vartala.soulofw0lf.rpgapi.loaders;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.mobcommandapi.MobEditingChatListener;
import de.kumpelblase2.remoteentities.RemoteEntities;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 7/8/13
 * Time: 6:14 PM
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
public class MinionLoader {
    RpgAPI rpg;
    public MinionLoader(RpgAPI Rpg){
        this.rpg = Rpg;
        RpgAPI.entityManager = RemoteEntities.createManager(this.rpg);
        this.rpg.mobEditingChatListener = new MobEditingChatListener(this.rpg);
        RpgAPI.minionConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Minions.yml"));
        RpgAPI.minionLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Minions.yml"));
        RpgAPI.mobCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/MobCommands.yml"));
        RpgAPI.mobLocaleCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/MobCommands.yml"));
        if (RpgAPI.mobCommand.get("Mob Commands") == null) {
            RpgAPI.mobCommand.set("Mob Commands.Set 1.Item 1.Commands.1.ClickType", "right");
        }
        if (RpgAPI.minionConfig.get("Minions") == null) {
            RpgAPI.minionConfig.set("Minions", "this file is used to store all minion and monster data (Mysql is highly recommended!");
        }
        try {
            RpgAPI.minionConfig.save(new File("plugins/RpgAPI/Minions.yml"));
            RpgAPI.minionLocaleConfig.save(new File("plugins/RpgAPI/Locale/Minions.yml"));
            RpgAPI.mobCommand.save(new File("plugins/RpgAPI/MobCommands.yml"));
            RpgAPI.mobLocaleCommand.save(new File("plugins/RpgAPI/Locale/MobCommands.yml"));
        } catch (IOException e) {
        }
        //after file is saved
    }
}
