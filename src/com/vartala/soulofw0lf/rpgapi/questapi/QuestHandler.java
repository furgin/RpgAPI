package com.vartala.soulofw0lf.rpgapi.questapi;

/**
 * Created by: tennyson.holloway
 * Date: 6/26/13
 * Time: 9:46 AM
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
public class QuestHandler {
    /**
     * each player will have a quest List<AbstractQuest> where the quest information will be stored
     * by default, all quests not in the player's list are un-started. when a player starts a quest
     * it will be added to his list, and when he finishes it, it will stay in the list in the finished state.
     * Each Quest will have one of two states - in progress, completed. when in progress, tracking will
     * occur in the quest object itself, and will be modified when a player completes a task.
     */
}
