package com.vartala.soulofw0lf.rpgapi;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import com.vartala.soulofw0lf.rpgapi.achievementapi.TitleAchievement;
import com.vartala.soulofw0lf.rpgapi.chatapi.*;
import com.vartala.soulofw0lf.rpgapi.classapi.RpgClasses;
import com.vartala.soulofw0lf.rpgapi.commandapi.UniqueCommands;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.DespawnReason;
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
import com.vartala.soulofw0lf.rpgapi.loaders.*;
import com.vartala.soulofw0lf.rpgapi.locale.LocaleSetting;
import com.vartala.soulofw0lf.rpgapi.minionapi.MinionEntity;
import com.vartala.soulofw0lf.rpgapi.mobcommandapi.MobCommand;
import com.vartala.soulofw0lf.rpgapi.mobcommandapi.MobEditingChatListener;
import com.vartala.soulofw0lf.rpgapi.partyapi.LFGPlayer;
import com.vartala.soulofw0lf.rpgapi.partyapi.PartyGroup;
import com.vartala.soulofw0lf.rpgapi.permissionsapi.PermissionGroup;
import com.vartala.soulofw0lf.rpgapi.playerapi.RpgPlayer;
import com.vartala.soulofw0lf.rpgapi.poisonapi.RpgPoison;
import com.vartala.soulofw0lf.rpgapi.savers.ChatSaver;
import com.vartala.soulofw0lf.rpgapi.savers.VecSaver;
import com.vartala.soulofw0lf.rpgapi.spellapi.MagicSpell;
import com.vartala.soulofw0lf.rpgapi.sqlapi.SQLHandler;
import com.vartala.soulofw0lf.rpgapi.tradeapi.TradeCommandProcessor;
import com.vartala.soulofw0lf.rpgapi.tradeapi.TradeEventListener;
import com.vartala.soulofw0lf.rpgapi.tradeapi.TradeHandler;
import com.vartala.soulofw0lf.rpgapi.util.HelpFile;
import com.vartala.soulofw0lf.rpgapi.util.HelpPage;
import com.vartala.soulofw0lf.rpgapi.util.RPGLogging;
import com.vartala.soulofw0lf.rpgapi.vectorapi.RpgVectorBlocks;
import com.vartala.soulofw0lf.rpgapi.warpsapi.RpgWarp;
import com.vartala.soulofw0lf.rpgapi.warpsapi.WarpBuilder;
import com.vartala.soulofw0lf.rpgapi.warpsapi.WarpSetBuilder;
import com.vartala.soulofw0lf.rpgapi.warpsapi.WarpSets;
import com.vartala.soulofw0lf.rpgapi.entityapi.EntityManager;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.plugin.java.JavaPlugin;


import com.vartala.soulofw0lf.rpgapi.eventsapi.MapRightClickEvent;
import com.vartala.soulofw0lf.rpgapi.listenersapi.MapListener;
import com.vartala.soulofw0lf.rpgapi.listenersapi.playerLogIn;
import com.vartala.soulofw0lf.rpgapi.mapsapi.ScrollMap;
import com.vartala.soulofw0lf.rpgapi.util.PlayerUtil;
import org.bukkit.util.Vector;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

//@author soulofwolf linksbro..
public class RpgAPI extends JavaPlugin implements Listener {
    //Plugins
    public static RpgAPI plugin;

    //
    //files
    public static YamlConfiguration playerConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayers.yml"));
    public static YamlConfiguration tradeConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Trade.yml"));
    public static YamlConfiguration tradeLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Trade.yml"));
    public static YamlConfiguration playerLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/RpgPlayers.yml"));
    public static YamlConfiguration localeConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale.yml"));
    public static YamlConfiguration guildConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Guilds.yml"));
    public static YamlConfiguration guildLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Guilds.yml"));
    public static YamlConfiguration foodConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Food.yml"));
    public static YamlConfiguration foodLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Food.yml"));
    public static YamlConfiguration clickConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Clicks.yml"));
    public static YamlConfiguration clickLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Clicks.yml"));
    public static YamlConfiguration settingsConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Settings.yml"));
    public static YamlConfiguration settingsLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Settings.yml"));
    public static YamlConfiguration achievementConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Achievements.yml"));
    public static YamlConfiguration achievementLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Achievements.yml"));
    public static YamlConfiguration minionConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Minions.yml"));
    public static YamlConfiguration minionLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Minions.yml"));
    public static YamlConfiguration classConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Classes.yml"));
    public static YamlConfiguration classLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Classes.yml"));
    public static YamlConfiguration mobCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/MobCommands.yml"));
    public static YamlConfiguration mobLocaleCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/MobCommands.yml"));
    public static YamlConfiguration poisonCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Poisons.yml"));
    public static YamlConfiguration poisonLocaleCommand = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Poisons.yml"));
    public static YamlConfiguration worldBorder = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgBorders.yml"));
    public static YamlConfiguration worldLocaleBorder = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/RpgBorders.yml"));

