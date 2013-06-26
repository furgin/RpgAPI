package com.vartala.soulofw0lf.rpgapi.playerapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vartala.soulofw0lf.rpgapi.enumapi.*;
import org.bukkit.ChatColor;
import org.bukkit.Location;

/*
 * main player wrapper class
 * holds all variables related to the online player
 */
public class RpgPlayer {
    //
	/*
	 * all vars go above the player method
	 */
	
	/*
	 * general variables
	 */



    //the players actual name
    private String realName = "";

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

    //food items a player has eaten
    private List<String> eatenItems = new ArrayList<String>();

	
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
	 * trade variables
	 */
    //is the player currently in trade
	private boolean inTrade = false;

    //the players total Copper
    private int copper = 0;

    //the player total Silver
    private int silver = 0;

    //the players total Gold
    private int gold = 0;

    //the players total Platinum
    private int platinum = 0;

	
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
		
	
	public RpgPlayer()
	{
		
	}

    public Boolean isEncumbered() {
        return encumbered;
    }

    public void setEncumbered(Boolean encumbered) {
        this.encumbered = encumbered;
    }

    public Map<String, Integer> getSpellsPerCombat() {
        return spellsPerCombat;
    }

    public void setSpellsPerCombat(Map<String, Integer> spellsPerCombat) {
        this.spellsPerCombat = spellsPerCombat;
    }

    public List<String> getSpells() {
        return spells;
    }

    public void setSpells(List<String> spells) {
        this.spells = spells;
    }

    public Map<String, Integer> getSkills() {
        return skills;
    }

    public void setSkills(Map<String, Integer> skills) {
        this.skills = skills;
    }

    public List<String> getFeats() {
        return feats;
    }

    public void setFeats(List<String> feats) {
        this.feats = feats;
    }

    public Map<String, Integer> getElemResTypes() {
        return elemResTypes;
    }

    public void setElemResTypes(Map<String, Integer> elemResTypes) {
        this.elemResTypes = elemResTypes;
    }

    public Map<String, Integer> getElemDmgTypes() {
        return elemDmgTypes;
    }

    public void setElemDmgTypes(Map<String, Integer> elemDmgTypes) {
        this.elemDmgTypes = elemDmgTypes;
    }

    public Map<String, Integer> getDmgTypes() {
        return dmgTypes;
    }

    public void setDmgTypes(Map<String, Integer> dmgTypes) {
        this.dmgTypes = dmgTypes;
    }

    public Map<String, Integer> getDrTypes() {
        return drTypes;
    }

    public void setDrTypes(Map<String, Integer> drTypes) {
        this.drTypes = drTypes;
    }

    public Map<String, String> getPlayerText() {
        return playerText;
    }

    public void setPlayerText(Map<String, String> playerText) {
        this.playerText = playerText;
    }

    public Map<String, Integer> getStats() {
        return stats;
    }

