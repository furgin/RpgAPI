package com.vartala.soulofw0lf.rpgapi.listenersapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.minionapi.MinionGui;
import de.kumpelblase2.remoteentities.api.RemoteEntity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

/**
 * Created with IntelliJ IDEA.
 * User: links
 * Date: 6/19/13
 * Time: 4:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class MobEditingListener implements Listener {
    RpgAPI rRA;
    public MobEditingListener(RpgAPI RA)
    {
        rRA = RA;
        Bukkit.getPluginManager().registerEvents(this, this.rRA);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteractEntityEvent (PlayerInteractEntityEvent event)
    {
        Player who = event.getPlayer();
        Entity clickedEntity = event.getRightClicked();
        who.sendMessage("You've interacted with an entity.");
        if(who.isSneaking())
        {
            if (who.getPlayerListName().equalsIgnoreCase("linksbro"))
            {
                if(clickedEntity.getType().isAlive())
                {
                    RemoteEntity rm = RpgAPI.entityManager.getRemoteEntityFromEntity((LivingEntity)clickedEntity);
                    who.sendMessage("You've attempted to access remoteentity:"+rm.getID());
                    MinionGui.createGui(who,1,rm.getID());

                }
            }
        }

    }
}
