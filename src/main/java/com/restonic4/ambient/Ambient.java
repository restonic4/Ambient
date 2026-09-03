package com.restonic4.ambient;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.ornithemc.osl.entrypoints.api.ModInitializer;

public class Ambient implements ModInitializer {
	public static final String MOD_ID = "ambient";
	public static final String MOD_NAME = "Ambient";
	public static final Logger LOGGER = LogManager.getLogger(MOD_NAME);

	@Override
	public void init() {
		LOGGER.info("Initializing {}!", MOD_NAME);
	}
}
