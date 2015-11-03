package ch.k42.cropdrop.config;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

/**
 * @author Thomas
 * @version radio-tower-plugin 03.11.2015.
 */
public class DropBag {
    private Material type = null;
    private short damage = 0;
    private int amount = 0;

    private transient ItemStack stack;

    public ItemStack getItemStack(){
        if(stack == null) {
            stack = new ItemStack(type, amount, damage);
        }
        return stack;
    }
}
