package com.vartala.soulofw0lf.rpgapi.loaders;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 7/8/13
 * Time: 6:13 PM
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
public class GuildLoader {
    public GuildLoader(){
        RpgAPI.guildConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgGuilds/Guilds.yml"));
        RpgAPI.guildLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgGuilds/Locale/Guilds.yml"));
        if (RpgAPI.guildConfig.get("Guilds Info") == null) {
            RpgAPI.guildConfig.set("Guilds Info", "This File will save all guild info, Mysql is highly recommended!");
        }
        try {
            RpgAPI.guildConfig.save(new File("plugins/RpgGuilds/Guilds.yml"));
            RpgAPI.guildLocaleConfig.save(new File("plugins/RpgGuilds/Locale/Guilds.yml"));
        } catch (IOException e) {
        }
        //after file is saved
    }
}
