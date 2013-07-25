package com.vartala.soulofw0lf.rpgapi.listenersapi;

import com.vartala.soulofw0lf.rpgapi.RpgAPI;
import com.vartala.soulofw0lf.rpgapi.minionapi.MinionGui;
import com.vartala.soulofw0lf.rpgapi.entityapi.api.RemoteEntity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class MobEditingListener implements Listener {
    RpgAPI rRA;

    /**
     *
     * @param RA
     */
    public MobEditingListener(RpgAPI RA) {
        rRA = RA;
        Bukkit.getPluginManager().registerEvents(this, this.rRA);
    }

    /**
     *
     * @param event
     */
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerInteractEntityEvent(PlayerInteractEntityEvent event) {
        if (!RpgAPI.minionsOn) {
            return;
        }
        Player who = event.getPlayer();
        Entity clickedEntity = event.getRightClicked();
        who.sendMessage("You've interacted with an entity.");
        if (who.isSneaking()) {
            if (who.isOp()) {
                if (clickedEntity.getType().isAlive()) {
                    RemoteEntity rm = RpgAPI.entityManager.getRemoteEntityFromEntity((LivingEntity) clickedEntity);
                    who.sendMessage("You've attempted to access remoteentity:" + rm.getID());
                    MinionGui.createGui(who, 1, rm.getID());

                }
            }
        }

    }
}
