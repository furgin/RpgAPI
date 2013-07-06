package com.vartala.soulofw0lf.rpgapi;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.vartala.soulofw0lf.rpgapi.achievementapi.TitleAchievement;
import com.vartala.soulofw0lf.rpgapi.borderapi.BorderCheck;
import com.vartala.soulofw0lf.rpgapi.chatapi.*;
import com.vartala.soulofw0lf.rpgapi.classapi.RpgClasses;
import com.vartala.soulofw0lf.rpgapi.commandapi.UniqueCommands;
import com.vartala.soulofw0lf.rpgapi.enumapi.ClassName;
import com.vartala.soulofw0lf.rpgapi.enumapi.Spell;
import com.vartala.soulofw0lf.rpgapi.factionapi.FactionLevel;
import com.vartala.soulofw0lf.rpgapi.foodapi.CustomFood;
import com.vartala.soulofw0lf.rpgapi.foodapi.FoodListener;
import com.vartala.soulofw0lf.rpgapi.guiapi.ClickInvListener;
import com.vartala.soulofw0lf.rpgapi.guiapi.RpgClickInv;
import com.vartala.soulofw0lf.rpgapi.guildapi.GuildObject;
import com.vartala.soulofw0lf.rpgapi.guildapi.GuildRank;
import com.vartala.soulofw0lf.rpgapi.listenersapi.PoisonListener;
import com.vartala.soulofw0lf.rpgapi.minionapi.MinionEntity;
import com.vartala.soulofw0lf.rpgapi.mobcommandapi.MobCommand;
import com.vartala.soulofw0lf.rpgapi.mobcommandapi.MobEditingChatListener;
import com.vartala.soulofw0lf.rpgapi.mobcommandapi.SetBuilder;
import com.vartala.soulofw0lf.rpgapi.partyapi.LFGPlayer;
import com.vartala.soulofw0lf.rpgapi.partyapi.PartyGroup;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.poisonapi.PoisonBuilder;
import com.vartala.soulofw0lf.rpgapi.poisonapi.PoisonTimeChecker;
import com.vartala.soulofw0lf.rpgapi.poisonapi.RpgPoison;
import com.vartala.soulofw0lf.rpgapi.spellapi.MagicSpell;
import com.vartala.soulofw0lf.rpgapi.sqlapi.SQLHandler;
import com.vartala.soulofw0lf.rpgapi.tradeapi.TradeCommandProcessor;
import com.vartala.soulofw0lf.rpgapi.tradeapi.TradeEventListener;
import com.vartala.soulofw0lf.rpgapi.tradeapi.TradeHandler;
import com.vartala.soulofw0lf.rpgapi.util.HelpFile;
import com.vartala.soulofw0lf.rpgapi.util.HelpPage;
import com.vartala.soulofw0lf.rpgapi.util.RPGLogging;
import com.vartala.soulofw0lf.rpgapi.warpsapi.RpgWarp;
import com.vartala.soulofw0lf.rpgapi.warpsapi.WarpBuilder;
import com.vartala.soulofw0lf.rpgapi.warpsapi.WarpSetBuilder;
import com.vartala.soulofw0lf.rpgapi.warpsapi.WarpSets;
import de.kumpelblase2.remoteentities.EntityManager;
import de.kumpelblase2.remoteentities.RemoteEntities;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;


import com.vartala.soulofw0lf.rpgapi.eventsapi.MapRightClickEvent;
import com.vartala.soulofw0lf.rpgapi.listenersapi.MapListener;
import com.vartala.soulofw0lf.rpgapi.listenersapi.playerLogIn;
import com.vartala.soulofw0lf.rpgapi.mapsapi.ScrollMap;
import com.vartala.soulofw0lf.rpgapi.util.PlayerUtil;
import org.bukkit.scheduler.BukkitRunnable;

//@author soulofwolf linksbro..
public class RpgAPI extends JavaPlugin implements Listener {
    //Plugins
    public static RpgAPI plugin;
    //
    //files
    public static YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayers.yml"));
    public static YamlConfiguration localeConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale.yml"));
    public static YamlConfiguration guildConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Guilds.yml"));
    public static YamlConfiguration chatConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat.yml"));
    public static YamlConfiguration foodConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Food.yml"));
    public static YamlConfiguration clickConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Clicks.yml"));
    public static YamlConfiguration settingsConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Settings.yml"));
    public static YamlConfiguration achievementConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Achievements.yml"));
    public static YamlConfiguration minionConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Minions.yml"));
    public static YamlConfiguration classConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Classes.yml"));
    public static YamlConfiguration commandConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Commands.yml"));
    public static YamlConfiguration mobCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/MobCommands.yml"));
    public static YamlConfiguration poisonCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Poisons.yml"));
    public static YamlConfiguration testPlayer = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayer/TestPlayer.yml"));
    public static YamlConfiguration worldBorder = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgBorders.yml"));
    public static YamlConfiguration warpConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/WarpConfig.yml"));
    public static YamlConfiguration languageConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgLanguages.yml"));
    public static YamlConfiguration cityConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat/RpgCities.yml"));
    public static YamlConfiguration regionConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat/RpgRegions.yml"));


