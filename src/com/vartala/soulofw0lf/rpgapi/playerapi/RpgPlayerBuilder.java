package com.vartala.soulofw0lf.rpgapi.playerapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.enumapi.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;



/**
 * Created by: soulofw0lf
 * Date: 6/22/13
 * Time: 6:20 PM
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
public class RpgPlayerBuilder {
    /**
     * Used to save an RpgPlayer object to a player's account
     * @param p Nickname to save the RpgPlayer object to
     * @param rp RpgPlayer object to be saved
     */
    public static void RpgSaver(String p, RpgPlayer rp){
        if (RpgAPI.useMySql){
            //TODO do stuff here LinksBro
        } else {
            YamlConfiguration playerFile = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayers/" + p + ".yml"));
                /*
	             * general variables
	            */
                //the players actual name
                playerFile.set(p + ".Real Name", rp.getRealName());
                //player TP invite state
                playerFile.set(p + ".Tp Invite State", rp.hasTpInvitePending());
                //get wether a player has moved from a previous position
                playerFile.set(p + ".Location Changed", rp.locationHasChanged());


            	/*
	            * Rpg Races Variables
	            */
                //players race name
                if (RpgAPI.racesOn){
                    playerFile.set(p + ".RpgRace.Race Name", rp.getRace());
                    //is the player immune to poison
                    playerFile.set(p + ".RpgRace.Poison Proof", rp.isPoisonProof());
                    //is the player currently poisoned
                    playerFile.set(p + ".RpgRace.Poisoned", rp.isPoisoned());
                }
                /*
            	 * rpgfood variables
	            */
                //does the player already have a food buff
                if (RpgAPI.foodOn){
                    playerFile.set(p + ".RpgFood.Food Buffed", rp.isBuffed());
                    playerFile.set(p + ".RpgFood.Food Consumed", rp.getEatenItems());
                }

                /*
            	 * rpg party variables
	            */
                if (RpgAPI.partyOn){
                    //does the player have a pending party invite
                    playerFile.set(p + ".RpgParty.Party Invite Pending", rp.hasPartyInvitePending());
                    //does the player want a gui to automatically
                    //open when being invited to partys
                    playerFile.set(p + ".RpgParty.Show Party Gui", rp.showPartyGui());
                    //is the player in a party
                    playerFile.set(p + ".RpgParty.In Party", rp.isInParty());
                    //auto pass on rolls
                    playerFile.set(p + ".RpgParty.Passing On All Rolls", rp.isPassingRolls());
                    //auto need on rolls
                    playerFile.set(p + ".RpgParty.Needing On All Rolls", rp.isNeedingRolls());
                    //auto greed on rolls
                    playerFile.set(p + ".RpgParty.Greeding On All Rolls", rp.isGreedingRolls());
                    //auto open loot window for player
                    playerFile.set(p + ".RpgParty.Show Loot Gui", rp.showLootGui());
                }
                /*
	            * rpg guilds variables
	            */
                if (RpgAPI.guildsOn){
                    //does the player have a pending guild invite
                    playerFile.set(p + ".RpgGuilds.Has Pending Guild Invite", rp.hasGuildInvite());
                    //should the guild accept gui auto open on a guild invitation
                    playerFile.set(p + ".RpgGuilds.Show Guild Gui", rp.showGuildGui());
                    //is the player in a guild
                    playerFile.set(p + ".RpgGuilds.Is In A Guild", rp.isInGuild());
                    //what is the players guild name
                    playerFile.set(p + ".RpgGuilds.Guild Name", rp.getGuild());
                    //what is the players rank within a guild
                    playerFile.set(p + ".RpgGuilds.Guild Rank", rp.getGuildRank());
                }
	            /*
	            * rpg friends variables
	            */
                if (RpgAPI.friendsOn){
                    //should the friend gui auto open on friend invite?
                    playerFile.set(p + ".RpgFriends.Show Friends Gui", rp.showFriendsGui());
                    //player friends list
                    playerFile.set(p + ".RpgFriends.Friends List", rp.getFriendsList());
                }
                /*
	            * trade variables
	            */
                if (RpgAPI.tradeOn){
                    //the players total Copper
                    playerFile.set(p + ".RpgTrade.Copper", rp.getCopper());
                    //the player total Silver
                    playerFile.set(p + ".RpgTrade.Silver", rp.getSilver());
                    //the players total Gold
                    playerFile.set(p + ".RpgTrade.Gold", rp.getGold());
                    //the players total Platinum
                    playerFile.set(p + ".RpgTrade.Platinum", rp.getPlatinum());
                }
                /*
	            * chat variables
	            */
                if (RpgAPI.chatOn){
                    //colors of chat channel mapped to channel name
                    playerFile.set(p + ".RpgChat.Chat Channels", rp.getChannelColor());
                    //active channel a player is talking in
                    playerFile.set(p + ".RpgChat.Active Channel", rp.getActiveChannel());
                    //all players on ignore
                    playerFile.set(p + ".RpgChat.Ignore List", rp.getIgnoreList());
                    //does the player have a pending chat invite
                    playerFile.set(p + ".RpgChat.Chat Invite Pending", rp.hasChatInvite());
                    //list of channels the player has invites for
                    playerFile.set(p + ".RpgChat.Invited Chats", rp.getInvitedChats());
                    //list of channels the player is banned from
                    playerFile.set(p + ".RpgChat.Banned Chats", rp.getBannedChats());
                    //list of channels the player is muted in
                    playerFile.set(p + ".RpgChat.Muted Chats", rp.getMutedChats());
                    //list of channels the player owns
                    playerFile.set(p + ".RpgChat.Owned Chats", rp.getOwnedChats());
                    //list of channels the player is a mod in
                    playerFile.set(p + ".RpgChat.Moderated Chats", rp.getModChats());
                    //is chat spy toggled on or off
                    playerFile.set(p + ".RpgChat.Spying On Chats", rp.isSpyingOnChats());
                    /*
                    * booleans for which message prefixes are shown in chat
                    */
                    playerFile.set(p + ".RpgChat.Showing Guild Tags", rp.isShowingGuildTags());
                    playerFile.set(p + ".RpgChat.Showing Achieve Titles", rp.isShowingAchieveTitles());
                    playerFile.set(p + ".RpgChat.Showing Channel Names", rp.isShowingChannelNames());
                    playerFile.set(p + ".RpgChat.Showing Language Names", rp.isShowingLanguageNames());
                    playerFile.set(p + ".RpgChat.Showing World Name", rp.isShowingWorldNames());
                }
	            /*
	            * rpg achievements variables
	            */
                if (RpgAPI.achievementsOn){
                    //players active prefix title
                    playerFile.set(p + ".RpgAchievements.Active Prefix", rp.getActivePrefix());
                    //players active suffix title
                    playerFile.set(p + ".RpgAchievements.Active Suffix", rp.getActiveSuffix());
                    //list of all titles a player has earned
                    playerFile.set(p + ".RpgAchievements.Titles", rp.getTitles());
                }
            	/*
	            * rpg click variables
	            */
                if (RpgAPI.clickOn){
                    //should the player use the default shift click on player behavior
                    playerFile.set(p + ".RpgClick.Use Click", rp.usesClick());
                }
            	/*
	            * rpg language variables
	            */
                if (RpgAPI.chatOn){
                    //players active spoken language
                    playerFile.set(p + ".RpgLanguages.Active Language", rp.getActiveLanguage());
                    //all languages a player knows
                    playerFile.set(p + ".RpgLanguages.Known Languages", rp.getKnownLanguages());
                    //should languages a player doesn't know be shown in chat?
                    playerFile.set(p + ".RpgLangauges.Languages In Chat", rp.showLanguagesInChat());
                }
                /*
	            * rpg lobby variables
	            */
                if (RpgAPI.lobbyOn){
                    //is the player in a lobby?
                    playerFile.set(p + ".RpgLobby.In Lobby", rp.isInLobby());
                    //serialised armor inventory for a player
                    playerFile.set(p + ".RpgLobby.Armor Inventory", rp.getArmorInventory());
                    //serialised inventory for a player
                    playerFile.set(p + ".RpgLobby.Inventory Contents", rp.getInventoryContents());
                    //players current health upon entering a lobby
                    playerFile.set(p + ".RpgLobby.Current Health", rp.getCurrentHealth());
                    //a players x coords before entering lobby
                    playerFile.set(p + ".RpgLobby.OldX", rp.getOldX());
                    //a players y coords before entering lobby
                    playerFile.set(p + ".RpgLobby.OldY", rp.getOldY());
                    //a players z coords before entering lobby
                    playerFile.set(p + ".RpgLobby.OldZ", rp.getOldZ());
                    //a players world name before entering lobby
                    playerFile.set(p + ".RpgLobby.Old World", rp.getOldWorld());
                }
	            /*
            	 * rpg minions
	            */
                if (RpgAPI.minionsOn){
                    //list of all p-ets a player owns
                    playerFile.set(p + ".RpgMinions.Pets Owned", rp.getPetsOwned());
                    //does the player have an active pet
                    playerFile.set(p + ".RpgMinions.Is Pet Active", rp.hasPetActive());
                    //active pets name
                    playerFile.set(p + ".RpgMinions.Active Pet", rp.getActivePet());
                    //does the player have agro
                    playerFile.set(p + ".RpgMinions.Agro", rp.hasAgro());
                    //is the player in combat
                    playerFile.set(p + ".RpgMinions.Is In Combat", rp.isInCombat());
                    //a players current agro rating
                    playerFile.set(p + ".RpgMinions.Agro Level", rp.getAgroLevel());
                }
	            /*
            	 * rpg Quest variables - comming soon?
	            */
                if (RpgAPI.questOn){
                    //players quests that are currently active
                    playerFile.set(p + ".RpgQuests.Current Quests", rp.getCurrentQuests());
                    //quests a player has completed
                    playerFile.set(p + ".RpgQuests.Completed Quests", rp.getCompletedQuests());
                    //stages of each quest a player is on
                    playerFile.set(p + ".RpgQuests.Quest Stages", rp.getQuestStages());
                    //players "activated" quest
                    playerFile.set(p + ".RpgQuests.Active Quest", rp.getActiveQuest());
                    //how many counter based goals are completed for quest - String
                    playerFile.set(p + ".RpgQuests.Quest Goal Count", rp.getQuestGoalCount());
                }
                /*
                * Reputations variables
                */
                if (RpgAPI.reputationOn){
                    //number for current reputation with a faction
                    playerFile.set(p + ".RpgReputations.Reputation Levels", rp.getReputationLevels());
                    //wether or not a player has discovered a factions existance
                    playerFile.set(p + ".RpgReputations.Factions Discovered", rp.getFactionsDiscovered());
                }
            	/*
	            * rpg Spawns
	            */
                if (RpgAPI.spawnsOn){
                    //does the player have a pending rez?
                    playerFile.set(p + ".RpgSpawns.Ressurection Pending", rp.hasRessurectionPending());
                    //is the player currently rezz'ing someone
                    playerFile.set(p + ".RpgSpawns.Ressurecting", rp.isRessurecting());
                    //is the player dead
                    playerFile.set(p + ".RpgSpawns.Is Dead", rp.isDead());
                }
	            /*
            	 * rpgclasses variables
            	 */
                if (RpgAPI.classesOn){
                    //players class name
                    playerFile.set(p + ".RpgClasses.Class Name", rp.getClassName());
                    //player Lawful / neutral / chaotic alignment
                    playerFile.set(p + ".RpgClasses.Lawful Alignment", rp.getLawfulAlignment());
                    //players Good Neutral Evil Alignment
                    playerFile.set(p + ".RpgClasses.Good Alignment", rp.getGoodAlignment());
                    //a map of the values for every player stat (sorted by enum)
                    playerFile.set(p + ".RpgClasses.Stats", rp.getStats());
                    //a map of the strings for all a players text bassed stats (sorted by enum)
                    playerFile.set(p + ".RpgClasses.Player Text", rp.getPlayerText());
                    //true or false for each type of damage a player is resistant to
                    playerFile.set(p + ".RpgClasses.Damage Reduction Types", rp.getDrTypes());
                    //true or false for the damage types a player is currently doing
                    playerFile.set(p + ".RpgClasses.Damage Types", rp.getDmgTypes());
                    //true or false for the elemental damage types a player is currently doing
                    playerFile.set(p + ".RpgClasses.Elemental Damage Types", rp.getElemDmgTypes());
                    //true or false for each type of elemental damage a player is resistant to
                    playerFile.set(p + ".RpgClasses.Elemental Resistance Types", rp.getElemResTypes());
                    //list of all feats a player has
                    playerFile.set(p + ".RpgClasses.Feats", rp.getFeats());
                    //skills a player has ranks in and how many ranks they have
                    playerFile.set(p + ".RpgClasses.Skills", rp.getSkills());
                    //true or false list of all spells for which a player knows
                    playerFile.set(p + ".RpgClasses.Spells", rp.getSpells());
                    //spells per level per combat
                    playerFile.set(p + ".RpgClasses.Spells Per Combat", rp.getSpellsPerCombat());
                    //is the player wearing aromor he isn't proficient with
                    playerFile.set(p + ".RpgClasses.Encumbered", rp.isEncumbered());
                }
        try {
            playerFile.save(new File("plugins/RpgAPI/RpgPlayer/" + p + ".yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }

    /**
     * Used to create a new RpgPlayer object by loading information from a file/database
     *
     * @param p playerNickname to be loaded
     * @return returns the newly created RpgPlayer, initialised with loaded data
     */
    public static RpgPlayer RpgBuilder(String p){
        RpgPlayer rp = new RpgPlayer();
        if (RpgAPI.useMySql){
                  //TODO do stuff here LinksBro
        } else {
            Boolean fileExists = false;
             File pFile = new File("plugins/RpgAPI/RpgPlayer/" + p + ".yml");
                   if (pFile.exists()){

                        fileExists = true;
                   }
            if (!(fileExists)){
                if (RpgAPI.classesOn){
                    rp.setLawfulAlignment("NEUTRAL");
                    rp.setGoodAlignment("NEUTRAL");
                    rp.setClassName("NONE");
                    Map<PlayerStat, Integer> playerStats = rp.getStats();
                    playerStats.put(PlayerStat.CHARACTER_LEVEL, 1);
                    playerStats.put(PlayerStat.AGE, 0);
                    playerStats.put(PlayerStat.STRENGTH, 10);
                    playerStats.put(PlayerStat.DEXTERITY, 10);
                    playerStats.put(PlayerStat.CONSTITUTION, 10);
                    playerStats.put(PlayerStat.INTELLIGENCE, 10);
                    playerStats.put(PlayerStat.WISDOM, 10);
                    playerStats.put(PlayerStat.CHARISMA, 10);
                    playerStats.put(PlayerStat.HIT_POINTS, 10);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_PIERCING, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_SLASHING, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_BLUDGEONING, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_CHAOTIC, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_LAWFUL, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_GOOD, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_EVIL, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_COLD, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_FIRE, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_ACID, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_SONIC, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_ELECTRICITY, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_ADAMANTINE, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_COLD_IRON, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_EPIC, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_MAGICAL, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_SILVER, 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_NONE, 0);
                    playerStats.put(PlayerStat.TOTAL_HIT_POINTS, 10);
                    playerStats.put(PlayerStat.SPEED_LAND, 30);
                    playerStats.put(PlayerStat.SPEED_LAND_WITH_ARMOR, 20);
                    playerStats.put(PlayerStat.SPEED_FLY, 30);
                    playerStats.put(PlayerStat.SPEED_SWIM, 20);
                    playerStats.put(PlayerStat.INITIATIVE, 1);
                    playerStats.put(PlayerStat.ARMOR_CLASS_ARMOR_BONUS, 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_SHIELD_BONUS, 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_SIZE_MODIFIER, 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_NATURAL_ARMOR, 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_DEFLECTION_MODIFIER, 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_MODIFIER_MISC, 0);
                    playerStats.put(PlayerStat.FORTITUDE_CLASS_BONUS, 0);
                    playerStats.put(PlayerStat.FORTITUDE_CONSTITUTION_BONUS, 0);
                    playerStats.put(PlayerStat.FORTITUDE_MAGIC, 0);
                    playerStats.put(PlayerStat.FORTITUDE_MISC, 0);
                    playerStats.put(PlayerStat.REFLEX__CLASS_BONUS, 0);
                    playerStats.put(PlayerStat.REFLEX_DEXTERITY_BONUS, 0);
                    playerStats.put(PlayerStat.REFLEX_MAGIC, 0);
                    playerStats.put(PlayerStat.REFLEX_MISC, 0);
                    playerStats.put(PlayerStat.WILLPOWER_CLASS_BONUS, 0);
                    playerStats.put(PlayerStat.WILLPOWER_WISDOM_BONUS, 0);
                    playerStats.put(PlayerStat.WILLPOWER_MAGIC, 0);
                    playerStats.put(PlayerStat.WILLPOWER_MISC, 0);
                    playerStats.put(PlayerStat.BASE_ATTACK_BONUS, 0);
                    playerStats.put(PlayerStat.SPELL_RESISTANCE, 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_BAB, 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_SIZE, 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_STRENGTH, 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_MISC, 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_STRENGTH, 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_DEXTERITY, 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_BAB, 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_SIZE, 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_STANDARD, 10);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_MISC, 0);
                    playerStats.put(PlayerStat.EXPERIENCE_TOTAL, 0);
                    rp.setStats(playerStats);
                    Map<PlayerText, String> textStats = rp.getPlayerText();
                    textStats.put(PlayerText.DEITY, "NONE");
                    textStats.put(PlayerText.SIZE, "NONE");
                    textStats.put(PlayerText.GENDER, "NONE");
                    textStats.put(PlayerText.HEIGHT, "NONE");
                    textStats.put(PlayerText.WEIGHT, "NONE");
                    textStats.put(PlayerText.HAIR_COLOR, "NONE");
                    textStats.put(PlayerText.EYE_COLOR, "NONE");
                    textStats.put(PlayerText.DESCRIPTION, "NONE");
                    rp.setPlayerText(textStats);
                    Map<ElementalType, Integer> elementalTypeIntegerMap = rp.getElemResTypes();
                    elementalTypeIntegerMap.put(ElementalType.FIRE, 0);
                    elementalTypeIntegerMap.put(ElementalType.COLD, 0);
                    elementalTypeIntegerMap.put(ElementalType.ACID, 0);
                    elementalTypeIntegerMap.put(ElementalType.ELECTRICITY, 0);
                    elementalTypeIntegerMap.put(ElementalType.SONIC, 0);
                    rp.setElemResTypes(elementalTypeIntegerMap);
                    List<Feat> playerFeats = rp.getFeats();
                    playerFeats.add(Feat.SOCIABLE);
                    rp.setFeats(playerFeats);
                    Map<PlayerSkill, Integer> playerSkills = rp.getSkills();
                    playerSkills.put(PlayerSkill.ACROBATICS, 0);
                    playerSkills.put(PlayerSkill.APPRAISE, 0);
                    playerSkills.put(PlayerSkill.BLUFF, 0);
                    playerSkills.put(PlayerSkill.CLIMB, 0);
                    playerSkills.put(PlayerSkill.CRAFT_ALCHEMY, 0);
                    playerSkills.put(PlayerSkill.CRAFT_ARMOR, 0);
                    playerSkills.put(PlayerSkill.CRAFT_ITEMS, 0);
                    playerSkills.put(PlayerSkill.CRAFT_JEWELRY, 0);
                    playerSkills.put(PlayerSkill.CRAFT_POISON, 0);
                    playerSkills.put(PlayerSkill.CRAFT_TRAPS, 0);
                    playerSkills.put(PlayerSkill.CRAFT_WEAPONS, 0);
                    playerSkills.put(PlayerSkill.DIPLOMACY, 0);
                    playerSkills.put(PlayerSkill.DISABLE_DEVICE, 0);
                    playerSkills.put(PlayerSkill.DISGUISE, 0);
                    playerSkills.put(PlayerSkill.ESCAPE_ARTIST, 0);
                    playerSkills.put(PlayerSkill.FLY, 0);
                    playerSkills.put(PlayerSkill.HANDLE_ANIMAL, 0);
                    playerSkills.put(PlayerSkill.HEAL, 0);
                    playerSkills.put(PlayerSkill.INTIMIDATE, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_ARCANA, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_DUNGEONEERING, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_ENGINEERING, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_GEOGRAPHY, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_HISTORY, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_LOCAL, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_NATURE, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_NOBILITY, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_PLANES, 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_RELIGION, 0);
                    playerSkills.put(PlayerSkill.LINGUISTICS, 0);
                    playerSkills.put(PlayerSkill.PERCEPTION, 0);
                    playerSkills.put(PlayerSkill.PERFORM, 0);
                    playerSkills.put(PlayerSkill.PROFESSION, 0);
                    playerSkills.put(PlayerSkill.RIDE, 0);
                    playerSkills.put(PlayerSkill.SENSE_MOTIVE, 0);
                    playerSkills.put(PlayerSkill.SLEIGHT_OF_HAND, 0);
                    playerSkills.put(PlayerSkill.SPELLCRAFT, 0);
                    playerSkills.put(PlayerSkill.STEALTH, 0);
                    playerSkills.put(PlayerSkill.SURVIVAL, 0);
                    playerSkills.put(PlayerSkill.SWIM, 0);
                    playerSkills.put(PlayerSkill.USE_MAGIC_DEVICE, 0);
                    rp.setSkills(playerSkills);
                    List<Spell> playerSpells = rp.getSpells();
                    playerSpells.add(Spell.PRESTIDIGITATION);
                    rp.setSpells(playerSpells);
                    Map<String, Integer> spellsPerLevel = rp.getSpellsPerCombat();
                    spellsPerLevel.put("0", 0);
                    rp.setSpellsPerCombat(spellsPerLevel);

                }
                if (RpgAPI.racesOn){
                    rp.setRace("NONE");
                }
                if (RpgAPI.guildsOn){
                    rp.setGuild("NONE");
                    rp.setGuildRank("NONE");
                }
                if (RpgAPI.friendsOn){
                    List<String> friendList = rp.getFriendsList();
                    friendList.add("soulofw0lf");
                    friendList.add("Blokroq");
                    rp.setFriendsList(friendList);
                }
                if (RpgAPI.tradeOn){
                    rp.setCopper(5);
                    rp.setSilver(0);
                    rp.setGold(0);
                    rp.setPlatinum(0);
                }
                if (RpgAPI.chatOn){
                    Map<String, String> channelColors = rp.getChannelColor();
                    channelColors.put("Party", ChatColor.BLUE.toString());
                    channelColors.put("Region", ChatColor.WHITE.toString());
                    channelColors.put("Guild", ChatColor.DARK_GREEN.toString());
                    channelColors.put("Admin Announcements", ChatColor.DARK_RED.toString());
                    rp.setChannelColor(channelColors);
                    List<String> ignoreList = rp.getIgnoreList();
                    ignoreList.add("Notch");
                    ignoreList.add("Jeb");
                    rp.setIgnoreList(ignoreList);
                    List<String> invitedChats = rp.getInvitedChats();
                    invitedChats.add("Soul\'s Party Room");
                    invitedChats.add("The Basement");
                    rp.setInvitedChats(invitedChats);
                    List<String> bannedChats = rp.getBannedChats();
                    bannedChats.add("Blok\'s Room");
                    bannedChats.add("Out of The Basement");
                    rp.setBannedChats(bannedChats);
                    List<String> mutedChats = rp.getMutedChats();
                    mutedChats.add("Admin Announcements");
                    mutedChats.add("Soul\'s Party Room");
                    rp.setMutedChats(mutedChats);
                    List<String> ownedChats = rp.getOwnedChats();
                    ownedChats.add(p);
                    ownedChats.add("Talk with " + p);
                    rp.setOwnedChats(ownedChats);
                    List<String> moderatedChats = rp.getModChats();
                    moderatedChats.add(p);
                    moderatedChats.add("Talk with " + p);
                    rp.setModChats(moderatedChats);
                    rp.setSpyingOnChats(false);
                    rp.setShowingGuildTags(true);
                    rp.setShowingAchieveTitles(true);
                    rp.setShowingChannelNames(true);
                    rp.setShowingLanguageNames(true);
                    rp.setShowingWorldName(true);
                    rp.setActiveLanguage("Region");
                    List<String> languages = rp.getKnownLanguages();
                    languages.add("Common");
                    languages.add("Out of Game");
                    rp.setKnownLanguages(languages);
                    rp.setLanguagesInChat(true);
                }
                if (RpgAPI.achievementsOn){
                    rp.setActivePrefix("The Recruit");
                    rp.setActiveSuffix("NONE");
                    List<String> playerTitles = rp.getTitles();
                    playerTitles.add("The Recruit");
                    playerTitles.add("Server Joiner");
                    rp.setTitles(playerTitles);
                }
                if (RpgAPI.clickOn){rp.setClick(true);}
                if (RpgAPI.lobbyOn){
                    rp.setInLobby(false);
                    rp.setArmorInventory("NONR");
                    rp.setInventoryContents("NONE");
                    rp.setCurrentHealth(0);
                    rp.setOldX(0);
                    rp.setOldY(0);
                    rp.setOldZ(0);
                    rp.setOldWorld("World");
                }
                if (RpgAPI.minionsOn){
                    List<String> petsOwned = rp.getPetsOwned();
                    petsOwned.add("Mugli");
                    petsOwned.add("Ilgum");
                    rp.setPetsOwned(petsOwned);
                    rp.setActivePet("Mugli");
                }
                rp.setRealName(p);
                if (RpgAPI.questOn){
                    List<String> currentQuests = rp.getCurrentQuests();
                    Map<String, Integer> questStage = rp.getQuestStages();
                    Map<String, Integer> stageCounter = rp.getQuestGoalCount();
                    rp.setCurrentQuests(currentQuests);
                    rp.setQuestStages(questStage);
                    rp.setQuestGoalCount(stageCounter);
                    List<String> completedQuests = rp.getCompletedQuests();
                    rp.setCompletedQuests(completedQuests);
                }
                if (RpgAPI.reputationOn){
                    Map<String, Integer> repLevel = rp.getReputationLevels();
                    List<Reputation> repDiscovered = rp.getFactionsDiscovered();
                    rp.setReputationLevels(repLevel);
                    rp.setFactionsDiscovered(repDiscovered);
                }
                return rp;
            } else {

                YamlConfiguration playerFile = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayer/" + p + ".yml"));
                /*
	             * general variables
	            */
                //the players actual name
                rp.setRealName(playerFile.getString(p + ".Real Name"));
                //player TP invite state
                rp.setTpInviteState(playerFile.getBoolean(p + ".Tp Invite State"));
                //get wether a player has moved from a previous position
                playerFile.set(p + ".Location Changed", rp.locationHasChanged());


            	/*
	            * Rpg Races Variables
	            */
                //players race name
                if (RpgAPI.racesOn){
                    playerFile.set(p + ".RpgRace.Race Name", rp.getRace());
                    //is the player immune to poison
                    playerFile.set(p + ".RpgRace.Poison Proof", rp.isPoisonProof());
                    //is the player currently poisoned
                    playerFile.set(p + ".RpgRace.Poisoned", rp.isPoisoned());
                }
                /*
            	 * rpgfood variables
	            */
                //does the player already have a food buff
                if (RpgAPI.foodOn){
                    playerFile.set(p + ".RpgFood.Food Buffed", rp.isBuffed());
                    playerFile.set(p + ".RpgFood.Food Consumed", rp.getEatenItems());
                }

                /*
            	 * rpg party variables
	            */
                if (RpgAPI.partyOn){
                    //does the player have a pending party invite
                    playerFile.set(p + ".RpgParty.Party Invite Pending", rp.hasPartyInvitePending());
                    //does the player want a gui to automatically
                    //open when being invited to partys
                    playerFile.set(p + ".RpgParty.Show Party Gui", rp.showPartyGui());
                    //is the player in a party
                    playerFile.set(p + ".RpgParty.In Party", rp.isInParty());
                    //auto pass on rolls
                    playerFile.set(p + ".RpgParty.Passing On All Rolls", rp.isPassingRolls());
                    //auto need on rolls
                    playerFile.set(p + ".RpgParty.Needing On All Rolls", rp.isNeedingRolls());
                    //auto greed on rolls
                    playerFile.set(p + ".RpgParty.Greeding On All Rolls", rp.isGreedingRolls());
                    //auto open loot window for player
                    playerFile.set(p + ".RpgParty.Show Loot Gui", rp.showLootGui());
                }
                /*
	            * rpg guilds variables
	            */
                if (RpgAPI.guildsOn){
                    //does the player have a pending guild invite
                    playerFile.set(p + ".RpgGuilds.Has Pending Guild Invite", rp.hasGuildInvite());
                    //should the guild accept gui auto open on a guild invitation
                    playerFile.set(p + ".RpgGuilds.Show Guild Gui", rp.showGuildGui());
                    //is the player in a guild
                    playerFile.set(p + ".RpgGuilds.Is In A Guild", rp.isInGuild());
                    //what is the players guild name
                    playerFile.set(p + ".RpgGuilds.Guild Name", rp.getGuild());
                    //what is the players rank within a guild
                    playerFile.set(p + ".RpgGuilds.Guild Rank", rp.getGuildRank());
                }
	            /*
	            * rpg friends variables
	            */
                if (RpgAPI.friendsOn){
                    //should the friend gui auto open on friend invite?
                    playerFile.set(p + ".RpgFriends.Show Friends Gui", rp.showFriendsGui());
                    //player friends list
                    playerFile.set(p + ".RpgFriends.Friends List", rp.getFriendsList());
                }
                /*
	            * trade variables
	            */
                if (RpgAPI.tradeOn){
                    //the players total Copper
                    playerFile.set(p + ".RpgTrade.Copper", rp.getCopper());
                    //the player total Silver
                    playerFile.set(p + ".RpgTrade.Silver", rp.getSilver());
                    //the players total Gold
                    playerFile.set(p + ".RpgTrade.Gold", rp.getGold());
                    //the players total Platinum
                    playerFile.set(p + ".RpgTrade.Platinum", rp.getPlatinum());
                }
                /*
	            * chat variables
	            */
                if (RpgAPI.chatOn){
                    //colors of chat channel mapped to channel name
                    playerFile.set(p + ".RpgChat.Chat Channels", rp.getChannelColor());
                    //active channel a player is talking in
                    playerFile.set(p + ".RpgChat.Active Channel", rp.getActiveChannel());
                    //all players on ignore
                    playerFile.set(p + ".RpgChat.Ignore List", rp.getIgnoreList());
                    //does the player have a pending chat invite
                    playerFile.set(p + ".RpgChat.Chat Invite Pending", rp.hasChatInvite());
                    //list of channels the player has invites for
                    playerFile.set(p + ".RpgChat.Invited Chats", rp.getInvitedChats());
                    //list of channels the player is banned from
                    playerFile.set(p + ".RpgChat.Banned Chats", rp.getBannedChats());
                    //list of channels the player is muted in
                    playerFile.set(p + ".RpgChat.Muted Chats", rp.getMutedChats());
                    //list of channels the player owns
                    playerFile.set(p + ".RpgChat.Owned Chats", rp.getOwnedChats());
                    //list of channels the player is a mod in
                    playerFile.set(p + ".RpgChat.Moderated Chats", rp.getModChats());
                    //is chat spy toggled on or off
                    playerFile.set(p + ".RpgChat.Spying On Chats", rp.isSpyingOnChats());
                    /*
                    * booleans for which message prefixes are shown in chat
                    */
                    playerFile.set(p + ".RpgChat.Showing Guild Tags", rp.isShowingGuildTags());
                    playerFile.set(p + ".RpgChat.Showing Achieve Titles", rp.isShowingAchieveTitles());
                    playerFile.set(p + ".RpgChat.Showing Channel Names", rp.isShowingChannelNames());
                    playerFile.set(p + ".RpgChat.Showing Language Names", rp.isShowingLanguageNames());
                    playerFile.set(p + ".RpgChat.Showing World Name", rp.isShowingWorldNames());
                }
	            /*
	            * rpg achievements variables
	            */
                if (RpgAPI.achievementsOn){
                    //players active prefix title
                    playerFile.set(p + ".RpgAchievements.Active Prefix", rp.getActivePrefix());
                    //players active suffix title
                    playerFile.set(p + ".RpgAchievements.Active Suffix", rp.getActiveSuffix());
                    //list of all titles a player has earned
                    playerFile.set(p + ".RpgAchievements.Titles", rp.getTitles());
                }
            	/*
	            * rpg click variables
	            */
                if (RpgAPI.clickOn){
                    //should the player use the default shift click on player behavior
                    playerFile.set(p + ".RpgClick.Use Click", rp.usesClick());
                }
            	/*
	            * rpg language variables
	            */
                if (RpgAPI.chatOn){
                    //players active spoken language
                    playerFile.set(p + ".RpgLanguages.Active Language", rp.getActiveLanguage());
                    //all languages a player knows
                    playerFile.set(p + ".RpgLanguages.Known Languages", rp.getKnownLanguages());
                    //should languages a player doesn't know be shown in chat?
                    playerFile.set(p + ".RpgLangauges.Languages In Chat", rp.showLanguagesInChat());
                }
                /*
	            * rpg lobby variables
	            */
                if (RpgAPI.lobbyOn){
                    //is the player in a lobby?
                    playerFile.set(p + ".RpgLobby.In Lobby", rp.isInLobby());
                    //serialised armor inventory for a player
                    playerFile.set(p + ".RpgLobby.Armor Inventory", rp.getArmorInventory());
                    //serialised inventory for a player
                    playerFile.set(p + ".RpgLobby.Inventory Contents", rp.getInventoryContents());
                    //players current health upon entering a lobby
                    playerFile.set(p + ".RpgLobby.Current Health", rp.getCurrentHealth());
                    //a players x coords before entering lobby
                    playerFile.set(p + ".RpgLobby.OldX", rp.getOldX());
                    //a players y coords before entering lobby
                    playerFile.set(p + ".RpgLobby.OldY", rp.getOldY());
                    //a players z coords before entering lobby
                    playerFile.set(p + ".RpgLobby.OldZ", rp.getOldZ());
                    //a players world name before entering lobby
                    playerFile.set(p + ".RpgLobby.Old World", rp.getOldWorld());
                }
	            /*
            	 * rpg minions
	            */
                if (RpgAPI.minionsOn){
                    //list of all p-ets a player owns
                    playerFile.set(p + ".RpgMinions.Pets Owned", rp.getPetsOwned());
                    //does the player have an active pet
                    playerFile.set(p + ".RpgMinions.Is Pet Active", rp.hasPetActive());
                    //active pets name
                    playerFile.set(p + ".RpgMinions.Active Pet", rp.getActivePet());
                    //does the player have agro
                    playerFile.set(p + ".RpgMinions.Agro", rp.hasAgro());
                    //is the player in combat
                    playerFile.set(p + ".RpgMinions.Is In Combat", rp.isInCombat());
                    //a players current agro rating
                    playerFile.set(p + ".RpgMinions.Agro Level", rp.getAgroLevel());
                }
	            /*
            	 * rpg Quest variables - comming soon?
	            */
                if (RpgAPI.questOn){
                    //players quests that are currently active
                    playerFile.set(p + ".RpgQuests.Current Quests", rp.getCurrentQuests());
                    //quests a player has completed
                    playerFile.set(p + ".RpgQuests.Completed Quests", rp.getCompletedQuests());
                    //stages of each quest a player is on
                    playerFile.set(p + ".RpgQuests.Quest Stages", rp.getQuestStages());
                    //players "activated" quest
                    playerFile.set(p + ".RpgQuests.Active Quest", rp.getActiveQuest());
                    //how many counter based goals are completed for quest - String
                    playerFile.set(p + ".RpgQuests.Quest Goal Count", rp.getQuestGoalCount());
                }
                /*
                * Reputations variables
                */
                if (RpgAPI.reputationOn){
                    //number for current reputation with a faction
                    playerFile.set(p + ".RpgReputations.Reputation Levels", rp.getReputationLevels());
                    //wether or not a player has discovered a factions existance
                    playerFile.set(p + ".RpgReputations.Factions Discovered", rp.getFactionsDiscovered());
                }
            	/*
	            * rpg Spawns
	            */
                if (RpgAPI.spawnsOn){
                    //does the player have a pending rez?
                    playerFile.set(p + ".RpgSpawns.Ressurection Pending", rp.hasRessurectionPending());
                    //is the player currently rezz'ing someone
                    playerFile.set(p + ".RpgSpawns.Ressurecting", rp.isRessurecting());
                    //is the player dead
                    playerFile.set(p + ".RpgSpawns.Is Dead", rp.isDead());
                }
	            /*
            	 * rpgclasses variables
            	 */
                 if (RpgAPI.classesOn){
                    //players class name
                     playerFile.set(p + ".RpgClasses.Class Name", rp.getClassName());
                     //player Lawful / neutral / chaotic alignment
                     playerFile.set(p + ".RpgClasses.Lawful Alignment", rp.getLawfulAlignment());
                     //players Good Neutral Evil Alignment
                     playerFile.set(p + ".RpgClasses.Good Alignment", rp.getGoodAlignment());
                    //a map of the values for every player stat (sorted by enum)
                     playerFile.set(p + ".RpgClasses.Stats", rp.getStats());
                    //a map of the strings for all a players text bassed stats (sorted by enum)
                     playerFile.set(p + ".RpgClasses.Player Text", rp.getPlayerText());
                    //true or false for each type of damage a player is resistant to
                     playerFile.set(p + ".RpgClasses.Damage Reduction Types", rp.getDrTypes());
                    //true or false for the damage types a player is currently doing
                     playerFile.set(p + ".RpgClasses.Damage Types", rp.getDmgTypes());
                    //true or false for the elemental damage types a player is currently doing
                     playerFile.set(p + ".RpgClasses.Elemental Damage Types", rp.getElemDmgTypes());
                    //true or false for each type of elemental damage a player is resistant to
                     playerFile.set(p + ".RpgClasses.Elemental Resistance Types", rp.getElemResTypes());
                    //list of all feats a player has
                     playerFile.set(p + ".RpgClasses.Feats", rp.getFeats());
                    //skills a player has ranks in and how many ranks they have
                     playerFile.set(p + ".RpgClasses.Skills", rp.getSkills());
                    //true or false list of all spells for which a player knows
                     playerFile.set(p + ".RpgClasses.Spells", rp.getSpells());
                    //spells per level per combat
                     playerFile.set(p + ".RpgClasses.Spells Per Combat", rp.getSpellsPerCombat());
                    //is the player wearing aromor he isn't proficient with
                     playerFile.set(p + ".RpgClasses.Encumbered", rp.isEncumbered());
                 }
                return rp;
            }
        }
        return rp;
        }

}
