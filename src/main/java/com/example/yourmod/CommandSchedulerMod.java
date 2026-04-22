package com.example.yourmod;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CommandSchedulerMod implements ModInitializer {
    public static final String MOD_ID = "command-scheduler";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Initializing Command Scheduler Mod");
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            CommandScheduler.tick(client);
        });
    }
}
