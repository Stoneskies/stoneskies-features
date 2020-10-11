package com.github.stoneskies;

import com.github.stoneskies.VillagerPerms.VPMain;
import org.bukkit.plugin.java.JavaPlugin;

public class FeaturesMain extends JavaPlugin {

    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new VPMain(), this);
    }

    public void onDisable() {

    }
}
