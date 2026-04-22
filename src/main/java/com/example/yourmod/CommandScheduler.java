package com.example.yourmod;
import net.minecraft.client.MinecraftClient;
import net.minecraft.network.packet.c2s.play.ChatMessageC2SPacket;

public class CommandScheduler {
    private static final int CYCLE_DURATION = 6000;
    private static int tickCounter = 0;
    private static boolean cycleActive = false;

    public static void tick(MinecraftClient client) {
        if (client.player == null || client.getNetworkHandler() == null) {
            return;
        }
        tickCounter++;
        if (tickCounter >= CYCLE_DURATION) {
            tickCounter = 0;
            cycleActive = false;
        }
        if (!cycleActive && tickCounter == 0) {
            cycleActive = true;
        }
        if (cycleActive) {
            if (tickCounter == 20) {
                sendCommand(client, "/hub");
                sendCommand(client, "#stop");
            }
            if (tickCounter == 60) {
                sendCommand(client, "#mine minecraft:ancient_debris");
            }
            if (tickCounter == 100) {
                sendCommand(client, "/an4");
            }
        }
    }

    private static void sendCommand(MinecraftClient client, String command) {
        if (client.getNetworkHandler() != null) {
            client.getNetworkHandler().sendPacket(new ChatMessageC2SPacket(command));
        }
    }
}