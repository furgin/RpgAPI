package com.vartala.soulofw0lf.rpgapi.savers;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.diseaseapi.Disease;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 7/30/13
 * Time: 12:33 AM
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
public class DiseaseSaver {
    public DiseaseSaver(){
        YamlConfiguration diseaseConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgDiseases/RpgDisease.yml"));

    for (Disease dis : RpgAPI.diseases){
        String key = dis.getDiseaseName();
        diseaseConfig.set("Diseases." + key + ".Severity Level", dis.getSeverity());
        diseaseConfig.set("Diseases." + key + ".Spreadable", dis.isSpreadable());
        diseaseConfig.set("Diseases." + key + ".Use Air Spread", dis.isAirSpread());
        diseaseConfig.set("Diseases." + key + ".Air Spread Chance", dis.getAirSpreadChance());
        diseaseConfig.set("Diseases." + key + ".Air Spread Distance", dis.getSpreadDistance());
        diseaseConfig.set("Diseases." + key + ".Use Hit Spread", dis.isHitSpread());
        diseaseConfig.set("Diseases." + key + ".Hit Spread Chance", dis.getHitSpreadChance());
        diseaseConfig.set("Diseases." + key + ".Stackable", dis.isStackable());
        diseaseConfig.set("Diseases." + key + ".Fatal", dis.isFatal());
        diseaseConfig.set("Diseases." + key + ".Ticks Before Death", dis.getTicksBeforeDeath());
        diseaseConfig.set("Diseases." + key + ".Gets Worse", dis.isGetsWorse());
        diseaseConfig.set("Diseases." + key + ".Morphs Into", dis.getProgressiveDisease());
        diseaseConfig.set("Diseases." + key + ".Regresses To", dis.getRegressiveDisease());
        diseaseConfig.set("Diseases." + key + ".Morph Progression Timer", dis.getProgressionTime());
        diseaseConfig.set("Diseases." + key + ".Effect Damage Dealt", dis.isEffectDamage());
        diseaseConfig.set("Diseases." + key + ".Adjust Damage Dealt By", dis.getAdjustDamage());
        diseaseConfig.set("Diseases." + key + ".Miss Chance", dis.isMiss());
        diseaseConfig.set("Diseases." + key + ".Miss Percentage", dis.getMissChance());
        diseaseConfig.set("Diseases." + key + ".Effect Damage Taken", dis.isEffectDamageTaken());
        diseaseConfig.set("Diseases." + key + ".Adjust Damage Taken By", dis.getAdjustDamageTaken());
        List<PotionEffect> pots = dis.getDiseasePots();
        if (!pots.isEmpty()){
        for (PotionEffect pot : pots){
            if (pot == null){
                continue;
            }
            String type = pot.getType().getName();
            int time = pot.getDuration();
            int amp = pot.getAmplifier();
            diseaseConfig.set("Diseases." + key + ".Effects." + type + ".Duration", time);
            diseaseConfig.set("Diseases." + key + ".Effects." + type + ".Amplifier", amp);
        }
        }
        diseaseConfig.set("Diseases." + key + ".Behavior Timer", dis.getDiseaseTime());
        diseaseConfig.set("Diseases." + key + ".Use Damage Over Time", dis.isDot());
        diseaseConfig.set("Diseases." + key + ".Damage Per DOT Tick", dis.getDotDamage());
        diseaseConfig.set("Diseases." + key + ".Dot Tick Time", dis.getDotTimer());
        diseaseConfig.set("Diseases." + key + ".Adjust Health", dis.hasHealthEffect());
        diseaseConfig.set("Diseases." + key + ".Adjust Health Amount", dis.getHealthChange());
    }
        try {
            diseaseConfig.save(new File("plugins/RpgDiseases/RpgDisease.yml"));
        } catch (IOException e){
            e.printStackTrace();
        }
        RpgAPI.diseases.clear();
    }
}
