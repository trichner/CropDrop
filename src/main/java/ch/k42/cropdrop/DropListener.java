package ch.k42.cropdrop;

import ch.k42.rand.WeightedItem;
import ch.k42.rand.WeightedRandom;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * @author Thomas
 * @version radio-tower-plugin 03.11.2015.
 */
public class DropListener implements BlockBreakListener {

    private final Material material;
    private final int data;
    private WeightedRandom<List<ItemStack>> rand;

    public DropListener(Material material, int data,
                        List<WeightedItem<List<ItemStack>>> weightedItems) {
        this.material = material;
        this.data = data;
        this.rand = new WeightedRandom<>(weightedItems);
    }

    @Override
    public Material getMaterial() {
        return this.material;
    }

    @Override
    public boolean onBlockBreak(Block block) {

        if (block.getData() == this.data) {
            List<ItemStack> drops = rand.next();
            World w = block.getWorld();
            Location l = block.getLocation();
            for (ItemStack i : drops) {
                w.dropItemNaturally(l, i);
            }
        }

        return true;
    }
}
