package com.github.stoneskies.VillagerPerms;

import com.palmergames.bukkit.towny.object.TownyPermission;
import com.palmergames.bukkit.towny.utils.PlayerCacheUtil;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VPMain implements Listener {

    public void onVillagerInteract(PlayerInteractEntityEvent event) {
        Entity entity = event.getRightClicked();
        Player player = event.getPlayer();
        Block block = player.getLocation().getBlock();
        if (entity.getType() == EntityType.VILLAGER) {
            boolean bBuild = PlayerCacheUtil.getCachePermission(player, player.getLocation(), block.getType(), TownyPermission.ActionType.ITEM_USE);
            if (!bBuild) {
                event.setCancelled(true);
            }
        }
    }
}
