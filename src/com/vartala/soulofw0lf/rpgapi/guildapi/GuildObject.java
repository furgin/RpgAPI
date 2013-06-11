package com.vartala.soulofw0lf.rpgapi.guildapi;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulofw0lf
 * Date: 6/4/13
 * Time: 12:29 AM
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
public class GuildObject {
    //
    //all members of a guils
    private List<String> members = new ArrayList<String>();

    //all ranks in a guild
    private List<GuildRank> ranks = new ArrayList<GuildRank>();

    //guild message of the day
    private String GMoTD = "";

    //player notes
    private Map<String, String> playerNotes = new HashMap<>();

    //officer notes
    private Map<String, String> officerNotes = new HashMap<>();

    //guilds name
    private String guildName = "";

    //guild bank section will be changed
    private Inventory guildBank1 = Bukkit.createInventory(null, 45, "Gbank: Tab 1");
    private Inventory guildBank2 = Bukkit.createInventory(null, 45, "Gbank: Tab 2");
    private Inventory guildBank3 = Bukkit.createInventory(null, 45, "Gbank: Tab 3");
    private Inventory guildBank4 = Bukkit.createInventory(null, 45, "Gbank: Tab 4");
    private Inventory guildBank5 = Bukkit.createInventory(null, 45, "Gbank: Tab 5");

    //money a guild has
    private Integer guildMoney = 0;

    //guild leader
    private String guildOwner = "";

    //guilds headquarters
    private GuildHQ guildHQ;


    /*
     * all getters and setters
     */

    public GuildObject(){

    }
    public String getGuildName() {
        return guildName;
    }

    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    public List<String> getMembers() {
        return members;
    }

    public void setMembers(List<String> members) {
        this.members = members;
    }

    public List<GuildRank> getRanks() {
        return ranks;
    }

    public void setRanks(List<GuildRank> ranks) {
        this.ranks = ranks;
    }

    public String getGMoTD() {
        return GMoTD;
    }

    public void setGMoTD(String GMoTD) {
        this.GMoTD = GMoTD;
    }

    public Map<String, String> getPlayerNotes() {
        return playerNotes;
    }

    public void setPlayerNotes(Map<String, String> playerNotes) {
        this.playerNotes = playerNotes;
    }

    public Map<String, String> getOfficerNotes() {
        return officerNotes;
    }

    public void setOfficerNotes(Map<String, String> officerNotes) {
        this.officerNotes = officerNotes;
    }

    public Integer getGuildMoney() {
        return guildMoney;
    }

    public void setGuildMoney(Integer guildMoney) {
        this.guildMoney = guildMoney;
    }

    public String getGuildOwner() {
        return guildOwner;
    }

    public void setGuildOwner(String guildOwner) {
        this.guildOwner = guildOwner;
    }

    public Inventory getGuildBank1() {
        return guildBank1;
    }

    public void setGuildBank1(Inventory guildBank1) {
        this.guildBank1 = guildBank1;
    }

    public Inventory getGuildBank2() {
        return guildBank2;
    }

    public void setGuildBank2(Inventory guildBank2) {
        this.guildBank2 = guildBank2;
    }

    public Inventory getGuildBank3() {
        return guildBank3;
    }

    public void setGuildBank3(Inventory guildBank3) {
        this.guildBank3 = guildBank3;
    }

    public Inventory getGuildBank4() {
        return guildBank4;
    }

    public void setGuildBank4(Inventory guildBank4) {
        this.guildBank4 = guildBank4;
    }

    public Inventory getGuildBank5() {
        return guildBank5;
    }

    public void setGuildBank5(Inventory guildBank5) {
        this.guildBank5 = guildBank5;
    }

    public GuildHQ getGuildHQ() {
        return guildHQ;
    }

    public void setGuildHQ(GuildHQ guildHQ) {
        this.guildHQ = guildHQ;
    }
}
