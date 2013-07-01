package com.vartala.soulofw0lf.rpgapi.partyapi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulof
 * Date: 6/4/13
 * Time: 2:59 AM
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
public class PartyGroup {
    //
    //list of all players in this party
    private List<String> playersInParty = new ArrayList<String>();

    //name of the party leader to save as party name
    private String partyName = "";

    /*
     *  all getters and setters
     */
    public PartyGroup() {

    }

    public List<String> getPlayersInParty() {
        return playersInParty;
    }

    public void setPlayersInParty(List<String> playersInParty) {
        this.playersInParty = playersInParty;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }
}
