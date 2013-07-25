package com.vartala.soulofw0lf.rpgapi.commandapi;

import org.apache.commons.lang.Validate;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class SubCommand {
    //
    private final String name;
    private final String permission;
    private boolean allow_console = false;
    private int minAgs = 0;
    private MultiHandler handler = null;
    private String description;
    private String usage = null;

    /**
     *
     * @param name
     * @param permission
     */
    public SubCommand(String name, String permission) {
        this.name = name;
        this.permission = permission;
    }

    /**
     *
     * @return
     */
    public SubCommand allowConsole() {
        this.allow_console = true;
        return this;
    }

    /**
     *
     * @return
     */
    public boolean isConsoleAllowed() {
        return this.allow_console;
    }

    /**
     *
     * @return
     */
    public int getMinArgs() {
        return this.minAgs;
    }

    /**
     *
     * @param minArgs
     * @return
     */
    public SubCommand setMinArgs(int minArgs) {
        Validate.isTrue(minArgs >= 0, "minArgs Cannot Be Less Than 0");
        this.minAgs = minArgs;
        return this;
    }

    /**
     *
     * @return
     */
    public MultiHandler getHandler() {
        return this.handler;
    }

    /**
     *
     * @param handler
     * @return
     */
    public SubCommand setHandler(MultiHandler handler) {
        Validate.notNull(handler);
        this.handler = handler;
        return this;
    }

    /**
     *
     * @return
     */
    public String getName() {
        return this.name;
    }

    /**
     *
     * @return
     */
    public String getUsage() {
        return this.usage;
    }

    /**
     *
     * @param usage
     * @return
     */
    public SubCommand setUsage(String usage) {
        this.usage = usage;
        return this;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return this.description;
    }

    /**
     *
     * @param description
     * @return
     */
    public SubCommand setDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     *
     * @return
     */
    public String getPermission() {
        return this.permission;
    }

    /**
     *
     * @param sender
     * @return
     */
    public boolean checkPermission(CommandSender sender) {
        if (this.permission == null) return true;
        return sender.hasPermission(this.permission);
    }

    /**
     *
     * @param sender
     * @return
     */
    public boolean checkConsole(CommandSender sender) {
        if (!(sender instanceof Player) && !this.allow_console) return false;
        return true;
    }

}
