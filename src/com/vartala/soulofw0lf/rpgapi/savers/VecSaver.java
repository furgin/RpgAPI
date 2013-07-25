package com.vartala.soulofw0lf.rpgapi.savers;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.util.Misc;
import com.vartala.soulofw0lf.rpgapi.vectorapi.RpgVectorBlocks;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created by: soulofw0lf
 * Date: 7/25/13
 * Time: 4:43 PM
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
public class VecSaver {
    public VecSaver(){
        YamlConfiguration vecConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgVectorBlocks/config.yml"));
            if (!RpgAPI.vecBlocks.isEmpty()){
                for (Block b : RpgAPI.vecBlocks){
                    RpgVectorBlocks rV = RpgAPI.vecBlockMap.get(b);
                    vecConfig.set("Vector Blocks."+rV.getName()+".Location", Misc.locToString(b.getLocation()));
                    vecConfig.set("Vector Blocks."+rV.getName()+".Vector", Misc.vecToString(rV.getVec()));
                    vecConfig.set("Vector Blocks."+rV.getName()+".Vector Immune", rV.getImmune());
                }
            try {
                vecConfig.save(new File("plugins/RpgVectorBlocks/config.yml"));
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
