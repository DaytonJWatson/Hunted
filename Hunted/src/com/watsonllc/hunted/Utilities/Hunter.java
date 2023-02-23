package com.watsonllc.hunted.Utilities;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Mob;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import com.watsonllc.hunted.Hunted;

public class Hunter {
	
	//new Location(Bukkit.getWorld("world"), 0.5,
	//Bukkit.getWorlds().get(1).getHighestBlockAt(0, 0).getY(), 0.5)

	private static EntityType Type = EntityType.ZOMBIE;
	private static String Name = "defaultHunter";
	private static String Armor = "null";
	private static Location spawnLoc;
	private static ItemStack Weapon = new ItemStack(Material.WOODEN_SWORD);
	private static double Health = 20.0;
	private static double Speed = 0.3;
	private static double Strength = 2.0;

	private static AttributeInstance damageAttribute;
	private static AttributeInstance healthAttribute;
	private static AttributeInstance speedAttribute;

	public static void compileHunter(Player player) {
		Location loc = player.getLocation();
		World world = loc.getWorld();
		LivingEntity type = (LivingEntity) world.spawnEntity(loc, Type);
		
		damageAttribute = type.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
		healthAttribute = type.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		speedAttribute = type.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
		// setupName
		type.setCustomName(Name);
		type.setCustomNameVisible(true);
		// setupArmor
		type.getEquipment().setItemInMainHand(Weapon);
		if (Armor != "null") {
			type.getEquipment().setBoots(new ItemStack(Material.valueOf(Armor + "_BOOTS")));
			type.getEquipment().setLeggings(new ItemStack(Material.valueOf(Armor + "_LEGGINGS")));
			type.getEquipment().setChestplate(new ItemStack(Material.valueOf(Armor + "_CHESTPLATE")));
			type.getEquipment().setHelmet(new ItemStack(Material.valueOf(Armor + "_HELMET")));
			type.getEquipment().setItemInMainHand(Weapon);
		}
		// setupAttributes
		damageAttribute.setBaseValue(Strength);
		healthAttribute.setBaseValue(Health);
		speedAttribute.setBaseValue(Speed);

		new BukkitRunnable() {
			@Override
			public void run() {
				((Mob) type).setTarget(player);
			}
		}.runTaskTimer(Hunted.instance, 0L, 600L);
	}

	// getters and setters
	public static EntityType getType() {
		return Type;
	}

	public static void setType(EntityType type) {
		Type = type;
	}

	public static String getName() {
		return Name;
	}

	public static void setName(String name) {
		Name = name;
	}

	public static String getArmor() {
		return Armor;
	}

	public static void setArmor(String armor) {
		Armor = armor;
	}

	public static ItemStack getWeapon() {
		return Weapon;
	}

	public static void setWeapon(ItemStack weapon) {
		Weapon = weapon;
	}

	public static double getHealth() {
		return Health;
	}

	public static void setHealth(String health) {
		Health = Double.parseDouble(health);
	}

	public static double getSpeed() {
		return Speed;
	}

	public static void setSpeed(String speed) {
		Speed = Double.parseDouble(speed);
	}

	public static double getStrength() {
		return Strength;
	}

	public static void setStrength(String string) {
		Strength = Double.parseDouble(string);
	}

	public static Location getSpawnLoc() {
		return spawnLoc;
	}

	public static void setSpawnLoc(Location spawnLoc) {
		Hunter.spawnLoc = spawnLoc;
	}
}
