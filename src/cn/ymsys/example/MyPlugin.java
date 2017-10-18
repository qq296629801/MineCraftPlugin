package cn.ymsys.example;

import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		// TODO Insert logic to be performed when the plugin is enabled
		getLogger().info("onEnable has been invoked!");
		getServer().getPluginManager().registerEvents(new MyListener(), this);
	}

	@Override
	public void onDisable() {
		// TODO Insert logic to be performed when the plugin is disabled
		getLogger().info("onDisable has been invoked!");
	}

}
