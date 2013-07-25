package com.vartala.soulofw0lf.rpgapi.loaders;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.listenersapi.PoisonListener;
import com.vartala.soulofw0lf.rpgapi.poisonapi.PoisonBuilder;
import com.vartala.soulofw0lf.rpgapi.poisonapi.PoisonTimeChecker;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 7/8/13
 * Time: 6:16 PM
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
public class PoisonLoader {
    RpgAPI rpg;
    public PoisonLoader(RpgAPI Rpg){
    this.rpg = Rpg;

    this.rpg.poisonlistener = new PoisonListener(this.rpg);
    RpgAPI.poisonCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgPoisons/Poisons.yml"));
        RpgAPI.poisonLocaleCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgPoisons/Locale/Poisons.yml"));
    if (RpgAPI.poisonCommand.get("Poisons") == null) {
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Potion Effects.POISON.Duration", 15);
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Potion Effects.POISON.Strength", 2);
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Potion Effects.WEAKNESS.Duration", 30);
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Potion Effects.WEAKNESS.Strength", 4);
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.World", "Kardegah");
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Potion X", -2587);
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Potion Z", -3060);
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Potion Y", 162);
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Above Y", true);
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Reset Length", 10);
        RpgAPI.poisonCommand.set("Poisons.Sickening Ground.Radius", 38);
    }
        try {
            RpgAPI.poisonCommand.save(new File("plugins/RpgPoisons/Poisons.yml"));
            RpgAPI.poisonLocaleCommand.save(new File("plugins/RpgPoisons/Locale/Poisons.yml"));
        } catch (IOException e) {
        }
        //after file is saved
        PoisonBuilder.newPoison();
        PoisonTimeChecker.PoisonRegionTimer();

    }
}
