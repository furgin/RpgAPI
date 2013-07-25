package com.vartala.soulofw0lf.rpgapi.playerapi;

import java.util.*;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.enumapi.*;
import com.vartala.soulofw0lf.rpgapi.permissionsapi.PermissionGroup;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permissible;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.plugin.Plugin;

/*
 * main player wrapper class
 * holds all variables related to the online player
 */
public class RpgPlayer implements Permissible {
    //
    /*
	 * all vars go above the player method
	 */
	
	/*
	 * general variables
	 */
    //perm groups
    private Map<String, List<String>> permGroups = new HashMap<>();

    //individual perms
    private Map<String, List<String>> individualPerms = new HashMap<>();

    //used for mob editing
    public String chatLock = "";

    //the players actual name
    private String realName = "";

    //rpg player name
    private String name = "";

    //player TP invite state
    private boolean tpInviteState = false;

    //is the player currently in a menu
    private boolean menuOpen = false;

    //get wether a player has moved from a previous position
    private boolean locationChanged = false;

    //player Lawful / neutral / chaotic alignment
    private String lawfulAlignment = "";

    //players Good Neutral Evil Alignment
    private String goodAlignment = "";

    //is the player immune to poison
    private boolean poisonProof = false;

    //is the player currently poisoned
    private boolean poisoned = false;

    private boolean pvp = false;

    private boolean useOp = false;


    /*
     * Rpg Races Variables
     */
    //players race name
    private String race = "";


    /*
     * rpgfood variables
     */
    //is the player currently eatting
    private boolean eating = false;

    //does the player already have a food buff
    private boolean buffed = false;


    /*
     * rpg party variables
     */
    //does the player have a pending party invite
    private boolean partyInvite = false;

    //does the player want a gui to automatically
    //open when being invited to partys
    private boolean partyGui = true;

    //is the player in a party
    private boolean inParty = false;

    //party leader of the party
    private String leaderName = "";

    //auto pass on rolls
    private boolean passingRolls = false;

    //auto need on rolls
    private boolean needingRolls = false;

    //auto greed on rolls
    private boolean greedingRolls = false;

    //auto open loot window for player
    private boolean lootGui = true;


	/*
	 * rpg guilds variables
	 */

    //does the player have a pending guild invite
    private boolean guildInvite = false;

    //should the guild accept gui auto open on a guild invitation
    private boolean guildGui = true;

    //is the player in a guild
    private boolean inGuild = false;

    //what is the players guild name
    private String guild = "";

    //what is the players rank within a guild
    private String guildRank = "";


    /*
     * rpg friends variables
     */
    //should the friend gui auto open on friend invite?
    private boolean friendsGui = true;

    //player friends list
    private List<String> friendsList = new ArrayList<String>();

    /*
     *duel variables
     */
    private boolean inDuel = false;
    private String whoDuelling = "";

    /*
     * trade variables
     */
    //is the player currently in trade
    private boolean inTrade = false;


    private boolean inConfirm = false;

    //the players total copper
    private int coin = 0;

    //if a receiver is waiting for a trade
    private String waitTrade = "";

    private boolean defaultTrade = true;

	
	/*
	 * chat variables
	 */

    //colors of chat channel mapped to channel name
    private Map<String, String> channelColor = new HashMap<>();

    //active channel a player is talking in
    private String activeChannel = "";

    //all players on ignore
    private List<String> ignoreList = new ArrayList<String>();

    //does the player have a pending chat invite
    private boolean chatInvite = false;

    //list of channels the player has invites for
    private List<String> invitedChats = new ArrayList<String>();

    //list of channels the player is banned from
    private List<String> bannedChats = new ArrayList<String>();

    //list of channels the player is muted in
    private List<String> mutedChats = new ArrayList<String>();

    //list of channels the player owns
    private List<String> ownedChats = new ArrayList<String>();

    //list of channels the player is a mod in
    private List<String> modChats = new ArrayList<String>();

    //is chat spy toggled on or off
    private boolean SpyingOnChats = false;

    /*
     * booleans for which message prefixes are shown in chat
     */
    private boolean showingGuildTags = true;
    private boolean showingAchieveTitles = true;
    private boolean showingChannelNames = true;
    private boolean showingLanguageNames = true;
    private boolean showingWorldName = true;
	
	/*
	 * rpg achievements variables
	 */

    //players active prefix title
    private String activePrefix = "";

    //players active suffix title
    private String activeSuffix = "";

    //list of all titles a player has earned
    private List<String> titles = new ArrayList<String>();

    //list of mobs killed with counter
    private Map<String, Integer> mobKills = new HashMap<>();

    //list of players killed with counter
    private Map<String, Integer> playerKills = new HashMap<>();

    //food items a player has eaten
    private Map<String, Integer> eatenItems = new HashMap<>();

    //Items used
    private Map<String, Integer> itemsUsed = new HashMap<>();


