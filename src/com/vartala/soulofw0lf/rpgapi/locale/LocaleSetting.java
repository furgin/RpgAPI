package com.vartala.soulofw0lf.rpgapi.locale;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: soulof
 * Date: 6/13/13
 * Time: 10:43 AM
 * To change this template use File | Settings | File Templates.
 */
public class LocaleSetting {
    //locale config (only general localle commands and messages should go in here)

    /**
     *
     */
    public static void localeLoader(){
    RpgAPI.localeConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale.yml"));
        if (RpgAPI.localeConfig.get("Locale Settings") == null) {
            RpgAPI.localeConfig.set("Locale Settings", "This file is used to set all language settings!");
            RpgAPI.localeConfig.set("Translations.Error Message", "&F[&2Rpg API&F] &4This command should be ");
            RpgAPI.localeConfig.set("Translations.Active Character", "&F[&4Rpg Player&F] &2Your Active Character Name is &6");
            //help Command
            RpgAPI.localeConfig.set("General Commands.Help Command.Alias", "Help");
            RpgAPI.localeConfig.set("General Commands.Help Command.Help Color", "&2");
            RpgAPI.localeConfig.set("General Commands.Help Command.Description", "&fShow the different help Pages. &2Usage: &f/help page#");
        }
        try {
            RpgAPI.localeConfig.save(new File("plugins/RpgAPI/Locale.yml"));
        } catch (IOException e){
            System.out.print(e);
        }

    }
}
