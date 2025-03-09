package com.NovaCraft;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ChatComponentText;

public class ServerMessage {

    public static void broadcastMessage(String message) {
        MinecraftServer server = MinecraftServer.getServer();
        if (server != null && server.getConfigurationManager() != null) {
            server.getConfigurationManager().sendChatMsg(new ChatComponentText(message));
        }
    }
}