    /*
     * rpg click variables
     */
    //should the player use the default shift click on player behavior
    private boolean UseClick = true;

	
	/*
	 * rpg language variables
	 */

    //players active spoken language
    private String activeLanguage = "Common";

    //all languages a player knows
    private List<String> knownLanguages = new ArrayList<String>();

    //should languages a player doesn't know be shown in chat?
    private boolean languagesInChat = true;

		
	
	/*
	 * rpg lobby variables
	 */

    //is the player in a lobby?
    private boolean inLobby = false;

    //serialised armor inventory for a player
    private String armorInventory = "";

    //serialised inventory for a player
    private String inventoryContents = "";

    //players current health upon entering a lobby
    private Integer currentHealth = 0;

    //a players x coords before entering lobby
    private double oldX = 0;

    //a players y coords before entering lobby
    private double oldY = 0;

    //a players z coords before entering lobby
    private double oldZ = 0;

    //a players world name before entering lobby
    private String oldWorld = "";

	
	/*
	 * rpg minions
	 */

    //list of all p-ets a player owns
    private List<String> petsOwned = new ArrayList<String>();

    //does the player have an active pet
    private boolean petActive = false;

    //active pets name
    private String activePet = "";

    //does the player have agro
    private boolean agro = false;

    //is the player in combat
    private boolean inCombat = false;

    //a players current agro rating
    private Integer agroLevel = 0;
	
	/*
	 * rpg Quest variables - comming soon?
	 */

    //players quests that are currently active
    private List<String> currentQuests = new ArrayList<String>();

    //quests a player has completed
    private List<String> completedQuests = new ArrayList<String>();

    //stages of each quest a player is on
    private Map<String, Integer> questStages = new HashMap<>();

    //players "activated" quest
    private String activeQuest = "";

    //how many counter based goals are completed for quest - String
    private Map<String, Integer> questGoalCount = new HashMap<>();


    /*
     * Reputations variables
     */

    //number for current reputation with a faction
    private Map<String, Integer> reputationLevels = new HashMap<>();

    //wether or not a player has discovered a factions existance
    private List<String> factionsDiscovered = new ArrayList<String>();
	
	
	/*
	 * rpg Spawns
	 */

    //does the player have a pending rez?
    private boolean ressurectionPending = false;

    //is the player currently rezz'ing someone
    private boolean ressurecting = false;

    //is the player dead
    private boolean dead = false;

	/*
	 * rpgclasses variables
	 */

    //players class name
    private String className = "";

    //a map of the values for every player stat (sorted by enum)
    private Map<String, Integer> stats = new HashMap<>();

    //a map of the strings for all a players text bassed stats (sorted by enum)
    private Map<String, String> playerText = new HashMap<>();

    //true or false for each type of damage a player is resistant to
    private Map<String, Integer> drTypes = new HashMap<>();

    //true or false for the damage types a player is currently doing
    private Map<String, Integer> dmgTypes = new HashMap<>();

    //true or false for the elemental damage types a player is currently doing
    private Map<String, Integer> elemDmgTypes = new HashMap<>();

    //true or false for each type of elemental damage a player is resistant to
    private Map<String, Integer> elemResTypes = new HashMap<>();

    //list of all feats a player has
    private List<String> feats = new ArrayList<String>();

    //skills a player has ranks in and how many ranks they have
    private Map<String, Integer> skills = new HashMap<>();

    //true or false list of all spells for which a player knows
    private List<String> spells = new ArrayList<String>();

    //spells per level per combat
    private Map<String, Integer> spellsPerCombat = new HashMap<>();

    //is the player wearing aromor he isn't proficient with
    private Boolean encumbered = false;


    /*
     *  all getters and setters
     */

    /**
     *
     */
    public RpgPlayer() {

    }

    /**
     *
     * @return
     */
    public Boolean isEncumbered() {
        return encumbered;
    }