    public void setStats(Map<String, Integer> stats) {
        this.stats = stats;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public boolean isRessurecting() {
        return ressurecting;
    }

    public void setRessurecting(boolean ressurecting) {
        this.ressurecting = ressurecting;
    }

    public boolean hasRessurectionPending() {
        return ressurectionPending;
    }

    public void setRessurectionPending(boolean ressurectionPending) {
        this.ressurectionPending = ressurectionPending;
    }

    public List<String> getFactionsDiscovered() {
        return factionsDiscovered;
    }

    public void setFactionsDiscovered(List<String> factionsDiscovered) {
        this.factionsDiscovered = factionsDiscovered;
    }

    public Map<String, Integer> getReputationLevels() {
        return reputationLevels;
    }

    public void setReputationLevels(Map<String, Integer> reputationLevels) {
        this.reputationLevels = reputationLevels;
    }

    public Map<String, Integer> getQuestGoalCount() {
        return questGoalCount;
    }

    public void setQuestGoalCount(Map<String, Integer> questGoalCount) {
        this.questGoalCount = questGoalCount;
    }

    public String getActiveQuest() {
        return activeQuest;
    }

    public void setActiveQuest(String activeQuest) {
        this.activeQuest = activeQuest;
    }

    public Map<String, Integer> getQuestStages() {
        return questStages;
    }

    public void setQuestStages(Map<String, Integer> questStages) {
        this.questStages = questStages;
    }

    public List<String> getCompletedQuests() {
        return completedQuests;
    }

    public void setCompletedQuests(List<String> completedQuests) {
        this.completedQuests = completedQuests;
    }

    public List<String> getCurrentQuests() {
        return currentQuests;
    }

    public void setCurrentQuests(List<String> currentQuests) {
        this.currentQuests = currentQuests;
    }

    public Boolean hasAgro() {
        return agro;
    }

    public void setAgroTarget(Boolean agro) {
        this.agro = agro;
    }

    public boolean isInCombat() {
        return inCombat;
    }

    public void setInCombat(boolean inCombat) {
        this.inCombat = inCombat;
    }

    public Integer getAgroLevel() {
        return agroLevel;
    }

    public void setAgroLevel(Integer agroLevel) {
        this.agroLevel = agroLevel;
    }

    public String getActivePet() {
        return activePet;
    }

    public void setActivePet(String activePet) {
        this.activePet = activePet;
    }

    public boolean hasPetActive() {
        return petActive;
    }

    public void setPetActive(boolean petActive) {
        this.petActive = petActive;
    }

    public List<String> getPetsOwned() {
        return petsOwned;
    }

    public void setPetsOwned(List<String> petsOwned) {
        this.petsOwned = petsOwned;
    }

    public String getOldWorld() {
        return oldWorld;
    }

    public void setOldWorld(String oldWorld) {
        this.oldWorld = oldWorld;
    }

    public double getOldZ() {
        return oldZ;
    }

    public void setOldZ(double oldZ) {
        this.oldZ = oldZ;
    }

    public double getOldY() {
        return oldY;
    }

    public void setOldY(double oldY) {
        this.oldY = oldY;
    }

    public double getOldX() {
        return oldX;
    }

    public void setOldX(double oldX) {
        this.oldX = oldX;
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(Integer currentHealth) {
        this.currentHealth = currentHealth;
    }

    public String getInventoryContents() {
        return inventoryContents;
    }

    public void setInventoryContents(String inventoryContents) {
        this.inventoryContents = inventoryContents;
    }

    public String getArmorInventory() {
        return armorInventory;
    }

    public void setArmorInventory(String armorInventory) {
        this.armorInventory = armorInventory;
    }

    public boolean isInLobby() {
        return inLobby;
    }

    public void setInLobby(boolean inLobby) {
        this.inLobby = inLobby;
    }

    public boolean showLanguagesInChat() {
        return languagesInChat;
    }

    public void setLanguagesInChat(boolean languagesInChat) {
        this.languagesInChat = languagesInChat;
    }

    public List<String> getKnownLanguages() {
        return knownLanguages;
    }

    public void setKnownLanguages(List<String> knownLanguages) {
        this.knownLanguages = knownLanguages;
    }

    public String getActiveLanguage() {
        return activeLanguage;
    }

    public void setActiveLanguage(String activeLanguage) {
        this.activeLanguage = activeLanguage;
    }

    public boolean usesClick() {
        return UseClick;
    }

    public void setClick(boolean useClick) {
        UseClick = useClick;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public String getActiveSuffix() {
        return activeSuffix;
    }

    public void setActiveSuffix(String activeSuffix) {
        this.activeSuffix = activeSuffix;
    }

    public String getActivePrefix() {
        return activePrefix;
    }

    public void setActivePrefix(String activePrefix) {
        this.activePrefix = activePrefix;
    }

    public boolean isShowingWorldNames() {
        return showingWorldName;
    }

    public void setShowingWorldName(boolean showingWorldName) {
        this.showingWorldName = showingWorldName;
    }

    public boolean isShowingLanguageNames() {
        return showingLanguageNames;
    }

    public void setShowingLanguageNames(boolean showingLanguageNames) {
        this.showingLanguageNames = showingLanguageNames;
    }

    public boolean isShowingChannelNames() {
        return showingChannelNames;
    }

    public void setShowingChannelNames(boolean showingChannelNames) {
        this.showingChannelNames = showingChannelNames;
    }

    public boolean isShowingAchieveTitles() {
        return showingAchieveTitles;
    }

    public void setShowingAchieveTitles(boolean showingAchieveTitles) {
        this.showingAchieveTitles = showingAchieveTitles;
    }

    public boolean isShowingGuildTags() {
        return showingGuildTags;
    }

    public void setShowingGuildTags(boolean showingGuildTags) {
        this.showingGuildTags = showingGuildTags;
    }

    public boolean isSpyingOnChats() {
        return SpyingOnChats;
    }

    public void setSpyingOnChats(boolean spyingOnChats) {
        SpyingOnChats = spyingOnChats;
    }

    public List<String> getModChats() {
        return modChats;
    }

    public void setModChats(List<String> modChats) {
        this.modChats = modChats;
    }

    public List<String> getOwnedChats() {
        return ownedChats;
    }

    public void setOwnedChats(List<String> ownedChats) {
        this.ownedChats = ownedChats;
    }

    public List<String> getMutedChats() {
        return mutedChats;
    }

    public void setMutedChats(List<String> mutedChats) {
        this.mutedChats = mutedChats;
    }

    public List<String> getBannedChats() {
        return bannedChats;
    }

    public void setBannedChats(List<String> bannedChats) {
        this.bannedChats = bannedChats;
    }

    public List<String> getInvitedChats() {
        return invitedChats;
    }

    public void setInvitedChats(List<String> invitedChats) {
        this.invitedChats = invitedChats;
    }

    public boolean hasChatInvite() {
        return chatInvite;
    }

    public void setChatInvite(boolean chatInvite) {
        this.chatInvite = chatInvite;
    }

    public List<String> getIgnoreList() {
        return ignoreList;
    }

    public void setIgnoreList(List<String> ignoreList) {
        this.ignoreList = ignoreList;
    }

    public String getActiveChannel() {
        return activeChannel;
    }

    public void setActiveChannel(String activeChannel) {
        this.activeChannel = activeChannel;
    }

    public Map<String, String> getChannelColor() {
        return channelColor;
    }

    public void setChannelColor(Map<String, String> channelColor) {
        this.channelColor = channelColor;
    }

    public int getPlatinum() {
        return platinum;
    }

    public void setPlatinum(int platinum) {
        this.platinum = platinum;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    public boolean isInTrade() {
        return inTrade;
    }

    public void setInTrade(boolean inTrade) {
        this.inTrade = inTrade;
    }

    public List<String> getFriendsList() {
        return friendsList;
    }

    public void setFriendsList(List<String> friendsList) {
        this.friendsList = friendsList;
    }

    public boolean showFriendsGui() {
        return friendsGui;
    }

    public void setFriendsGui(boolean friendsGui) {
        this.friendsGui = friendsGui;
    }

    public String getGuildRank() {
        return guildRank;
    }

    public void setGuildRank(String guildRank) {
        this.guildRank = guildRank;
    }

    public String getGuild() {
        return guild;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public boolean isInGuild() {
        return inGuild;
    }

    public void setInGuild(boolean inGuild) {
        this.inGuild = inGuild;
    }

    public boolean showGuildGui() {
        return guildGui;
    }

    public void setGuildGui(boolean guildGui) {
        this.guildGui = guildGui;
    }

    public boolean hasGuildInvite() {
        return guildInvite;
    }

    public void setGuildInvite(boolean guildInvite) {
        this.guildInvite = guildInvite;
    }

    public boolean showLootGui() {
        return lootGui;
    }

    public void setLootGui(boolean lootGui) {
        this.lootGui = lootGui;
    }

    public boolean isGreedingRolls() {
        return greedingRolls;
    }

    public void setGreedingRolls(boolean greedingRolls) {
        this.greedingRolls = greedingRolls;
    }

    public boolean isNeedingRolls() {
        return needingRolls;
    }

    public void setNeedingRolls(boolean needingRolls) {
        this.needingRolls = needingRolls;
    }

    public boolean isPassingRolls() {
        return passingRolls;
    }

    public void setPassingRolls(boolean passingRolls) {
        this.passingRolls = passingRolls;
    }

    public boolean isInParty() {
        return inParty;
    }

    public void setInParty(boolean inParty) {
        this.inParty = inParty;
    }

    public boolean showPartyGui() {
        return partyGui;
    }

    public void setPartyGui(boolean partyGui) {
        this.partyGui = partyGui;
    }

    public boolean hasPartyInvitePending() {
        return partyInvite;
    }

    public void setPartyInvitePending(boolean partyInvite) {
        this.partyInvite = partyInvite;
    }

    public boolean isBuffed() {
        return buffed;
    }

    public void setBuffed(boolean buffed) {
        this.buffed = buffed;
    }

    public boolean isEating() {
        return eating;
    }

    public void setEating(boolean eating) {
        this.eating = eating;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public boolean isPoisoned() {
        return poisoned;
    }

    public void setPoisoned(boolean poisoned) {
        this.poisoned = poisoned;
    }

    public boolean isPoisonProof() {
        return poisonProof;
    }

    public void setPoisonProof(boolean poisonProof) {
        this.poisonProof = poisonProof;
    }

    public String getGoodAlignment() {
        return goodAlignment;
    }

    public void setGoodAlignment(String goodAlignment) {
        this.goodAlignment = goodAlignment;
    }

    public String getLawfulAlignment() {
        return lawfulAlignment;
    }

    public void setLawfulAlignment(String lawfulAlignment) {
        this.lawfulAlignment = lawfulAlignment;
    }

    public boolean locationHasChanged() {
        return locationChanged;
    }

    public void setLocationChanged(boolean locationChanged) {
        this.locationChanged = locationChanged;
    }

    public boolean hasMenuOpen() {
        return menuOpen;
    }

    public void setMenuOpen(boolean menuOpen) {
        this.menuOpen = menuOpen;
    }

    public boolean hasTpInvitePending() {
        return tpInviteState;
    }

    public void setTpInviteState(boolean tpInviteState) {
        this.tpInviteState = tpInviteState;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public List<String> getEatenItems() {
        return eatenItems;
    }

    public void setEatenItems(List<String> eatenItems) {
        this.eatenItems = eatenItems;
    }
}