    //Listeners
    public MapListener MapListen;
    public playerLogIn PlayerListener;
    public ClickInvListener clickListener;
    public TradeEventListener tradeListener;
    public ChatListener chatListener;
    public FoodListener foodListener;
    public PoisonListener poisonlistener;
    public MobEditingChatListener mobEditingChatListener;

    //plugin booleans
    public static boolean useMySql = false;
    public static boolean guildsOn = true;
    public static boolean chatOn = true;
    public static boolean poisonedEarthOn = true;
    public static boolean classesOn = true;
    public static boolean racesOn = true;
    public static boolean achievementsOn = true;
    public static boolean foodOn = true;
    public static boolean partyOn = true;
    public static boolean minionsOn = true;
    public static boolean clickOn = true;
    public static boolean friendsOn = true;
    public static boolean lobbyOn = true;
    public static boolean questOn = true;
    public static boolean spawnsOn = true;
    public static boolean warpsOn = true;
    public static boolean tradeOn = true;
    public static boolean borderOn = true;
    public static boolean reputationOn = true;
    public static boolean languagesOn = true;


    //Utilities
    PlayerUtil PlayerUtility = new PlayerUtil(this);

    //Variables
    public static ArrayList<RpgClickInv> rpgClicks = new ArrayList<RpgClickInv>();
    public static Map<String, GuildObject> guilds = new HashMap<>();
    public static Map<String, PartyGroup> partys = new HashMap<>();
    public static Map<String, LFGPlayer> lookingForGroup = new HashMap<>();
    public static Map<String, GuildRank> guildRanks = new HashMap<>();
    public static Integer partyQue = 0;
    public static Map<Integer, MinionEntity> activeMinions = new HashMap<>();
    public static Map<String, FactionLevel> allFactions = new HashMap<>();
    public static Map<String, TitleAchievement> titleAchievs = new HashMap<>();
    public static Map<Spell, MagicSpell> allSpells = new HashMap<>();
    public static Map<String, RpgPlayer> rpgPlayers = new HashMap<>();
    public static Map<ClassName, RpgClasses> rpgClasses = new HashMap<>();
    public static List<ChatClass> chatClasses = new ArrayList<ChatClass>();
    public static Map<String, String> activeNicks = new HashMap<>();
    public static Map<String, CustomFood> foodItems = new HashMap<>();
    public static boolean rpgStyleFood = true;
    public static String dBUserName = "";
    public static String dBPassword = "";
    public static String dBEncoding = "";
    public static boolean uniCode = true;
    public static String dBURL = "";
    public static Logger logger = Logger.getLogger(RpgAPI.class.getName());
    public static SQLHandler sqlHandler = null;
    public static TradeHandler tradeHandler = null;
    public static List<String> commands = new ArrayList<String>();
    public static Map<String, MobCommand> minionCommands = new HashMap<>();
    public static EntityManager entityManager;
    public static Map<String, RpgPoison> rpgPoisons = new HashMap<>();

    public static Map<String, String> localeSettings = new HashMap<>();
    public static Map<String, String> commandSettings = new HashMap<>();
    public static Map<String, WarpSets> savedSets = new HashMap<>();
    public static Map<String, RpgWarp> savedWarps = new HashMap<>();
    public static List<ItemStack> warpItems = new ArrayList<ItemStack>();
    public static Map<String, List<String>> warpCds = new HashMap<>();
    public static String nameDisplays = "";
    public static Map<String, String> playerColors = new HashMap<>();
    public static Map<String, List<String>> languageCypher = new HashMap<>();
    public static Map<String, List<String>> languageKey = new HashMap<>();
    public static Map<String, List<String>> pluginCommand = new HashMap<>();
    public static Map<String, Integer> chatDistances = new HashMap<>();
    public static List<ChatRegions> chatRegions = new ArrayList<ChatRegions>();
    public static List<RpgCities> rpgCities = new ArrayList<RpgCities>();
    public static Map<String, String> chatRealNames = new HashMap<>();
    public static List<HelpFile> helpMap = new ArrayList<HelpFile>();
    public static Map<String, List<HelpFile>> helpPages = new HashMap<>();
    public static Map<Integer, HelpPage> helpDisplay = new HashMap<>();


