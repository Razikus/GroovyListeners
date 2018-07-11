/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.razniewski.groovylisteners;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.codehaus.groovy.control.CompilationFailedException;

/**
 *
 * @author edge
 */
public class GroovyListenersPlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Loading...");
        GroovyInterface loader = new GroovyListenerLoader();
        FileUtils.createDirectoryIfNotExists(getDataFolder());
        List<String> paths = new ArrayList<>();
        try {
            
            paths = FileUtils.getAllFilesFromDirectory(getDataFolder());
        } catch (IOException ex) {
            Logger.getLogger(GroovyListenersPlugin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(String path: paths) {
            try {
                Listener loaded = loader.compileAndGetInstance(path);
                getServer().getPluginManager().registerEvents(loaded, this);
                getLogger().info(loaded.getClass().getCanonicalName() + " loaded!");
            } catch (CompilationFailedException ex) {
                getLogger().info("Compilation failed! " + ex.getMessage());
            } catch (IOException ex) {
                getLogger().info("Something wrong with file! " + ex.getMessage());
            } catch (InstantiationException ex) {
                getLogger().info("Cannot instance groovy class. It is implements Listener? " + ex.getMessage());
            } catch (IllegalAccessException ex) {
                getLogger().info("Cannot instance groovy class. It is implements Listener and have public constructor with no parameters? " + ex.getMessage());
            }
        }
        
        
        getLogger().info("Loaded");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabling...");
        getLogger().info("Disabled");
    }
    
    public static GroovyListenersPlugin getInstance() {
        Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("GroovyListenersPlugin");
        if (plugin == null || !(plugin instanceof GroovyListenersPlugin)) {
            throw new RuntimeException("GroovyListenersPlugin not found");
        }
 
        return ((GroovyListenersPlugin) plugin);
    }
    
}
