package com.vartala.soulofw0lf.rpgapi.partyapi;

import com.vartala.soulofw0lf.rpgapi.enumapi.ClassName;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by: soulof
 * Date: 6/4/13
 * Time: 3:13 AM
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
public class LFGPlayer {
    //
    //current nickname of the player
    private String playerName = "";

    //players class sorted by role
    private Map<ClassRole, ClassName> playerRole = new HashMap<>();

    //reason for joining que
    private String reasonForJoining = "";

    //integer for a players place in que
    private Integer inQue = 0;


    /*
     *  all getters and setters
     */

    public LFGPlayer() {

    }

    public Integer getInQue() {
        return inQue;
    }

    public void setInQue(Integer inQue) {
        this.inQue = inQue;
    }

    public Map<ClassRole, ClassName> getPlayerRole() {
        return playerRole;
    }

    public void setPlayerRole(Map<ClassRole, ClassName> playerRole) {
        this.playerRole = playerRole;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getReasonForJoining() {
        return reasonForJoining;
    }

    public void setReasonForJoining(String reasonForJoining) {
        this.reasonForJoining = reasonForJoining;
    }
}
