package ch.k42.cropdrop;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockFromToEvent;
import org.bukkit.event.block.BlockPistonExtendEvent;

import java.util.Collection;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author Thomas
 * @version radio-tower-plugin 03.11.2015.
 */
public class CropListener implements Listener {

    private Random random = new Random();

    private Map<Material,BlockBreakListener> listeners;

    public CropListener(Collection<BlockBreakListener> listeners) {
        this.listeners = listeners.stream().collect(Collectors.toMap(BlockBreakListener::getMaterial, Function.identity()));
    }

    private boolean handleBlockBreak(Block block){
        boolean cancelled = false;
        if(block!=null){
            BlockBreakListener listener = listeners.get(block.getType());
            if(listener!=null) {
                cancelled = listener.onBlockBreak(block);
            }
        }
        return cancelled;
    }

    @EventHandler
    public void onBlockFromTo(BlockFromToEvent event) {
        final Block block = event.getToBlock();
        event.setCancelled(handleBlockBreak(block));
    }

    @EventHandler
    public void onBlockPistonExtend(BlockPistonExtendEvent event) {
        final Block block = event.getBlock().getRelative(event.getDirection());
        event.setCancelled(handleBlockBreak(block));
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final Block block = event.getBlock();
        event.setCancelled(handleBlockBreak(block));
    }
}