    public static Map<String, PermissionAttachment> permAttachments = new HashMap<>();
    public static boolean chatInConsole = true;
    public static Map<Block, RpgVectorBlocks> vecBlockMap = new HashMap<>();
    public static List<Block> vecBlocks = new ArrayList<>();


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
    public static boolean duelsOn = true;
    public static boolean permsOn = true;
    public static boolean vectorOn = true;


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
    public static List<RpgClickInv> deleteOnClose = new ArrayList<>();
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
    public static Map<String, String> permissionSettings = new HashMap<>();
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
    public static Map<String, PermissionGroup> permGroups = new HashMap<>();
    public static String defaultGroup = "";
    public static Block jumpBlock;
    public static Vector vec;
    public static List<String> noLeaveChats = new ArrayList<>();
    public static List<String> defaultChats = new ArrayList<>();
    public static List<String> recentlyJumped = new ArrayList<>();
    public static String firstChat = "";

    //RE stuff
    public final Map<String, EntityManager> m_managers = new HashMap<String, EntityManager>();
    public static final String COMPATIBLE_VERSION = "1.6.2";


    public static RpgAPI getInstance() {
        return plugin;
    }

    /**
     * Only load content that is enabled through config during onEnable
     *
     */
    @Override
    public void onEnable() {
        plugin = this;
        //load the default config if it doesn't exist
        saveDefaultConfig();
        //set all config based booleans to check which plugin features are enabled
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
        permsOn = getConfig().getBoolean("Plugins.Permissions");
        vectorOn = getConfig().getBoolean("Plugins.Vector Blocks");

        //register global listeners
        Bukkit.getPluginManager().registerEvents(this, this);
        this.MapListen = new MapListener(this);
        this.PlayerListener = new playerLogIn(this);
        LocaleSetting.localeLoader();

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

        /*
        default ymls and initial settings
         */

        //player config
        playerConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayers.yml"));
        playerLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/RpgPlayers.yml"));
        if (playerConfig.get("Active Nicks") == null) {
            playerConfig.set("Active Nicks.Sample Player", "Sample Nick");
            playerConfig.set("Player Colors.soulofw0lf", "&4");
        }
        for (String players : playerConfig.getConfigurationSection("Active Nicks").getKeys(false)) {
            String currentNick = playerConfig.getString("Active Nicks." + players);
            activeNicks.put(players, currentNick);
        }

        //settings config, i'm sure we'll use ti for something eventually
        settingsConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Settings.yml"));
        settingsLocaleConfig = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Locale/Settings.yml"));
        if (settingsConfig.get("Settings") == null) {
            settingsConfig.set("Settings", "this file is used for all plugin settings!");
        }

        //default file structure for rpgplayers
        File f = new File("plugins/RpgAPI/RpgPLayers");
        File[] files = f.listFiles();
        if (!(files == null)) {
            for (File playerFile : files) {
                YamlConfiguration.loadConfiguration(playerFile);
            }
        }

        /*
        all yml files to be loaded if they are turned on. sorted in alphabetic order for ease of reference
         */

         commands.add("zomb");
        //check for achievements and load settings
        if (achievementsOn) {new AchievementLoader();}

        //check for border and load settings
        if (borderOn) {new BorderLoader();}

        //check for chat and load settings
        if (chatOn) {new ChatLoader(this);}

        //check for classes and load settings
        if (classesOn) {new RpgClassLoader();}

        //check for click and load settings
        if (clickOn) {new ClickLoader(this);}

        //check for food and load setting
        if (foodOn) {new FoodLoader(this);}

        //check for guilds and load settings
        if (guildsOn) {new GuildLoader();}

        //check for languages and load settings
        if (languagesOn) {new LanguageLoader();}

        //check for minions and load settings
        if (minionsOn) {new MinionLoader(this);}

        //check for poisoned earth and load settings
        if (poisonedEarthOn) {new PoisonLoader(this);}

        //check for trade and load settings
        if (tradeOn) {new TradeLoader(this);}

        //check for vector settings
        if (vectorOn) {new VectorLoader(this);}

        //check for warp and load settings
        if (warpsOn) {new WarpLoader();}

        try {
            playerConfig.save(new File("plugins/RpgAPI/RpgPlayers.yml"));
            localeConfig.save(new File("plugins/RpgAPI/Locale.yml"));
            settingsConfig.save(new File("plugins/RpgAPI/Settings.yml"));
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

        for (String pName : playerConfig.getConfigurationSection("Player Colors").getKeys(false)) {
            playerColors.put(pName, playerConfig.getString("Player Colors." + pName));
        }
    }

    /**
     * get an rpg player from a player name
     *
     * @param name player name
     * @return RpgPlayer Object
     */
    public static RpgPlayer getRp(String name) {
        return rpgPlayers.get(activeNicks.get(name));
    }

    /**
     * get an RpgPlayer from a player object
     *
     * @param p  player object
     * @return RpgPlayer Object
     */
    public static RpgPlayer getRp(Player p) {
        return rpgPlayers.get(activeNicks.get(p.getName()));
    }

    /**
     *
     */
    @Override
    public void onDisable() {
        if (chatOn){
            LoadCities.ToFile();
            LoadRegions.ToFile();
            new ChatSaver();
        }
        if (vectorOn) {
            new VecSaver();
            vecBlockMap.clear();
            vecBlocks.clear();
        }
        if (warpsOn) {
            for (String thisWarp : RpgAPI.savedWarps.keySet()) {
                WarpBuilder.SaveWarp(thisWarp);
                WarpSetBuilder.SaveSets();
            }
        }
        playerConfig.set("Player Colors", playerColors);
        try {
            playerConfig.save(new File("plugins/RpgAPI/RpgPlayers.yml"));
        } catch (IOException e) {
        }
       // for(EntityManager manager : m_managers.values())
        //{
         //   manager.despawnAll(DespawnReason.PLUGIN_DISABLE);
          //  manager.unregisterEntityLoader();
        //}

    }

    /**
     *
     * @param event
     */
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

    /**
     * Grab command input before it is executed so have the appearance of dynamically registering commands
     * Uses the commands List to stop the command handler and use custom handlers instead
     *
     * @param event PlayerCommandPreProcessEvent
     */


    @EventHandler(priority = EventPriority.HIGHEST)
    public void playerCommand(PlayerCommandPreprocessEvent event) {
        Player p = event.getPlayer();
        String s = event.getMessage();
        String[] args = s.split(" ");
        String cmdAlias = args[0].replaceAll("/", "");
        for (String command : commands) {
            if (cmdAlias.equalsIgnoreCase(command)) {
                event.setCancelled(true);
                UniqueCommands.BaseCommandHandler(p, args);

            }
        }
        // For testing Trading
        args[0] = args[0].replace("/", "");
        TradeCommandProcessor.process(p, args);
        if (args[0].equalsIgnoreCase("crypt")){
            if (args.length >= 1){
            p.sendMessage(args[1]);
            String code = encode(args[1]);
            p.sendMessage(code);
            String unCode = decode(code);
            p.sendMessage(unCode);
            event.setCancelled(true);
            return;
            }
        }
    }
    public String getPresentMinecraftVersion()
    {
        String fullVersion = Bukkit.getServer().getVersion();
        String[] split = fullVersion.split("MC: ");
        split = split[1].split("\\)");

        return split[0];
    }
    /**
     * Get a ChatClass object by name
     *
     * @param displayName the name of the ChatClass object you are looking for
     * @return A ChatClass object from the chatClasses List
     */
    public static ChatClass getChatByName(String displayName) {
        ChatClass thisChat = new ChatClass();
        for (ChatClass ch : chatClasses){
            if (ch.getChannelName().equalsIgnoreCase(displayName)){
                thisChat = ch;
            }
        }
        return thisChat;
    }
    public static RpgVectorBlocks getVecByName(String s){
        for (Block b : vecBlockMap.keySet()){
            RpgVectorBlocks rV = vecBlockMap.get(b);
            if (rV.getName().equalsIgnoreCase(s)){
                return rV;
            }
        }
        return null;
    }

    private String encode(String str) {
        BASE64Encoder encoder = new BASE64Encoder();
        str = encoder.encodeBuffer(str.getBytes());
        return str;
    }

    private String decode(String str) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            str = new String(decoder.decodeBuffer(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }
    public static void listVecNames(Player p){
        for (Block b : vecBlockMap.keySet()){
            RpgVectorBlocks rV = vecBlockMap.get(b);
            p.sendMessage(rV.getName());
        }
    }
}
