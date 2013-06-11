package com.vartala.soulofw0lf.rpgapi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.vartala.soulofw0lf.rpgapi.achievementapi.TitleAchievement;
import com.vartala.soulofw0lf.rpgapi.chatapi.ChatClass;
import com.vartala.soulofw0lf.rpgapi.chatapi.ChatListener;
import com.vartala.soulofw0lf.rpgapi.classapi.RpgClasses;
import com.vartala.soulofw0lf.rpgapi.enumapi.ClassName;
import com.vartala.soulofw0lf.rpgapi.enumapi.Spell;
import com.vartala.soulofw0lf.rpgapi.factionapi.FactionLevel;
import com.vartala.soulofw0lf.rpgapi.foodapi.CustomFood;
import com.vartala.soulofw0lf.rpgapi.foodapi.FoodListener;
import com.vartala.soulofw0lf.rpgapi.guiapi.ClickInvListener;
import com.vartala.soulofw0lf.rpgapi.guiapi.RpgClickInv;
import com.vartala.soulofw0lf.rpgapi.guildapi.GuildObject;
import com.vartala.soulofw0lf.rpgapi.guildapi.GuildRank;
import com.vartala.soulofw0lf.rpgapi.minionapi.MinionEntity;
import com.vartala.soulofw0lf.rpgapi.partyapi.LFGPlayer;
import com.vartala.soulofw0lf.rpgapi.partyapi.PartyGroup;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.spellapi.MagicSpell;
import com.vartala.soulofw0lf.rpgapi.sqlapi.SQLHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import com.vartala.soulofw0lf.rpgapi.eventsapi.MapRightClickEvent;
import com.vartala.soulofw0lf.rpgapi.listenersapi.MapListener;
import com.vartala.soulofw0lf.rpgapi.listenersapi.RegionListener;
import com.vartala.soulofw0lf.rpgapi.listenersapi.playerLogIn;
import com.vartala.soulofw0lf.rpgapi.mapsapi.ScrollMap;
import com.vartala.soulofw0lf.rpgapi.util.PlayerUtil;

//@author soulofwolf linksbro..
public class RpgAPI extends JavaPlugin implements Listener {
    //Plugins
    public WorldGuardPlugin WG;
    public static RpgAPI plugin;
    //
    //files
    public static YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayers.yml"));
    public static YamlConfiguration localeConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale.yml"));
    public static YamlConfiguration guildConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Guilds.yml"));
    public static YamlConfiguration chatConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/ChatChannels.yml"));
    public static YamlConfiguration foodConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Food.yml"));
    public static YamlConfiguration clickConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Clicks.yml"));
    public static YamlConfiguration settingsConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Settings.yml"));
    public static YamlConfiguration achievementConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Achievements.yml"));
    public static YamlConfiguration minionConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Minions.yml"));
    public static YamlConfiguration classConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Classes.yml"));


    //Listeners
    public MapListener MapListen;
    public RegionListener RegionListen;
    public playerLogIn PlayerListener;
    public ClickInvListener clickListener;
    public ChatListener chatListener;
    public FoodListener foodListener;


    //Utilities
    PlayerUtil PlayerUtility = new PlayerUtil(this);