    /**
     *
     * @param encumbered
     */
    public void setEncumbered(Boolean encumbered) {
        this.encumbered = encumbered;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getSpellsPerCombat() {
        return spellsPerCombat;
    }

    /**
     *
     * @param spellsPerCombat
     */
    public void setSpellsPerCombat(Map<String, Integer> spellsPerCombat) {
        this.spellsPerCombat = spellsPerCombat;
    }

    /**
     *
     * @return
     */
    public List<String> getSpells() {
        return spells;
    }

    /**
     *
     * @param spells
     */
    public void setSpells(List<String> spells) {
        this.spells = spells;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getSkills() {
        return skills;
    }

    /**
     *
     * @param skills
     */
    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }

    /**
     *
     * @return
     */
    public List<String> getFeats() {
        return feats;
    }

    /**
     *
     * @param feats
     */
    public void setFeats(List<String> feats) {
        this.feats = feats;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getElemResTypes() {
        return elemResTypes;
    }

    /**
     *
     * @param elemResTypes
     */
    public void setElemResTypes(Map<String, Integer> elemResTypes) {
        this.elemResTypes = elemResTypes;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getElemDmgTypes() {
        return elemDmgTypes;
    }

    /**
     *
     * @param elemDmgTypes
     */
    public void setElemDmgTypes(Map<String, Integer> elemDmgTypes) {
        this.elemDmgTypes = elemDmgTypes;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getDmgTypes() {
        return dmgTypes;
    }

    /**
     *
     * @param dmgTypes
     */
    public void setDmgTypes(Map<String, Integer> dmgTypes) {
        this.dmgTypes = dmgTypes;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getDrTypes() {
        return drTypes;
    }

    /**
     *
     * @param drTypes
     */
    public void setDrTypes(Map<String, Integer> drTypes) {
        this.drTypes = drTypes;
    }

    /**
     *
     * @return
     */
    public Map<String, String> getPlayerText() {
        return playerText;
    }

    /**
     *
     * @param playerText
     */
    public void setPlayerText(Map<String, String> playerText) {
        this.playerText = playerText;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getStats() {
        return stats;
    }

    /**
     *
     * @param stats
     */
    public void setStats(Map<String, Integer> stats) {
        this.stats = stats;
    }

    /**
     *
     * @return
     */
    public String getClassName() {
        return className;
    }

    /**
     *
     * @param className
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     *
     * @return
     */
    public boolean isDead() {
        return dead;
    }

    /**
     *
     * @param dead
     */
    public void setDead(boolean dead) {
        this.dead = dead;
    }

    /**
     *
     * @return
     */
    public boolean isRessurecting() {
        return ressurecting;
    }

    /**
     *
     * @param ressurecting
     */
    public void setRessurecting(boolean ressurecting) {
        this.ressurecting = ressurecting;
    }

    /**
     *
     * @return
     */
    public boolean hasRessurectionPending() {
        return ressurectionPending;
    }

    /**
     *
     * @param ressurectionPending
     */
    public void setRessurectionPending(boolean ressurectionPending) {
        this.ressurectionPending = ressurectionPending;
    }

    /**
     *
     * @return
     */
    public List<String> getFactionsDiscovered() {
        return factionsDiscovered;
    }

    /**
     *
     * @param factionsDiscovered
     */
    public void setFactionsDiscovered(List<String> factionsDiscovered) {
        this.factionsDiscovered = factionsDiscovered;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getReputationLevels() {
        return reputationLevels;
    }

    /**
     *
     * @param reputationLevels
     */
    public void setReputationLevels(Map<String, Integer> reputationLevels) {
        this.reputationLevels = reputationLevels;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getQuestGoalCount() {
        return questGoalCount;
    }

    /**
     *
     * @param questGoalCount
     */
    public void setQuestGoalCount(Map<String, Integer> questGoalCount) {
        this.questGoalCount = questGoalCount;
    }

    /**
     *
     * @return
     */
    public String getActiveQuest() {
        return activeQuest;
    }

    /**
     *
     * @param activeQuest
     */
    public void setActiveQuest(String activeQuest) {
        this.activeQuest = activeQuest;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getQuestStages() {
        return questStages;
    }

    /**
     *
     * @param questStages
     */
    public void setQuestStages(Map<String, Integer> questStages) {
        this.questStages = questStages;
    }

    /**
     *
     * @return
     */
    public List<String> getCompletedQuests() {
        return completedQuests;
    }

    /**
     *
     * @param completedQuests
     */
    public void setCompletedQuests(List<String> completedQuests) {
        this.completedQuests = completedQuests;
    }

    /**
     *
     * @return
     */
    public List<String> getCurrentQuests() {
        return currentQuests;
    }

    /**
     *
     * @param currentQuests
     */
    public void setCurrentQuests(List<String> currentQuests) {
        this.currentQuests = currentQuests;
    }

    /**
     *
     * @return
     */
    public Boolean hasAgro() {
        return agro;
    }

    /**
     *
     * @param agro
     */
    public void setAgroTarget(Boolean agro) {
        this.agro = agro;
    }

    /**
     *
     * @return
     */
    public boolean isInCombat() {
        return inCombat;
    }

    /**
     *
     * @param inCombat
     */
    public void setInCombat(boolean inCombat) {
        this.inCombat = inCombat;
    }

    /**
     *
     * @return
     */
    public Integer getAgroLevel() {
        return agroLevel;
    }

    /**
     *
     * @param agroLevel
     */
    public void setAgroLevel(Integer agroLevel) {
        this.agroLevel = agroLevel;
    }

    /**
     *
     * @return
     */
    public String getActivePet() {
        return activePet;
    }

    /**
     *
     * @param activePet
     */
    public void setActivePet(String activePet) {
        this.activePet = activePet;
    }

    /**
     *
     * @return
     */
    public boolean hasPetActive() {
        return petActive;
    }

    /**
     *
     * @param petActive
     */
    public void setPetActive(boolean petActive) {
        this.petActive = petActive;
    }

    /**
     *
     * @return
     */
    public List<String> getPetsOwned() {
        return petsOwned;
    }

    /**
     *
     * @param petsOwned
     */
    public void setPetsOwned(List<String> petsOwned) {
        this.petsOwned = petsOwned;
    }

    /**
     *
     * @return
     */
    public String getOldWorld() {
        return oldWorld;
    }

    /**
     *
     * @param oldWorld
     */
    public void setOldWorld(String oldWorld) {
        this.oldWorld = oldWorld;
    }

    /**
     *
     * @return
     */
    public double getOldZ() {
        return oldZ;
    }

    /**
     *
     * @param oldZ
     */
    public void setOldZ(double oldZ) {
        this.oldZ = oldZ;
    }

    /**
     *
     * @return
     */
    public double getOldY() {
        return oldY;
    }

    /**
     *
     * @param oldY
     */
    public void setOldY(double oldY) {
        this.oldY = oldY;
    }

    /**
     *
     * @return
     */
    public double getOldX() {
        return oldX;
    }

    /**
     *
     * @param oldX
     */
    public void setOldX(double oldX) {
        this.oldX = oldX;
    }

    /**
     *
     * @return
     */
    public Integer getCurrentHealth() {
        return currentHealth;
    }

    /**
     *
     * @param currentHealth
     */
    public void setCurrentHealth(Integer currentHealth) {
        this.currentHealth = currentHealth;
    }

    /**
     *
     * @return
     */
    public String getInventoryContents() {
        return inventoryContents;
    }

    /**
     *
     * @param inventoryContents
     */
    public void setInventoryContents(String inventoryContents) {
        this.inventoryContents = inventoryContents;
    }

    /**
     *
     * @return
     */
    public String getArmorInventory() {
        return armorInventory;
    }

    /**
     *
     * @param armorInventory
     */
    public void setArmorInventory(String armorInventory) {
        this.armorInventory = armorInventory;
    }

    /**
     *
     * @return
     */
    public boolean isInLobby() {
        return inLobby;
    }

    /**
     *
     * @param inLobby
     */
    public void setInLobby(boolean inLobby) {
        this.inLobby = inLobby;
    }

    /**
     *
     * @return
     */
    public boolean showLanguagesInChat() {
        return languagesInChat;
    }

    /**
     *
     * @param languagesInChat
     */
    public void setLanguagesInChat(boolean languagesInChat) {
        this.languagesInChat = languagesInChat;
    }

    /**
     *
     * @return
     */
    public List<String> getKnownLanguages() {
        return knownLanguages;
    }

    /**
     *
     * @param knownLanguages
     */
    public void setKnownLanguages(List<String> knownLanguages) {
        this.knownLanguages = knownLanguages;
    }

    /**
     *
     * @return
     */
    public String getActiveLanguage() {
        return activeLanguage;
    }

    /**
     *
     * @param activeLanguage
     */
    public void setActiveLanguage(String activeLanguage) {
        this.activeLanguage = activeLanguage;
    }

    /**
     *
     * @return
     */
    public boolean usesClick() {
        return UseClick;
    }

    /**
     *
     * @param useClick
     */
    public void setClick(boolean useClick) {
        UseClick = useClick;
    }

    /**
     *
     * @return
     */
    public List<String> getTitles() {
        return titles;
    }

    /**
     *
     * @param titles
     */
    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    /**
     *
     * @return
     */
    public String getActiveSuffix() {
        return activeSuffix;
    }

    /**
     *
     * @param activeSuffix
     */
    public void setActiveSuffix(String activeSuffix) {
        this.activeSuffix = activeSuffix;
    }

    /**
     *
     * @return
     */
    public String getActivePrefix() {
        return activePrefix;
    }

    /**
     *
     * @param activePrefix
     */
    public void setActivePrefix(String activePrefix) {
        this.activePrefix = activePrefix;
    }

    /**
     *
     * @return
     */
    public boolean isShowingWorldNames() {
        return showingWorldName;
    }

    /**
     *
     * @param showingWorldName
     */
    public void setShowingWorldName(boolean showingWorldName) {
        this.showingWorldName = showingWorldName;
    }

    /**
     *
     * @return
     */
    public boolean isShowingLanguageNames() {
        return showingLanguageNames;
    }

    /**
     *
     * @param showingLanguageNames
     */
    public void setShowingLanguageNames(boolean showingLanguageNames) {
        this.showingLanguageNames = showingLanguageNames;
    }

    /**
     *
     * @return
     */
    public boolean isShowingChannelNames() {
        return showingChannelNames;
    }

    /**
     *
     * @param showingChannelNames
     */
    public void setShowingChannelNames(boolean showingChannelNames) {
        this.showingChannelNames = showingChannelNames;
    }

    /**
     *
     * @return
     */
    public boolean isShowingAchieveTitles() {
        return showingAchieveTitles;
    }

    /**
     *
     * @param showingAchieveTitles
     */
    public void setShowingAchieveTitles(boolean showingAchieveTitles) {
        this.showingAchieveTitles = showingAchieveTitles;
    }

    /**
     *
     * @return
     */
    public boolean isShowingGuildTags() {
        return showingGuildTags;
    }

    /**
     *
     * @param showingGuildTags
     */
    public void setShowingGuildTags(boolean showingGuildTags) {
        this.showingGuildTags = showingGuildTags;
    }

    /**
     *
     * @return
     */
    public boolean isSpyingOnChats() {
        return SpyingOnChats;
    }

    /**
     *
     * @param spyingOnChats
     */
    public void setSpyingOnChats(boolean spyingOnChats) {
        SpyingOnChats = spyingOnChats;
    }

    /**
     *
     * @return
     */
    public List<String> getModChats() {
        return modChats;
    }

    /**
     *
     * @param modChats
     */
    public void setModChats(List<String> modChats) {
        this.modChats = modChats;
    }

    /**
     *
     * @return
     */
    public List<String> getOwnedChats() {
        return ownedChats;
    }

    /**
     *
     * @param ownedChats
     */
    public void setOwnedChats(List<String> ownedChats) {
        this.ownedChats = ownedChats;
    }

    /**
     *
     * @return
     */
    public List<String> getMutedChats() {
        return mutedChats;
    }

    /**
     *
     * @param mutedChats
     */
    public void setMutedChats(List<String> mutedChats) {
        this.mutedChats = mutedChats;
    }

    /**
     *
     * @return
     */
    public List<String> getBannedChats() {
        return bannedChats;
    }

    /**
     *
     * @param bannedChats
     */
    public void setBannedChats(List<String> bannedChats) {
        this.bannedChats = bannedChats;
    }

    /**
     *
     * @return
     */
    public List<String> getInvitedChats() {
        return invitedChats;
    }

    /**
     *
     * @param invitedChats
     */
    public void setInvitedChats(List<String> invitedChats) {
        this.invitedChats = invitedChats;
    }

    /**
     *
     * @return
     */
    public boolean hasChatInvite() {
        return chatInvite;
    }

    /**
     *
     * @param chatInvite
     */
    public void setChatInvite(boolean chatInvite) {
        this.chatInvite = chatInvite;
    }

    /**
     *
     * @return
     */
    public List<String> getIgnoreList() {
        return ignoreList;
    }

    /**
     *
     * @param ignoreList
     */
    public void setIgnoreList(List<String> ignoreList) {
        this.ignoreList = ignoreList;
    }

    /**
     *
     * @return
     */
    public String getActiveChannel() {
        return activeChannel;
    }

    /**
     *
     * @param activeChannel
     */
    public void setActiveChannel(String activeChannel) {
        this.activeChannel = activeChannel;
    }

    /**
     *
     * @return
     */
    public Map<String, String> getChannelColor() {
        return channelColor;
    }

    /**
     *
     * @param channelColor
     */
    public void setChannelColor(Map<String, String> channelColor) {
        this.channelColor = channelColor;
    }

    /**
     *
     * @return
     */
    public int getCoin() {
        return coin;
    }

    /**
     *
     * @param coin
     */
    public void setCoin(int coin) {
        this.coin = coin;
    }

    /**
     *
     * @return
     */
    public String getWaitTrade() {
        return waitTrade;
    }

    /**
     *
     * @param waitTrade
     */
    public void setWaitTrade(String waitTrade) {
        this.waitTrade = waitTrade;
    }

    /**
     *
     * @return
     */
    public boolean isInTrade() {
        return inTrade;
    }

    /**
     *
     * @param inTrade
     */
    public void setInTrade(boolean inTrade) {
        this.inTrade = inTrade;
    }

    /**
     *
     * @return
     */
    public boolean isInConfirm() {
        return inConfirm;
    }

    /**
     *
     * @param inConfirm
     */
    public void setInConfirm(boolean inConfirm) {
        this.inConfirm = inConfirm;
    }

    /**
     *
     * @return
     */
    public List<String> getFriendsList() {
        return friendsList;
    }

    /**
     *
     * @param friendsList
     */
    public void setFriendsList(List<String> friendsList) {
        this.friendsList = friendsList;
    }

    /**
     *
     * @return
     */
    public boolean showFriendsGui() {
        return friendsGui;
    }

    /**
     *
     * @param friendsGui
     */
    public void setFriendsGui(boolean friendsGui) {
        this.friendsGui = friendsGui;
    }

    /**
     *
     * @return
     */
    public String getGuildRank() {
        return guildRank;
    }

    /**
     *
     * @param guildRank
     */
    public void setGuildRank(String guildRank) {
        this.guildRank = guildRank;
    }

    /**
     *
     * @return
     */
    public String getGuild() {
        return guild;
    }

    /**
     *
     * @param guild
     */
    public void setGuild(String guild) {
        this.guild = guild;
    }

    /**
     *
     * @return
     */
    public boolean isInGuild() {
        return inGuild;
    }

    /**
     *
     * @param inGuild
     */
    public void setInGuild(boolean inGuild) {
        this.inGuild = inGuild;
    }

    /**
     *
     * @return
     */
    public boolean showGuildGui() {
        return guildGui;
    }

    /**
     *
     * @param guildGui
     */
    public void setGuildGui(boolean guildGui) {
        this.guildGui = guildGui;
    }

    /**
     *
     * @return
     */
    public boolean hasGuildInvite() {
        return guildInvite;
    }

    /**
     *
     * @param guildInvite
     */
    public void setGuildInvite(boolean guildInvite) {
        this.guildInvite = guildInvite;
    }

    /**
     *
     * @return
     */
    public boolean showLootGui() {
        return lootGui;
    }

    /**
     *
     * @param lootGui
     */
    public void setLootGui(boolean lootGui) {
        this.lootGui = lootGui;
    }

    /**
     *
     * @return
     */
    public boolean isGreedingRolls() {
        return greedingRolls;
    }

    /**
     *
     * @param greedingRolls
     */
    public void setGreedingRolls(boolean greedingRolls) {
        this.greedingRolls = greedingRolls;
    }

    /**
     *
     * @return
     */
    public boolean isNeedingRolls() {
        return needingRolls;
    }

    /**
     *
     * @param needingRolls
     */
    public void setNeedingRolls(boolean needingRolls) {
        this.needingRolls = needingRolls;
    }

    /**
     *
     * @return
     */
    public boolean isPassingRolls() {
        return passingRolls;
    }

    /**
     *
     * @param passingRolls
     */
    public void setPassingRolls(boolean passingRolls) {
        this.passingRolls = passingRolls;
    }

    /**
     *
     * @return
     */
    public boolean isInParty() {
        return inParty;
    }

    /**
     *
     * @param inParty
     */
    public void setInParty(boolean inParty) {
        this.inParty = inParty;
    }

    /**
     *
     * @return
     */
    public boolean showPartyGui() {
        return partyGui;
    }

    /**
     *
     * @param partyGui
     */
    public void setPartyGui(boolean partyGui) {
        this.partyGui = partyGui;
    }

    /**
     *
     * @return
     */
    public boolean hasPartyInvitePending() {
        return partyInvite;
    }

    /**
     *
     * @param partyInvite
     */
    public void setPartyInvitePending(boolean partyInvite) {
        this.partyInvite = partyInvite;
    }

    /**
     *
     * @return
     */
    public boolean isBuffed() {
        return buffed;
    }

    /**
     *
     * @param buffed
     */
    public void setBuffed(boolean buffed) {
        this.buffed = buffed;
    }

    /**
     *
     * @return
     */
    public boolean isEating() {
        return eating;
    }

    /**
     *
     * @param eating
     */
    public void setEating(boolean eating) {
        this.eating = eating;
    }

    /**
     *
     * @return
     */
    public String getRace() {
        return race;
    }

    /**
     *
     * @param race
     */
    public void setRace(String race) {
        this.race = race;
    }

    /**
     *
     * @return
     */
    public boolean isPoisoned() {
        return poisoned;
    }

    /**
     *
     * @param poisoned
     */
    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }

    /**
     *
     * @return
     */
    public boolean isPoisonProof() {
        return poisonProof;
    }

    /**
     *
     * @param poisonProof
     */
    public void setPoisonProof(boolean poisonProof) {
        this.poisonProof = poisonProof;
    }

    /**
     *
     * @return
     */
    public String getGoodAlignment() {
        return goodAlignment;
    }

    /**
     *
     * @param goodAlignment
     */
    public void setGoodAlignment(String goodAlignment) {
        this.goodAlignment = goodAlignment;
    }

    /**
     *
     * @return
     */
    public String getLawfulAlignment() {
        return lawfulAlignment;
    }

    /**
     *
     * @param lawfulAlignment
     */
    public void setLawfulAlignment(String lawfulAlignment) {
        this.lawfulAlignment = lawfulAlignment;
    }

    /**
     *
     * @return
     */
    public boolean locationHasChanged() {
        return locationChanged;
    }

    /**
     *
     * @param locationChanged
     */
    public void setLocationChanged(boolean locationChanged) {
        this.locationChanged = locationChanged;
    }

    /**
     *
     * @return
     */
    public boolean hasMenuOpen() {
        return menuOpen;
    }

    /**
     *
     * @param menuOpen
     */
    public void setMenuOpen(boolean menuOpen) {
        this.menuOpen = menuOpen;
    }

    /**
     *
     * @return
     */
    public boolean hasTpInvitePending() {
        return tpInviteState;
    }

    /**
     *
     * @param tpInviteState
     */
    public void setTpInviteState(boolean tpInviteState) {
        this.tpInviteState = tpInviteState;
    }

    /**
     *
     * @return
     */
    public String getRealName() {
        return realName;
    }

    /**
     *
     * @param realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getEatenItems() {
        return eatenItems;
    }

    /**
     *
     * @param eatenItems
     */
    public void setEatenItems(Map<String, Integer> eatenItems) {
        this.eatenItems = eatenItems;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getPlayerKills() {
        return playerKills;
    }

    /**
     *
     * @param playerKills
     */
    public void setPlayerKills(Map<String, Integer> playerKills) {
        this.playerKills = playerKills;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getMobKills() {
        return mobKills;
    }

    /**
     *
     * @param mobKills
     */
    public void setMobKills(Map<String, Integer> mobKills) {
        this.mobKills = mobKills;
    }

    /**
     *
     * @return
     */
    public Map<String, Integer> getItemsUsed() {
        return itemsUsed;
    }

    /**
     *
     * @param itemsUsed
     */
    public void setItemsUsed(Map<String, Integer> itemsUsed) {
        this.itemsUsed = itemsUsed;
    }

    /**
     *
     * @return
     */
    public String getLeaderName() {
        return leaderName;
    }

    /**
     *
     * @param leaderName
     */
    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean isPermissionSet(String s) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param permission
     * @return
     */
    @Override
    public boolean isPermissionSet(Permission permission) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param s
     * @return
     */
    @Override
    public boolean hasPermission(String s) {
        if (!RpgAPI.permsOn){
            if (Bukkit.getPlayer(realName).hasPermission(s)){return true;} else {return false;}
        }
        PermissionAttachment attachment = RpgAPI.permAttachments.get(RpgAPI.activeNicks.get(realName));
        if (attachment.getPermissions().containsKey(s)){
            return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param permission
     * @return
     */
    @Override
    public boolean hasPermission(Permission permission) {
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param plugin
     * @param s
     * @param b
     * @return
     */

    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param plugin
     * @return
     */
    @Override
    public PermissionAttachment addAttachment(Plugin plugin) {
        PermissionAttachment attachment = new PermissionAttachment(plugin, this);
        return attachment;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param plugin
     * @param s
     * @param b
     * @param i
     * @return
     */
    @Override
    public PermissionAttachment addAttachment(Plugin plugin, String s, boolean b, int i) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param plugin
     * @param i
     * @return
     */
    @Override
    public PermissionAttachment addAttachment(Plugin plugin, int i) {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param permissionAttachment
     */
    @Override
    public void removeAttachment(PermissionAttachment permissionAttachment) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     */
    @Override
    public void recalculatePermissions() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public Set<PermissionAttachmentInfo> getEffectivePermissions() {
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @return
     */
    @Override
    public boolean isOp() {

        if (Bukkit.getPlayer(realName).isOp() && useOp){
            return true;
        }
        return false;  //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param b
     */
    @Override
    public void setOp(boolean b) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    /**
     *
     * @param p
     * @return
     */
    public Boolean noDamage(Player p){
        RpgPlayer rp = RpgAPI.getRp(p.getName());
        if (RpgAPI.guildsOn  && rp.isInGuild() && this.isInGuild()){
            if (rp.getGuild().equals(this.getGuild())){
                 return false;
            }
        }
        if (RpgAPI.partyOn && rp.isInParty() && this.isInParty()){
            if (rp.getLeaderName().equals(this.getLeaderName())){
                return false;
            }
        }
        if (RpgAPI.duelsOn && this.getInDuel()){
            if (!(rp.getInDuel())){
                return false;
            }
            if (!(rp.getWhoDuelling().equals(this.getWhoDuelling()))){
                return false;
            }
        }
        if (RpgAPI.duelsOn && rp.getInDuel()){
            if (!(this.getInDuel())){
                return false;
            }
        }
        if (!(this.isPvp())){
            return false;
        }

        return true;
    }

    /**
     *
     * @return
     */
    public Boolean canTrade() {
        //insert checks to return null here

        if (this.isDead()){
            return false;
        }
        return true;
    }

    /**
     *
     * @return
     */
    public String getWhoDuelling() {
        return whoDuelling;
    }

    /**
     *
     * @param whoDuelling
     */
    public void setWhoDuelling(String whoDuelling) {
        this.whoDuelling = whoDuelling;
    }

    /**
     *
     * @return
     */
    public Boolean getInDuel() {
        return inDuel;
    }

    /**
     *
     * @param inDuel
     */
    public void setInDuel(Boolean inDuel) {
        this.inDuel = inDuel;
    }

    /**
     *
     * @return
     */
    public boolean isPvp() {
        return pvp;
    }

    /**
     *
     * @param pvp
     */
    public void setPvp(boolean pvp) {
        this.pvp = pvp;
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean addFriend(String s) {
        if (this.friendsList.contains(s))
            return false;
        else
            return this.friendsList.add(s);
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean addIgnore(String s) {
        if (this.ignoreList.contains(s))
            return false;
        else
            return this.ignoreList.add(s);
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean removeFriend(String s) {
        if (!this.friendsList.contains(s))
            return false;
        else
            return this.friendsList.remove(s);
    }

    /**
     *
     * @param s
     * @return
     */
    public boolean removeIgnore(String s) {
        if (!this.ignoreList.contains(s))
            return false;
        else
            return this.ignoreList.remove(s);
    }

    /**
     *
     * @return
     */
    public boolean isUsingOp(){
        return useOp;
    }

    /**
     *
     * @param setIsOp
     */
    public void setOp(Boolean setIsOp){
        useOp = setIsOp;
    }

    /**
     *
     * @return
     */
    public Map<String, List<String>> getPermGroups() {
        return permGroups;
    }

    /**
     *
     * @param world
     */
    public void worldChange(String world){
        resetPerms();
        if (!permGroups.containsKey(world)){
            List<String> permgroups = new ArrayList<>();
            permgroups.add(RpgAPI.defaultGroup);
            permGroups.put(world, permgroups);
        }
        PermissionAttachment pAttach = RpgAPI.permAttachments.get(realName);
        PermissionAttachment attach = RpgAPI.permAttachments.get(name);
        if (individualPerms.containsKey(world)){
            for (String perms : individualPerms.get(world)){
                pAttach.setPermission(perms, true);
                attach.setPermission(perms, true);
            }
        }
        for (String group : permGroups.get(world)){
            PermissionGroup pG = RpgAPI.permGroups.get(group);

            for (String deny : pG.getDeniedPerms()){
                pAttach.setPermission(deny, false);
                attach.setPermission(deny, false);
            }
            for (String perm : pG.getPermissions()){
                pAttach.setPermission(perm, true);
                attach.setPermission(perm, true);
            }
            List<PermissionGroup> inheritance = new ArrayList<>();
            for (String  inh : pG.getInheritances()){
                if (inh != null){
                    inheritance.add(RpgAPI.permGroups.get(inh));
                    for (PermissionGroup pg1 : inheritance){
                        for (String deny : pg1.getDeniedPerms()){
                            pAttach.setPermission(deny, false);
                            attach.setPermission(deny, false);
                        }
                        for (String perm : pg1.getPermissions()){
                            pAttach.setPermission(perm, true);
                            attach.setPermission(perm, true);
                        }
                    }
                }
            }
        }
    }

    /**
     *
     * @param s
     * @param group
     */
    public void addGroup(String s, String group){
        permGroups.get(s).add(group);
        worldChange(s);
    }

    /**
     *
     * @param s
     * @param group
     */
    public void removeGroup(String s, String group){
        permGroups.get(s).remove(group);
        worldChange(s);
    }

    /**
     *
     */
    public void resetPerms(){
        permGroups.clear();
        individualPerms.clear();
        if (RpgAPI.permAttachments.containsKey(realName)){
            RpgAPI.permAttachments.remove(realName);
        }
        if (RpgAPI.permAttachments.containsKey(name)){
            RpgAPI.permAttachments.remove(name);
        }
        PermissionAttachment pAttach = Bukkit.getPlayer(realName).addAttachment(RpgAPI.getInstance());
        PermissionAttachment attach = this.addAttachment(RpgAPI.getInstance());
        RpgAPI.permAttachments.put(realName, pAttach);
        RpgAPI.permAttachments.put(name, attach);
    }

    /**
     *
     * @param world
     * @param permGroups
     */
    public void setWorldPermGroups(String world, List<String> permGroups) {
        this.permGroups.put(world, permGroups);
        worldChange(world);
    }

    /**
     *
     * @param world
     * @return
     */
    public List<String> getIndividualPerms(String world) {
        return individualPerms.get(world);
    }

    /**
     *
     * @param world
     * @param individualPerms
     */
    public void setIndividualWorldPerms(String world, List<String> individualPerms) {
        this.individualPerms.put(world, individualPerms);
        worldChange(world);
    }

    /**
     *
     * @param world
     * @param s
     */
    public void addPerm(String world, String s){
        individualPerms.get(world).add(s);
        worldChange(world);
    }

    /**
     *
     * @param world
     * @param s
     */
    public void delPerm(String world, String s){
        individualPerms.get(world).remove(s);
        worldChange(world);
    }

    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public boolean useDefaultTrade() {
        return defaultTrade;
    }

    /**
     *
     * @param defaultTrade
     */
    public void setDefaultTrade(boolean defaultTrade) {
        this.defaultTrade = defaultTrade;
    }
}
