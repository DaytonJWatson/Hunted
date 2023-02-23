package com.watsonllc.hunted.Commands.player;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.watsonllc.hunted.Utilities.Hunter;

public class Spawn implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		Player player = (Player) sender;

		if (cmd.getName().equalsIgnoreCase("hunter")) {
			// length = 8
			// /hunter type name armor weapon health speed strength
			//   cmd    0    1     2     3      4      5      6
			
			if(args.length == 1) {
				if(args[0].equalsIgnoreCase("spawn")) {
					Hunter.compileHunter(player);
					
					player.sendMessage("Hunter spawned!");
					player.sendMessage("   <Stats>   ");
					player.sendMessage("Type: " + Hunter.getType().toString());
					player.sendMessage("Name: " + Hunter.getName());
					player.sendMessage("Armor: " + Hunter.getArmor());
					player.sendMessage("Weapon: " + Hunter.getWeapon().toString());
					player.sendMessage("Health: " + Hunter.getHealth());
					player.sendMessage("Speed: " + Hunter.getSpeed());
					player.sendMessage("Strength: " + Hunter.getStrength());
					return true;
				}
				
			} else if(args.length == 3) {
				if(args[0].equalsIgnoreCase("set")) {
					if(args[1].equalsIgnoreCase("type")) {
						Hunter.setType(EntityType.valueOf(args[2]));
						player.sendMessage("Type: " + Hunter.getType().toString());
					}
						
					if(args[1].equalsIgnoreCase("name")) {
						Hunter.setName(args[2]);
						player.sendMessage("Name: " + Hunter.getName());
					}
						
					if(args[1].equalsIgnoreCase("armor")) {
						Hunter.setArmor(args[2].toUpperCase());
						player.sendMessage("Armor: " + Hunter.getArmor());
					}
						
					if(args[1].equalsIgnoreCase("weapon")) {
						Hunter.setWeapon(new ItemStack(Material.valueOf(args[2])));
						player.sendMessage("Weapon: " + Hunter.getWeapon().toString().replace("ItemStack{" + " x 1}", " "));
					}
						
					if(args[1].equalsIgnoreCase("health")) {
						Hunter.setHealth(args[2]);
						player.sendMessage("Health: " + Hunter.getHealth());
					}
						
					if(args[1].equalsIgnoreCase("speed")) {
						Hunter.setSpeed(args[2]);
						player.sendMessage("Speed: " + Hunter.getSpeed());
					}
						
					if(args[1].equalsIgnoreCase("strength")) {
						Hunter.setStrength(args[2]);
						player.sendMessage("Strength: " + Hunter.getStrength());
					}
				}
			}
		}
		return false;
	}
}