    //Variables
    public static ArrayList<RpgClickInv> rpgClicks = new ArrayList<RpgClickInv>();
    public Map<String, GuildObject> guilds = new HashMap<>();
    public Map<String, PartyGroup> partys = new HashMap<>();
    public Map<String, LFGPlayer> lookingForGroup = new HashMap<>();
    public Map<String, GuildRank> guildRanks = new HashMap<>();
    public Integer partyQue = 0;
    public Map<Integer, MinionEntity> activeMinions = new HashMap<>();
    public Map<String, FactionLevel> allFactions = new HashMap<>();
    public Map<String, TitleAchievement> titleAchievs = new HashMap<>();
    public Map<Spell, MagicSpell> allSpells = new HashMap<>();
    public Map<String, RpgPlayer> rpgPlayers = new HashMap<>();
    public Map<ClassName, RpgClasses> rpgClasses = new HashMap<>();
    public static List<ChatClass> chatClasses = new ArrayList<ChatClass>();
    public Map<String, String> activeNicks = new HashMap<>();
    public Map<String, CustomFood> foodItems = new HashMap<>();
    public static boolean rpgStyleFood = true;
    public static String dBUserName = "";
    public static String dBPassword = "";
    public static String dBEncoding = "";
    public static boolean uniCode = true;
    public static String dBURL = "";
    public static Logger logger = Logger.getLogger(RpgAPI.class.getName());
    public static SQLHandler sqlHandler = null;


    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getPluginManager().registerEvents(this, this);
        if (Bukkit.getPluginManager().isPluginEnabled("WorldGuard")) {
            this.WG = (WorldGuardPlugin) Bukkit.getPluginManager().getPlugin("WorldGuard");
        }
        this.RegionListen = new RegionListener(this, this.WG);
        this.MapListen = new MapListener(this);
        this.PlayerListener = new playerLogIn();
        this.clickListener = new ClickInvListener(plugin);
        this.chatListener = new ChatListener(this);
        this.foodListener = new FoodListener(this);
        saveDefaultConfig();
        //grab database values if they should be used
        if (getConfig().getBoolean("Use Mysql") == true) {
            dBUserName = getConfig().getString("Mysql Database.User");
            dBPassword = getConfig().getString("Mysql Database.Password");
            dBEncoding = getConfig().getString("Mysql Database.Encoding");
            uniCode = getConfig().getBoolean("Mysql Database.UseUnicode");
            dBURL = getConfig().getString("Mysql Database.URL");
            sqlHandler = new SQLHandler(dBUserName, dBPassword, dBURL);
        }
        //load yml files and set a value to each of them if they don't exist.
        playerConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayers.yml"));
        localeConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale.yml"));
        guildConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Guilds.yml"));
        chatConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/ChatChannels.yml"));
        foodConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Food.yml"));
        clickConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Clicks.yml"));
        settingsConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Settings.yml"));
        achievementConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Achievements.yml"));
        minionConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Minions.yml"));
        classConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Classes.yml"));
        if (playerConfig.get("Players") == null) {
            playerConfig.set("Players", "This Config File will hold all player data (Mysql is greatly recommended!)");
        }
        if (localeConfig.get("Locale Settings") == null) {
            localeConfig.set("Locale Settings", "This file is used to set all language settings!");
        }
        if (guildConfig.get("Guilds Info") == null) {
            guildConfig.set("Guilds Info", "This File will save all guild info, Mysql is highly recommended!");
        }
        if (chatConfig.get("Channels") == null) {
            chatConfig.set("Channels", "This config will save all your chat channel data.");
        }
        if (foodConfig.get("Rpg Foods") == null) {
            foodConfig.set("Rpg Foods", "This file will save all your Rpg Food Items");
        }
        if (clickConfig.get("Click File") == null) {
            clickConfig.set("Click File", "This File is used to save all your click menu's");
        }
        if (settingsConfig.get("Settings") == null) {
            settingsConfig.set("Settings", "this file is used for all plugin settings!");
        }
        if (achievementConfig.get("Achievements") == null) {
            achievementConfig.set("Achievements", "This file stores all your servers saved Achievements");
        }
        if (minionConfig.get("Minions") == null) {
            minionConfig.set("Minions", "this file is used to store all minion and monster data (Mysql is highly recommended!");
        }
        if (classConfig.get("Classes") == null) {
            classConfig.set("Classes", "This file is used to save all Rpg Classes");
        }
        try {
            playerConfig.save(new File("plugins/RpgAPI/RpgPlayers.yml"));
            localeConfig.save(new File("plugins/RpgAPI/Locale.yml"));
            guildConfig.save(new File("plugins/RpgAPI/Guilds.yml"));
            chatConfig.save(new File("plugins/RpgAPI/ChatChannels.yml"));
            foodConfig.save(new File("plugins/RpgAPI/Food.yml"));
            clickConfig.save(new File("plugins/RpgAPI/Clicks.yml"));
            settingsConfig.save(new File("plugins/RpgAPI/Settings.yml"));
            achievementConfig.save(new File("plugins/RpgAPI/Achievements.yml"));
            minionConfig.save(new File("plugins/RpgAPI/Minions.yml"));
            classConfig.save(new File("plugins/RpgAPI/Classes.yml"));
        } catch (IOException e) {
        }

    }

    @EventHandler
    public void onRightClickMap(MapRightClickEvent event) {
        if (event.isPlayerSneaking()) {
            ScrollMap.getScrollMap(event.getMapID()).getMapRender().decrementIndex();
            ScrollMap.getScrollMap(event.getMapID()).update(event.getPlayer().getName());
        } else {
            ScrollMap.getScrollMap(event.getMapID()).getMapRender().incrementIndex();
            ScrollMap.getScrollMap(event.getMapID()).update(event.getPlayer().getName());
        }
    }

}
