package com.vartala.soulofw0lf.rpgapi.entityapi.api.features;

import org.bukkit.inventory.Inventory;

public interface InventoryFeature extends Feature
{
	/**
	 * Gets the inventory
	 *
	 * @return inventory
	 */
	public Inventory getInventory();
}