package com.github.emcc13.cobbler.Config;

import com.github.emcc13.cobbler.Generator;
import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;

public enum CobbleConfig implements ConfigInterface {
    overworld("overworld", "bskyblock_world"),
    netherworld("nether", "bskyblock_world_nether"),
    endworld("endworld", "bskyblock_world_the_end"),

    world_default_COBBLESTONE(CobbleConfig.overworld.value()+".default.COBBLESTONE", 7455),
    world_default_STONE(CobbleConfig.overworld.value()+".default.STONE", 1400),
    world_default_GRANITE(CobbleConfig.overworld.value()+".default.GRANITE", 200),
    world_default_DIORITE(CobbleConfig.overworld.value()+".default.DIORITE", 200),
    world_default_ANDESITE(CobbleConfig.overworld.value()+".default.ANDESITE", 200),
    world_default_TERRACOTTA(CobbleConfig.overworld.value()+".default.TERRACOTTA", 65),
    world_default_COAL_ORE(CobbleConfig.overworld.value()+".default.COAL_ORE", 100),
    world_default_REDSTONE_ORE(CobbleConfig.overworld.value()+".default.REDSTONE_ORE", 80),
    world_default_LAPIS_ORE(CobbleConfig.overworld.value()+".default.LAPIS_ORE", 80),
    world_default_IRON_ORE(CobbleConfig.overworld.value()+".default.IRON_ORE", 70),
    world_default_GOLD_ORE(CobbleConfig.overworld.value()+".default.GOLD_ORE", 45),
    world_default_COPPER_ORE(CobbleConfig.overworld.value()+".default.COPPER_ORE", 45),
    world_default_EMERALD_ORE(CobbleConfig.overworld.value()+".default.EMERALD_ORE", 45),
    world_default_DIAMOND_ORE(CobbleConfig.overworld.value()+".default.DIAMOND_ORE", 15),

    world_sub0_COBBLED_DEEPSLATE(CobbleConfig.overworld.value()+".<0.COBBLED_DEEPSLATE", 7055),
    world_sub0_DEEPSLATE(CobbleConfig.overworld.value()+".<0.DEEPSLATE", 1400),
    world_sub0_CALCITE(CobbleConfig.overworld.value()+".<0.CALCITE", 500),
    world_sub0_TUFF(CobbleConfig.overworld.value()+".<0.TUFF", 500),
    world_sub0_TERRACOTTA(CobbleConfig.overworld.value()+".<0.TERRACOTTA", 65),
    world_sub0_DEEPSLATE_COAL_ORE(CobbleConfig.overworld.value()+".<0.DEEPSLATE_COAL_ORE", 100),
    world_sub0_DEEPSLATE_REDSTONE_ORE(CobbleConfig.overworld.value()+".<0.DEEPSLATE_REDSTONE_ORE", 80),
    world_sub0_DEEPSLATE_LAPIS_ORE(CobbleConfig.overworld.value()+".<0.DEEPSLATE_LAPIS_ORE", 80),
    world_sub0_DEEPSLATE_IRON_ORE(CobbleConfig.overworld.value()+".<0.DEEPSLATE_IRON_ORE", 70),
    world_sub0_DEEPSLATE_COPPER_ORE(CobbleConfig.overworld.value()+".<0.DEEPSLATE_COPPER_ORE", 45),
    world_sub0_DEEPSLATE_GOLD_ORE(CobbleConfig.overworld.value()+".<0.DEEPSLATE_GOLD_ORE", 45),
    world_sub0_DEEPSLATE_EMERALD_ORE(CobbleConfig.overworld.value()+".<0.DEEPSLATE_EMERALD_ORE", 45),
    world_sub0_DEEPSLATE_DIAMOND_ORE(CobbleConfig.overworld.value()+".<0.DEEPSLATE_DIAMOND_ORE", 15),

    nether_default_NETHERRACK(CobbleConfig.netherworld.value()+".default.NETHERRACK", 7455),
    nether_default_NETHER_BRICKS(CobbleConfig.netherworld.value()+".default.NETHER_BRICKS", 1400),
    nether_default_NETHER_QUARTZ_ORE(CobbleConfig.netherworld.value()+".default.NETHER_QUARTZ_ORE", 360),
    nether_default_MAGMA_BLOCK(CobbleConfig.netherworld.value()+".default.MAGMA_BLOCK", 300),
    nether_default_COAL_ORE(CobbleConfig.netherworld.value()+".default.COAL_ORE", 100),
    nether_default_REDSTONE_ORE(CobbleConfig.netherworld.value()+".default.REDSTONE_ORE", 80),
    nether_default_LAPIS_ORE(CobbleConfig.netherworld.value()+".default.LAPIS_ORE", 80),
    nether_default_IRON_ORE(CobbleConfig.netherworld.value()+".default.IRON_ORE", 70),
    nether_default_NETHER_GOLD_ORE(CobbleConfig.netherworld.value()+".default.NETHER_GOLD_ORE", 25),
    nether_default_GILDED_BLACKSTONE(CobbleConfig.netherworld.value()+".default.GILDED_BLACKSTONE", 25),
    nether_default_COPPER_ORE(CobbleConfig.netherworld.value()+".default.COPPER_ORE", 45),
    nether_default_EMERALD_ORE(CobbleConfig.netherworld.value()+".default.EMERALD_ORE", 45),
    nether_default_DIAMOND_ORE(CobbleConfig.netherworld.value()+".default.DIAMOND_ORE", 15),

