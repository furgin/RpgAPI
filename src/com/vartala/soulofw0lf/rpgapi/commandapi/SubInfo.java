package com.vartala.soulofw0lf.rpgapi.commandapi;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.vartala.soulofw0lf.rpgapi.util.MultiColorUtil;


public class SubInfo {
    //
    private final CommandSender Sender;
    private final Player Player;
    private final String BaseCommand;
    private final SubCommand SubCommand;
    private final String ReplyPrefix;

    private List<String> Args;

    /**
     *
     * @param sender
     * @param player
     * @param basecommand
     * @param subcommand
     * @param args
     */
    public SubInfo(CommandSender sender, Player player, String basecommand, SubCommand subcommand, List<String> args) {
        Validate.notNull(sender);
        Validate.notEmpty(basecommand);
        Validate.notNull(subcommand);
        this.Sender = sender;
        this.Player = player;
        this.Args = args;
        this.BaseCommand = basecommand;
        this.SubCommand = subcommand;
        this.ReplyPrefix = "{blue}Reply: ";
    }

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return this.Player;
    }

    /**
     *
     * @return
     */
    public CommandSender getSender() {
        return this.Sender;
    }

    /**
     *
     * @return
     */
    public List<String> getArgs() {
        return this.Args;
    }

    /**
     *
     * @param index
     * @return
     */
    public String getIntArgs(int index) {
        return this.Args.get(index);
    }

    /**
     *
     * @param index
     * @return
     */
    public String getJoinedArgsAfter(int index) {
        return StringUtils.join(this.Args.subList(index, this.Args.size()), " ");
    }

    /**
     *
     * @return
     */
    public int getNumArgs() {
        return this.Args.size();
    }

    /**
     *
     * @return
     */
    public String getBaseCommand() {
        return this.BaseCommand;
    }

    /**
     *
     * @return
     */
    public SubCommand getSubCommand() {
        return this.SubCommand;
    }

    /**
     *
     * @param message
     * @param args
     */
    public void reply(String message, Object... args) {
        reply(true, message, args);
    }

    /**
     *
     * @param prefix
     * @param message
     * @param args
     */
    public void reply(boolean prefix, String message, Object... args) {
        if (prefix) {
            MultiColorUtil.send(this.Sender, this.ReplyPrefix + message, args);
        } else {
            MultiColorUtil.send(this.Sender, message, args);
        }
    }

}
