package com.github.emcc13.cobbler;

import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.plugin.Plugin;

public class OreGenListener implements Listener {
    private Cobbler og;

    private final BlockFace[] faces;

    public OreGenListener(Cobbler cobbler) {
        this.faces = new BlockFace[]{BlockFace.SELF, BlockFace.UP, BlockFace.DOWN, BlockFace.NORTH, BlockFace.EAST, BlockFace.SOUTH, BlockFace.WEST};
        this.og = cobbler;
    }

    @EventHandler
    public void onBlockBreakEvent(BlockBreakEvent event) {
        final Block b = event.getBlock();
        String w = b.getWorld().getName();
        if (!this.og.cachedConfig.containsKey(w)) {
            return;
        }
        World.Environment e = b.getWorld().getEnvironment();
        if (!(((e != World.Environment.NETHER) && canGenerate(b)) ||
                ((e == World.Environment.NETHER) && canGenerateNether(b)))) {
            return;
        }
        Material m = Material.COBBLESTONE;
        Material tmp;
        for (Generator gen : ((Map<String, Generator>)this.og.cachedConfig.get(w)).values()){
            tmp = gen.getMaterial(b.getY());
            if (tmp != null){
                m = tmp;
                break;
            }
        }
        final Material matf = m;
        Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this.og, new Runnable() {
            public void run() {
                b.setType(matf);
            }
        }, 2L);
    }

    @EventHandler
    public void onFromTo(final BlockFromToEvent event) {
        final Block block = event.getToBlock();
        if (!block.getType().equals(Material.AIR)){
            return;
        }
        if (!this.og.cachedConfig.containsKey(block.getWorld().getName())){
            return;
        }
        World.Environment environment = block.getWorld().getEnvironment();
        if (!(((environment != World.Environment.NETHER) && canGenerate(block)) ||
                ((environment == World.Environment.NETHER) && canGenerateNether(block)))) {
            return;
        }

        for (Entity entity : block.getChunk().getEntities()){
            if (entity instanceof org.bukkit.entity.Player){
                Bukkit.getScheduler().scheduleSyncDelayedTask((Plugin) this.og, new Runnable() {
                    public void run() {
                        if (environment == World.Environment.NETHER)
                            event.getToBlock().setType(Material.NETHERRACK);
                        else
                            event.getToBlock().setType(Material.COBBLESTONE);
                    }
                }, 3L);
                event.setCancelled(true);
                return;
            }
        }
    }

    private boolean canGenerate(Block b) {
        boolean lava = false;
        boolean water = false;
        BlockFace[] faces;
        for (int length = (faces = this.faces).length, i = 0; i < length; i++) {
            BlockFace face = faces[i];
            Block r = b.getRelative(face, 1);
            if (r.getType().equals(Material.LAVA)) {
                lava = true;
            } else if (r.getType().equals(Material.WATER)) {
                water = true;
            }
        }
        if (lava && water)
            return true;
        return false;
    }

    private boolean canGenerateNether(Block b) {
        boolean lava = false;
        boolean water = false;
        BlockFace[] faces;
        for (int length = (faces = this.faces).length, i = 0; i < length; i++) {
            BlockFace face = faces[i];
            Block r = b.getRelative(face, 1);
            if (r.getType().equals(Material.LAVA)) {
                lava = true;
            } else if (r.getType().equals(Material.BLUE_ICE)) {
                water = true;
            }
        }
        if (lava && water)
            return true;
        return false;
    }
}
