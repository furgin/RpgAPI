package com.vartala.soulofw0lf.rpgapi.warpsapi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 6/24/13
 * Time: 6:29 PM
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

/**
 *
 */
public class WarpSets {
    private String setName = "";
    private Boolean warpsRandom = false;
    private String setPermission = "";
    private List<RpgWarp> setWarps = new ArrayList<RpgWarp>();

    /**
     *
     */
    public WarpSets() {

    }

    /**
     * @return
     */
    public String getSetPermission() {
        return setPermission;
    }

    /**
     * @param setPermission
     */
    public void setSetPermission(String setPermission) {
        this.setPermission = setPermission;
    }

    /**
     * @return
     */
    public Boolean getWarpsRandom() {
        return warpsRandom;
    }

    /**
     * @param warpsRandom
     */
    public void setWarpsRandom(Boolean warpsRandom) {
        this.warpsRandom = warpsRandom;
    }

    /**
     * @return
     */
    public String getSetName() {
        return setName;
    }

    /**
     * @param setName
     */
    public void setSetName(String setName) {
        this.setName = setName;
    }

    /**
     * @return
     */
    public List<RpgWarp> getSetWarps() {
        return setWarps;
    }

    /**
     * @param setWarps
     */
    public void setSetWarps(List<RpgWarp> setWarps) {
        this.setWarps = setWarps;
    }
}
