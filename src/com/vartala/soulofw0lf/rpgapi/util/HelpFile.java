package com.vartala.soulofw0lf.rpgapi.util;

/**
 * Created by: soulofw0lf
 * Date: 6/29/13
 * Time: 2:13 AM
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
public class HelpFile {
    private String cmdAlias = "";
    private String aliasColor = "";
    private String description = "";
    private String helpGroup = "";

    /**
     *
     */
    public void HelpFile() {

    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getAliasColor() {
        return aliasColor;
    }

    /**
     *
     * @param aliasColor
     */
    public void setAliasColor(String aliasColor) {
        this.aliasColor = aliasColor;
    }

    /**
     *
     * @return
     */
    public String getCmdAlias() {
        return cmdAlias;
    }

    /**
     *
     * @param cmdAlias
     */
    public void setCmdAlias(String cmdAlias) {
        this.cmdAlias = cmdAlias;
    }

    /**
     *
     * @return
     */
    public String getHelpGroup() {
        return helpGroup;
    }

    /**
     *
     * @param helpGroup
     */
    public void setHelpGroup(String helpGroup) {
        this.helpGroup = helpGroup;
    }
}
