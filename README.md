# Purpouse
Simplify adding new listeners into Bukkit system.

# Usage
Write your Groovy script, then put into GroovyListenersPlugin folder in plugins. All of them will be loaded

# Example
``` 
import org.bukkit.event.Listener
import org.bukkit.event.EventHandler
import org.bukkit.event.block.BlockPlaceEvent
import org.bukkit.Bukkit;

class TestListener implements Listener {

	@EventHandler
	public void onBlockPlacement(BlockPlaceEvent e) {
	        eu.razniewski.groovylisteners.GroovyListenersPlugin.getInstance().getLogger().info("test222");
		      Bukkit.getLogger().info("test omg")
	}

}
```

This listener will run when somebody will put block on the world. You have access to whole system, so you can write everything.
Save this example as example.groovy and put it on plugins/GroovyListenersPlugin/, then restart your server. That's all!


