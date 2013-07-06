package project.common;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbyStuff extends JavaPlugin implements Listener{

	  @EventHandler
	  public void onPlayerJoin(PlayerJoinEvent e)
	  {
	    Player p = e.getPlayer();
	    PlayerInventory pi = p.getInventory();
	    if(!p.hasPermission("lobby.inventory") || (!p.isOp())) {
	    pi.clear();
	    }
	    if(!p.hasPermission("lobby.spawn") || (!p.isOp())){
	    p.teleport(p.getWorld().getSpawnLocation());
	    }
	  }

	  public void onEnable() {
	    PluginManager pm = Bukkit.getServer().getPluginManager();
	    pm.registerEvents(this, this);
	  }

	  public void onDisable()
	  {
	  }
	}