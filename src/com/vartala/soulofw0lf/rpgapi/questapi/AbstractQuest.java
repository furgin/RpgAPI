package com.vartala.soulofw0lf.rpgapi.questapi;

/**
 * Created by: tennyson.holloway
 * Date: 6/26/13
 * Time: 9:54 AM
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
public class AbstractQuest implements Quest {
    @Override
    public String getName() {
        return null;
    }

    @Override
    public boolean getRequirements() {
        return false;
    }

    @Override
    public int getQuestID() {
        return -1;
    }

    @Override
    public boolean isRepeatable() {
        return false;
    }

}
