package com.vartala.soulofw0lf.rpgapi.util;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 6/29/13
 * Time: 2:08 AM
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
public class HelpBuilder {
    /**
     *
     */
    public void MakeHelpPages() {
        List<HelpFile> gc = new ArrayList<>();
        List<HelpFile> wc = new ArrayList<>();
        for (HelpFile hF : RpgAPI.helpMap) {
            if (hF.getHelpGroup().equalsIgnoreCase("General Commands")) {
                gc.add(hF);
            }
            if (hF.getHelpGroup().equalsIgnoreCase("Warp Commands")) {
                wc.add(hF);
            }
        }
        RpgAPI.helpPages.put("General Commands", gc);
        RpgAPI.helpPages.put("Warp Commands", wc);
        SeperatePages();
    }

    /**
     *
     */
    public void SeperatePages() {
        Integer i = 0;
        Integer y = 1;
        List<String> helpLines = new ArrayList<String>();
        while (i <= RpgAPI.helpPages.get("General Commands").size()) {
            if (i == 0) {
                helpLines.add("General Commands");
            } else {
                helpLines.add(RpgAPI.helpPages.get("General Commands").get(i).getCmdAlias());
            }
            i++;
        }
        while (i <= RpgAPI.helpPages.get("Warp Commands").size() + RpgAPI.helpPages.get("General Commands").size()) {
            if (i == RpgAPI.helpPages.get("General Commands").size() + 1) {
                helpLines.add("Warp Commands");
            } else {
                helpLines.add(RpgAPI.helpPages.get("Warp Commands").get(i).getCmdAlias());
            }
            i++;
        }

        //TODO add code lines here to seperate the list of commands into Individual help pages
    }
}
