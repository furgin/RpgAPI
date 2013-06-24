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
    public static void RpgSaver(String name, RpgPlayer rp){
        if (RpgAPI.useMySql){
            //TODO do stuff here LinksBro
        } else {
        YamlConfiguration playerFile = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayers/" + name + ".yml"));
        if (RpgAPI.classesOn){
            playerFile.set("Rpg Player.Classes.Lawful Chaotic Alignment", rp.getPlayerLCAlignment());
            playerFile.set("Rpg Player.Classes.Good Evil Alignment", rp.getPlayerGEAlignment());
            playerFile.set("Rpg Player.Classes.Class", rp.getPlayerClass());
            playerFile.set("Rpg Player.Classes.Stats.Character Level", rp.getStats().get(PlayerStat.CHARACTER_LEVEL));
            playerFile.set("Rpg Player.Classes.Stats.Age", rp.getStats().get(PlayerStat.AGE));
            playerFile.set("Rpg Player.Classes.Stats.Strength", rp.getStats().get(PlayerStat.STRENGTH));
            playerFile.set("Rpg Player.Classes.Stats.Dexterity", rp.getStats().get(PlayerStat.DEXTERITY));
            playerFile.set("Rpg Player.Classes.Stats.Constitution", rp.getStats().get(PlayerStat.CONSTITUTION));
            playerFile.set("Rpg Player.Classes.Stats.Intelligence", rp.getStats().get(PlayerStat.INTELLIGENCE));
            playerFile.set("Rpg Player.Classes.Stats.Wisdom", rp.getStats().get(PlayerStat.WISDOM));
            playerFile.set("Rpg Player.Classes.Stats.Charisma", rp.getStats().get(PlayerStat.CHARISMA));
            playerFile.set("Rpg Player.Classes.Stats.Hit Points", rp.getStats().get(PlayerStat.HIT_POINTS));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_PIERCING", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_PIERCING));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_SLASHING", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_SLASHING));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_BLUDGEONING", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_BLUDGEONING));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_MAGICAL", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_MAGICAL));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_EPIC", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_EPIC));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_LAWFUL", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_LAWFUL));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_GOOD", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_GOOD));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_CHAOTIC", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_CHAOTIC));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_EVIL", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_EVIL));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_FIRE", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_FIRE));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_COLD", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_COLD));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_ACID", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_ACID));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_SONIC", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_SONIC));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_ELECTRICITY", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_ELECTRICITY));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_SILVER", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_SILVER));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_COLD_IRON", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_COLD_IRON));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_ADAMANTINE", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_ADAMANTINE));
            playerFile.set("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_NONE", rp.getStats().get(PlayerStat.DAMAGE_REDUCTION_NONE));
            playerFile.set("Rpg Player.Classes.Stats.Total Hit Points", rp.getStats().get(PlayerStat.TOTAL_HIT_POINTS));
            playerFile.set("Rpg Player.Classes.Stats.Speed.Land", rp.getStats().get(PlayerStat.SPEED_LAND));
            playerFile.set("Rpg Player.Classes.Stats.Speed.Land With Armor", rp.getStats().get(PlayerStat.SPEED_LAND_WITH_ARMOR));
            playerFile.set("Rpg Player.Classes.Stats.Speed.Fly", rp.getStats().get(PlayerStat.SPEED_FLY));
            playerFile.set("Rpg Player.Classes.Stats.Speed.Swim", rp.getStats().get(PlayerStat.SPEED_SWIM));
            playerFile.set("Rpg Player.Classes.Stats.Initiative", rp.getStats().get(PlayerStat.INITIATIVE));
            playerFile.set("Rpg Player.Classes.Stats.Armor Class.Armor Bonus", rp.getStats().get(PlayerStat.ARMOR_CLASS_ARMOR_BONUS));
            playerFile.set("Rpg Player.Classes.Stats.Armor Class.Shield Bonus", rp.getStats().get(PlayerStat.ARMOR_CLASS_SHIELD_BONUS));
            playerFile.set("Rpg Player.Classes.Stats.Armor Class.Size Modifier", rp.getStats().get(PlayerStat.ARMOR_CLASS_SIZE_MODIFIER));
            playerFile.set("Rpg Player.Classes.Stats.Armor Class.Natural Armor", rp.getStats().get(PlayerStat.ARMOR_CLASS_NATURAL_ARMOR));
            playerFile.set("Rpg Player.Classes.Stats.Armor Class.Deflection Bonus", rp.getStats().get(PlayerStat.ARMOR_CLASS_DEFLECTION_MODIFIER));
            playerFile.set("Rpg Player.Classes.Stats.Armor Class.Miscellaneous Modifier", rp.getStats().get(PlayerStat.ARMOR_CLASS_MODIFIER_MISC));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Fortitude.Class Bonus", rp.getStats().get(PlayerStat.FORTITUDE_CLASS_BONUS));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Fortitude.Constitution Bonus", rp.getStats().get(PlayerStat.FORTITUDE_CONSTITUTION_BONUS));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Fortitude.Magic Bonus", rp.getStats().get(PlayerStat.FORTITUDE_MAGIC));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Fortitude.Miscellaneous Bonus", rp.getStats().get(PlayerStat.FORTITUDE_MISC));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Reflex.Class Bonus", rp.getStats().get(PlayerStat.REFLEX__CLASS_BONUS));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Reflex.Dexterity Bonus", rp.getStats().get(PlayerStat.REFLEX_DEXTERITY_BONUS));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Reflex.Magic Bonus", rp.getStats().get(PlayerStat.REFLEX_MAGIC));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Reflex.Miscellaneous Bonus", rp.getStats().get(PlayerStat.REFLEX_MISC));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Will.Class Bonus", rp.getStats().get(PlayerStat.WILLPOWER_CLASS_BONUS));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Will.Wisdom Bonus", rp.getStats().get(PlayerStat.WILLPOWER_WISDOM_BONUS));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Will.Magic Bonus", rp.getStats().get(PlayerStat.WILLPOWER_MAGIC));
            playerFile.set("Rpg Player.Classes.Stats.Saves.Will.Miscellaneous Bonus", rp.getStats().get(PlayerStat.WILLPOWER_MISC));
            playerFile.set("Rpg Player.Classes.Stats.Base Attack Bonus", rp.getStats().get(PlayerStat.BASE_ATTACK_BONUS));
            playerFile.set("Rpg Player.Classes.Stats.Spell Resistance", rp.getStats().get(PlayerStat.SPELL_RESISTANCE));
            playerFile.set("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Base Attack Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_BONUS_BAB));
            playerFile.set("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Size Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_BONUS_SIZE));
            playerFile.set("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Strength Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_BONUS_STRENGTH));
            playerFile.set("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Miscellaneous Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_BONUS_MISC));
            playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Strength Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_DEFENSE_STRENGTH));
            playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Dexterity Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_DEFENSE_DEXTERITY));
            playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Base Attack Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_DEFENSE_BAB));
            playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Size Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_DEFENSE_SIZE));
            playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Standard Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_DEFENSE_STANDARD));
            playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Miscellaneous Bonus", rp.getStats().get(PlayerStat.COMBAT_MANUEVER_DEFENSE_MISC));
            playerFile.set("Rpg Player.Classes.Stats.Experience", rp.getStats().get(PlayerStat.EXPERIENCE_TOTAL));
            playerFile.set("Rpg Player.Classes.Stats.Deity", rp.getPlayerText().get(PlayerText.DEITY));
            playerFile.set("Rpg Player.Classes.Stats.Size", rp.getPlayerText().get(PlayerText.SIZE));
            playerFile.set("Rpg Player.Classes.Stats.Gender", rp.getPlayerText().get(PlayerText.GENDER));
            playerFile.set("Rpg Player.Classes.Stats.Height", rp.getPlayerText().get(PlayerText.HEIGHT));
            playerFile.set("Rpg Player.Classes.Stats.Weight", rp.getPlayerText().get(PlayerText.WEIGHT));
            playerFile.set("Rpg Player.Classes.Stats.Hair Color", rp.getPlayerText().get(PlayerText.HAIR_COLOR));
            playerFile.set("Rpg Player.Classes.Stats.Eye color", rp.getPlayerText().get(PlayerText.EYE_COLOR));
            playerFile.set("Rpg Player.Classes.Stats.Description", rp.getPlayerText().get(PlayerText.DESCRIPTION));
            playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.FIRE", rp.getElemRestype().get(ElementalType.FIRE));
            playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.COLD", rp.getElemRestype().get(ElementalType.COLD));
            playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.ACID", rp.getElemRestype().get(ElementalType.ACID));
            playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.ELECTRICITY", rp.getElemRestype().get(ElementalType.ELECTRICITY));
            playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.SONIC", rp.getElemRestype().get(ElementalType.SONIC));
            for (Feat charFeat : rp.getHasFeats()){
                playerFile.set("Rpg Player.Classes.Stats.Feats." + charFeat, true);
            }
            playerFile.set("Rpg Player.Classes.Stats.Skills.ACROBATICS", rp.getSkills().get(PlayerSkill.ACROBATICS));
            playerFile.set("Rpg Player.Classes.Stats.Skills.APPRAISE", rp.getSkills().get(PlayerSkill.APPRAISE));
            playerFile.set("Rpg Player.Classes.Stats.Skills.BLUFF", rp.getSkills().get(PlayerSkill.BLUFF));
            playerFile.set("Rpg Player.Classes.Stats.Skills.CLIMB", rp.getSkills().get(PlayerSkill.CLIMB));
            playerFile.set("Rpg Player.Classes.Stats.Skills.CRAFT_ALCHEMY", rp.getSkills().get(PlayerSkill.CRAFT_ALCHEMY));
            playerFile.set("Rpg Player.Classes.Stats.Skills.CRAFT_ARMOR", rp.getSkills().get(PlayerSkill.CRAFT_ARMOR));
            playerFile.set("Rpg Player.Classes.Stats.Skills.CRAFT_ITEMS", rp.getSkills().get(PlayerSkill.CRAFT_ITEMS));
            playerFile.set("Rpg Player.Classes.Stats.Skills.CRAFT_JEWELRY", rp.getSkills().get(PlayerSkill.CRAFT_JEWELRY));
            playerFile.set("Rpg Player.Classes.Stats.Skills.CRAFT_POISON", rp.getSkills().get(PlayerSkill.CRAFT_POISON));
            playerFile.set("Rpg Player.Classes.Stats.Skills.CRAFT_TRAPS", rp.getSkills().get(PlayerSkill.CRAFT_TRAPS));
            playerFile.set("Rpg Player.Classes.Stats.Skills.CRAFT_WEAPONS", rp.getSkills().get(PlayerSkill.CRAFT_WEAPONS));
            playerFile.set("Rpg Player.Classes.Stats.Skills.DIPLOMACY", rp.getSkills().get(PlayerSkill.DIPLOMACY));
            playerFile.set("Rpg Player.Classes.Stats.Skills.DISABLE_DEVICE", rp.getSkills().get(PlayerSkill.DISABLE_DEVICE));
            playerFile.set("Rpg Player.Classes.Stats.Skills.DISGUISE", rp.getSkills().get(PlayerSkill.DISGUISE));
            playerFile.set("Rpg Player.Classes.Stats.Skills.ESCAPE_ARTIST", rp.getSkills().get(PlayerSkill.ESCAPE_ARTIST));
            playerFile.set("Rpg Player.Classes.Stats.Skills.FLY", rp.getSkills().get(PlayerSkill.FLY));
            playerFile.set("Rpg Player.Classes.Stats.Skills.HANDLE_ANIMAL", rp.getSkills().get(PlayerSkill.HANDLE_ANIMAL));
            playerFile.set("Rpg Player.Classes.Stats.Skills.HEAL", rp.getSkills().get(PlayerSkill.HEAL));
            playerFile.set("Rpg Player.Classes.Stats.Skills.INTIMIDATE", rp.getSkills().get(PlayerSkill.INTIMIDATE));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_ARCANA", rp.getSkills().get(PlayerSkill.KNOWLEDGE_ARCANA));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_DUNGEONEERING", rp.getSkills().get(PlayerSkill.KNOWLEDGE_DUNGEONEERING));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_ENGINEERING", rp.getSkills().get(PlayerSkill.KNOWLEDGE_ENGINEERING));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_GEOGRAPHY", rp.getSkills().get(PlayerSkill.KNOWLEDGE_GEOGRAPHY));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_HISTORY", rp.getSkills().get(PlayerSkill.KNOWLEDGE_HISTORY));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_LOCAL", rp.getSkills().get(PlayerSkill.KNOWLEDGE_LOCAL));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_NATURE", rp.getSkills().get(PlayerSkill.KNOWLEDGE_NATURE));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_NOBILITY", rp.getSkills().get(PlayerSkill.KNOWLEDGE_NOBILITY));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_PLANES", rp.getSkills().get(PlayerSkill.KNOWLEDGE_PLANES));
            playerFile.set("Rpg Player.Classes.Stats.Skills.KNOWLEDGE_RELIGION", rp.getSkills().get(PlayerSkill.KNOWLEDGE_RELIGION));
            playerFile.set("Rpg Player.Classes.Stats.Skills.LINGUISTICS", rp.getSkills().get(PlayerSkill.LINGUISTICS));
            playerFile.set("Rpg Player.Classes.Stats.Skills.PERCEPTION", rp.getSkills().get(PlayerSkill.PERCEPTION));
            playerFile.set("Rpg Player.Classes.Stats.Skills.PERFORM", rp.getSkills().get(PlayerSkill.PERFORM));
            playerFile.set("Rpg Player.Classes.Stats.Skills.PROFESSION", rp.getSkills().get(PlayerSkill.PROFESSION));
            playerFile.set("Rpg Player.Classes.Stats.Skills.RIDE", rp.getSkills().get(PlayerSkill.RIDE));
            playerFile.set("Rpg Player.Classes.Stats.Skills.SENSE_MOTIVE", rp.getSkills().get(PlayerSkill.SENSE_MOTIVE));
            playerFile.set("Rpg Player.Classes.Stats.Skills.SLEIGHT_OF_HAND", rp.getSkills().get(PlayerSkill.SLEIGHT_OF_HAND));
            playerFile.set("Rpg Player.Classes.Stats.Skills.SPELLCRAFT", rp.getSkills().get(PlayerSkill.SPELLCRAFT));
            playerFile.set("Rpg Player.Classes.Stats.Skills.STEALTH", rp.getSkills().get(PlayerSkill.STEALTH));
            playerFile.set("Rpg Player.Classes.Stats.Skills.SURVIVAL", rp.getSkills().get(PlayerSkill.SURVIVAL));
            playerFile.set("Rpg Player.Classes.Stats.Skills.SWIM", rp.getSkills().get(PlayerSkill.SWIM));
            playerFile.set("Rpg Player.Classes.Stats.Skills.USE_MAGIC_DEVICE", rp.getSkills().get(PlayerSkill.USE_MAGIC_DEVICE));
            for (Spell spell : rp.getSpells().keySet()){
                playerFile.set("Rpg Player.Classes.Stats.Spells.Spells Known." + spell, true);
            }
            for (Integer level : rp.getSpellsPerCombat().keySet()){
                playerFile.set("Rpg Player.Classes.stats.Spells.Spells Per Combat" + level, rp.getSpellsPerCombat().get(level));
            }
        }
            if (RpgAPI.racesOn){playerFile.set("Rpg Player.Race", rp.getRace());}
            if (RpgAPI.guildsOn){
                playerFile.set("Rpg Player.Guild.Name", rp.getGuild());
                playerFile.set("Rpg Player.Guild.Rank",  rp.getGuildRank());
            }
            if (RpgAPI.friendsOn){
                for (String friends : rp.getFriendsList()){
                    playerFile.set("Rpg Player.Friends List." + friends, true);}
            }

            if (RpgAPI.tradeOn){
                playerFile.set("Rpg Player.Trade.Copper", rp.getCopper());
                playerFile.set("Rpg Player.Trade.Silver", rp.getSilver());
                playerFile.set("Rpg Player.Trade.Gold", rp.getGold());
                playerFile.set("Rpg Player.Trade.Platinum", rp.getPlatinum());
            }
            if (RpgAPI.chatOn){
                for (String channelName : rp.getChatChannels()){
                    playerFile.set("Rpg Player.Chat.Channel." + channelName + ".Color", rp.getChannelColors().get(channelName).toString());
                    if (rp.getActiveChannel().equalsIgnoreCase(channelName)){
                        playerFile.set("Rpg Player.Chat.Channel." + channelName + ".Active", true);
                    } else {
                        playerFile.set("Rpg Player.Chat.Channel." + channelName + ".Active", false);
                    }
                }
                for (String ignoredPlayers : rp.getIgnoreList()){
                    playerFile.set("Rpg Player.Chat.Ignore List." + ignoredPlayers, true);
                }
                for (String ignoredPlayers : rp.getInvitedChats()){
                    playerFile.set("Rpg Player.Chat.Invited Chats." + ignoredPlayers, true);
                }
                for (String ignoredPlayers : rp.getBannedChats()){
                    playerFile.set("Rpg Player.Chat.Banned Chats." + ignoredPlayers, true);
                }
                for (String ignoredPlayers : rp.getMutedChats()){
                    playerFile.set("Rpg Player.Chat.Muted Chats." + ignoredPlayers, true);
                }
                for (String ignoredPlayers : rp.getOwnedChats()){
                    playerFile.set("Rpg Player.Chat.Owned Chats." + ignoredPlayers, true);
                }
                for (String ignoredPlayers : rp.getModChats()){
                    playerFile.set("Rpg Player.Chat.Moderated Chats." + ignoredPlayers, true);
                }
                playerFile.set("Rpg Player.Chat.Spy", rp.isChatSpy());
                playerFile.set("Rpg Player.Chat.Show Guild Tags", rp.isShowGuildTags());
                playerFile.set("Rpg Player.Chat.Show Achieve Titles", rp.isShowAchieveTitles());
                playerFile.set("Rpg Player.Chat.Show Channel Names", rp.isShowChannelNames());
                playerFile.set("Rpg Player.Chat.Show Language Names", rp.isShowLanguageNames());
                playerFile.set("Rpg Player.Chat.Show World Name", rp.isShowWorldName());
                playerFile.set("Rpg Player.Chat.Languages.Active", rp.getActiveLanguage());
                for (String languages : rp.getKnownLanguages()){
                    playerFile.set("Rpg Player.Chat.Languages.Known Languages." + languages, true);
                }

                playerFile.set("Rpg Player.Chat.Languages.Show Languages", rp.isShowLanguages());
            }
            if (RpgAPI.achievementsOn){
                playerFile.set("Rpg Player.Achievements.Active Prefix", rp.getActivePrefix());
                playerFile.set("Rpg Player.Achievements.Active Suffix", rp.getActiveSuffix());
                for (String title : rp.getTitles()){
                    playerFile.set("Rpg Player.Achievements.Titles." + title, true);
                }
            }
            if (RpgAPI.clickOn){playerFile.set("Rpg Player.Click.defaultClick", rp.isDefaultClick());}
            if (RpgAPI.lobbyOn){
                playerFile.set("Rpg Player.Lobby.In Lobby", rp.isInLobby());
                playerFile.set("Rpg Player.Lobby.Armor Inventory", rp.getArmorInventory());
                playerFile.set("Rpg Player.Lobby.Inventory Contents", rp.getInventoryContents());
                playerFile.set("Rpg Player.Lobby.Current Health", rp.getCurrentHealth());
                playerFile.set("Rpg Player.Lobby.Coordinates.X", rp.getOldX());
                playerFile.set("Rpg Player.Lobby.Coordinates.Y", rp.getOldY());
                playerFile.set("Rpg Player.Lobby.Coordinates.Z", rp.getOldZ());
                playerFile.set("Rpg Player.Lobby.Coordinates.World", rp.getOldWorld());
            }
            if (RpgAPI.minionsOn){
                for (String pet : rp.getPetsOwned()){
                    playerFile.set("Rpg Player.Minions.Pets Owned." + pet, true);
                }
                playerFile.set("Rpg Player.Minions.Active Pet", rp.getActivePet());
            }
            if (RpgAPI.questOn){
                for (String quest : rp.getQuestStages().keySet()){
                    playerFile.set("Rpg Player.Quests.Current Quests." + quest + ".Stage", rp.getQuestStages().get(quest));
                    if (rp.getActiveQuest().equalsIgnoreCase(quest)){
                        playerFile.set("Rpg Player.Quests.Current Quests." + quest + ".Active", true);
                    }   else {
                        playerFile.set("Rpg Player.Quests.Current Quests." + quest + ".Active", false);
                    }
                }
                for (String questsC : rp.getQuestGoalCount().keySet()){
                    playerFile.set("Rpg Player.Quests.Current Quests." + questsC + ".Counter", rp.getQuestGoalCount().get(questsC));
                }
                for (String completedQuests : rp.getCompletedQuests()){

                    playerFile.set("Rpg Player.Quests.Completed Quests." + completedQuests, true);
                }
            }
            if (RpgAPI.reputationOn){
                for (Reputation rep : rp.getReputationLevels().keySet()){
                    playerFile.set("Rpg Player.Reputation.Factions."+rep+".Reputation Level", rp.getReputationLevels().get(rep));
                }
                for (Reputation rep : rp.getFactionsDiscovered().keySet()){
                    playerFile.set("Rpg Player.Reputation.Factions."+rep+".Discovered", rp.getFactionsDiscovered().get(rep));
                }
            }
        try {
            playerFile.save(new File("plugins/RpgAPI/RpgPlayer/" + name + ".yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        }
    }
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
                    rp.setPlayerLCAlignment("NEUTRAL");
                    rp.setPlayerGEAlignment("NEUTRAL");
                    rp.setPlayerClass("NONE");
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
                    playerStats.put(PlayerStat.TOTAL_HIT_POINTS, 0);
                    playerStats.put(PlayerStat.SPEED_LAND, 30);
                    playerStats.put(PlayerStat.SPEED_LAND_WITH_ARMOR, 20);
                    playerStats.put(PlayerStat.SPEED_FLY, 0);
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
                    Map<ElementalType, Integer> elementalTypeIntegerMap = rp.getElemRestype();
                    elementalTypeIntegerMap.put(ElementalType.FIRE, 0);
                    elementalTypeIntegerMap.put(ElementalType.COLD, 0);
                    elementalTypeIntegerMap.put(ElementalType.ACID, 0);
                    elementalTypeIntegerMap.put(ElementalType.ELECTRICITY, 0);
                    elementalTypeIntegerMap.put(ElementalType.SONIC, 0);
                    rp.setElemRestype(elementalTypeIntegerMap);
                    List<Feat> playerFeats = rp.getHasFeats();
                    playerFeats.add(Feat.SOCIABLE);
                    rp.setHasFeats(playerFeats);
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
                    Map<Spell, Boolean> playerSpells = rp.getSpells();
                    playerSpells.put(Spell.PRESTIDIGITATION, false);
                    rp.setSpells(playerSpells);
                    Map<Integer, Integer> spellsPerLevel = rp.getSpellsPerCombat();
                    spellsPerLevel.put(0, 0);
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
                    List<String> chatChannels = rp.getChatChannels();
                    Map<String, ChatColor> channelColors = rp.getChannelColors();
                    chatChannels.add("Party");
                    channelColors.put("Party", ChatColor.BLUE);
                    chatChannels.add("Region");
                    channelColors.put("Region", ChatColor.WHITE);
                    chatChannels.add("Guild");
                    channelColors.put("Guild", ChatColor.DARK_GREEN);
                    chatChannels.add("Admin Announcements");
                    channelColors.put("Admin Announcements", ChatColor.DARK_RED);
                    rp.setChatChannels(chatChannels);
                    rp.setChannelColors(channelColors);
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
                    rp.setChatSpy(false);
                    rp.setShowGuildTags(true);
                    rp.setShowAchieveTitles(true);
                    rp.setShowChannelNames(true);
                    rp.setShowLanguageNames(true);
                    rp.setShowWorldName(true);
                    rp.setActiveLanguage("Region");
                    List<String> languages = rp.getKnownLanguages();
                    languages.add("Common");
                    languages.add("Out of Game");
                    rp.setKnownLanguages(languages);
                    rp.setShowLanguages(true);
                }
                if (RpgAPI.achievementsOn){
                    rp.setActivePrefix("The Recruit");
                    rp.setActiveSuffix("NONE");
                    List<String> playerTitles = rp.getTitles();
                    playerTitles.add("The Recruit");
                    playerTitles.add("Server Joiner");
                    rp.setTitles(playerTitles);
                }
                if (RpgAPI.clickOn){rp.setDefaultClick(true);}
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
                    Map<Reputation, Integer> repLevel = rp.getReputationLevels();
                    Map<Reputation, Boolean> repDiscovered = rp.getFactionsDiscovered();
                    rp.setReputationLevels(repLevel);
                    rp.setFactionsDiscovered(repDiscovered);
                }
                return rp;
            } else {
            YamlConfiguration playerFile = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/RpgPlayer/" + p + ".yml"));

            if (RpgAPI.classesOn){
                rp.setPlayerLCAlignment(playerFile.getString("Rpg Player.Classes.Lawful Chaotic Alignment"));
                rp.setPlayerGEAlignment(playerFile.getString("Rpg Player.Classes.Good Evil Alignment"));
                rp.setPlayerClass(playerFile.getString("Rpg Player.Classes.Class"));
                Map<PlayerStat, Integer> playerStats = rp.getStats();
                playerStats.put(PlayerStat.CHARACTER_LEVEL, playerFile.getInt("Rpg Player.Classes.Stats.Character Level"));
                playerStats.put(PlayerStat.AGE, playerFile.getInt("Rpg Player.Classes.Stats.Age"));
                playerStats.put(PlayerStat.STRENGTH, playerFile.getInt("Rpg Player.Classes.Stats.Strength"));
                playerStats.put(PlayerStat.DEXTERITY, playerFile.getInt("Rpg Player.Classes.Stats.Dexterity"));
                playerStats.put(PlayerStat.CONSTITUTION, playerFile.getInt("Rpg Player.Classes.Stats.Constitution"));
                playerStats.put(PlayerStat.INTELLIGENCE, playerFile.getInt("Rpg Player.Classes.Stats.Intelligence"));
                playerStats.put(PlayerStat.WISDOM, playerFile.getInt("Rpg Player.Classes.Stats.Wisdom"));
                playerStats.put(PlayerStat.CHARISMA, playerFile.getInt("Rpg Player.Classes.Stats.Charisma"));
                playerStats.put(PlayerStat.HIT_POINTS, playerFile.getInt("Rpg Player.Classes.Stats.Hit Points"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_PIERCING, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_PIERCING"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_SLASHING, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_SLASHING"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_BLUDGEONING, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_BLUDGEONING"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_CHAOTIC, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_CHAOTIC"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_LAWFUL, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_LAWFUL"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_GOOD, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_GOOD"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_EVIL, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_EVIL"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_COLD, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_COLD"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_FIRE, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_FIRE"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_ACID, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_ACID"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_SONIC, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_SONIC"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_ELECTRICITY, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_ELECTRICITY"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_ADAMANTINE, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_ADAMANTINE"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_COLD_IRON, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_COLD_IRON"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_EPIC, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_EPIC"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_MAGICAL, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_MAGICAL"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_SILVER, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_SILVER"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_NONE, playerFile.getInt("Rpg Player.Classes.Stats.DAMAGE_REDUCTION_NONE"));
                playerStats.put(PlayerStat.TOTAL_HIT_POINTS, playerFile.getInt("Rpg Player.Classes.Stats.Total Hit Points"));
                playerStats.put(PlayerStat.SPEED_LAND, playerFile.getInt("Rpg Player.Classes.Stats.Speed.Land"));
                playerStats.put(PlayerStat.SPEED_LAND_WITH_ARMOR, playerFile.getInt("Rpg Player.Classes.Stats.Speed.Land With Armor"));
                playerStats.put(PlayerStat.SPEED_FLY, playerFile.getInt("Rpg Player.Classes.Stats.Speed.Fly"));
                playerStats.put(PlayerStat.SPEED_SWIM, playerFile.getInt("Rpg Player.Classes.Stats.Speed.Swim"));
                playerStats.put(PlayerStat.INITIATIVE, playerFile.getInt("Rpg Player.Classes.Stats.Initiative"));
                playerStats.put(PlayerStat.ARMOR_CLASS_ARMOR_BONUS, playerFile.getInt("Rpg Player.Classes.Stats.Armor Class.Armor Bonus"));
                playerStats.put(PlayerStat.ARMOR_CLASS_SHIELD_BONUS, playerFile.getInt("Rpg Player.Classes.Stats.Armor Class.Shield Bonus"));
                playerStats.put(PlayerStat.ARMOR_CLASS_SIZE_MODIFIER, playerFile.getInt("Rpg Player.Classes.Stats.Armor Class.Size Modifier"));
                playerStats.put(PlayerStat.ARMOR_CLASS_NATURAL_ARMOR, playerFile.getInt("Rpg Player.Classes.Stats.Armor Class.Natural Armor"));
                playerStats.put(PlayerStat.ARMOR_CLASS_DEFLECTION_MODIFIER, playerFile.getInt("Rpg Player.Classes.Stats.Armor Class.Deflection Bonus"));
                playerStats.put(PlayerStat.ARMOR_CLASS_MODIFIER_MISC, playerFile.getInt("Rpg Player.Classes.Stats.Armor Class.Miscellaneous Modifier"));
                playerStats.put(PlayerStat.FORTITUDE_CLASS_BONUS, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Fortitude.Class Bonus"));
                playerStats.put(PlayerStat.FORTITUDE_CONSTITUTION_BONUS, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Fortitude.Constitution Bonus"));
                playerStats.put(PlayerStat.FORTITUDE_MAGIC, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Fortitude.Magic Bonus"));
                playerStats.put(PlayerStat.FORTITUDE_MISC, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Fortitude.Miscellaneous Bonus"));
                playerStats.put(PlayerStat.REFLEX__CLASS_BONUS, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Reflex.Class Bonus"));
                playerStats.put(PlayerStat.REFLEX_DEXTERITY_BONUS, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Reflex.Dexterity Bonus"));
                playerStats.put(PlayerStat.REFLEX_MAGIC, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Reflex.Magic Bonus"));
                playerStats.put(PlayerStat.REFLEX_MISC, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Reflex.Miscellaneous Bonus"));
                playerStats.put(PlayerStat.WILLPOWER_CLASS_BONUS, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Will.Class Bonus"));
                playerStats.put(PlayerStat.WILLPOWER_WISDOM_BONUS, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Will.Wisdom Bonus"));
                playerStats.put(PlayerStat.WILLPOWER_MAGIC, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Will.Magic Bonus"));
                playerStats.put(PlayerStat.WILLPOWER_MISC, playerFile.getInt("Rpg Player.Classes.Stats.Saves.Will.Miscellaneous Bonus"));
                playerStats.put(PlayerStat.BASE_ATTACK_BONUS, playerFile.getInt("Rpg Player.Classes.Stats.Base Attack Bonus"));
                playerStats.put(PlayerStat.SPELL_RESISTANCE, playerFile.getInt("Rpg Player.Classes.Stats.Spell Resistance"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_BAB, playerFile.getInt("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Base Attack Bonus"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_SIZE, playerFile.getInt("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Size Bonus"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_STRENGTH, playerFile.getInt("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Strength Bonus"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_BONUS_MISC, playerFile.getInt("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Miscellaneous Bonus"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_STRENGTH, playerFile.getInt("Rpg Player.Classes.Stats.Combat Defense Bonus.Strength Bonus"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_DEXTERITY, playerFile.getInt("Rpg Player.Classes.Stats.Combat Defense Bonus.Dexterity Bonus"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_BAB, playerFile.getInt("Rpg Player.Classes.Stats.Combat Defense Bonus.Base Attack Bonus"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_SIZE, playerFile.getInt("Rpg Player.Classes.Stats.Combat Defense Bonus.Size Bonus"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_STANDARD, playerFile.getInt("Rpg Player.Classes.Stats.Combat Defense Bonus.Standard Bonus"));
                playerStats.put(PlayerStat.COMBAT_MANUEVER_DEFENSE_MISC, playerFile.getInt("Rpg Player.Classes.Stats.Combat Defense Bonus.Miscellaneous Bonus"));
                playerStats.put(PlayerStat.EXPERIENCE_TOTAL, playerFile.getInt("Rpg Player.Classes.Stats.Experience"));
                rp.setStats(playerStats);
                Map<PlayerText, String> textStats = rp.getPlayerText();
                textStats.put(PlayerText.DEITY, playerFile.getString("Rpg Player.Classes.Stats.Deity"));
                textStats.put(PlayerText.SIZE, playerFile.getString("Rpg Player.Classes.Stats.Size"));
                textStats.put(PlayerText.GENDER, playerFile.getString("Rpg Player.Classes.Stats.Gender"));
                textStats.put(PlayerText.HEIGHT, playerFile.getString("Rpg Player.Classes.Stats.Height"));
                textStats.put(PlayerText.WEIGHT, playerFile.getString("Rpg Player.Classes.Stats.Weight"));
                textStats.put(PlayerText.HAIR_COLOR, playerFile.getString("Rpg Player.Classes.Stats.Hair Color"));
                textStats.put(PlayerText.EYE_COLOR, playerFile.getString("Rpg Player.Classes.Stats.Eye color"));
                textStats.put(PlayerText.DESCRIPTION, playerFile.getString("Rpg Player.Classes.Stats.Description"));
                rp.setPlayerText(textStats);
                Map<ElementalType, Integer> elementalTypeIntegerMap = rp.getElemRestype();
                elementalTypeIntegerMap.put(ElementalType.FIRE, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.FIRE"));
                elementalTypeIntegerMap.put(ElementalType.COLD, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.COLD"));
                elementalTypeIntegerMap.put(ElementalType.ACID, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.ACID"));
                elementalTypeIntegerMap.put(ElementalType.ELECTRICITY, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.ELECTRICITY"));
                elementalTypeIntegerMap.put(ElementalType.SONIC, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.SONIC"));
                rp.setElemRestype(elementalTypeIntegerMap);
                List<Feat> playerFeats = rp.getHasFeats();
                if (playerFile.getString("Rpg Player.Classes.Stats.Feats") != null){
                if (!(playerFile.getString("Rpg Player.Classes.Stats.Feats").equalsIgnoreCase("none"))){
                for (String feat : playerFile.getConfigurationSection("Rpg Player.Classes.Stats.Feats").getKeys(false)){
                    playerFeats.add(Feat.valueOf(feat));
                }
                }
                }
                rp.setHasFeats(playerFeats);
                Map<PlayerSkill, Integer> playerSkills = rp.getSkills();
                if (playerFile.getString("Rpg Player.Classes.Stats.Skills") != null){
                for (String skillName : playerFile.getConfigurationSection("Rpg Player.Classes.Stats.Skills").getKeys(false)){
                    playerSkills.put(PlayerSkill.valueOf(skillName), playerFile.getInt("Rpg Player.Classes.Stats.Skills." + skillName));
                }
                }
                rp.setSkills(playerSkills);
                Map<Spell, Boolean> playerSpells = rp.getSpells();
                if (playerFile.getString("Rpg Player.Classes.Stats.Spells.Spells Known") != null){
                    if (!(playerFile.getString("Rpg Player.Classes.Stats.Spells.Spells Known").equalsIgnoreCase("none"))){
                for (String spellsKnown : playerFile.getConfigurationSection("Rpg Player.Classes.Stats.Spells.Spells Known").getKeys(false)){
                    playerSpells.put(Spell.valueOf(spellsKnown), playerFile.getBoolean("Rpg Player.Classes.Stats.Spells.Spells Known." + spellsKnown));
                }
                }
                }
                rp.setSpells(playerSpells);
                Map<Integer, Integer> spellsPerLevel = rp.getSpellsPerCombat();
                if (playerFile.getString("Rpg Player.Classes.Stats.Spells.Spells Per Combat") != null){
                    if (!(playerFile.getString("Rpg Player.Classes.Stats.Spells.Spells Per Combat").equalsIgnoreCase("none"))){
                for (String level : playerFile.getConfigurationSection("Rpg Player.Classes.Stats.Spells.Spells Per Combat").getKeys(false)){
                spellsPerLevel.put(Integer.parseInt(level), playerFile.getInt("Rpg Player.Classes.Stats.Spells.Spells Per Combat." + level));
                }
                }
                }
                rp.setSpellsPerCombat(spellsPerLevel);

            }
            if (RpgAPI.racesOn){
                rp.setRace(playerFile.getString("Rpg Player.Race"));
            }
            if (RpgAPI.guildsOn){
                rp.setGuild(playerFile.getString("Rpg Player.Guild.Name"));
                rp.setGuildRank(playerFile.getString("Rpg Player.Guild.Rank"));
            }
            if (RpgAPI.friendsOn){
                List<String> friendList = rp.getFriendsList();
                if (playerFile.getString("Rpg Player.Friends List") != null){
                    if (!(playerFile.getString("Rpg Player.Friends List").equalsIgnoreCase("none"))){
                for (String friendName : playerFile.getConfigurationSection("Rpg Player.Friends List").getKeys(false)){
                friendList.add(friendName);
                }
                }
                }
                rp.setFriendsList(friendList);
            }
            if (RpgAPI.tradeOn){
                rp.setCopper(playerFile.getInt("Rpg Player.Trade.Copper"));
                rp.setSilver(playerFile.getInt("Rpg Player.Trade.Silver"));
                rp.setGold(playerFile.getInt("Rpg Player.Trade.Gold"));
                rp.setPlatinum(playerFile.getInt("Rpg Player.Trade.Platinum"));
            }
            if (RpgAPI.chatOn){
                List<String> chatChannels = rp.getChatChannels();
                Map<String, ChatColor> channelColors = rp.getChannelColors();
                if (playerFile.getString("Rpg Player.Chat.Channels") != null){
                for (String chat : playerFile.getConfigurationSection("Rpg Player.Chat.Channels").getKeys(false)){
                    chatChannels.add(chat);
                    if (playerFile.getBoolean("Rpg Player.Chat.Channels." + chat + ".Active") == true){
                        rp.setActiveChannel(chat);
                    }
                    channelColors.put(chat, ChatColor.valueOf(playerFile.getString("Rpg Player.Chat.Channels." + chat + ".Color")));
                }
                }
                rp.setChatChannels(chatChannels);
                rp.setChannelColors(channelColors);
                List<String> ignoreList = rp.getIgnoreList();
                if (playerFile.getString("Rpg Player.Chat.Ignore List") != null){
                    if (!(playerFile.getString("Rpg Player.Chat.Ignore List").equalsIgnoreCase("none"))){
                for (String ignoredPlayer : playerFile.getConfigurationSection("Rpg Player.Chat.Ignore List").getKeys(false)){
                    ignoreList.add(ignoredPlayer);
                }
                }
                }
                rp.setIgnoreList(ignoreList);
                List<String> invitedChats = rp.getInvitedChats();
                if (playerFile.getString("Rpg Player.Chat.Invited Chats") != null){
                    if (!(playerFile.getString("Rpg Player.Chat.Invited Chats").equalsIgnoreCase("none"))){
                for (String invitedChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Invited Chats").getKeys(false)){
                    invitedChats.add(invitedChatChannels);
                }
                }
                }
                rp.setInvitedChats(invitedChats);
                List<String> bannedChats = rp.getBannedChats();
                if (playerFile.getString("Rpg Player.Chat.Banned Chats") != null){
                    if (!(playerFile.getString("Rpg Player.Chat.Banned Chats").equalsIgnoreCase("none"))){

                for (String bannedChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Banned Chats").getKeys(false)){
                    bannedChats.add(bannedChatChannels);
                }
                }
                }
                rp.setBannedChats(bannedChats);
                List<String> mutedChats = rp.getMutedChats();
                if (playerFile.getString("Rpg Player.Chat.Muted Chats") != null){
                    if (!(playerFile.getString("Rpg Player.Chat.Muted Chats").equalsIgnoreCase("none"))){
                for (String mutedChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Muted Chats").getKeys(false)){
                    mutedChats.add(mutedChatChannels);
                }
                }
                }
                rp.setMutedChats(mutedChats);

                List<String> ownedChats = rp.getOwnedChats();
                if (playerFile.getString("Rpg Player.Chat.Owned Chats") != null){
                    if (!(playerFile.getString("Rpg Player.Chat.Owned Chats").equalsIgnoreCase("none"))){

                for (String ownedChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Owned Chats").getKeys(false)){
                    ownedChats.add(ownedChatChannels);
                }
                }
                }
                rp.setOwnedChats(ownedChats);
                List<String> moderatedChats = rp.getModChats();
                if (playerFile.getString("Rpg Player.Chat.Moderated Chats") != null){
                    if (!(playerFile.getString("Rpg Player.Chat.Moderated Chats").equalsIgnoreCase("none"))){
                for (String modChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Moderated Chats").getKeys(false)){
                    moderatedChats.add(modChatChannels);
                }
                }
                }
                rp.setModChats(moderatedChats);
                rp.setChatSpy(playerFile.getBoolean("Rpg Player.Chat.Spy"));
                rp.setShowGuildTags(playerFile.getBoolean("Rpg Player.Chat.Show Guild Tags"));
                rp.setShowAchieveTitles(playerFile.getBoolean("Rpg Player.Chat.Show Achieve Titles"));
                rp.setShowChannelNames(playerFile.getBoolean("Rpg Player.Chat.Show Channel Names"));
                rp.setShowLanguageNames(playerFile.getBoolean("Rpg Player.Chat.Show Language Names"));
                rp.setShowWorldName(playerFile.getBoolean("Rpg Player.Chat.Show World Name"));
                rp.setActiveLanguage(playerFile.getString("Rpg Player.Chat.Languages.Active"));
                List<String> languages = rp.getKnownLanguages();
                if (playerFile.getString("Rpg Player.Chat.Languages.Known Languages") != null){
                    if (!(playerFile.getString("Rpg Player.Chat.Languages.Known Languages").equalsIgnoreCase("none"))){
                for (String language : playerFile.getConfigurationSection("Rpg Player.Chat.Languages.Known Languages").getKeys(false)){
                    languages.add(language);
                }
                }
                }
                rp.setKnownLanguages(languages);
                rp.setShowLanguages(playerFile.getBoolean("Rpg Player.Chat.Languages.Show Languages"));
            }
            if (RpgAPI.achievementsOn){
                rp.setActivePrefix(playerFile.getString("Rpg Player.Achievements.Active Prefix"));
                rp.setActiveSuffix(playerFile.getString("Rpg Player.Achievements.Active Suffix"));
                List<String> playerTitles = rp.getTitles();
                if (playerFile.getString("Rpg Player.Achievements.Titles") != null){
                    if (!(playerFile.getString("Rpg Player.Achievements.Titles").equalsIgnoreCase("none"))){
                for (String title : playerFile.getConfigurationSection("Rpg Player.Achievements.Titles").getKeys(false)){
                    playerTitles.add(title);
                }
                }
                }
                rp.setTitles(playerTitles);
            }
            if (RpgAPI.clickOn){rp.setDefaultClick(playerFile.getBoolean("Rpg Player.Click.defaultClick"));}
            if (RpgAPI.lobbyOn){
                rp.setInLobby(playerFile.getBoolean("Rpg Player.Lobby.In Lobby"));
                rp.setArmorInventory(playerFile.getString("Rpg Player.Lobby.Armor Inventory"));
                rp.setInventoryContents(playerFile.getString("Rpg Player.Lobby.Inventory Contents"));
                rp.setCurrentHealth(playerFile.getInt("Rpg Player.Lobby.Current Health"));
                rp.setOldX(playerFile.getDouble("Rpg Player.Lobby.Coordinates.X"));
                rp.setOldY(playerFile.getDouble("Rpg Player.Lobby.Coordinates.Y"));
                rp.setOldZ(playerFile.getDouble("Rpg Player.Lobby.Coordinates.Z"));
                rp.setOldWorld(playerFile.getString("Rpg Player.Lobby.Coordinates.World"));
            }
            if (RpgAPI.minionsOn){
                List<String> petsOwned = rp.getPetsOwned();
                if (playerFile.getString("Rpg Player.Minions.Pets Owned") != null){
                    if (!(playerFile.getString("Rpg Player.Minions.Pets Owned").equalsIgnoreCase("none"))){
                for (String pet : playerFile.getConfigurationSection("Rpg Player.Minions.Pets Owned").getKeys(false)){
                    petsOwned.add(pet);
                }
                }
                }
                rp.setPetsOwned(petsOwned);
                rp.setActivePet(playerFile.getString("Rpg Player.Minions.Active Pet"));
            }
            rp.setRealName(playerFile.getString("Rpg Player.RealName"));
            if (RpgAPI.questOn){
                List<String> currentQuests = rp.getCurrentQuests();
                Map<String, Integer> questStage = rp.getQuestStages();
                Map<String, Integer> stageCounter = rp.getQuestGoalCount();
                if (playerFile.getString("Rpg Player.Quests.Current Quests") != null){
                    if (!(playerFile.getString("Rpg Player.Quests.Current Quests").equalsIgnoreCase("none"))){
                for (String questName : playerFile.getConfigurationSection("Rpg Player.Quests.Current Quests").getKeys(false)){
                    currentQuests.add(questName);
                    if (playerFile.getBoolean("Rpg Player.Quests.Current Quests." + questName + ".Active")){
                        rp.setActiveQuest(questName);
                    }
                    questStage.put(questName, playerFile.getInt("Rpg Player.Quests.Current Quests." + questName + ".Stage"));
                    stageCounter.put(questName, playerFile.getInt("Rpg Player.Quests.Current Quests." + questName + ".Counter"));
                }
                }
                }
                rp.setCurrentQuests(currentQuests);
                rp.setQuestStages(questStage);
                rp.setQuestGoalCount(stageCounter);
                List<String> completedQuests = rp.getCompletedQuests();
                if (playerFile.getString("Rpg Player.Quests.Completed Quests") != null){
                    if (!(playerFile.getString("Rpg Player.Quests.Completed Quests").equalsIgnoreCase("none"))){
                for (String questName : playerFile.getConfigurationSection("Rpg Player.Quests.Completed Quests").getKeys(false)){
                    completedQuests.add(questName);
                }
                }
                }
                rp.setCompletedQuests(completedQuests);
            }
            if (RpgAPI.reputationOn){
                Map<Reputation, Integer> repLevel = rp.getReputationLevels();
                Map<Reputation, Boolean> repDiscovered = rp.getFactionsDiscovered();
                if (playerFile.getString("Rpg Player.Reputation.Factions") != null){
                    if (!(playerFile.getString("Rpg Player.Reputation.Factions").equalsIgnoreCase("none"))){
                for (String rep : playerFile.getConfigurationSection("Rpg Player.Reputation.Factions.").getKeys(false)){
                    repLevel.put(Reputation.valueOf(rep), playerFile.getInt("Rpg Player.Reputation.Factions." + rep + "Reputation Level"));
                    repDiscovered.put(Reputation.valueOf(rep), playerFile.getBoolean("Rpg Player.Reputation.Factions." + rep + "Discovered"));
                }
                        rp.setReputationLevels(repLevel);
                        rp.setFactionsDiscovered(repDiscovered);
                }
                }

            }
          return rp;
            }
        }
        return rp;
        }

}
