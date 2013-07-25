package com.vartala.soulofw0lf.rpgapi.spellbehaviors;

import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.spellapi.MagicSpell;
import com.vartala.soulofw0lf.rpgapi.spellapi.SpellBehaviors;
import org.bukkit.Location;

/**
 * Created by: soulofw0lf
 * Date: 7/4/13
 * Time: 2:20 AM
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
public class AoeKnockBackBehavior implements SpellBehaviors {
    /**
     *
     * @param rpgP caster of the spell
     * @param rp person being hit by the spell
     * @param spell the spell being cast
     * @param loc location the spell actually hit
     */
    @Override
    public void onSpellCast(RpgPlayer rpgP, RpgPlayer rp, MagicSpell spell, Location loc){
        //rpgP should be the caster of the spell
        //rp is the person being hit, this behavior should be iterated through for each player in its range
        //spell is the spell being cast where radius will be determined
        //location is the location the spell hits
         //TODO: wait until a way to check mobs is set before i can do spell behaviors

    }
}