    @Override
    public void onEnable() {
        plugin = this;
        saveDefaultConfig();

        useMySql = getConfig().getBoolean("Use Mysql");
        guildsOn = getConfig().getBoolean("Plugins.Guilds");
        chatOn = getConfig().getBoolean("Plugins.Chat");
        poisonedEarthOn = getConfig().getBoolean("Plugins.Poisoned Earth");
        classesOn = getConfig().getBoolean("Plugins.Classes");
        racesOn = getConfig().getBoolean("Plugins.Races");
        achievementsOn = getConfig().getBoolean("Plugins.Achievements");
        foodOn = getConfig().getBoolean("Plugins.Food");
        partyOn = getConfig().getBoolean("Plugins.Party");
        minionsOn = getConfig().getBoolean("Plugins.Minions");
        clickOn = getConfig().getBoolean("Plugins.Click");
        friendsOn = getConfig().getBoolean("Plugins.Friends");
        lobbyOn = getConfig().getBoolean("Plugins.Lobby");
        questOn = getConfig().getBoolean("Plugins.Quest");
        spawnsOn = getConfig().getBoolean("Plugins.Spawns");
        warpsOn = getConfig().getBoolean("Plugins.Warps");
        tradeOn = getConfig().getBoolean("Plugins.Trade");
        borderOn = getConfig().getBoolean("Plugins.Border");
        reputationOn = getConfig().getBoolean("Plugins.Reputation");
        languagesOn = getConfig().getBoolean("Plugins.Languages");
        Bukkit.getPluginManager().registerEvents(this, this);
        this.MapListen = new MapListener(this);
        this.PlayerListener = new playerLogIn(this);
        this.mobEditingChatListener = new MobEditingChatListener(this);
        File f = new File("plugins/RpgAPI/RpgPLayers");
        File[] files = f.listFiles();
        if (!(files == null)) {
            for (File playerFile : files) {
                YamlConfiguration.loadConfiguration(playerFile);
            }
        }
        if (languagesOn) {
            File l = new File("plugins/RpgAPI/RpgLanguages");
            File[] lFiles = l.listFiles();
            if (!(lFiles == null)) {
                for (File languageFile : lFiles) {
                    YamlConfiguration lang = YamlConfiguration.loadConfiguration(languageFile);
                    LanguageProcessor.LanguageLoader(lang);
                }
            }
        }
        if (clickOn) {
            this.clickListener = new ClickInvListener(this);
        }
        if (tradeOn) {
            this.tradeListener = new TradeEventListener(this);
        }
        if (chatOn) {
            this.chatListener = new ChatListener(this);
        }
        if (foodOn) {
            this.foodListener = new FoodListener(this);
        }
        if (tradeOn) {
            this.tradeHandler = new TradeHandler(this);
        }
        if (minionsOn) {
            this.entityManager = RemoteEntities.createManager(this);
        }
        if (poisonedEarthOn) {
            this.poisonlistener = new PoisonListener(this);
        }
        if (borderOn) {
            worldBorder = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgBorders.yml"));
            if (worldBorder.get("Worlds") == null) {
                worldBorder.set("Worlds.World.X", 0);
                worldBorder.set("Worlds.World.Y", 0);
                worldBorder.set("Worlds.World.Z", 0);
                worldBorder.set("Worlds.World.Radius", 1000);
            }
            try {
                worldBorder.save(new File("plugins/RpgAPI/RpgBorders.yml"));

            } catch (IOException e) {
            }
            Double X = 0.0;
            Double Y = 0.0;
            Double Z = 0.0;
            Location loc = null;
            Integer radius = 0;
            for (String worlds : worldBorder.getConfigurationSection("Worlds").getKeys(false)) {
                X = worldBorder.getDouble("Worlds." + worlds + ".X");
                Y = worldBorder.getDouble("Worlds." + worlds + ".Y");
                Z = worldBorder.getDouble("Worlds." + worlds + ".Z");
                radius = worldBorder.getInt("Worlds." + worlds + ".Radius");
                World world = Bukkit.getWorld(worlds);
                if (world != null) {
                    loc = new Location(world, X, Y, Z);
                    BorderCheck.cycleCheck(this, loc, radius);
                }
            }

        }
        //grab database values if they should be used
        if (useMySql) {
            dBUserName = getConfig().getString("Mysql Database.User");
            dBPassword = getConfig().getString("Mysql Database.Password");
            dBURL = getConfig().getString("Mysql Database.URL");
            sqlHandler = new SQLHandler();
            if (!sqlHandler.initialise()) {
                RPGLogging.logSevere("Failed to initialize the SQL connection. Check connection settings in RPGAPI config files. Otherwise please disable mysql as storage system.");
            } else
                RPGLogging.logInfo("SQL connection initialised.");
        }
        //load yml files and set a value to each of them if they don't exist.
        playerConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayers.yml"));
        testPlayer = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayer/TestPlayer.yml"));

        localeConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale.yml"));
        if (guildsOn) {
            guildConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Guilds.yml"));
        }
        if (chatOn) {
            chatConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat.yml"));
            cityConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat/RpgCities.yml"));
            regionConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgChat/RpgRegions.yml"));
        }
        if (foodOn) {
            foodConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Food.yml"));
        }
        if (clickOn) {
            clickConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Clicks.yml"));
        }
        settingsConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Settings.yml"));
        if (achievementsOn) {
            achievementConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Achievements.yml"));
        }
        if (minionsOn) {
            minionConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Minions.yml"));
        }
        if (classesOn) {
            classConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Classes.yml"));
        }
        commandConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Commands.yml"));
        if (minionsOn) {
            mobCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/MobCommands.yml"));
        }
        if (poisonedEarthOn) {
            poisonCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Poisons.yml"));
            if (poisonCommand.get("Poisons") == null) {
                poisonCommand.set("Poisons.Sickening Ground.Potion Effects.POISON.Duration", 15);
                poisonCommand.set("Poisons.Sickening Ground.Potion Effects.POISON.Strength", 2);
                poisonCommand.set("Poisons.Sickening Ground.Potion Effects.WEAKNESS.Duration", 30);
                poisonCommand.set("Poisons.Sickening Ground.Potion Effects.WEAKNESS.Strength", 4);
                poisonCommand.set("Poisons.Sickening Ground.World", "Kardegah");
                poisonCommand.set("Poisons.Sickening Ground.Potion X", -2587);
                poisonCommand.set("Poisons.Sickening Ground.Potion Z", -3060);
                poisonCommand.set("Poisons.Sickening Ground.Potion Y", 162);
                poisonCommand.set("Poisons.Sickening Ground.Above Y", true);
                poisonCommand.set("Poisons.Sickening Ground.Reset Length", 10);
                poisonCommand.set("Poisons.Sickening Ground.Radius", 38);
            }
        }
        if (minionsOn) {
            if (mobCommand.get("Mob Commands") == null) {
                mobCommand.set("Mob Commands.Set 1.Item 1.Commands.1.ClickType", "right");
            }
        }
        if (commandConfig.get("Commands") == null) {
            commandConfig.set("Commands.SetNick", "nick");
        }
        for (String command : commandConfig.getConfigurationSection("Commands").getKeys(false)) {
            commands.add(command);
        }
        if (playerConfig.get("Active Nicks") == null) {
            playerConfig.set("Active Nicks.Sample Player", "Sample Nick");
            playerConfig.set("Player Colors.soulofw0lf", "&4");
        }
        for (String players : playerConfig.getConfigurationSection("Active Nicks").getKeys(false)) {
            String currentNick = playerConfig.getString("Active Nicks." + players);
            activeNicks.put(players, currentNick);
        }
        if (localeConfig.get("Locale Settings") == null) {
            localeConfig.set("Locale Settings", "This file is used to set all language settings!");
            localeConfig.set("Translations.Error Message", "&F[&2Rpg API&F] &4This command should be ");
            localeConfig.set("Translations.Eating Health Full", "&F[&2Rpg API&F] &4you cannot eat while your health is full!");
            localeConfig.set("Translations.Already Eating", "&F[&2Rpg API&F] &4you are already eating!");
            localeConfig.set("Translations.Test Message", "&0Black &1Dark Blue &2Dark Green &4Dark Red &5Purple &6Gold &7 Grey" +
                    " &8Dark Grey &9 Blue &aGreen &bAqua &cRed &dLight Purple &eYellow &fWhite" +
                    "&lBold &mStrikeThrough &nUnderlined &oitalic &kObfuscated &rreset");
            localeConfig.set("Translations.Active Character", "&F[&4Rpg Player&F] &2Your Active Character Name is &6");
            //chat translations
            localeConfig.set("Translations.Chat Left Click", "&2Left click to join this channel or switch it's color");
            localeConfig.set("Translations.Chat Right Click", "&4Right click to leave this channel");
            localeConfig.set("Translations.Chat Shift Click", "&9Shift click to set this as your active channel");
            //test command
            localeConfig.set("General Commands.Test Command.Alias", "test");
            localeConfig.set("General Commands.Test Command.Help Color", "&2");
            localeConfig.set("General Commands.Test Command.Description", "&fThis command will be going away soon. &2Usage: &f/test");
            //Player Info Command
            localeConfig.set("General Commands.Player Info.Alias", "pinfo");
            localeConfig.set("General Commands.Player Info.Help Color", "&2");
            localeConfig.set("General Commands.Player Info.Description", "&fA way of freezing yourself in one place. &2Usage: &f/setwarp warpname");
            //help Command
            localeConfig.set("General Commands.Help Command.Alias", "Help");
            localeConfig.set("General Commands.Help Command.Help Color", "&2");
            localeConfig.set("General Commands.Help Command.Description", "&fShow the different help Pages. &2Usage: &f/help page#");
            if (warpsOn) {
                localeConfig.set("Warp Commands.Set Warp.Alias", "setwarp");
                localeConfig.set("Warp Commands.Set Warp.Help Color", "&2");
                localeConfig.set("Warp Commands.Set Warp.Description", "&fSet a new Warp Point. &2Usage: &f/setwarp warpname");

                localeConfig.set("Warp Commands.Delete Warp.Alias", "delwarp");
                localeConfig.set("Warp Commands.Delete Warp.Help Color", "&2");
                localeConfig.set("Warp Commands.Delete Warp.Description", "&fDelete a Warp Point. &2Usage: &f/delwarp warpname");

                localeConfig.set("Warp Commands.Use Warp.Alias", "warp");
                localeConfig.set("Warp Commands.Use Warp.Help Color", "&2");
                localeConfig.set("Warp Commands.Use Warp.Description", "&fUse a Warp Point. &2Usage: &f/warp warpname");

                localeConfig.set("Warp Commands.Save Warp.Alias", "savewarp");
                localeConfig.set("Warp Commands.Save Warp.Help Color", "&2");
                localeConfig.set("Warp Commands.Save Warp.Description", "&fSave a specific Warp Point to config. &2Usage: &f/savewarp warpname");

                localeConfig.set("Warp Commands.Edit Warp.Alias", "editwarp");
                localeConfig.set("Warp Commands.Edit Warp.Help Color", "&2");
                localeConfig.set("Warp Commands.Edit Warp.Description", "&fEdit the attributes of a Warp Point. &2Usage: &f/editwarp warpname <Cd | World | Level | Perm | Variance | item> <true/false>");

                localeConfig.set("Warp Commands.Edit set.Alias", "editset");
                localeConfig.set("Warp Commands.Edit set.Help Color", "&2");
                localeConfig.set("Warp Commands.Edit set.Description", "&fEdit the attributes of a Warp Set. &2Usage: &f/editset setname <values coming soon>");

                localeConfig.set("Warp Commands.Make Set.Alias", "makeset");
                localeConfig.set("Warp Commands.Make Set.Help Color", "&2");
                localeConfig.set("Warp Commands.Make Set.Description", "&fMake a new Warp Set. &2Usage: &f/makeset setname");

                localeConfig.set("Warp Commands.Delete set.Alias", "delset");
                localeConfig.set("Warp Commands.Delete set.Help Color", "&2");
                localeConfig.set("Warp Commands.Delete set.Description", "&fdelete a warp set &4Warning!!! This deletes all Warps in the set!!!. &2Usage: &f/delset setname");

                localeConfig.set("Warp Commands.Load Warps.Alias", "loadwarps");
                localeConfig.set("Warp Commands.Load Warps.Help Color", "&2");
                localeConfig.set("Warp Commands.Load Warps.Description", "&fLoad all warps and sets from config: &f/loadwarps");

                localeConfig.set("Warp Commands.Edit Warp Values.Alias", "warpvalues");
                localeConfig.set("Warp Commands.Edit Warp Values.Help Color", "&2");
                localeConfig.set("Warp Commands.Edit Warp Values.Description", "Edit the attributes of a Warp Point. &2Usage: &f/editwarp warpname <Cd |Level | Perm | Variance | Material | iName | iLore> <Value_settings>");

            }

        }
        if (guildsOn) {
            if (guildConfig.get("Guilds Info") == null) {
                guildConfig.set("Guilds Info", "This File will save all guild info, Mysql is highly recommended!");
            }
        }
        if (chatOn) {
            if (cityConfig.get("Rpg Cities") == null) {
                RpgAPI.cityConfig.set("Rpg Cities.Example City.Radius", 100);
                RpgAPI.cityConfig.set("Rpg Cities.Example City.X", 0.0);
                RpgAPI.cityConfig.set("Rpg Cities.Example City.Y", 0.0);
                RpgAPI.cityConfig.set("Rpg Cities.Example City.Z", 0.0);
                RpgAPI.cityConfig.set("Rpg Cities.Example City.World", "World");
            }
            if (regionConfig.get("Rpg Regions") == null) {
                RpgAPI.regionConfig.set("Rpg Regions.Example Region.Radius", 100);
                RpgAPI.regionConfig.set("Rpg Regions.Example Region.X", 0.0);
                RpgAPI.regionConfig.set("Rpg Regions.Example Region.Y", 0.0);
                RpgAPI.regionConfig.set("Rpg Regions.Example Region.Z", 0.0);
                RpgAPI.regionConfig.set("Rpg Regions.Example Region.World", "World");
            }
            if (chatConfig.get("Channels") == null) {
                chatConfig.set("Titles and Names", "&7[@World]&2[@Guild]&3[@Channel]&r[@Prefix @Pname @Suffix&F]");
                //whisper Chat
                chatConfig.set("Chats.Whisper.Name", "Whisper");
                chatConfig.set("Chats.Whisper.Nick Name", "W");
                chatConfig.set("Chats.Whisper.Enabled", true);
                chatConfig.set("Chats.Whisper.Spy Enabled", true);
                chatConfig.set("Chats.Whisper.Use Basic", true);
                chatConfig.set("Chats.Whisper.Use Language", true);
                chatConfig.set("Chats.Whisper.Use Distance", true);
                chatConfig.set("Chats.Whisper.Distance", 5);
                chatConfig.set("Chats.Whisper.Use Party", false);
                chatConfig.set("Chats.Whisper.Use Guild", false);
                chatConfig.set("Chats.Whisper.Use Region", false);
                chatConfig.set("Chats.Whisper.Use City", false);
                chatConfig.set("Chats.Whisper.Use World", false);

                //local chat
                chatConfig.set("Chats.Local.Name", "Local");
                chatConfig.set("Chats.Local.Nick Name", "L");
                chatConfig.set("Chats.Local.Enabled", true);
                chatConfig.set("Chats.Local.Spy Enabled", true);
                chatConfig.set("Chats.Local.Use Basic", true);
                chatConfig.set("Chats.Local.Use Language", true);
                chatConfig.set("Chats.Local.Use Distance", true);
                chatConfig.set("Chats.Local.Distance", 50);
                chatConfig.set("Chats.Local.Use Party", false);
                chatConfig.set("Chats.Local.Use Guild", false);
                chatConfig.set("Chats.Local.Use Region", false);
                chatConfig.set("Chats.Local.Use City", false);
                chatConfig.set("Chats.Local.Use World", false);

                //shout Chat
                chatConfig.set("Chats.Shout.Name", "Shout");
                chatConfig.set("Chats.Shout.Nick Name", "Yell");
                chatConfig.set("Chats.Shout.Enabled", true);
                chatConfig.set("Chats.Shout.Spy Enabled", true);
                chatConfig.set("Chats.Shout.Use Basic", true);
                chatConfig.set("Chats.Shout.Use Language", true);
                chatConfig.set("Chats.Shout.Use Distance", true);
                chatConfig.set("Chats.Shout.Distance", 150);
                chatConfig.set("Chats.Shout.Use Party", false);
                chatConfig.set("Chats.Shout.Use Guild", false);
                chatConfig.set("Chats.Shout.Use Region", false);
                chatConfig.set("Chats.Shout.Use City", false);
                chatConfig.set("Chats.Shout.Use World", false);

                //General chat
                chatConfig.set("Chats.General.Name", "General");
                chatConfig.set("Chats.General.Nick Name", "Gen");
                chatConfig.set("Chats.General.Enabled", true);
                chatConfig.set("Chats.General.Spy Enabled", true);
                chatConfig.set("Chats.General.Use Basic", true);
                chatConfig.set("Chats.General.Use Language", true);
                chatConfig.set("Chats.General.Use Distance", false);
                chatConfig.set("Chats.General.Use Party", false);
                chatConfig.set("Chats.General.Use Guild", false);
                chatConfig.set("Chats.General.Use Region", false);
                chatConfig.set("Chats.General.Use City", false);
                chatConfig.set("Chats.General.Use World", false);

                //party Chat
                chatConfig.set("Chats.Party.Name", "Party");
                chatConfig.set("Chats.Party.Nick Name", "Pc");
                chatConfig.set("Chats.Party.Enabled", true);
                chatConfig.set("Chats.Party.Spy Enabled", true);
                chatConfig.set("Chats.Party.Use Basic", true);
                chatConfig.set("Chats.Party.Use Language", true);
                chatConfig.set("Chats.Party.Use Distance", false);
                chatConfig.set("Chats.Party.Use Party", true);
                chatConfig.set("Chats.Party.Use Guild", false);
                chatConfig.set("Chats.Party.Use Region", false);
                chatConfig.set("Chats.Party.Use City", false);
                chatConfig.set("Chats.Party.Use World", false);

                //guild chat
                chatConfig.set("Chats.Guild.Name", "Guild");
                chatConfig.set("Chats.Guild.Nick Name", "G");
                chatConfig.set("Chats.Guild.Enabled", true);
                chatConfig.set("Chats.Guild.Spy Enabled", true);
                chatConfig.set("Chats.Guild.Use Basic", true);
                chatConfig.set("Chats.Guild.Use Language", true);
                chatConfig.set("Chats.Guild.Use Distance", false);
                chatConfig.set("Chats.Guild.Use Party", false);
                chatConfig.set("Chats.Guild.Use Guild", true);
                chatConfig.set("Chats.Guild.Use Region", false);
                chatConfig.set("Chats.Guild.Use City", false);
                chatConfig.set("Chats.Guild.Use World", false);

                //world chat
                chatConfig.set("Chats.World.Name", "World");
                chatConfig.set("Chats.Guild.Nick Name", "world");
                chatConfig.set("Chats.World.Enabled", true);
                chatConfig.set("Chats.World.Spy Enabled", true);
                chatConfig.set("Chats.World.Use Basic", true);
                chatConfig.set("Chats.World.Use Language", true);
                chatConfig.set("Chats.World.Use Distance", false);
                chatConfig.set("Chats.World.Use Party", false);
                chatConfig.set("Chats.World.Use Guild", false);
                chatConfig.set("Chats.World.Use Region", false);
                chatConfig.set("Chats.World.Use City", false);
                chatConfig.set("Chats.World.Use World", true);

                //region Chat
                chatConfig.set("Chats.Region.Name", "Region");
                chatConfig.set("Chats.Region.Nick Name", "Reg");
                chatConfig.set("Chats.Region.Enabled", true);
                chatConfig.set("Chats.Region.Spy Enabled", true);
                chatConfig.set("Chats.Region.Use Basic", true);
                chatConfig.set("Chats.Region.Use Language", true);
                chatConfig.set("Chats.Region.Use Distance", false);
                chatConfig.set("Chats.Region.Use Party", false);
                chatConfig.set("Chats.Region.Use Guild", false);
                chatConfig.set("Chats.Region.Use Region", true);
                chatConfig.set("Chats.Region.Use City", false);
                chatConfig.set("Chats.Region.Use World", true);

                //trade chat
                chatConfig.set("Chats.Trade.Name", "Trade");
                chatConfig.set("Chats.Trade.Nick Name", "Tr");
                chatConfig.set("Chats.Trade.Enabled", true);
                chatConfig.set("Chats.Trade.Spy Enabled", true);
                chatConfig.set("Chats.Trade.Use Basic", true);
                chatConfig.set("Chats.Trade.Use Language", true);
                chatConfig.set("Chats.Trade.Use Distance", false);
                chatConfig.set("Chats.Trade.Use Party", false);
                chatConfig.set("Chats.Trade.Use Guild", false);
                chatConfig.set("Chats.Trade.Use Region", false);
                chatConfig.set("Chats.Trade.Use City", true);
                chatConfig.set("Chats.Trade.Use World", false);


            }
        }
        if (foodOn) {
            if (foodConfig.get("Rpg Foods") == null) {
                foodConfig.set("Rpg Foods", "This file will save all your Rpg Food Items");
            }
        }
        if (clickOn) {
            if (clickConfig.get("Click File") == null) {
                clickConfig.set("Click File", "This File is used to save all your click menu's");
            }
        }
        if (settingsConfig.get("Settings") == null) {
            settingsConfig.set("Settings", "this file is used for all plugin settings!");
        }
        if (achievementsOn) {
            if (achievementConfig.get("Achievements") == null) {
                achievementConfig.set("Achievements", "This file stores all your servers saved Achievements");
            }
        }
        if (minionsOn) {
            if (minionConfig.get("Minions") == null) {
                minionConfig.set("Minions", "this file is used to store all minion and monster data (Mysql is highly recommended!");
            }
        }
        if (classesOn) {
            if (classConfig.get("Classes") == null) {
                classConfig.set("Classes", "This file is used to save all Rpg Classes");
            }
        }
        if (warpsOn) {
            warpConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/WarpConfig.yml"));
        }
        try {
            playerConfig.save(new File("plugins/RpgAPI/RpgPlayers.yml"));
            localeConfig.save(new File("plugins/RpgAPI/Locale.yml"));
            testPlayer.save(new File("plugins/RpgAPI/RpgPlayer/TestPlayer.yml"));
            if (guildsOn) {
                guildConfig.save(new File("plugins/RpgAPI/Guilds.yml"));
            }
            if (chatOn) {
                chatConfig.save(new File("plugins/RpgAPI/ChatChannels.yml"));
                cityConfig.save((new File("plugins/RpgAPI/RpgChat/RpgCities.yml")));
                regionConfig.save((new File("plugins/RpgAPI/RpgChat/RpgRegions.yml")));
            }
            if (foodOn) {
                foodConfig.save(new File("plugins/RpgAPI/Food.yml"));
            }
            if (clickOn) {
                clickConfig.save(new File("plugins/RpgAPI/Clicks.yml"));
            }
            settingsConfig.save(new File("plugins/RpgAPI/Settings.yml"));
            if (achievementsOn) {
                achievementConfig.save(new File("plugins/RpgAPI/Achievements.yml"));
            }
            if (minionsOn) {
                minionConfig.save(new File("plugins/RpgAPI/Minions.yml"));
            }
            if (classesOn) {
                classConfig.save(new File("plugins/RpgAPI/Classes.yml"));
            }
            if (minionsOn) {
                mobCommand.save(new File("plugins/RpgAPI/MobCommands.yml"));
            }
            if (poisonedEarthOn) {
                poisonCommand.save(new File("plugins/RpgAPI/Poisons.yml"));
            }
            if (warpsOn) {
                warpConfig.save(new File("plugins/RpgAPI/WarpConfig.yml"));
            }
        } catch (IOException e) {
        }
        for (String s : localeConfig.getConfigurationSection("Translations").getKeys(false)) {
            localeSettings.put(s, localeConfig.getString("Translations." + s));
        }
        List<String> generalCommands = new ArrayList<String>();

        for (String command : localeConfig.getConfigurationSection("General Commands").getKeys(false)) {
            String commandRT = localeConfig.getString("General Commands." + command + ".Alias");
            String helpColor = localeConfig.getString("General Commands." + command + ".Help Color");
            String descText = localeConfig.getString("General Commands." + command + ".Description");
            HelpFile cmd = new HelpFile();
            cmd.setCmdAlias(commandRT);
            cmd.setAliasColor(helpColor);
            cmd.setDescription(descText);
            cmd.setHelpGroup("General Commands");
            helpMap.add(cmd);
            commands.add(commandRT);
            commandSettings.put(command, commandRT);
            generalCommands.add(commandRT);
        }
        pluginCommand.put("General Commands", generalCommands);
        List<String> warpCommands = new ArrayList<String>();
        for (String command : localeConfig.getConfigurationSection("Warp Commands").getKeys(false)) {
            String commandRT = localeConfig.getString("Warp Commands." + command + ".Alias");
            String helpColor = localeConfig.getString("Warp Commands." + command + ".Help Color");
            String descText = localeConfig.getString("Warp Commands." + command + ".Description");
            HelpFile cmd = new HelpFile();
            cmd.setCmdAlias(commandRT);
            cmd.setAliasColor(helpColor);
            cmd.setDescription(descText);
            cmd.setHelpGroup("Warp Commands");
            helpMap.add(cmd);
            commands.add(commandRT);
            commandSettings.put(command, commandRT);
            warpCommands.add(commandRT);
        }
        pluginCommand.put("Warp Commands", warpCommands);
        //SetBuilder.minionCommand();

        if (warpsOn) {
            WarpSetBuilder.BuildSets();
            new BukkitRunnable() {
                @Override
                public void run() {
                    WarpBuilder.WarpLoader();
                }
            }.runTaskLater(plugin, 5);
        }
        if (poisonedEarthOn) {
            PoisonBuilder.newPoison();
            PoisonTimeChecker.PoisonRegionTimer();
            for (String pName : playerConfig.getConfigurationSection("Player Colors").getKeys(false)) {
                playerColors.put(pName, playerConfig.getString("Player Colors." + pName));
            }
        }
        if (chatOn) {
            LoadCities.FromFile();
            LoadRegions.FromFile();
            nameDisplays = chatConfig.getString("Titles and Names");
            for (String chats : chatConfig.getConfigurationSection("Chats").getKeys(false)) {
                //general chat
                if (chatConfig.getBoolean("Chats." + chats + ".Enabled")) {
                    ChatClass chatClass = new ChatClass();
                    chatClass.setChannelName(chats);
                    chatClass.setChannelNick(chatConfig.getString("Chats." + chats + ".Nick Name"));
                    chatRealNames.put(chatConfig.getString("Chats." + chats + ".Nick Name"), chats);
                    commands.add(chatClass.getChannelNick());
                    chatClass.setChatSpy(chatConfig.getBoolean("Chats." + chats + ".Spy Enabled"));
                    if (chatConfig.getBoolean("Chats." + chats + ".Use Basic")) {
                        chatClass.addBehavior(new BasicChatBehavior());
                    }
                    if (chatConfig.getBoolean("Chats." + chats + ".Use Language")) {
                        chatClass.addBehavior(new LanguageBehavior());
                    }
                    if (chatConfig.getBoolean("Chats." + chats + ".Use Distance")) {
                        chatClass.addBehavior(new DistanceChatBehavior());
                        chatDistances.put(chats, chatConfig.getInt("Chats." + chats + ".Distance"));
                    }
                    if (chatConfig.getBoolean("Chats." + chats + ".Use Party")) {
                        chatClass.addBehavior(new PartyChatBehavior());
                    }
                    if (chatConfig.getBoolean("Chats." + chats + ".Use Guild")) {
                        chatClass.addBehavior(new GuildChatBehavior());
                    }
                    if (chatConfig.getBoolean("Chats." + chats + ".Use Region")) {
                        chatClass.addBehavior(new RegionChatBehavior());
                    }
                    if (chatConfig.getBoolean("Chats." + chats + ".Use City")) {
                        chatClass.addBehavior(new CityChatBehavior());
                    }
                    if (chatConfig.getBoolean("Chats." + chats + ".Use World")) {
                        chatClass.addBehavior(new WorldChatBehavior());
                    }
                    chatClasses.add(chatClass);
                }
            }
        }

    }

