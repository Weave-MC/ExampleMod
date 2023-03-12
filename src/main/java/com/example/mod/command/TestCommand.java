package com.example.mod.command;

import club.maxstats.weave.loader.api.Command;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public class TestCommand extends Command {
    @NotNull
    @Override
    public String getName() {
        return "test";
    }

    @NotNull
    @Override
    public List<String> getAliases() {
        return Arrays.asList("sometest", "somealias", "t");
    }

    @NotNull
    @Override
    public String getUsage() {
        return "<arg1> <arg2> [arg3]";
    }

    @Override
    public void handle(@NotNull List<String> args) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("This is a command!"));
    }
}
