package com.liuyue.igny.task;

import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;

public interface ITask {
    String getPlayerName();
    String getTaskType();
    Component getStatusText();
    void stop();
    boolean isStopped();
    MinecraftServer getServer();
    void tick();
}