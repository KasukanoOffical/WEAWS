package net.yyh.WEAWS;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	@Override
	public void onEnable() {
		String message = pluginMessage();
		message += ChatColor.GREEN + ">> Welcome to";
		message += ChatColor.RESET + " use WorldEdit Addition of ";
		message += ChatColor.AQUA + "" + ChatColor.BOLD + "Watersuno" + ChatColor.RESET + "!";

		getServer().getConsoleSender().sendMessage(message);

		// Registering the Commands.
		commandsRegister();
	}

	public void onDisable() {
		String message = pluginMessage();
		message += ChatColor.RED + "<< Thanks for";
		message += ChatColor.RESET + " use WorldEdit Addition of ";
		message += ChatColor.AQUA + "" + ChatColor.BOLD + "Watersuno" + ChatColor.RESET + "!";

		getServer().getConsoleSender().sendMessage(message);
	}

	public static String pluginMessage() {
		String message = "[" + ChatColor.RED + "" + ChatColor.BOLD + "WEAWS" + ChatColor.RESET + "] ";
		return message;
	}

	public void commandsRegister() {
		getCommand("WEAWS").setExecutor(new Commands());
		
		//Gamemode switcher
		getCommand("g").setExecutor(new Commands());
		getCommand("/gm").setExecutor(new Commands());
		getCommand("gm0").setExecutor(new Commands());
		getCommand("gm1").setExecutor(new Commands());
		getCommand("gm2").setExecutor(new Commands());
		getCommand("gm3").setExecutor(new Commands());

		// WorldEdit commands alias
		getCommand("/st").setExecutor(new Commands());
		getCommand("/mo").setExecutor(new Commands());
		getCommand("/sh").setExecutor(new Commands());
		getCommand("/exp").setExecutor(new Commands());
		getCommand("/con").setExecutor(new Commands());
		getCommand("/far").setExecutor(new Commands());
		
		getCommand("cuboid").setExecutor(new Commands());
		getCommand("extend").setExecutor(new Commands());
		getCommand("poly").setExecutor(new Commands());
		getCommand("ellipsoid").setExecutor(new Commands());
		getCommand("convex").setExecutor(new Commands());
		getCommand("polyherdral").setExecutor(new Commands());
		getCommand("cu").setExecutor(new Commands());
		
		getCommand("/gamsk").setExecutor(new Commands());
		getCommand("/un").setExecutor(new Commands());
		getCommand("/red").setExecutor(new Commands());
		
		// Additional WorldEdit commands
		getCommand("makeland").setExecutor(new Commands());
		getCommand("cuttree").setExecutor(new Commands());
		getCommand("nearcuttree").setExecutor(new Commands());
		getCommand("chunkregen").setExecutor(new Commands());

	}
}
