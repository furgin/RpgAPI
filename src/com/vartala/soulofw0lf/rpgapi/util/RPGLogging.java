package com.vartala.soulofw0lf.rpgapi.util;

import java.util.logging.Logger;

/**
 * Created by: tennyson.holloway
 * Date: 6/24/13
 * Time: 1:45 PM
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
public class RPGLogging {
    private static final Logger log = Logger.getLogger("RPGAPI");
    private static final String prefix = "[RPGAPI] ";
    /**
     * Logs a message to the console, with the severity level of "info" or, not that important.
     *
     * @param message the message to be logged to console
     */
    public static void logInfo(String message){
        log.info(prefix + message);
    }

    /**
     * Logs a message to the console, with the severity level of "warning" or, proceed with caution
     *
     * @param message message to be logged to console
     */
    public static void logWarning(String message){
        log.warning(prefix + message);
    }

    /**
     * Logs a message to the console with the severity level of "severe" or, critical error.
     * <p>
     * Any process that logs a severe warning is at great risk of failing.
     *
     * @param message message to be logged to console
     */
    public static void logSevere(String message){
        log.severe(prefix + message);
    }
}
