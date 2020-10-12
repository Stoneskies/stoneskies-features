package com.github.stoneskies.VillagerPerms;

import com.palmergames.bukkit.towny.object.TownyPermission;
import com.palmergames.bukkit.towny.utils.PlayerCacheUtil;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerHarvestBlockEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class VPMain implements Listener {

    @EventHandler
    public void onVillagerInteract(PlayerInteractEntityEvent event) {
        Player player = event.getPlayer();
        if (event.getRightClicked() instanceof Villager) {
            boolean hasperms = PlayerCacheUtil.getCachePermission(player, player.getLocation(), Material.CHEST, TownyPermission.ActionType.SWITCH);
            if (!hasperms) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6You don't have permissions to trade with villagers here."));
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBerryBush(PlayerHarvestBlockEvent event) {
        Player player = event.getPlayer();
        boolean hasperms = PlayerCacheUtil.getCachePermission(player, player.getLocation(), Material.CHEST, TownyPermission.ActionType.SWITCH);
        if(event.getHarvestedBlock().getType() == Material.SWEET_BERRY_BUSH) {
            if(!hasperms) {
                event.setCancelled(true);
            }
        }
    }
}
