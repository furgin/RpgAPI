package com.vartala.soulofw0lf.rpgapi.playerapi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vartala.soulofw0lf.rpgapi.enumapi.*;
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

    //the players current nickname
	private String NickName = "";

    //the players actual name
    private String realName = "";

    //player TP invite state
	private boolean hasTpInvite = false;

    //is the player currently in a menu
	private boolean isInMenu = false;

    //get wether a player has moved from a previous position
	private boolean hasMoved = false;

    //player Lawful / neutral / chaotic alignment
    private String playerLCAlignment = "";

    //players Good Neutral Evil Alignment
    private String playerGEAlignment = "";

    //is the player immune to poison
    private boolean poisonProof = false;

    //is the player currently poisoned
    private boolean isPoisoned = false;

	
	/*
	 * Rpg Races Variables
	 */
    //players race name
	private String race = "";

	
	/*
	 * rpgfood variables
	 */
    //is the player currently eatting
	private boolean isEating = false;

    //does the player already have a food buff
	private boolean hasBuff = false;

	
	/*
	 * rpg party variables
	 */
    //does the player have a pending party invite
	private boolean isPartyInvited = false;

    //does the player want a gui to automatically
    //open when being invited to partys
	private boolean partyGui = true;

    //is the player in a party
	private boolean isInParty = false;

    //auto pass on rolls
	private boolean allPass = false;

    //auto need on rolls
	private boolean allNeed = false;

    //auto greed on rolls
    private boolean allGreed = false;

    //auto open loot window for player
	private boolean lootGui = true;


	/*
	 * rpg guilds variables
	 */

    //does the player have a pending guild invite
	private boolean isGuildInvited = false;

    //should the guild accept gui auto open on a guild invitation
	private boolean guildGui = true;

    //is the player in a guild
	private boolean isInGuild = false;

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
	private boolean isInTrade = false;

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

    //all channels a player is in
    private List<String> chatChannels = new ArrayList<String>();

    //colors of chat channel mapped to channel name
	private Map<String, Integer> channelColors = new HashMap<>();

    //active channel a player is talking in
	private String activeChannel = "";

    //all players on ignore
	private List<String> ignoreList = new ArrayList<String>();

	//does the player have a pending chat invite
	private boolean isChatInvited = false;

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
    private boolean chatSpy = false;

    /*
     * booleans for which message prefixes are shown in chat
     */
    private boolean showGuildTags = true;
    private boolean showAchieveTitles = true;
    private boolean showChannelNames = true;
    private boolean showLanguageNames = true;
    private boolean showWorldName = true;
	
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
	private boolean defaultClick = true;

	
	/*
	 * rpg language variables
	 */

    //players active spoken language
	private String activeLanguage = "Common";

    //all languages a player knows
	private List<String> knownLanguages = new ArrayList<String>();

    //should languages a player doesn't know be shown in chat?
	private boolean showLanguages = true; 

		
	
	/*
	 * rpg lobby variables
	 */

    //is the player in a lobby?
	private boolean isInLobby = false;

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
	private boolean hasActivePet = false;

    //active pets name
	private String activePet = "";

    //does the player have agro
    private boolean hasAgro = false;

    //is the player in combat
    private boolean isInCombat = false;

    //a players current agro rating
    private Integer agro = 0;
	
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
    private Map<Reputation, Integer> reputationLevels = new HashMap<>();

    //wether or not a player has discovered a factions existance
    private Map<Reputation, Boolean> factionsDiscovered = new HashMap<>();
	
	
	/*
	 * rpg Spawns
	 */

    //does the player have a pending rez?
	private boolean hasRez = false;

    //is the player currently rezz'ing someone
	private boolean isRezzing = false;

    //is the player dead
	private boolean isDead = false;

	/*
	 * rpgclasses variables
	 */
	
    //players class name
	private String playerClass = "";

    //a map of the values for every player stat (sorted by enum)
	private Map<PlayerStat, Integer> stats = new HashMap<>();

    //a map of the strings for all a players text bassed stats (sorted by enum)
    private Map<PlayerText, String> playerText = new HashMap<>();

    //true or false for each type of damage a player is resistant to
	private Map<DamageType, Boolean> drTypes = new HashMap<>();

    //true or false for the damage types a player is currently doing
	private Map<DamageType, Boolean> dmgType = new HashMap<>();

    //true or false for the elemental damage types a player is currently doing
	private Map<ElementalType, Boolean> elemDmgtype = new HashMap<>();

    //true or false for each type of elemental damage a player is resistant to
    private Map<ElementalType, Boolean> elemRestype = new HashMap<>();

    //list of all feats a player has
	private List<Feat> hasFeats = new ArrayList<Feat>();

    //skills a player has ranks in and how many ranks they have
	private Map<PlayerSkill, Integer> skills = new HashMap<>();

    //true or false list of all spells for which a player knows
	private Map<Spell, Boolean> spells = new HashMap<>();

    //spells per level per combat
	private Map<Integer, Integer> spellsPerCombat = new HashMap<>();


    /*
     *  all getters and setters
     */
		
	
	public RpgPlayer()
	{
		
	}
		


	public boolean isHasTpInvite() {
		return hasTpInvite;
	}


	public void setHasTpInvite(boolean hasTpInvite) {
		this.hasTpInvite = hasTpInvite;
	}


	public boolean isInMenu() {
		return isInMenu;
	}


	public void setInMenu(boolean isInMenu) {
		this.isInMenu = isInMenu;
	}


	public boolean isHasMoved() {
		return hasMoved;
	}


	public void setHasMoved(boolean hasMoved) {
		this.hasMoved = hasMoved;
	}


	public boolean isEating() {
		return isEating;
	}


	public void setEating(boolean isEating) {
		this.isEating = isEating;
	}


	public boolean isHasBuff() {
		return hasBuff;
	}


	public void setHasBuff(boolean hasBuff) {
		this.hasBuff = hasBuff;
	}


	public boolean isPartyInvited() {
		return isPartyInvited;
	}


	public void setPartyInvited(boolean isPartyInvited) {
		this.isPartyInvited = isPartyInvited;
	}


	public boolean isPartyGui() {
		return partyGui;
	}


	public void setPartyGui(boolean partyGui) {
		this.partyGui = partyGui;
	}


	public boolean isInParty() {
		return isInParty;
	}


	public void setInParty(boolean isInParty) {
		this.isInParty = isInParty;
	}


	public boolean isAllPass() {
		return allPass;
	}


	public void setAllPass(boolean allPass) {
		this.allPass = allPass;
	}


	public boolean isLootGui() {
		return lootGui;
	}


	public void setLootGui(boolean lootGui) {
		this.lootGui = lootGui;
	}


	public boolean isGuildInvited() {
		return isGuildInvited;
	}


	public void setGuildInvited(boolean isGuildInvited) {
		this.isGuildInvited = isGuildInvited;
	}


	public boolean isGuildGui() {
		return guildGui;
	}


	public void setGuildGui(boolean guildGui) {
		this.guildGui = guildGui;
	}


	public boolean isInGuild() {
		return isInGuild;
	}


	public void setInGuild(boolean isInGuild) {
		this.isInGuild = isInGuild;
	}


	public String getGuild() {
		return guild;
	}


	public void setGuild(String guild) {
		this.guild = guild;
	}


	public String getGuildRank() {
		return guildRank;
	}


	public void setGuildRank(String guildRank) {
		this.guildRank = guildRank;
	}


	public boolean isFriendsGui() {
		return friendsGui;
	}


	public void setFriendsGui(boolean friendsGui) {
		this.friendsGui = friendsGui;
	}


	public List<String> getFriendsList() {
		return friendsList;
	}


	public void setFriendsList(List<String> friendsList) {
		this.friendsList = friendsList;
	}


	public boolean isInTrade() {
		return isInTrade;
	}


	public void setInTrade(boolean isInTrade) {
		this.isInTrade = isInTrade;
	}


	public List<String> getChatChannels() {
		return chatChannels;
	}


	public void setChatChannels(List<String> chatChannels) {
		this.chatChannels = chatChannels;
	}


	public String getActiveChannel() {
		return activeChannel;
	}


	public void setActiveChannel(String activeChannel) {
		this.activeChannel = activeChannel;
	}


	public List<String> getIgnoreList() {
		return ignoreList;
	}


	public void setIgnoreList(List<String> ignoreList) {
		this.ignoreList = ignoreList;
	}


	public boolean isChatInvited() {
		return isChatInvited;
	}


	public void setChatInvited(boolean isChatInvited) {
		this.isChatInvited = isChatInvited;
	}


	public List<String> getInvitedChats() {
		return invitedChats;
	}


	public void setInvitedChats(List<String> invitedChats) {
		this.invitedChats = invitedChats;
	}


	public String getActivePrefix() {
		return activePrefix;
	}


	public void setActivePrefix(String activePrefix) {
		this.activePrefix = activePrefix;
	}


	public String getActiveSuffix() {
		return activeSuffix;
	}


	public void setActiveSuffix(String activeSuffix) {
		this.activeSuffix = activeSuffix;
	}


	public List<String> getTitles() {
		return titles;
	}


	public void setTitles(List<String> titles) {
		this.titles = titles;
	}


	public boolean isDefaultClick() {
		return defaultClick;
	}


	public void setDefaultClick(boolean defaultClick) {
		this.defaultClick = defaultClick;
	}


	public String getActiveLanguage() {
		return activeLanguage;
	}


	public void setActiveLanguage(String activeLanguage) {
		this.activeLanguage = activeLanguage;
	}


	public List<String> getKnownLanguages() {
		return knownLanguages;
	}


	public void setKnownLanguages(List<String> knownLanguages) {
		this.knownLanguages = knownLanguages;
	}


	public boolean isShowLanguages() {
		return showLanguages;
	}


	public void setShowLanguages(boolean showLanguages) {
		this.showLanguages = showLanguages;
	}


	public boolean isInLobby() {
		return isInLobby;
	}


	public void setInLobby(boolean isInLobby) {
		this.isInLobby = isInLobby;
	}


	public List<String> getPetsOwned() {
		return petsOwned;
	}


	public void setPetsOwned(List<String> petsOwned) {
		this.petsOwned = petsOwned;
	}


	public boolean isHasActivePet() {
		return hasActivePet;
	}


	public void setHasActivePet(boolean hasActivePet) {
		this.hasActivePet = hasActivePet;
	}


	public String getActivePet() {
		return activePet;
	}


	public void setActivePet(String activePet) {
		this.activePet = activePet;
	}


	public boolean isHasRez() {
		return hasRez;
	}


	public void setHasRez(boolean hasRez) {
		this.hasRez = hasRez;
	}


	public boolean isRezzing() {
		return isRezzing;
	}


	public void setRezzing(boolean isRezzing) {
		this.isRezzing = isRezzing;
	}


	public boolean isDead() {
		return isDead;
	}


	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}


	public String getPlayerClass() {
		return playerClass;
	}

    public void setPlayerClass(String playerclass){
        this.playerClass = playerclass;
    }


	public Map<PlayerStat, Integer> getStats() {
		return stats;
	}


	public void setStats(Map<PlayerStat, Integer> stats) {
		this.stats = stats;
	}


	public Map<DamageType, Boolean> getDrTypes() {
		return drTypes;
	}


	public void setDrTypes(Map<DamageType, Boolean> drTypes) {
		this.drTypes = drTypes;
	}


	public Map<DamageType, Boolean> getDmgType() {
		return dmgType;
	}


	public void setDmgType(Map<DamageType, Boolean> dmgType) {
		this.dmgType = dmgType;
	}


	public Map<ElementalType, Boolean> getElemDmgtype() {
		return elemDmgtype;
	}


	public void setElemDmgtype(Map<ElementalType, Boolean> elemDmgtype) {
		this.elemDmgtype = elemDmgtype;
	}


	public Map<ElementalType, Boolean> getElemRestype() {
		return elemRestype;
	}


	public void setElemRestype(Map<ElementalType, Boolean> elemRestype) {
		this.elemRestype = elemRestype;
	}


	public List<Feat> getHasFeats() {
		return hasFeats;
	}


	public void setHasFeats(List<Feat> hasFeats) {
		this.hasFeats = hasFeats;
	}



	public Map<PlayerSkill, Integer> getSkills() {
		return skills;
	}



	public void setSkills(Map<PlayerSkill, Integer> skills) {
		this.skills = skills;
	}



	public String getRace() {
		return race;
	}



	public void setRace(String race) {
		this.race = race;
	}



	public Map<Spell, Boolean> getSpells() {
		return spells;
	}



	public void setSpells(Map<Spell, Boolean> spells) {
		this.spells = spells;
	}



	public Map<Integer, Integer> getSpellsPerCombat() {
		return spellsPerCombat;
	}



	public void setSpellsPerCombat(Map<Integer, Integer> spellsPerCombat) {
		this.spellsPerCombat = spellsPerCombat;
	}



	public String getNickName() {
		return NickName;
	}



	public void setNickName(String nickName) {
		NickName = nickName;
	}

    public Integer getAgro() {
        return agro;
    }

    public void setAgro(Integer agro) {
        this.agro = agro;
    }

    public boolean isHasAgro() {
        return hasAgro;
    }

    public void setHasAgro(boolean hasAgro) {
        this.hasAgro = hasAgro;
    }

    public boolean isInCombat() {
        return isInCombat;
    }

    public void setInCombat(boolean inCombat) {
        isInCombat = inCombat;
    }

    public String getArmorInventory() {
        return armorInventory;
    }

    public void setArmorInventory(String armorInventory) {
        this.armorInventory = armorInventory;
    }

    public String getInventoryContents() {
        return inventoryContents;
    }

    public void setInventoryContents(String inventoryContents) {
        this.inventoryContents = inventoryContents;
    }

    public Integer getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(Integer currentHealth) {
        this.currentHealth = currentHealth;
    }

    public List<String> getCurrentQuests() {
        return currentQuests;
    }

    public void setCurrentQuests(List<String> currentQuests) {
        this.currentQuests = currentQuests;
    }

    public List<String> getCompletedQuests() {
        return completedQuests;
    }

    public void setCompletedQuests(List<String> completedQuests) {
        this.completedQuests = completedQuests;
    }

    public Map<String, Integer> getQuestStages() {
        return questStages;
    }

    public void setQuestStages(Map<String, Integer> questStages) {
        this.questStages = questStages;
    }

    public String getActiveQuest() {
        return activeQuest;
    }

    public void setActiveQuest(String activeQuest) {
        this.activeQuest = activeQuest;
    }

    public Map<Reputation, Integer> getReputationLevels() {
        return reputationLevels;
    }

    public void setReputationLevels(Map<Reputation, Integer> reputationLevels) {
        this.reputationLevels = reputationLevels;
    }

    public Map<Reputation, Boolean> getFactionsDiscovered() {
        return factionsDiscovered;
    }

    public void setFactionsDiscovered(Map<Reputation, Boolean> factionsDiscovered) {
        this.factionsDiscovered = factionsDiscovered;
    }

    public Map<String, Integer> getQuestGoalCount() {
        return questGoalCount;
    }

    public void setQuestGoalCount(Map<String, Integer> questGoalCount) {
        this.questGoalCount = questGoalCount;
    }

    public Map<PlayerText, String> getPlayerText() {
        return playerText;
    }

    public void setPlayerText(Map<PlayerText, String> playerText) {
        this.playerText = playerText;
    }

    public String getPlayerLCAlignment() {
        return playerLCAlignment;
    }

    public void setPlayerLCAlignment(String playerLCAlignment) {
        this.playerLCAlignment = playerLCAlignment;
    }

    public String getPlayerGEAlignment() {
        return playerGEAlignment;
    }

    public void setPlayerGEAlignment(String playerGEAlignment) {
        this.playerGEAlignment = playerGEAlignment;
    }

    public List<String> getBannedChats() {
        return bannedChats;
    }

    public void setBannedChats(List<String> bannedChats) {
        this.bannedChats = bannedChats;
    }

    public List<String> getMutedChats() {
        return mutedChats;
    }

    public void setMutedChats(List<String> mutedChats) {
        this.mutedChats = mutedChats;
    }

    public List<String> getOwnedChats() {
        return ownedChats;
    }

    public void setOwnedChats(List<String> ownedChats) {
        this.ownedChats = ownedChats;
    }

    public List<String> getModChats() {
        return modChats;
    }

    public void setModChats(List<String> modChats) {
        this.modChats = modChats;
    }

    public Map<String, Integer> getChannelColors() {
        return channelColors;
    }

    public void setChannelColors(Map<String, Integer> channelColors) {
        this.channelColors = channelColors;
    }

    public boolean isChatSpy() {
        return chatSpy;
    }

    public void setChatSpy(boolean chatSpy) {
        this.chatSpy = chatSpy;
    }

    public boolean isAllNeed() {
        return allNeed;
    }

    public void setAllNeed(boolean allNeed) {
        this.allNeed = allNeed;
    }

    public boolean isAllGreed() {
        return allGreed;
    }

    public void setAllGreed(boolean allGreed) {
        this.allGreed = allGreed;
    }

    public int getCopper() {
        return copper;
    }

    public void setCopper(int copper) {
        this.copper = copper;
    }

    public int getSilver() {
        return silver;
    }

    public void setSilver(int silver) {
        this.silver = silver;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getPlatinum() {
        return platinum;
    }

    public void setPlatinum(int platinum) {
        this.platinum = platinum;
    }

    public double getOldX() {
        return oldX;
    }

    public void setOldX(double oldX) {
        this.oldX = oldX;
    }

    public double getOldY() {
        return oldY;
    }

    public void setOldY(double oldY) {
        this.oldY = oldY;
    }

    public double getOldZ() {
        return oldZ;
    }

    public void setOldZ(double oldZ) {
        this.oldZ = oldZ;
    }

    public String getOldWorld() {
        return oldWorld;
    }

    public void setOldWorld(String oldWorld) {
        this.oldWorld = oldWorld;
    }

    public boolean isShowGuildTags() {
        return showGuildTags;
    }

    public void setShowGuildTags(boolean showGuildTags) {
        this.showGuildTags = showGuildTags;
    }

    public boolean isShowAchieveTitles() {
        return showAchieveTitles;
    }

    public void setShowAchieveTitles(boolean showAchieveTitles) {
        this.showAchieveTitles = showAchieveTitles;
    }

    public boolean isShowChannelNames() {
        return showChannelNames;
    }

    public void setShowChannelNames(boolean showChannelNames) {
        this.showChannelNames = showChannelNames;
    }

    public boolean isShowLanguageNames() {
        return showLanguageNames;
    }

    public void setShowLanguageNames(boolean showLanguageNames) {
        this.showLanguageNames = showLanguageNames;
    }

    public boolean isShowWorldName() {
        return showWorldName;
    }

    public void setShowWorldName(boolean showWorldName) {
        this.showWorldName = showWorldName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public boolean isPoisonProof() {
        return poisonProof;
    }

    public void setPoisonProof(boolean poisonProof) {
        this.poisonProof = poisonProof;
    }

    public boolean isPoisoned() {
        return isPoisoned;
    }

    public void setPoisoned(boolean poisoned) {
        isPoisoned = poisoned;
    }
}
