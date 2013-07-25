package com.vartala.soulofw0lf.rpgapi.chatapi;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: soulofw0lf
 * Date: 6/10/13
 * Time: 1:41 AM
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


public class ChatClass {
    //name of the chat channel

    private String channelName = "";

    //nickname of the channel for command useage
    private String channelNick = "";

    //players in chat
    private List<String> playersInChat = new ArrayList<>();

    //should chat spying be allowed in this channel
    private boolean chatSpy = true;

    //specific behaviors to add to chat channels
    private List<ChatBehavior> channelBehaviors = new ArrayList<ChatBehavior>();

    //is the channel private
    private Boolean privateChat = false;

    //muted players in channel
    private List<String> mutedPlayers = new ArrayList<String>();

    //banned players from channel
    private List<String> bannedPlayers = new ArrayList<String>();

    //channel owner
    private String channelOwner = "";

    //private channel password
    private String channelPassword = "";

    //invited player
    private List<String> invitedPlayers = new ArrayList<String>();

    //config use booleans
    private boolean enabled = false;
    private boolean spyEnabled = false;
    private boolean useBasic = false;
    private boolean useLanguage = false;
    private boolean useDistance = false;
    private int distance = 0;
    private boolean useParty = false;
    private boolean useGuild = false;
    private boolean useRegion = false;
    private boolean useCity = false;
    private boolean useWorld = false;


    public void ChatClass() {

    }

    /**
     *
     * @param behavior
     */
    public void addBehavior(ChatBehavior behavior) {

        channelBehaviors.add(behavior);
    }

    /**
     *
     * @param behavior
     */
    public void removeBehavior(ChatBehavior behavior){
        channelBehaviors.remove(behavior);
    }

    /**
     *
     */
    public void clearBehavior() {
        channelBehaviors.clear();
    }

    /**
     *
     * @return
     */
    public String getChannelName() {
        return channelName;
    }

    /**
     *
     * @param channelName
     */
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    /**
     *
     * @return
     */
    public boolean isChatSpy() {
        return chatSpy;
    }

    /**
     *
     * @param chatSpy
     */
    public void setChatSpy(boolean chatSpy) {
        this.chatSpy = chatSpy;
    }

    /**
     *
     * @return
     */
    public List<ChatBehavior> getChannelBehaviors() {
        return channelBehaviors;
    }

    /**
     *
     * @param channelBehaviors
     */
    public void setChannelBehaviors(List<ChatBehavior> channelBehaviors) {
        this.channelBehaviors = channelBehaviors;
    }

    /**
     *
     * @return
     */
    public boolean getPrivateChat() {
        return privateChat;
    }

    /**
     *
     * @param privateChat
     */
    public void setPrivateChat(Boolean privateChat) {
        this.privateChat = privateChat;
    }

    /**
     *
     * @return
     */
    public List<String> getMutedPlayers() {
        return mutedPlayers;
    }

    /**
     *
     * @param mutedPlayers
     */
    public void setMutedPlayers(List<String> mutedPlayers) {
        this.mutedPlayers = mutedPlayers;
    }

    /**
     *
     * @return
     */
    public List<String> getBannedPlayers() {
        return bannedPlayers;
    }

    /**
     *
     * @param bannedPlayers
     */
    public void setBannedPlayers(List<String> bannedPlayers) {
        this.bannedPlayers = bannedPlayers;
    }

    /**
     *
     * @return
     */
    public String getChannelOwner() {
        return channelOwner;
    }

    /**
     *
     * @param channelOwner
     */
    public void setChannelOwner(String channelOwner) {
        this.channelOwner = channelOwner;
    }

    /**
     *
     * @return
     */
    public String getChannelPassword() {
        return channelPassword;
    }

    /**
     *
     * @param channelPassword
     */
    public void setChannelPassword(String channelPassword) {
        this.channelPassword = channelPassword;
    }

    /**
     *
     * @return
     */
    public List<String> getInvitedPlayers() {
        return invitedPlayers;
    }

    /**
     *
     * @param invitedPlayers
     */
    public void setInvitedPlayers(List<String> invitedPlayers) {
        this.invitedPlayers = invitedPlayers;
    }

    /**
     *
     * @return
     */
    public String getChannelNick() {
        return channelNick;
    }

    /**
     *
     * @param channelNick
     */
    public void setChannelNick(String channelNick) {
        this.channelNick = channelNick;
    }

    /**
     *
     * @return
     */
    public boolean isUseWorld() {
        return useWorld;
    }

    /**
     *
     * @param useWorld
     */
    public void setUseWorld(boolean useWorld) {
        this.useWorld = useWorld;
    }

    /**
     *
     * @return
     */
    public boolean isUseCity() {
        return useCity;
    }

    /**
     *
     * @param useCity
     */
    public void setUseCity(boolean useCity) {
        this.useCity = useCity;
    }

    /**
     *
     * @return
     */
    public boolean isUseRegion() {
        return useRegion;
    }

    /**
     *
     * @param useRegion
     */
    public void setUseRegion(boolean useRegion) {
        this.useRegion = useRegion;
    }

    /**
     *
     * @return
     */
    public boolean isUseGuild() {
        return useGuild;
    }

    /**
     *
     * @param useGuild
     */
    public void setUseGuild(boolean useGuild) {
        this.useGuild = useGuild;
    }

    /**
     *
     * @return
     */
    public boolean isUseParty() {
        return useParty;
    }

    /**
     *
     * @param useParty
     */
    public void setUseParty(boolean useParty) {
        this.useParty = useParty;
    }

    /**
     *
     * @return
     */
    public int getDistance() {
        return distance;
    }

    /**
     *
     * @param distance
     */
    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    /**
     *
     * @return
     */
    public boolean isUseDistance() {
        return useDistance;
    }

    /**
     *
     * @param useDistance
     */
    public void setUseDistance(boolean useDistance) {
        this.useDistance = useDistance;
    }

    /**
     *
     * @return
     */
    public boolean isUseLanguage() {
        return useLanguage;
    }

    /**
     *
     * @param useLanguage
     */
    public void setUseLanguage(boolean useLanguage) {
        this.useLanguage = useLanguage;
    }

    /**
     *
     * @return
     */
    public boolean isUseBasic() {
        return useBasic;
    }

    /**
     *
     * @param useBasic
     */
    public void setUseBasic(boolean useBasic) {
        this.useBasic = useBasic;
    }

    /**
     *
     * @return
     */
    public boolean isSpyEnabled() {
        return spyEnabled;
    }

    /**
     *
     * @param spyEnabled
     */
    public void setSpyEnabled(boolean spyEnabled) {
        this.spyEnabled = spyEnabled;
    }

    /**
     *
     * @return
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     *
     * @param enabled
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Get a list of all player names of players currently online and in the chat channel
     *
     * @return - all online players in the chat channel
     */
    public List<String> getPlayersInChat() {
        return playersInChat;
    }

    /**
     * set the list of players in the channel
     *
     * @param playersInChat - List<String> of players to set as the channels players
     */
    public void setPlayersInChat(List<String> playersInChat) {
        this.playersInChat = playersInChat;
    }

    /**
     * Add a single player to the chat channel
     *
     * @param name - name of player to add to the channel
     */
    public void addPlayerToChat(String name){
        this.playersInChat.add(name);
    }

    /**
     * Remove a single player form the list of players in the chat channel
     *
     * @param name - name of player to remove
     */
    public void removePlayerFromChat(String name){
        this.playersInChat.remove(name);
    }

    /**
     * clear the list of players in the chat channel
     */
    public void clearPlayersFromChat(){
        this.playersInChat.clear();
    }
}