    public static RpgPlayer getRp(String name) {
        String nick = activeNicks.get(name);
        RpgPlayer rp = rpgPlayers.get(nick);
        return rp;
    }

    public static RpgPlayer getRp(Player p) {
        return getRp(p.getName());
    }

    @Override
    public void onDisable() {
        LoadCities.ToFile();
        LoadRegions.ToFile();
        for (String thisWarp : RpgAPI.savedWarps.keySet()) {
            if (warpsOn) {
                WarpBuilder.SaveWarp(thisWarp);
                WarpSetBuilder.SaveSets();
            }
        }
        playerConfig.set("Player Colors", playerColors);
        try {
            if (warpsOn) {
                warpConfig.save(new File("plugins/RpgAPI/WarpConfig.yml"));
            }
            playerConfig.save(new File("plugins/RpgAPI/RpgPlayers.yml"));
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

    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerCommand(PlayerCommandPreprocessEvent event) {
        Player p = event.getPlayer();
        String s = event.getMessage();
        String[] args = s.split(" ");
        String cmdAlias = args[0].replaceAll("/", "");
        for (String command : commands) {
            if (cmdAlias.equalsIgnoreCase(command)) {
                UniqueCommands.BaseCommandHandler(p, args);
                event.setCancelled(true);
            }
        }
        // For testing Trading
        args[0] = args[0].replace("/", "");
        TradeCommandProcessor.process(p, args);
    }


}
