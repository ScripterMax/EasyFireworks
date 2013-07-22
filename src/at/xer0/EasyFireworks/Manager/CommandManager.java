package at.xer0.EasyFireworks.Manager;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import at.xer0.EasyFireworks.util.CommandDistributer;

public class CommandManager implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command command,
			String label, String[] args) {

		if (sender instanceof Player) {

			Player p = (Player) sender;

			CommandDistributer cmd = new CommandDistributer(p, args);

			if (args.length == 1) {
				if (args[0].equalsIgnoreCase("lists")) {
					cmd.lists();
				} else if (args[0].equalsIgnoreCase("colors")) {
					cmd.colors();
				} else if (args[0].equalsIgnoreCase("effects")) {
					cmd.effects();
				} else if (args[0].equalsIgnoreCase("power")) {
					cmd.power();
				} else if (args[0].equalsIgnoreCase("usage")) {
					cmd.usage();
				} else if (args[0].equalsIgnoreCase("fillup")) {

					if (p.hasPermission("firework.*")
							|| p.hasPermission("firework.fillup"))
						cmd.fillup();
					else
						p.sendMessage(ChatColor.RED
								+ "You don't have permission to do this!");
				} else {
					cmd.help();
				}

			} else if (args.length == 6) {

				if (args[0].equalsIgnoreCase("give")) {

					if (p.hasPermission("firework.*")
							|| p.hasPermission("firework.give"))
						cmd.givedef();
					else
						p.sendMessage(ChatColor.RED
								+ "You don't have permission to do this!");
				} else
					cmd.help();
			} else if (args.length == 4) {
				if (args[0].equalsIgnoreCase("give")
						&& args[3].equalsIgnoreCase("random")) {
					if (p.hasPermission("firework.*")
							|| p.hasPermission("firework.give"))
						cmd.giverandom();
					else
						p.sendMessage(ChatColor.RED
								+ "You don't have permission to do this!");
				} else
					cmd.help();

			} else if (args.length == 5) {
				if (args[0].equalsIgnoreCase("get")) {
					if (p.hasPermission("firework.*")
							|| p.hasPermission("firework.get"))
						cmd.getdef();
					else
						p.sendMessage(ChatColor.RED
								+ "You don't have permission to do this!");
				} else
					cmd.help();

			} else if (args.length == 3) {
				if (args[0].equalsIgnoreCase("get")
						&& args[2].equalsIgnoreCase("random")) {
					if (p.hasPermission("firework.*")
							|| p.hasPermission("firework.get"))
						cmd.getrandom();
					else
						p.sendMessage(ChatColor.RED
								+ "You don't have permission to do this!");
				} else
					cmd.help();

			} else {

				cmd.help();
			}

		}

		else {

			CommandDistributer cmd = new CommandDistributer(null, args);

			if (args.length == 6)

			{
				if (args[0].equalsIgnoreCase("give")) {

					cmd.server_givedef();
				} else
					cmd.help();

			} else if (args.length == 4) {
				if (args[0].equalsIgnoreCase("give")) {

					if (args[3].equalsIgnoreCase("random")) {
						cmd.server_giverandom();
					} else
						cmd.help();

				}
			} else {
				cmd.server_help();
			}

		}

		return true;
	}
}
