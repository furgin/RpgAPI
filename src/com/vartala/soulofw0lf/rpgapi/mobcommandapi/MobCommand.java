package com.vartala.soulofw0lf.rpgapi.mobcommandapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 6/19/13
 * Time: 7:55 PM
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
public class MobCommand {
    //name of the set in the config (example Set 1)
    private String setName = "";
    //list off all item names in the set
    private List<String> itemNames = new ArrayList<String>();
    //all items in set mapped by name with a list of commands tied to it
    private Map<String, List<String>> commandMap = new HashMap<>();
    //all items in set mapped by name with a list of lores tied to it
    private Map<String, List<String>> loreMap = new HashMap<>();
    //all items in set ID's mapped by name
    private Map<String, Integer> idMap = new HashMap<>();

    public void MobCommand(){

    }


    public String getSetName() {
        return setName;
    }

    public void setSetName(String setName) {
        this.setName = setName;
    }

    public List<String> getItemNames() {
        return itemNames;
    }

    public void setItemNames(List<String> itemNames) {
        this.itemNames = itemNames;
    }

    public Map<String, List<String>> getCommandMap() {
        return commandMap;
    }

    public void setCommandMap(Map<String, List<String>> commandMap) {
        this.commandMap = commandMap;
    }

    public Map<String, List<String>> getLoreMap() {
        return loreMap;
    }

    public void setLoreMap(Map<String, List<String>> loreMap) {
        this.loreMap = loreMap;
    }

    public Map<String, Integer> getIdMap() {
        return idMap;
    }

    public void setIdMap(Map<String, Integer> idMap) {
        this.idMap = idMap;
    }
}
