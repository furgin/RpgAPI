package com.vartala.soulofw0lf.rpgapi.loaders;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.foodapi.FoodListener;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 7/8/13
 * Time: 6:11 PM
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
public class FoodLoader {
    RpgAPI rpg;

    /**
     *
     * @param Rpg
     */
    public FoodLoader(RpgAPI Rpg){
        this.rpg = Rpg;
        this.rpg.foodListener = new FoodListener(this.rpg);
        RpgAPI.foodConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgFood/Food.yml"));
        RpgAPI.foodLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgFood/Locale/Food.yml"));
        if (RpgAPI.foodConfig.get("Rpg Foods") == null) {
            RpgAPI.foodConfig.set("Rpg Foods", "This file will save all your Rpg Food Items");
            RpgAPI.foodLocaleConfig.set("Translations.Eating Health Full", "&F[&2Rpg API&F] &4you cannot eat while your health is full!");
            RpgAPI.foodLocaleConfig.set("Translations.Already Eating", "&F[&2Rpg API&F] &4you are already eating!");
        }

        try {
            RpgAPI.foodConfig.save(new File("plugins/RpgFood/Food.yml"));
            RpgAPI.foodLocaleConfig.save(new File("plugins/RpgFood/Locale/Food.yml"));
        } catch (IOException e) {
        }
        //after file is saved
    }
}
