package com.watsonllc.hunted.Commands;

import com.watsonllc.hunted.Hunted;
import com.watsonllc.hunted.Commands.player.Spawn;

public class Commands {
	public static void setup() {
		Hunted.instance.getCommand("hunter").setExecutor(new Spawn());
	}
}
