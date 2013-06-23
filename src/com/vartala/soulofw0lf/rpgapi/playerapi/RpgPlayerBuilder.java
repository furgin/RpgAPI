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

import static javax.xml.bind.DatatypeConverter.parseInt;

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
    public static RpgPlayer RpgBuilder(String p){
        RpgPlayer rp = new RpgPlayer();
        if (RpgAPI.useMySql){
                  //TODO do stuff here LinksBro
        } else {
          YamlConfiguration playerFile = YamlConfiguration.loadConfiguration(RpgAPI.playerFiles.get(p));
            if (playerFile == null){
                    playerFile = YamlConfiguration.loadConfiguration(new File("plugins/RpgAPI/Poisons.yml"));
                    playerFile.set("Rpg Player.Real Name", p);
                if (RpgAPI.classesOn){
                    playerFile.set("Rpg Player.Classes.Lawful Chaotic Alignment", "");
                    playerFile.set("Rpg Player.Classes.Good Evil Alignment", "");
                    playerFile.set("Rpg Player.Classes.Class", "");
                    playerFile.set("Rpg Player.Classes.Stats.Character Level", 1);
                    playerFile.set("Rpg Player.Classes.Stats.Age", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Strength", 10);
                    playerFile.set("Rpg Player.Classes.Stats.Dexterity", 10);
                    playerFile.set("Rpg Player.Classes.Stats.Constitution", 10);
                    playerFile.set("Rpg Player.Classes.Stats.Intelligence", 10);
                    playerFile.set("Rpg Player.Classes.Stats.Wisdom", 10);
                    playerFile.set("Rpg Player.Classes.Stats.Charisma", 10);
                    playerFile.set("Rpg Player.Classes.Stats.Hit Points", 10);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Piercing", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Slashing", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Bludgeoning", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Magical", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Epic", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Lawful", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Good", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Chaotic", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Evil", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Fire", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Cold", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Acid", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Sonic", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Electricity", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Silver", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Cold Iron", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.Adamantine", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Damage Reduction.None", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Total Hit Points", 10);
                    playerFile.set("Rpg Player.Classes.Stats.Speed.Land", 30);
                    playerFile.set("Rpg Player.Classes.Stats.Speed.Land With Armor", 20);
                    playerFile.set("Rpg Player.Classes.Stats.Speed.Fly", 30);
                    playerFile.set("Rpg Player.Classes.Stats.Speed.Swim", 15);
                    playerFile.set("Rpg Player.Classes.Stats.Initiative", 1);
                    playerFile.set("Rpg Player.Classes.Stats.Armor Class.Armor Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Armor Class.Shield Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Armor Class.Size Modifier", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Armor Class.Natural Armor", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Armor Class.Deflection Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Armor Class.Miscellaneous Modifier", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Fortitude.Class Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Fortitude.Constitution Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Fortitude.Magic Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Fortitude.Miscellaneous Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Reflex.Class Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Reflex.Dexterity Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Reflex.Magic Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Reflex.Miscellaneous Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Will.Class Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Will.Wisdom Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Will.Magic Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Saves.Will.Miscellaneous Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Base Attack Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Spell Resistance", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Base Attack Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Size Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Strength Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Maneuver Bonus.Miscellaneous Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Strength Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Dexterity Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Base Attack Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Size Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Standard Bonus", 10);
                    playerFile.set("Rpg Player.Classes.Stats.Combat Defense Bonus.Miscellaneous Bonus", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Experience", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Deity", "");
                    playerFile.set("Rpg Player.Classes.Stats.Size", "");
                    playerFile.set("Rpg Player.Classes.Stats.Gender", "");
                    playerFile.set("Rpg Player.Classes.Stats.Height", "");
                    playerFile.set("Rpg Player.Classes.Stats.Weight", "");
                    playerFile.set("Rpg Player.Classes.Stats.Hair Color", "");
                    playerFile.set("Rpg Player.Classes.Stats.Eye color", "");
                    playerFile.set("Rpg Player.Classes.Stats.Description", "");
                    playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.Fire", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.Cold", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.Acid", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.Electricity", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Elemental Resistances.Sonic", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Feats", "");
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Acrobatics", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Appraise", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Bluff", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Climb", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Craft", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Diplomacy", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Disable Device", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Disguise", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Escape Artist", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Fly", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Handle Animal", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Heal", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Intimidate", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.Arcana", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.Dungeoneering", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.Engineering", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.Geography", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.History", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.Local", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.Nature", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.Nobility", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.Planes", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Knowledges.Religion", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Linguistics", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Perception", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Perform", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Profession", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Ride", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Sense Motive", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Sleight of Hand", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Spellcraft", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Stealth", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Survival", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Swim", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Skills.Use Magic Device", 0);
                    playerFile.set("Rpg Player.Classes.Stats.Spells.Spells Known", "");
                    playerFile.set("Rpg Player.Classes.Stats.Spells.Spells Per Combat", "");

                }
                if (RpgAPI.racesOn){playerFile.set("Rpg Player.Race", "");}
                if (RpgAPI.guildsOn){
                    playerFile.set("Rpg Player.Guild.Name", "");
                    playerFile.set("Rpg Player.Guild.Rank",  "");
                }
                if (RpgAPI.friendsOn){playerFile.set("Rpg Player.Friends List", "");}
                if (RpgAPI.tradeOn){
                    playerFile.set("Rpg Player.Trade.Copper", 0);
                    playerFile.set("Rpg Player.Trade.Silver", 0);
                    playerFile.set("Rpg Player.Trade.Gold", 0);
                    playerFile.set("Rpg Player.Trade.Platinum", 0);
                }
                if (RpgAPI.chatOn){
                    playerFile.set("Rpg Player.Chat.Channels.Global.Active", true);
                    playerFile.set("Rpg Player.Chat.Channels.Global.Color", "White");
                    playerFile.set("Rpg Player.Chat.Ignore List", "");
                    playerFile.set("Rpg Player.Chat.Invited Chats", "");
                    playerFile.set("Rpg Player.Chat.Banned Chats", "");
                    playerFile.set("Rpg Player.Chat.Muted Chats", "");
                    playerFile.set("Rpg Player.Chat.Owned Chats", "");
                    playerFile.set("Rpg Player.Chat.Moderated Chats", "");
                    playerFile.set("Rpg Player.Chat.Spy", false);
                    playerFile.set("Rpg Player.Chat.Show Guild Tags", true);
                    playerFile.set("Rpg Player.Chat.Show Achieve Titles", true);
                    playerFile.set("Rpg Player.Chat.Show Channel Names", true);
                    playerFile.set("Rpg Player.Chat.Show Language Names", true);
                    playerFile.set("Rpg Player.Chat.Show World Name", true);
                    playerFile.set("Rpg Player.Chat.Languages.Active", "Common");
                    playerFile.set("Rpg Player.Chat.Languages.Known Languages", "");
                    playerFile.set("Rpg Player.Chat.Languages.Show Languages", true);
                }
                if (RpgAPI.achievementsOn){
                    playerFile.set("Rpg Player.Achievements.Active Prefix", "");
                    playerFile.set("Rpg Player.Achievements.Active Suffix", "");
                    playerFile.set("Rpg Player.Achievements.Titles", "");
                }
                if (RpgAPI.clickOn){playerFile.set("Rpg Player.Click.defaultClick", true);}
                if (RpgAPI.lobbyOn){
                    playerFile.set("Rpg Player.Lobby.In Lobby", false);
                    playerFile.set("Rpg Player.Lobby.Armor Inventory", "");
                    playerFile.set("Rpg Player.Lobby.Inventory Contents", "");
                    playerFile.set("Rpg Player.Lobby.Current Health", "");
                    playerFile.set("Rpg Player.Lobby.Coordinates.X", 0);
                    playerFile.set("Rpg Player.Lobby.Coordinates.Y", 0);
                    playerFile.set("Rpg Player.Lobby.Coordinates.Z", 0);
                    playerFile.set("Rpg Player.Lobby.Coordinates.World", "");
                }
                if (RpgAPI.minionsOn){
                    playerFile.set("Rpg Player.Minions.Pets Owned", "");
                    playerFile.set("Rpg Player.Minions.Active Pet", "");
                }
                if (RpgAPI.questOn){
                    playerFile.set("Rpg Player.Quests.Current Quests.Log On.Stage", 0);
                    playerFile.set("Rpg Player.Quests.Current Quests.Log On.Active", true);
                    playerFile.set("Rpg Player.Quests.Current Quests.Log On.Counter", 0);
                    playerFile.set("Rpg Player.Quests.Completed Quests", "");
                }
                if (RpgAPI.reputationOn){
                    playerFile.set("Rpg Player.Reputation.Factions.Server.Reputation Level", 0);
                    playerFile.set("Rpg Player.Reputation.Factions.Server.Discovered", true);
                }
                try {
                    playerFile.save(new File("plugins/RpgAPI/RpgPlayer/" + playerFile.getName() + ".yml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            rp.setRealName(playerFile.getString("Rpg Player.Real Name"));
            if (RpgAPI.classesOn){
                rp.setPlayerLCAlignment(playerFile.getString("Rpg Player.Classes.Lawful Chaotic Alignment"));
                rp.setPlayerGEAlignment(playerFile.getString("Rpg Player.Classes.Good Evil Alignment"));
                rp.setPlayerClass(playerFile.getString("Rpg Player.Classes.Class", ""));
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
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_PIERCING, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Piercing"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_SLASHING, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Slashing"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_BLUDGEONING, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Bludgeoning"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_CHAOTIC, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Chaotic"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_LAWFUL, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Lawful"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_GOOD, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Good"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_EVIL, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Evil"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_COLD, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Cold"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_FIRE, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Fire"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_ACID, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Acid"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_SONIC, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Sonic"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_ELECTRICITY, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Electricity"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_ADAMANTINE, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Adamantine"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_COLD_IRON, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Cold Iron"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_EPIC, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Epic"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_MAGICAL, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Magical"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_SILVER, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.Silver"));
                playerStats.put(PlayerStat.DAMAGE_REDUCTION_NONE, playerFile.getInt("Rpg Player.Classes.Stats.Damage Reduction.None"));
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
                elementalTypeIntegerMap.put(ElementalType.FIRE, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.Fire"));
                elementalTypeIntegerMap.put(ElementalType.COLD, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.Cold"));
                elementalTypeIntegerMap.put(ElementalType.ACID, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.Acid"));
                elementalTypeIntegerMap.put(ElementalType.ELECTRICITY, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.Electricity"));
                elementalTypeIntegerMap.put(ElementalType.SONIC, playerFile.getInt("Rpg Player.Classes.Stats.Elemental Resistances.Sonic"));
                rp.setElemRestype(elementalTypeIntegerMap);
                List<Feat> playerFeats = rp.getHasFeats();
                for (String feat : playerFile.getConfigurationSection("Rpg Player.Classes.Stats.Feats").getKeys(false)){
                    playerFeats.add(Feat.valueOf(feat));
                }
                rp.setHasFeats(playerFeats);
                Map<PlayerSkill, Integer> playerSkills = rp.getSkills();
                for (String skillName : playerFile.getConfigurationSection("Rpg Player.Classes.Stats.Skills").getKeys(false)){
                    playerSkills.put(PlayerSkill.valueOf(skillName), playerFile.getInt("Rpg Player.Classes.Stats.Skills." + skillName));
                }
                rp.setSkills(playerSkills);
                Map<Spell, Boolean> playerSpells = rp.getSpells();
                for (String spellsKnown : playerFile.getConfigurationSection("Rpg Player.Classes.Stats.Spells.Spells Known").getKeys(false)){
                    playerSpells.put(Spell.valueOf(spellsKnown), playerFile.getBoolean("Rpg Player.Classes.Stats.Spells.Spells Known." + spellsKnown));
                }
                rp.setSpells(playerSpells);
                Map<Integer, Integer> spellsPerLevel = rp.getSpellsPerCombat();
                for (String level : playerFile.getConfigurationSection("Rpg Player.Classes.Stats.Spells.Spells Per Combat").getKeys(false)){
                spellsPerLevel.put(parseInt(level), playerFile.getInt("Rpg Player.Classes.Stats.Spells.Spells Per Combat." + level));
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
                for (String friendName : playerFile.getConfigurationSection("rpg Player.Friends List").getKeys(false)){
                friendList.add(friendName);
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
                for (String chat : playerFile.getConfigurationSection("Rpg Player.Chat.Channels").getKeys(false)){
                    chatChannels.add(chat);
                    if (playerFile.getBoolean("Rpg Player.Chat.Channels." + chat + ".Active") == true){
                        rp.setActiveChannel(chat);
                    }
                    channelColors.put(chat, ChatColor.valueOf(playerFile.getString("Rpg Player.Chat.Channels." + chat + ".Color")));
                }
                rp.setChatChannels(chatChannels);
                rp.setChannelColors(channelColors);
                List<String> ignoreList = rp.getIgnoreList();
                for (String ignoredPlayer : playerFile.getConfigurationSection("Rpg Player.Chat.Ignore List").getKeys(false)){
                    ignoreList.add(ignoredPlayer);
                }
                rp.setIgnoreList(ignoreList);
                List<String> invitedChats = rp.getInvitedChats();
                for (String invitedChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Invited Chats").getKeys(false)){
                    invitedChats.add(invitedChatChannels);
                }
                rp.setInvitedChats(invitedChats);
                List<String> bannedChats = rp.getBannedChats();
                for (String bannedChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Banned Chats").getKeys(false)){
                    bannedChats.add(bannedChatChannels);
                }
                rp.setBannedChats(bannedChats);
                List<String> mutedChats = rp.getMutedChats();
                for (String mutedChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Muted Chats").getKeys(false)){
                    mutedChats.add(mutedChatChannels);
                }
                rp.setMutedChats(mutedChats);

                List<String> ownedChats = rp.getOwnedChats();
                for (String ownedChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Owned Chats").getKeys(false)){
                    ownedChats.add(ownedChatChannels);
                }
                rp.setOwnedChats(ownedChats);
                List<String> moderatedChats = rp.getModChats();
                for (String modChatChannels : playerFile.getConfigurationSection("Rpg Player.Chat.Moderated Chats").getKeys(false)){
                    moderatedChats.add(modChatChannels);
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
                for (String language : playerFile.getConfigurationSection("Rpg Player.Chat.Languages.Known Languages").getKeys(false)){
                    languages.add(language);
                }
                rp.setKnownLanguages(languages);
                rp.setShowLanguages(playerFile.getBoolean("Rpg Player.Chat.Languages.Show Languages"));
            }
            if (RpgAPI.achievementsOn){
                rp.setActivePrefix(playerFile.getString("Rpg Player.Achievements.Active Prefix"));
                rp.setActiveSuffix(playerFile.getString("Rpg Player.Achievements.Active Suffix"));
                List<String> playerTitles = rp.getTitles();
                for (String title : playerFile.getConfigurationSection("Rpg Player.Achievements.Titles").getKeys(false)){
                    playerTitles.add(title);
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
                for (String pet : playerFile.getConfigurationSection("Rpg Player.Minions.Pets Owned").getKeys(false)){
                    petsOwned.add(pet);
                }
                rp.setPetsOwned(petsOwned);
                rp.setActivePet(playerFile.getString("Rpg Player.Minions.Active Pet"));
            }
            if (RpgAPI.questOn){
                List<String> currentQuests = rp.getCurrentQuests();
                Map<String, Integer> questStage = rp.getQuestStages();
                Map<String, Integer> stageCounter = rp.getQuestGoalCount();
                for (String questName : playerFile.getConfigurationSection("Rpg Player.Quests.Current Quests").getKeys(false)){
                    currentQuests.add(questName);
                    if (playerFile.getBoolean("Rpg Player.Quests.Current Quests." + questName + ".Active")){
                        rp.setActiveQuest(questName);
                    }
                    questStage.put(questName, playerFile.getInt("Rpg Player.Quests.Current Quests." + questName + ".Stage"));
                    stageCounter.put(questName, playerFile.getInt("Rpg Player.Quests.Current Quests." + questName + ".Counter"));

                }
                rp.setCurrentQuests(currentQuests);
                rp.setQuestStages(questStage);
                rp.setQuestGoalCount(stageCounter);
                List<String> completedQuests = rp.getCompletedQuests();
                for (String questName : playerFile.getConfigurationSection("Rpg Player.Quests.Completed Quests").getKeys(false)){
                    completedQuests.add(questName);
                }
                rp.setCompletedQuests(completedQuests);
            }
            if (RpgAPI.reputationOn){
                Map<Reputation, Integer> repLevel = rp.getReputationLevels();
                Map<Reputation, Boolean> repDiscovered = rp.getFactionsDiscovered();
                for (String rep : playerFile.getConfigurationSection("Rpg Player.Reputation.Factions.").getKeys(false)){
                    repLevel.put(Reputation.valueOf(rep), playerFile.getInt("Rpg Player.Reputation.Factions." + rep + "Reputation Level"));
                    repDiscovered.put(Reputation.valueOf(rep), playerFile.getBoolean("Rpg Player.Reputation.Factions." + rep + "Discovered"));
                }
                rp.setReputationLevels(repLevel);
                rp.setFactionsDiscovered(repDiscovered);
            }
        }
        return rp;
    }
}
