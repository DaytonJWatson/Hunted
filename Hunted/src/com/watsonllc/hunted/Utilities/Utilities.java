package com.watsonllc.hunted.Utilities;

import java.util.HashMap;

import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;

public class Utilities {
	public static void setup() {
		create();
	}
	
	private static HashMap<Player, Mob> hunter;
	
	public static void create() {
		hunter = new HashMap<>();
	}
	
	public static boolean isRunning(Player player) {
		if(hunter.containsKey(player)) 
			return true;
		return false;
	}
	
	public static void setHunter(Player player, Mob mob) {
		if(isRunning(player)) {
			return;
		} else hunter.put(player, mob);
	}
	
	public static void removeHunter(Player player) {
		if(isRunning(player)) {
			hunter.remove(player);
		} else return;
	}
	
	public static Mob getMob(Player player) {
		return hunter.get(player);
	}
}
