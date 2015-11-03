package ch.k42.cropdrop;
/**
 * @author Thomas Richner
 * @created 07.02.14.
 * @license MIT
 */

import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Plugin extends JavaPlugin {

    @Override
    public void onEnable() {

        if (!hasConfig()) {
            saveDefaultConfig();
            getLogger().info("Creating default configuration.");
        }

        List<BlockBreakListener> listeners = new ArrayList<>();
        // add listeners
        getServer().getPluginManager().registerEvents(new CropListener(listeners), this);
    }

    @Override
    public void onDisable() {

    }

    //Checks if a config file exists
    private boolean hasConfig() {
        File file = new File(getDataFolder(), "config.yml");
        return file.exists();
    }
}