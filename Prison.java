package me.Beastly.Plugin;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{
	//Prefix ChatColor.GREEN + "[" + ChatColor.AQUA + "Prison" + ChatColor.GREEN + "]"
	
	public void onDisabled(){
		getLogger().info("Prison Has Been Disabled");
	}

	public void onEnabled(){
		getLogger().info("Prison Has Been Enabled");
		if(!new File(this.getDataFolder(),"config.yml").exists()){
			this.saveDefaultConfig();
		}
		if(!new File(this.getDataFolder(), "README.txt").exists()){
		}
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		if(cmd.getName().equalsIgnoreCase("Prisonreload")){
		Player p = (Player) sender;
		reloadConfig();
		p.sendMessage(ChatColor.GREEN + "[" + ChatColor.AQUA + "Prison" + ChatColor.GREEN + "]" + ChatColor.BLUE + "Reloaded " + ChatColor.GREEN + "Successfully");
		return true;
		}else if(cmd.getName().equalsIgnoreCase("Prisonbc")){
				String toBroadcast = "";
				for (String s : args){
					if(s != ""){
						toBroadcast = toBroadcast + s + " ";
					}
				}
				
				Bukkit.broadcastMessage(getConfig().getString("prefix").replaceAll("&8", ChatColor.DARK_GRAY + "").replaceAll("&l", ChatColor.BOLD + "").replaceAll("&9", ChatColor.BLUE + "") + " " + toBroadcast);
				return true;
		}else if(cmd.getName().equalsIgnoreCase("Prisonkick")){
			Player p = (Player) sender;
			String toBroadcast = "";
			for (String s : args){
				if(s != ""){
					toBroadcast = toBroadcast + s + " ";
				}
			}
			p.getPlayer().setExp(0);
			p.kickPlayer(toBroadcast);
			return true;
		}
		return false;
	}
}
