package com.vartala.soulofw0lf.rpgapi.poisonapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.potion.PotionEffectType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 6/21/13
 * Time: 12:43 AM
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
public class PoisonBuilder {
    public static void newPoison(){
        List<PotionEffectType> potionEffects = new ArrayList<PotionEffectType>();
        Map<PotionEffectType, PoisonEffects> pfm = new HashMap<>();
        for (String poisonName : RpgAPI.poisonCommand.getConfigurationSection("Poisons").getKeys(false)){
            pfm.clear();
            potionEffects.clear();
            RpgPoison rPoison = new RpgPoison();
            rPoison.setPoisonName(poisonName);
            for (String effect : RpgAPI.poisonCommand.getConfigurationSection("Poisons." + poisonName + ".Potion Effects").getKeys(false)){
                PotionEffectType pType = PotionEffectType.getByName(effect);
                potionEffects.add(pType);
                PoisonEffects pEffect = new PoisonEffects();
                pEffect.setEffectName(effect);
                pEffect.setDuration(RpgAPI.poisonCommand.getInt("Poisons." + poisonName + ".Potion Effects." + effect + ".Duration"));
                pEffect.setStrength(RpgAPI.poisonCommand.getInt("Poisons." + poisonName + ".Potion Effects." + effect + ".Strength"));
                pfm.put(pType, pEffect);
            }
            rPoison.setEffectStats(pfm);
            rPoison.setPoisonEffects(potionEffects);
            rPoison.setWorldName(RpgAPI.poisonCommand.getString("Poisons." + poisonName + ".World"));
            rPoison.setPoisonX(RpgAPI.poisonCommand.getDouble("Poisons." + poisonName + ".Potion X"));
            rPoison.setPoisonY(RpgAPI.poisonCommand.getDouble("Poisons." + poisonName + ".Potion Y"));
            rPoison.setPoisonZ(RpgAPI.poisonCommand.getDouble("Poisons." + poisonName + ".Potion Z"));
            rPoison.setAboveY(RpgAPI.poisonCommand.getBoolean("Poisons." + poisonName + ".Above Y"));
            rPoison.setPoisonTickLength(RpgAPI.poisonCommand.getInt("Poisons." + poisonName + ".Reset Length"));
            rPoison.setPoisonRadius(RpgAPI.poisonCommand.getInt("Poisons." + poisonName + ".Radius"));
            RpgAPI.rpgPoisons.put(poisonName, rPoison);
            RpgAPI.poisonNames.add(poisonName);
        }
    }
}
