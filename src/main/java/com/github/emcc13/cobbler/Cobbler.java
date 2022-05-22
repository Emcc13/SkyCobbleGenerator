package com.github.emcc13.cobbler;

import java.util.Map;

import com.github.emcc13.cobbler.Config.CobbleConfig;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class Cobbler extends JavaPlugin {
    Map<String, Object> cachedConfig;

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new OreGenListener(this), (Plugin) this);
        this.cachedConfig = CobbleConfig.getConfig(this);
    }

}
