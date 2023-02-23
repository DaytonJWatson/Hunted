package com.watsonllc.hunted;

import org.bukkit.plugin.java.JavaPlugin;

import com.watsonllc.hunted.Commands.Commands;
import com.watsonllc.hunted.Utilities.Utilities;

public class Hunted extends JavaPlugin {

	public static Hunted instance;
	
	@Override
	public void onEnable() {
		instance = this;
		
		Utilities.setup();
		Commands.setup();
	}
	
	@Override
	public void onDisable() {
		
	}
	
}
