package com.vartala.soulofw0lf.rpgapi.guildapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by: soulof
 * Date: 6/4/13
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
public class GuildRank {
    //which permissions are true or false hor the guild rank
    private Map<RankPermission, Boolean> ranksPerms = new HashMap<>();
    //
    //which guild dows this permission belong to
    private String guildName = "";

    //which players are this rank
    private List<String> playersInRank = new ArrayList<String>();

    //which rank order is this rank
    private Integer rankOrder = 0;

    /*
     * All getters and setters
     */

    public GuildRank() {

    }

    /**
     *
     * @return
     */
    public Map<RankPermission, Boolean> getRanksPerms() {
        return ranksPerms;
    }

    /**
     *
     * @param ranksPerms
     */
    public void setRanksPerms(Map<RankPermission, Boolean> ranksPerms) {
        this.ranksPerms = ranksPerms;
    }

    /**
     *
     * @return
     */
    public String getGuildName() {
        return guildName;
    }

    /**
     *
     * @param guildName
     */
    public void setGuildName(String guildName) {
        this.guildName = guildName;
    }

    /**
     *
     * @return
     */
    public List<String> getPlayersInRank() {
        return playersInRank;
    }

    /**
     *
     * @param playersInRank
     */
    public void setPlayersInRank(List<String> playersInRank) {
        this.playersInRank = playersInRank;
    }

    /**
     *
     * @return
     */
    public Integer getRankOrder() {
        return rankOrder;
    }

    /**
     *
     * @param rankOrder
     */
    public void setRankOrder(Integer rankOrder) {
        this.rankOrder = rankOrder;
    }
}
