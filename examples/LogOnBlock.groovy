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
