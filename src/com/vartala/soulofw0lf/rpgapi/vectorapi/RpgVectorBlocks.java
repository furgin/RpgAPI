package com.vartala.soulofw0lf.rpgapi.vectorapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.block.Block;
import org.bukkit.potion.PotionEffect;
import org.bukkit.util.Vector;

/**
 * Created by: soulofw0lf
 * Date: 7/25/13
 * Time: 3:59 PM
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
public class RpgVectorBlocks {
    private String name = "";
    private Vector vec;
    private Block b;
    private int immune = 0;
    public RpgVectorBlocks(String vecName, Block vecBlock, int im, Vector vect){
        this.name = vecName;
        this.b = vecBlock;
        this.immune = im;
        this.vec = vect;
        RpgAPI.vecBlockMap.put(b, this);
        RpgAPI.vecBlocks.add(b);
    }

    public Block getB() {
        return b;
    }

    public void setB(Block b) {
        this.b = b;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vector getVec() {
        return vec;
    }

    public void setVec(Vector vec) {
        this.vec = vec;
    }

    public int getImmune() {
        return immune;
    }

    public void setImmune(int immune) {
        this.immune = immune;
    }
}
