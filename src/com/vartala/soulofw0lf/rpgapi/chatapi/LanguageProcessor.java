package com.vartala.soulofw0lf.rpgapi.chatapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 6/27/13
 * Time: 10:29 PM
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
public class LanguageProcessor {
    /**
     *
     * @param m
     * @param language
     * @return
     */
    public static String LanguageDecoder(String m, String language) {
        List<String> cypher = RpgAPI.languageCypher.get(language);
        List<String> key = RpgAPI.languageKey.get(language);
        Integer i = 0;
        while (i < cypher.size()) {
            m = m.replace(key.get(i), cypher.get(i));
            i++;
        }

        return m;
    }

    /**
     *
     * @param languageFile
     */
    public static void LanguageLoader(YamlConfiguration languageFile) {
        RpgAPI.languageCypher.put(languageFile.getString("Language Name"), (List<String>) languageFile.getList("Language Cypher"));
        RpgAPI.languageKey.put(languageFile.getString("Language Name"), (List<String>) languageFile.getList("Language Key"));
    }
}
