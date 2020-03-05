package net.yyh.WEAWS;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {
	String message = Main.pluginMessage();
	Player player;
	boolean debug = false;

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		boolean done;
		if (sender instanceof Player) {
			this.player = (Player) sender;
			done = commandCondition(this.player, command.getName(), label, args);

		} else {
			sender.sendMessage(message + "此插件的命令只能在遊戲內輸入！Commands can only be used by player!");
			done = true;
		}

		// If the player (or console) uses our command correct, we can return true
		return done;
	}

	public boolean invalid() {
		this.player.sendMessage(message + "輸入無效！ Invaild input!");
		this.player.sendMessage(message + "用法如下：");
		return false;
	}

	public boolean gameModeSwitcher(Player player, int mode) {
		if (mode >= 0 && mode <= 3) {
			GameMode[] gamemodes = { GameMode.SURVIVAL, GameMode.CREATIVE, GameMode.ADVENTURE, GameMode.SPECTATOR };
			String[] gamemodeTexts = { "生存", "創造", "冒險", "旁觀" };
			player.setGameMode(gamemodes[mode]);
			player.sendMessage(message + "轉換為 " + ChatColor.RED + gamemodeTexts[mode] + "模式 " + ChatColor.RESET + "!");
			return true;
		} else {
			return invalid();
		}
	}

	public boolean commandCondition(Player player, String command, String label, String[] args) {
		// debug
		if (debug == true) {
			player.sendMessage(message + "Command: " + command);
		}

		// Plugin command
		if ("WEAWS".equalsIgnoreCase(command)) {
			String messageText = this.message;
			messageText += ChatColor.GREEN + ">> Welcome to";
			messageText += ChatColor.RESET + " use WorldEdit Addition of ";
			messageText += ChatColor.AQUA + "" + ChatColor.BOLD + "Watersuno" + ChatColor.RESET + "!";
			player.sendMessage(messageText);

			if (args.length > 0) {
				if ("debug".equalsIgnoreCase(args[0])) {
					if (args.length > 1) {
						if ("true".equalsIgnoreCase(args[1])) {
							this.debug = true;
						} else {
							this.debug = false;
						}
					} else {
						this.debug = !this.debug;
					}

					String text = message + "Debug mode switch to ";
					if (this.debug == true) {
						text += ChatColor.GREEN;
					} else {
						text += ChatColor.RED;
					}
					text += this.debug;
					player.sendMessage(text);
				} else if ("help".equalsIgnoreCase(args[0])) {
					player.sendMessage(message + "Being Maintenance, coming Soon!");
				}
			}
		}

		// Gamemode switcher
		if ("g".equalsIgnoreCase(command)) {
			boolean done = false;
			if (args.length == 1) {
				if ("m".equalsIgnoreCase(args[0].substring(0, 1))) {
					try {
						int mode = Integer.parseInt(args[0].substring(1));
						done = gameModeSwitcher(player, mode);
					} catch (java.lang.NumberFormatException e) {
						// Invalid.
					}
				}
			}

			if (done) {
				return true;
			} else {
				invalid();
			}
		}

		if ("/gm".equalsIgnoreCase(command)) {
			boolean done = false;
			if (args.length == 1) {
				try {
					int mode = Integer.parseInt(args[0]);
					done = gameModeSwitcher(player, mode);
				} catch (java.lang.NumberFormatException e) {
					// Invalid.
				}
			}

			if (done) {
				return true;
			} else {
				invalid();
			}
		}

		try {
			String gText = command.substring(0, 3);
			if (gText.substring(0, 2).equalsIgnoreCase("gm")) {
				boolean done = false;
				if (args.length == 0) {
					try {
						int mode = Integer.parseInt(gText.substring(2));
						done = gameModeSwitcher(player, mode);
					} catch (java.lang.NumberFormatException e) {
						// Invalid.
					}
				}

				if (done) {
					return true;
				} else {
					invalid();
				}
			}
		} catch (java.lang.IndexOutOfBoundsException e) {
			// Do nothing.
		}

		// WorldEdit commands alias
		// stack
		if ("/st".equalsIgnoreCase(command)) {
			String performCommand = "/stack";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// move
		if ("/mo".equalsIgnoreCase(command)) {
			String performCommand = "/move";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// shift
		if ("/sh".equalsIgnoreCase(command)) {
			String performCommand = "/shift";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// expand
		if ("/exp".equalsIgnoreCase(command)) {
			String performCommand = "/expand";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// contract
		if ("/con".equalsIgnoreCase(command)) {
			String performCommand = "/contract";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// farwand
		if ("/far".equalsIgnoreCase(command)) {
			String performCommand = "tool farwand";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// sel (seletion area)
		if ("cuboid".equalsIgnoreCase(command) || "extend".equalsIgnoreCase(command) || "poly".equalsIgnoreCase(command)
				|| "ellipsoid".equalsIgnoreCase(command) || "convex".equalsIgnoreCase(command)
				|| "polyherdral".equalsIgnoreCase(command)) {
			String performCommand = "/sel " + command;
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		if ("cu".equalsIgnoreCase(command)) {
			String performCommand = "/sel cuboid";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// gmask
		if ("/gamsk".equalsIgnoreCase(command)) {
			String performCommand = "/gmask";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// undo
		if ("/un".equalsIgnoreCase(command)) {
			String performCommand = "/undo";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// redo
		if ("/red".equalsIgnoreCase(command)) {
			String performCommand = "/redo";
			for (String arg : args) {
				performCommand += " " + arg;
			}
			player.performCommand(performCommand);
		}

		// Additional WorldEdit commands
		// makeland
		if ("makeland".equalsIgnoreCase(command)) {
			if (args.length != 0) {
				String performCommand = "/replace 0,6,8,9,10,11,12,13,17,18,30,31,32,37,38,39,40,51,78,79,81,83,86,99,100,103,106,111,127,161,162,174,175";
				for (String arg : args) {
					performCommand += " " + arg;
				}
				player.performCommand(performCommand);
			} else {
				invalid();
			}
		}

		// cuttree
		if ("cuttree".equalsIgnoreCase(command)) {
			String performCommand = "/replace 6,17,18,30,31,32,37,38,39,40,51,78,81,83,83,86,99,100,103,104,105,106,111,115,127,161,162,175 0";
			player.performCommand(performCommand);
		}

		// nearcuttree
		if ("nearcuttree".equalsIgnoreCase(command)) {
			if (args.length == 1) {
				String performCommand = "/replacenear";
				performCommand += " " + args[0] + " ";
				performCommand += "6,17,18,30,31,32,37,38,39,40,51,78,81,83,83,86,99,100,103,104,105,106,111,115,127,161,162,175 0";
				player.performCommand(performCommand);
			} else {
				invalid();
			}
		}

		// chunkregen
		if ("chunkregen".equalsIgnoreCase(command)) {
			player.performCommand("/chunk");
			player.performCommand("/regen");
		}

		// Output of commandCondition();: If command is executed correctly.
		return true;
	}
}
