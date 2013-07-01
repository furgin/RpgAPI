package com.vartala.soulofw0lf.rpgapi.playerapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.enumapi.*;
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
     *
     * @param p  Nickname to save the RpgPlayer object to
     * @param rp RpgPlayer object to be saved
     */
    public static void RpgSaver(String p, RpgPlayer rp) {
        if (RpgAPI.useMySql) {
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
            if (RpgAPI.racesOn) {
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
            if (RpgAPI.foodOn) {
                playerFile.set(p + ".RpgFood.Food Buffed", rp.isBuffed());

            }

                /*
            	 * rpg party variables
	            */
            if (RpgAPI.partyOn) {
                //does the player have a pending party invite
                playerFile.set(p + ".RpgParty.Party Invite Pending", rp.hasPartyInvitePending());
                //does the player want a gui to automatically
                //open when being invited to partys
                playerFile.set(p + ".RpgParty.Show Party Gui", rp.showPartyGui());
                //is the player in a party
                playerFile.set(p + ".RpgParty.In Party", rp.isInParty());
                //player party leaders name
                playerFile.set(p + ".RpgParty.Leader Name", rp.getLeaderName());
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
            if (RpgAPI.guildsOn) {
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
            if (RpgAPI.friendsOn) {
                //should the friend gui auto open on friend invite?
                playerFile.set(p + ".RpgFriends.Show Friends Gui", rp.showFriendsGui());
                //player friends list
                playerFile.set(p + ".RpgFriends.Friends List", rp.getFriendsList());
            }
                /*
	            * trade variables
	            */
            if (RpgAPI.tradeOn) {
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
            if (RpgAPI.chatOn) {
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
            if (RpgAPI.achievementsOn) {
                //players active prefix title
                playerFile.set(p + ".RpgAchievements.Active Prefix", rp.getActivePrefix());
                //players active suffix title
                playerFile.set(p + ".RpgAchievements.Active Suffix", rp.getActiveSuffix());
                //list of all titles a player has earned
                playerFile.set(p + ".RpgAchievements.Titles", rp.getTitles());
                //list of mobs killed with counter
                playerFile.set(p + ".RpgAchievements.Mob Kills", rp.getMobKills());

                //list of players killed with counter
                playerFile.set(p + ".RpgAchievements.Player Kills", rp.getPlayerKills());

                //food items a player has eaten
                playerFile.set(p + ".RpgAchievements.Food Consumed", rp.getEatenItems());

                //Items used
                playerFile.set(p + ".RpgAchievements.Items Used", rp.getItemsUsed());
            }
            	/*
	            * rpg click variables
	            */
            if (RpgAPI.clickOn) {
                //should the player use the default shift click on player behavior
                playerFile.set(p + ".RpgClick.Use Click", rp.usesClick());
            }
            	/*
	            * rpg language variables
	            */
            if (RpgAPI.chatOn) {
                //players active spoken language
                playerFile.set(p + ".RpgLanguages.Active Language", rp.getActiveLanguage());
                //all languages a player knows
                playerFile.set(p + ".RpgLanguages.Known Languages", rp.getKnownLanguages());
                //should languages a player doesn't know be shown in chat?
                playerFile.set(p + ".RpgLanguages.Languages In Chat", rp.showLanguagesInChat());
            }
                /*
	            * rpg lobby variables
	            */
            if (RpgAPI.lobbyOn) {
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
            if (RpgAPI.minionsOn) {
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
            if (RpgAPI.questOn) {
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
            if (RpgAPI.reputationOn) {
                //number for current reputation with a faction
                playerFile.set(p + ".RpgReputations.Reputation Levels", rp.getReputationLevels());
                //wether or not a player has discovered a factions existance
                playerFile.set(p + ".RpgReputations.Factions Discovered", rp.getFactionsDiscovered());
            }
            	/*
	            * rpg Spawns
	            */
            if (RpgAPI.spawnsOn) {
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
            if (RpgAPI.classesOn) {
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

    public static RpgPlayer RpgBuilder(String p) {
        RpgPlayer rp = new RpgPlayer();
        if (RpgAPI.useMySql) {
            //TODO do stuff here LinksBro
        } else {
            Boolean fileExists = false;
            File pFile = new File("plugins/RpgAPI/RpgPlayer/" + p + ".yml");
            if (pFile.exists()) {

                fileExists = true;
            }
            if (!(fileExists)) {
                if (RpgAPI.classesOn) {
                    rp.setLawfulAlignment("NEUTRAL");
                    rp.setGoodAlignment("NEUTRAL");
                    rp.setClassName("NONE");
                    Map<String, Integer> playerStats = rp.getStats();
                    playerStats.put(PlayerStat.CHARACTER_LEVEL.toString(), 1);
                    playerStats.put(PlayerStat.AGE.toString(), 0);
                    playerStats.put(PlayerStat.STRENGTH.toString(), 10);
                    playerStats.put(PlayerStat.DEXTERITY.toString(), 10);
                    playerStats.put(PlayerStat.CONSTITUTION.toString(), 10);
                    playerStats.put(PlayerStat.INTELLIGENCE.toString(), 10);
                    playerStats.put(PlayerStat.WISDOM.toString(), 10);
                    playerStats.put(PlayerStat.CHARISMA.toString(), 10);
                    playerStats.put(PlayerStat.HIT_POINTS.toString(), 10);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_PIERCING.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_SLASHING.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_BLUDGEONING.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_CHAOTIC.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_LAWFUL.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_GOOD.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_EVIL.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_COLD.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_FIRE.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_ACID.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_SONIC.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_ELECTRICITY.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_ADAMANTINE.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_COLD_IRON.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_EPIC.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_MAGICAL.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_SILVER.toString(), 0);
                    playerStats.put(PlayerStat.DAMAGE_REDUCTION_NONE.toString(), 0);
                    playerStats.put(PlayerStat.TOTAL_HIT_POINTS.toString(), 10);
                    playerStats.put(PlayerStat.SPEED_LAND.toString(), 30);
                    playerStats.put(PlayerStat.SPEED_LAND_WITH_ARMOR.toString(), 20);
                    playerStats.put(PlayerStat.SPEED_FLY.toString(), 30);
                    playerStats.put(PlayerStat.SPEED_SWIM.toString(), 20);
                    playerStats.put(PlayerStat.INITIATIVE.toString(), 1);
                    playerStats.put(PlayerStat.ARMOR_CLASS_ARMOR_BONUS.toString(), 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_SHIELD_BONUS.toString(), 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_SIZE_MODIFIER.toString(), 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_NATURAL_ARMOR.toString(), 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_DEFLECTION_MODIFIER.toString(), 0);
                    playerStats.put(PlayerStat.ARMOR_CLASS_MODIFIER_MISC.toString(), 0);
                    playerStats.put(PlayerStat.FORTITUDE_CLASS_BONUS.toString(), 0);
                    playerStats.put(PlayerStat.FORTITUDE_CONSTITUTION_BONUS.toString(), 0);
                    playerStats.put(PlayerStat.FORTITUDE_MAGIC.toString(), 0);
                    playerStats.put(PlayerStat.FORTITUDE_MISC.toString(), 0);
                    playerStats.put(PlayerStat.REFLEX__CLASS_BONUS.toString(), 0);
                    playerStats.put(PlayerStat.REFLEX_DEXTERITY_BONUS.toString(), 0);
                    playerStats.put(PlayerStat.REFLEX_MAGIC.toString(), 0);
                    playerStats.put(PlayerStat.REFLEX_MISC.toString(), 0);
                    playerStats.put(PlayerStat.WILLPOWER_CLASS_BONUS.toString(), 0);
                    playerStats.put(PlayerStat.WILLPOWER_WISDOM_BONUS.toString(), 0);
                    playerStats.put(PlayerStat.WILLPOWER_MAGIC.toString(), 0);
                    playerStats.put(PlayerStat.WILLPOWER_MISC.toString(), 0);
                    playerStats.put(PlayerStat.BASE_ATTACK_BONUS.toString(), 0);
                    playerStats.put(PlayerStat.SPELL_RESISTANCE.toString(), 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_BAB.toString(), 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_SIZE.toString(), 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_STRENGTH.toString(), 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_MISC.toString(), 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_STRENGTH.toString(), 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_DEXTERITY.toString(), 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_BAB.toString(), 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_SIZE.toString(), 0);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_STANDARD.toString(), 10);
                    playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_MISC.toString(), 0);
                    playerStats.put(PlayerStat.EXPERIENCE_TOTAL.toString(), 0);
                    rp.setStats(playerStats);
                    Map<String, String> textStats = rp.getPlayerText();
                    textStats.put(PlayerText.DEITY.toString(), "NONE");
                    textStats.put(PlayerText.SIZE.toString(), "NONE");
                    textStats.put(PlayerText.GENDER.toString(), "NONE");
                    textStats.put(PlayerText.HEIGHT.toString(), "NONE");
                    textStats.put(PlayerText.WEIGHT.toString(), "NONE");
                    textStats.put(PlayerText.HAIR_COLOR.toString(), "NONE");
                    textStats.put(PlayerText.EYE_COLOR.toString(), "NONE");
                    textStats.put(PlayerText.DESCRIPTION.toString(), "NONE");
                    rp.setPlayerText(textStats);
                    Map<String, Integer> elementalTypeIntegerMap = rp.getElemResTypes();
                    elementalTypeIntegerMap.put(ElementalType.FIRE.toString(), 0);
                    elementalTypeIntegerMap.put(ElementalType.COLD.toString(), 0);
                    elementalTypeIntegerMap.put(ElementalType.ACID.toString(), 0);
                    elementalTypeIntegerMap.put(ElementalType.ELECTRICITY.toString(), 0);
                    elementalTypeIntegerMap.put(ElementalType.SONIC.toString(), 0);
                    rp.setElemResTypes(elementalTypeIntegerMap);
                    List<String> playerFeats = rp.getFeats();
                    playerFeats.add(Feat.SOCIABLE.toString());
                    rp.setFeats(playerFeats);
                    Map<String, Integer> playerSkills = rp.getSkills();
                    playerSkills.put(PlayerSkill.ACROBATICS.toString(), 0);
                    playerSkills.put(PlayerSkill.APPRAISE.toString(), 0);
                    playerSkills.put(PlayerSkill.BLUFF.toString(), 0);
                    playerSkills.put(PlayerSkill.CLIMB.toString(), 0);
                    playerSkills.put(PlayerSkill.CRAFT_ALCHEMY.toString(), 0);
                    playerSkills.put(PlayerSkill.CRAFT_ARMOR.toString(), 0);
                    playerSkills.put(PlayerSkill.CRAFT_ITEMS.toString(), 0);
                    playerSkills.put(PlayerSkill.CRAFT_JEWELRY.toString(), 0);
                    playerSkills.put(PlayerSkill.CRAFT_POISON.toString(), 0);
                    playerSkills.put(PlayerSkill.CRAFT_TRAPS.toString(), 0);
                    playerSkills.put(PlayerSkill.CRAFT_WEAPONS.toString(), 0);
                    playerSkills.put(PlayerSkill.DIPLOMACY.toString(), 0);
                    playerSkills.put(PlayerSkill.DISABLE_DEVICE.toString(), 0);
                    playerSkills.put(PlayerSkill.DISGUISE.toString(), 0);
                    playerSkills.put(PlayerSkill.ESCAPE_ARTIST.toString(), 0);
                    playerSkills.put(PlayerSkill.FLY.toString(), 0);
                    playerSkills.put(PlayerSkill.HANDLE_ANIMAL.toString(), 0);
                    playerSkills.put(PlayerSkill.HEAL.toString(), 0);
                    playerSkills.put(PlayerSkill.INTIMIDATE.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_ARCANA.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_DUNGEONEERING.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_ENGINEERING.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_GEOGRAPHY.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_HISTORY.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_LOCAL.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_NATURE.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_NOBILITY.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_PLANES.toString(), 0);
                    playerSkills.put(PlayerSkill.KNOWLEDGE_RELIGION.toString(), 0);
                    playerSkills.put(PlayerSkill.LINGUISTICS.toString(), 0);
                    playerSkills.put(PlayerSkill.PERCEPTION.toString(), 0);
                    playerSkills.put(PlayerSkill.PERFORM.toString(), 0);
                    playerSkills.put(PlayerSkill.PROFESSION.toString(), 0);
                    playerSkills.put(PlayerSkill.RIDE.toString(), 0);
                    playerSkills.put(PlayerSkill.SENSE_MOTIVE.toString(), 0);
                    playerSkills.put(PlayerSkill.SLEIGHT_OF_HAND.toString(), 0);
                    playerSkills.put(PlayerSkill.SPELLCRAFT.toString(), 0);
                    playerSkills.put(PlayerSkill.STEALTH.toString(), 0);
                    playerSkills.put(PlayerSkill.SURVIVAL.toString(), 0);
                    playerSkills.put(PlayerSkill.SWIM.toString(), 0);
                    playerSkills.put(PlayerSkill.USE_MAGIC_DEVICE.toString(), 0);
                    rp.setSkills(playerSkills);
                    List<String> playerSpells = rp.getSpells();
                    playerSpells.add(Spell.PRESTIDIGITATION.toString());
                    rp.setSpells(playerSpells);
                    Map<String, Integer> spellsPerLevel = rp.getSpellsPerCombat();
                    spellsPerLevel.put("0", 0);
                    rp.setSpellsPerCombat(spellsPerLevel);

                }
                if (RpgAPI.racesOn) {
                    rp.setRace("NONE");
                }
                if (RpgAPI.guildsOn) {
                    rp.setGuild("NONE");
                    rp.setGuildRank("NONE");
                }
                if (RpgAPI.friendsOn) {
                    List<String> friendList = rp.getFriendsList();
                    friendList.add("soulofw0lf");
                    friendList.add("Blokroq");
                    rp.setFriendsList(friendList);
                }
                if (RpgAPI.tradeOn) {
                    rp.setCopper(5);
                    rp.setSilver(0);
                    rp.setGold(0);
                    rp.setPlatinum(0);
                }
                if (RpgAPI.chatOn) {
                    Map<String, String> channelColors = rp.getChannelColor();
                    channelColors.put("Party", ChatColor.BLUE.toString());
                    channelColors.put("Region", ChatColor.WHITE.toString());
                    channelColors.put("Guild", ChatColor.DARK_GREEN.toString());
                    channelColors.put("General", ChatColor.DARK_RED.toString());
                    channelColors.put("Shout", ChatColor.AQUA.toString());
                    channelColors.put("Local", ChatColor.DARK_PURPLE.toString());
                    channelColors.put("Whisper", ChatColor.LIGHT_PURPLE.toString());
                    channelColors.put("World", ChatColor.GRAY.toString());
                    channelColors.put("Trade", ChatColor.YELLOW.toString());
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
                    rp.setActiveLanguage("Common");
                    rp.setActiveChannel("General");
                    List<String> languages = rp.getKnownLanguages();
                    languages.add("Common");
                    languages.add("Out of Game");
                    rp.setKnownLanguages(languages);
                    rp.setLanguagesInChat(true);
                }
                if (RpgAPI.achievementsOn) {
                    rp.setActivePrefix("The Recruit");
                    rp.setActiveSuffix("NONE");
                    List<String> playerTitles = rp.getTitles();
                    playerTitles.add("The Recruit");
                    playerTitles.add("Server Joiner");
                    rp.setTitles(playerTitles);
                    Map<String, Integer> ei = rp.getEatenItems();
                    ei.put("Bread", 1);
                    rp.setEatenItems(ei);
                    Map<String, Integer> mk = rp.getMobKills();
                    mk.put("Pig", 1);
                    rp.setMobKills(mk);
                    Map<String, Integer> pk = rp.getPlayerKills();
                    pk.put("Notch", 1);
                    rp.setPlayerKills(pk);
                    Map<String, Integer> iu = rp.getItemsUsed();
                    iu.put("Stone of Destiny", 1);
                    rp.setItemsUsed(iu);

                }
                if (RpgAPI.clickOn) {
                    rp.setClick(true);
                }
                if (RpgAPI.lobbyOn) {
                    rp.setInLobby(false);
                    rp.setArmorInventory("NONE");
                    rp.setInventoryContents("NONE");
                    rp.setCurrentHealth(0);
                    rp.setOldX(0);
                    rp.setOldY(0);
                    rp.setOldZ(0);
                    rp.setOldWorld("World");
                }
                if (RpgAPI.minionsOn) {
                    List<String> petsOwned = rp.getPetsOwned();
                    petsOwned.add("Mugli");
                    petsOwned.add("Ilgum");
                    rp.setPetsOwned(petsOwned);
                    rp.setActivePet("Mugli");
                }
                rp.setRealName(p);
                if (RpgAPI.questOn) {
                    List<String> currentQuests = rp.getCurrentQuests();
                    Map<String, Integer> questStage = rp.getQuestStages();
                    Map<String, Integer> stageCounter = rp.getQuestGoalCount();
                    rp.setCurrentQuests(currentQuests);
                    rp.setQuestStages(questStage);
                    rp.setQuestGoalCount(stageCounter);
                    List<String> completedQuests = rp.getCompletedQuests();
                    rp.setCompletedQuests(completedQuests);
                }
                if (RpgAPI.reputationOn) {
                    Map<String, Integer> repLevel = rp.getReputationLevels();
                    List<String> repDiscovered = rp.getFactionsDiscovered();
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
                rp.setLocationChanged(playerFile.getBoolean(p + ".Location Changed"));


            	/*
	            * Rpg Races Variables
	            */
                //players race name
                if (RpgAPI.racesOn) {
                    rp.setRace(playerFile.getString(p + ".RpgRace.Race Name"));
                    //is the player immune to poison
                    rp.setPoisonProof(playerFile.getBoolean(p + ".RpgRace.Poison Proof"));
                    //is the player currently poisoned
                    rp.setPoisoned(playerFile.getBoolean(p + ".RpgRace.Poisoned"));
                }
                /*
            	 * rpgfood variables
	            */
                //does the player already have a food buff
                if (RpgAPI.foodOn) {
                    rp.setBuffed(playerFile.getBoolean(p + ".RpgFood.Food Buffed"));

                }

                /*
            	 * rpg party variables
	            */
                if (RpgAPI.partyOn) {
                    //does the player have a pending party invite
                    rp.setPartyInvitePending(playerFile.getBoolean(p + ".RpgParty.Party Invite Pending"));
                    //does the player want a gui to automatically
                    //open when being invited to partys
                    rp.setPartyGui(playerFile.getBoolean(p + ".RpgParty.Show Party Gui"));
                    //is the player in a party
                    rp.setInParty(playerFile.getBoolean(p + ".RpgParty.In Party"));
                    //name of the party leader of the players party
                    rp.setLeaderName(p + ".RpgParty.Leader Name");
                    //auto pass on rolls
                    rp.setPassingRolls(playerFile.getBoolean(p + ".RpgParty.Passing On All Rolls"));
                    //auto need on rolls
                    rp.setNeedingRolls(playerFile.getBoolean(p + ".RpgParty.Needing On All Rolls"));
                    //auto greed on rolls
                    rp.setGreedingRolls(playerFile.getBoolean(p + ".RpgParty.Greeding On All Rolls"));
                    //auto open loot window for player
                    rp.setLootGui(playerFile.getBoolean(p + ".RpgParty.Show Loot Gui"));
                }
                /*
	            * rpg guilds variables
	            */
                if (RpgAPI.guildsOn) {
                    //does the player have a pending guild invite
                    rp.setGuildInvite(playerFile.getBoolean(p + ".RpgGuilds.Has Pending Guild Invite"));
                    //should the guild accept gui auto open on a guild invitation
                    rp.setGuildGui(playerFile.getBoolean(p + ".RpgGuilds.Show Guild Gui"));
                    //is the player in a guild
                    rp.setInGuild(playerFile.getBoolean(p + ".RpgGuilds.Is In A Guild"));
                    //what is the players guild name
                    rp.setGuild(playerFile.getString(p + ".RpgGuilds.Guild Name"));
                    //what is the players rank within a guild
                    rp.setGuildRank(playerFile.getString(p + ".RpgGuilds.Guild Rank"));
                }
	            /*
	            * rpg friends variables
	            */
                if (RpgAPI.friendsOn) {
                    //should the friend gui auto open on friend invite?
                    rp.setFriendsGui(playerFile.getBoolean(p + ".RpgFriends.Show Friends Gui"));
                    //player friends list
                    rp.setFriendsList((List<String>) playerFile.getList(p + ".RpgFriends.Friends List"));
                }
                /*
	            * trade variables
	            */
                if (RpgAPI.tradeOn) {
                    //the players total Copper
                    rp.setCopper(playerFile.getInt(p + ".RpgTrade.Copper"));
                    //the player total Silver
                    rp.setSilver(playerFile.getInt(p + ".RpgTrade.Silver"));
                    //the players total Gold
                    rp.setGold(playerFile.getInt(p + ".RpgTrade.Gold"));
                    //the players total Platinum
                    rp.setPlatinum(playerFile.getInt(p + ".RpgTrade.Platinum"));
                }
                /*
	            * chat variables
	            */
                if (RpgAPI.chatOn) {
                    //colors of chat channel mapped to channel name
                    Map<String, String> colorMap = rp.getChannelColor();
                    for (String key : playerFile.getConfigurationSection(p + ".RpgChat.Chat Channels").getKeys(false)) {
                        colorMap.put(key, playerFile.getString(p + ".RpgChat.Chat Channels." + key));
                    }
                    rp.setChannelColor(colorMap);
                    //active channel a player is talking in
                    rp.setActiveChannel(playerFile.getString(p + ".RpgChat.Active Channel"));
                    //all players on ignore
                    rp.setIgnoreList((List<String>) playerFile.getList(p + ".RpgChat.Ignore List"));
                    //does the player have a pending chat invite
                    rp.setChatInvite(playerFile.getBoolean(p + ".RpgChat.Chat Invite Pending"));
                    //list of channels the player has invites for
                    rp.setInvitedChats((List<String>) playerFile.getList(p + ".RpgChat.Invited Chats"));
                    //list of channels the player is banned from
                    rp.setBannedChats((List<String>) playerFile.getList(p + ".RpgChat.Banned Chats"));
                    //list of channels the player is muted in
                    rp.setMutedChats((List<String>) playerFile.getList(p + ".RpgChat.Muted Chats"));
                    //list of channels the player owns
                    rp.setOwnedChats((List<String>) playerFile.getList(p + ".RpgChat.Owned Chats"));
                    //list of channels the player is a mod in
                    rp.setModChats((List<String>) playerFile.getList(p + ".RpgChat.Moderated Chats"));
                    //is chat spy toggled on or off
                    rp.setSpyingOnChats(playerFile.getBoolean(p + ".RpgChat.Spying On Chats"));
                    /*
                    * booleans for which message prefixes are shown in chat
                    */
                    rp.setShowingGuildTags(playerFile.getBoolean(p + ".RpgChat.Showing Guild Tags"));
                    rp.setShowingAchieveTitles(playerFile.getBoolean(p + ".RpgChat.Showing Achieve Titles"));
                    rp.setShowingChannelNames(playerFile.getBoolean(p + ".RpgChat.Showing Channel Names"));
                    rp.setShowingLanguageNames(playerFile.getBoolean(p + ".RpgChat.Showing Language Names"));
                    rp.setShowingWorldName(playerFile.getBoolean(p + ".RpgChat.Showing World Name"));
                }
	            /*
	            * rpg achievements variables
	            */
                if (RpgAPI.achievementsOn) {
                    //players active prefix title
                    rp.setActivePrefix(playerFile.getString(p + ".RpgAchievements.Active Prefix"));
                    //players active suffix title
                    rp.setActiveSuffix(playerFile.getString(p + ".RpgAchievements.Active Suffix"));
                    //list of all titles a player has earned
                    rp.setTitles((List<String>) playerFile.getList(p + ".RpgAchievements.Titles"));

                    Map<String, Integer> t = rp.getEatenItems();
                    for (String key : playerFile.getConfigurationSection(p + ".RpgAchievements.Food Consumed").getKeys(false)) {
                        t.put(key, playerFile.getInt(p + ".RpgAchievements.Food Consumed." + key));
                    }
                    rp.setEatenItems(t);

                    Map<String, Integer> r = rp.getMobKills();
                    for (String key : playerFile.getConfigurationSection(p + ".RpgAchievements.Mob Kills").getKeys(false)) {
                        r.put(key, playerFile.getInt(p + ".RpgAchievements.Mob Kills." + key));
                    }
                    rp.setMobKills(r);

                    Map<String, Integer> v = rp.getPlayerKills();
                    for (String key : playerFile.getConfigurationSection(p + ".RpgAchievements.Player Kills").getKeys(false)) {
                        v.put(key, playerFile.getInt(p + ".RpgAchievements.Player Kills." + key));
                    }
                    rp.setPlayerKills(v);

                    Map<String, Integer> q = rp.getItemsUsed();
                    for (String key : playerFile.getConfigurationSection(p + ".RpgAchievements.Items Used").getKeys(false)) {
                        q.put(key, playerFile.getInt(p + ".RpgAchievements.Items Used." + key));
                    }
                    rp.setItemsUsed(q);

                }
            	/*
	            * rpg click variables
	            */
                if (RpgAPI.clickOn) {
                    //should the player use the default shift click on player behavior
                    rp.setClick(playerFile.getBoolean(p + ".RpgClick.Use Click"));
                }
            	/*
	            * rpg language variables
	            */
                if (RpgAPI.chatOn) {
                    //players active spoken language
                    rp.setActiveLanguage(playerFile.getString(p + ".RpgLanguages.Active Language"));
                    //all languages a player knows
                    rp.setKnownLanguages((List<String>) playerFile.getList(p + ".RpgLanguages.Known Languages"));
                    //should languages a player doesn't know be shown in chat?
                    rp.setLanguagesInChat(playerFile.getBoolean(p + ".RpgLanguages.Languages In Chat"));
                }
                /*
	            * rpg lobby variables
	            */
                if (RpgAPI.lobbyOn) {
                    //is the player in a lobby?
                    rp.setInLobby(playerFile.getBoolean(p + ".RpgLobby.In Lobby"));
                    //serialised armor inventory for a player
                    rp.setArmorInventory(playerFile.getString(p + ".RpgLobby.Armor Inventory"));
                    //serialised inventory for a player
                    rp.setInventoryContents(playerFile.getString(p + ".RpgLobby.Inventory Contents"));
                    //players current health upon entering a lobby
                    rp.setCurrentHealth(playerFile.getInt(p + ".RpgLobby.Current Health"));
                    //a players x coords before entering lobby
                    rp.setOldX(playerFile.getDouble(p + ".RpgLobby.OldX"));
                    //a players y coords before entering lobby
                    rp.setOldY(playerFile.getDouble(p + ".RpgLobby.OldY"));
                    //a players z coords before entering lobby
                    rp.setOldZ(playerFile.getDouble(p + ".RpgLobby.OldZ"));
                    //a players world name before entering lobby
                    rp.setOldWorld(playerFile.getString(p + ".RpgLobby.Old World"));
                }
	            /*
            	 * rpg minions
	            */
                if (RpgAPI.minionsOn) {
                    //list of all p-ets a player owns
                    rp.setPetsOwned((List<String>) playerFile.getList(p + ".RpgMinions.Pets Owned"));
                    //does the player have an active pet
                    rp.setPetActive(playerFile.getBoolean(p + ".RpgMinions.Is Pet Active"));
                    //active pets name
                    rp.setActivePet(playerFile.getString(p + ".RpgMinions.Active Pet"));
                    //does the player have agro
                    rp.setAgroTarget(playerFile.getBoolean(p + ".RpgMinions.Agro"));
                    //is the player in combat
                    rp.setInCombat(playerFile.getBoolean(p + ".RpgMinions.Is In Combat"));
                    //a players current agro rating
                    rp.setAgroLevel(playerFile.getInt(p + ".RpgMinions.Agro Level"));
                }
	            /*
            	 * rpg Quest variables - comming soon?
	            */
                if (RpgAPI.questOn) {
                    //players quests that are currently active
                    rp.setCurrentQuests((List<String>) playerFile.getList(p + ".RpgQuests.Current Quests"));
                    //quests a player has completed
                    rp.setCompletedQuests((List<String>) playerFile.getList(p + ".RpgQuests.Completed Quests"));
                    //stages of each quest a player is on
                    Map<String, Integer> qStage = rp.getQuestStages();
                    for (String quest : playerFile.getConfigurationSection(p + ".RpgQuests.Quest Stages").getKeys(false)) {
                        qStage.put(quest, playerFile.getInt(p + ".RpgQuests.Quest Stages." + quest));
                    }
                    rp.setQuestStages(qStage);
                    //players "activated" quest
                    rp.setActiveQuest(playerFile.getString(p + ".RpgQuests.Active Quest"));
                    //how many counter based goals are completed for quest - String
                    Map<String, Integer> gCount = rp.getQuestGoalCount();
                    for (String quest : playerFile.getConfigurationSection(p + ".RpgQuests.Quest Goal Count").getKeys(false)) {
                        gCount.put(quest, playerFile.getInt(p + ".RpgQuests.Quest Goal Count." + quest));
                    }
                    rp.setQuestGoalCount(gCount);
                }
                /*
                * Reputations variables
                */
                if (RpgAPI.reputationOn) {
                    //number for current reputation with a faction
                    Map<String, Integer> repMap = rp.getReputationLevels();
                    for (String reputation : playerFile.getConfigurationSection(p + ".RpgReputations.Reputation Levels").getKeys(false)) {
                        repMap.put(reputation, playerFile.getInt(p + ".RpgReputations.Reputation Levels." + reputation));
                    }
                    rp.setReputationLevels(repMap);

                    //wether or not a player has discovered a factions existance
                    rp.setFactionsDiscovered((List<String>) playerFile.getList(p + ".RpgReputations.Factions Discovered"));
                }
            	/*
	            * rpg Spawns
	            */
                if (RpgAPI.spawnsOn) {
                    //does the player have a pending rez?
                    rp.setRessurectionPending(playerFile.getBoolean(p + ".RpgSpawns.Ressurection Pending"));
                    //is the player currently rezz'ing someone
                    rp.setRessurecting(playerFile.getBoolean(p + ".RpgSpawns.Ressurecting"));
                    //is the player dead
                    rp.setDead(playerFile.getBoolean(p + ".RpgSpawns.Is Dead"));
                }
	            /*
            	 * rpgclasses variables
            	 */
                if (RpgAPI.classesOn) {
                    //players class name
                    rp.setClassName(playerFile.getString(p + ".RpgClasses.Class Name"));
                    //player Lawful / neutral / chaotic alignment
                    rp.setLawfulAlignment(playerFile.getString(p + ".RpgClasses.Lawful Alignment"));
                    //players Good Neutral Evil Alignment
                    rp.setGoodAlignment(playerFile.getString(p + ".RpgClasses.Good Alignment"));
                    //a map of the values for every player stat (sorted by enum)
                    Map<String, Integer> statMap = rp.getStats();
                    for (String stat : playerFile.getConfigurationSection(p + ".RpgClasses.Stats").getKeys(false)) {
                        statMap.put(stat, playerFile.getInt(p + ".RpgClasses.Stats." + stat));
                    }
                    rp.setStats(statMap);

                    //a map of the strings for all a players text bassed stats (sorted by enum)
                    Map<String, String> textMap = rp.getPlayerText();
                    for (String stat : playerFile.getConfigurationSection(p + ".RpgClasses.Player Text").getKeys(false)) {
                        textMap.put(stat, playerFile.getString(p + ".RpgClasses.Player Text." + stat));
                    }
                    rp.setPlayerText(textMap);

                    //true or false for each type of damage a player is resistant to
                    Map<String, Integer> drMap = rp.getDrTypes();
                    for (String dr : playerFile.getConfigurationSection(p + ".RpgClasses.Damage Reduction Types").getKeys(false)) {
                        drMap.put(dr, playerFile.getInt(p + ".RpgClasses.Damage Reduction Types." + dr));
                    }
                    rp.setDrTypes(drMap);

                    //true or false for the damage types a player is currently doing
                    Map<String, Integer> dtMap = rp.getDmgTypes();
                    for (String dt : playerFile.getConfigurationSection(p + ".RpgClasses.Damage Types").getKeys(false)) {
                        dtMap.put(dt, playerFile.getInt(p + ".RpgClasses.Damage Types." + dt));
                    }
                    rp.setDmgTypes(dtMap);

                    //true or false for the elemental damage types a player is currently doing
                    Map<String, Integer> elemMap = rp.getElemDmgTypes();
                    for (String elem : playerFile.getConfigurationSection(p + ".RpgClasses.Elemental Damage Types").getKeys(false)) {
                        elemMap.put(elem, playerFile.getInt(p + ".RpgClasses.Elemental Damage Types." + elem));
                    }
                    rp.setElemDmgTypes(elemMap);

                    //true or false for each type of elemental damage a player is resistant to
                    Map<String, Integer> eResMap = rp.getElemResTypes();
                    for (String eRes : playerFile.getConfigurationSection(p + ".RpgClasses.Elemental Resistance Types").getKeys(false)) {
                        eResMap.put(eRes, playerFile.getInt(p + ".RpgClasses.Elemental Resistance Types." + eRes));
                    }
                    rp.setElemResTypes(eResMap);
                    //list of all feats a player has
                    rp.setFeats((List<String>) playerFile.getList(p + ".RpgClasses.Feats"));
                    //skills a player has ranks in and how many ranks they have
                    Map<String, Integer> skillMap = rp.getSkills();
                    for (String skill : playerFile.getConfigurationSection(p + ".RpgClasses.Skills").getKeys(false)) {
                        skillMap.put(skill, playerFile.getInt(p + ".RpgClasses.Skills." + skill));
                    }
                    rp.setSkills(skillMap);

                    //true or false list of all spells for which a player knows
                    rp.setSpells((List<String>) playerFile.getList(p + ".RpgClasses.Spells"));
                    //spells per level per combat
                    Map<String, Integer> spcMap = rp.getSpellsPerCombat();
                    for (String spell : playerFile.getConfigurationSection(p + ".RpgClasses.Spells Per Combat").getKeys(false)) {
                        spcMap.put(spell, playerFile.getInt(p + ".RpgClasses.Spells Per Combat." + spell));
                    }
                    rp.setSpellsPerCombat(spcMap);

                    //is the player wearing aromor he isn't proficient with
                    rp.setEncumbered(playerFile.getBoolean(p + ".RpgClasses.Encumbered"));
                }
                return rp;
            }
        }
        return rp;
    }

}
