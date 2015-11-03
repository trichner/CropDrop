package ch.k42.cropdrop;

import org.bukkit.Material;
import org.bukkit.block.Block;

/**
 * @author Thomas
 * @version radio-tower-plugin 03.11.2015.
 */
public interface BlockBreakListener {
    Material getMaterial();
    boolean onBlockBreak(Block block);
}