    end_default_END_STONE(CobbleConfig.endworld.value()+".default.END_STONE", 7455),
    end_default_PURPUR_BLOCK(CobbleConfig.endworld.value()+".default.PURPUR_BLOCK", 1400),
    end_default_PRISMARINE(CobbleConfig.endworld.value()+".default.PRISMARINE", 255),
    end_default_PRISMARINE_BRICKS(CobbleConfig.endworld.value()+".default.PRISMARINE_BRICKS", 225),
    end_default_DARK_PRISMARINE(CobbleConfig.endworld.value()+".default.DARK_PRISMARINE", 220),
    end_default_COAL_ORE(CobbleConfig.endworld.value()+".default.COAL_ORE", 100),
    end_default_REDSTONE_ORE(CobbleConfig.endworld.value()+".default.REDSTONE_ORE", 80),
    end_default_LAPIS_ORE(CobbleConfig.endworld.value()+".default.LAPIS_ORE", 80),
    end_default_IRON_ORE(CobbleConfig.endworld.value()+".default.IRON_ORE", 70),
    end_default_GOLD_ORE(CobbleConfig.endworld.value()+".default.GOLD_ORE", 45),
    end_default_COPPER_ORE(CobbleConfig.endworld.value()+".default.COPPER_ORE", 45),
    end_default_EMERALD_ORE(CobbleConfig.endworld.value()+".default.EMERALD_ORE", 45),
    end_default_DIAMOND_ORE(CobbleConfig.endworld.value()+".default.DIAMOND_ORE", 15),
    ;

    public final Object value;
    public final String key;

    CobbleConfig(String key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object value() {
        return this.value;
    }

//    public String key() {
//        return this.name().replace('$', '.').replace('ß', '-');
//    }

    public String key(){
        return this.key;
    }

    public static Map<String, Object> getConfig(Plugin plugin) {
        Map<String, Object> cachedConfig = new HashMap<>();
        plugin.reloadConfig();
        Configuration config = plugin.getConfig();
        String key;
        Object value;
        for (CobbleConfig entry : CobbleConfig.values()) {
            key = entry.key();
            value = config.get(key);
            if (value == null) {
                value = entry.value;
            }
            cachedConfig.put(key, value);
        }
        config.addDefaults(cachedConfig);
        config.options().copyDefaults(true);
        plugin.saveConfig();

        String world;
        world = config.getString(CobbleConfig.overworld.key(), (String) CobbleConfig.overworld.value());
        cachedConfig.put(world, getSubConfig(config.getConfigurationSection(world)));

        world = config.getString(CobbleConfig.netherworld.key(), (String) CobbleConfig.netherworld.value());
        cachedConfig.put(world, getSubConfig(config.getConfigurationSection(world)));

        world = config.getString(CobbleConfig.endworld.key(), (String) CobbleConfig.endworld.value());
        cachedConfig.put(world, getSubConfig(config.getConfigurationSection(world)));

        return cachedConfig; //(cachedConfig);
    }

    private static Map<String, Generator> getSubConfig(ConfigurationSection cs) {
        Map<String, Generator> sub_conf = new HashMap<String, Generator>();
        try {
            for (String sub_key : cs.getKeys(false)) {
                sub_conf.put(sub_key, new Generator(sub_key, cs.getConfigurationSection(sub_key)));
            }
        } catch (NullPointerException exception) {
        }
        return sub_conf;
    }

//    private static Map<Object, Object> convertConfig(Map<String, Object> cachedConfig) {
//        Map<Object, Object> converted_conf = new HashMap<>();
//        String overworld = (String) cachedConfig.get(CobbleConfig.overworld.key());
//        converted_conf.put(CobbleConfig.overworld.key(), overworld);
//
//
//        String netherworld = (String) cachedConfig.get(CobbleConfig.netherworld.key());
//        converted_conf.put(CobbleConfig.netherworld.key(), netherworld);
//
//        String endworld = (String) cachedConfig.get(CobbleConfig.endworld.key());
//        converted_conf.put(CobbleConfig.endworld.key(), endworld);
//
//        return converted_conf;
//    }

}
