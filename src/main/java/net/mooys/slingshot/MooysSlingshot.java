package net.mooys.slingshot;

import net.fabricmc.api.ModInitializer;

import net.mooys.slingshot.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MooysSlingshot implements ModInitializer {
	public static final String MOD_ID = "mooys-slingshot";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}