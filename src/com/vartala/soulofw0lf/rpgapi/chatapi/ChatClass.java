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



    public void  ChatClass(){

    }
    public void addBehavior(ChatBehavior behavior){

        channelBehaviors.add(behavior);
    }
    public void clearBehavior(){
        channelBehaviors.clear();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public boolean isChatSpy() {
        return chatSpy;
    }

    public void setChatSpy(boolean chatSpy) {
        this.chatSpy = chatSpy;
    }

    public List<ChatBehavior> getChannelBehaviors() {
        return channelBehaviors;
    }

    public void setChannelBehaviors(List<ChatBehavior> channelBehaviors) {
        this.channelBehaviors = channelBehaviors;
    }

    public Boolean getPrivateChat() {
        return privateChat;
    }

    public void setPrivateChat(Boolean privateChat) {
        this.privateChat = privateChat;
    }

    public List<String> getMutedPlayers() {
        return mutedPlayers;
    }

    public void setMutedPlayers(List<String> mutedPlayers) {
        this.mutedPlayers = mutedPlayers;
    }

    public List<String> getBannedPlayers() {
        return bannedPlayers;
    }

    public void setBannedPlayers(List<String> bannedPlayers) {
        this.bannedPlayers = bannedPlayers;
    }

    public String getChannelOwner() {
        return channelOwner;
    }

    public void setChannelOwner(String channelOwner) {
        this.channelOwner = channelOwner;
    }

    public String getChannelPassword() {
        return channelPassword;
    }

    public void setChannelPassword(String channelPassword) {
        this.channelPassword = channelPassword;
    }

    public List<String> getInvitedPlayers() {
        return invitedPlayers;
    }

    public void setInvitedPlayers(List<String> invitedPlayers) {
        this.invitedPlayers = invitedPlayers;
    }
}
