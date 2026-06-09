package com.example.mod.command;

import net.minecraft.client.Minecraft;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;
import net.weavemc.api.command.Command;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;

public class CommandExampleMod extends Command {
    public CommandExampleMod() {
        super("examplemod", "example", "exm");
    }

    @Override
    public void execute(@NotNull String[] args) {
        switch (args.length) {
            case 1:
                sendChatMessage("Available subcommands are " + String.join(", ", this.getSuggestions(new String[] {""}, null)));
                break;
            case 2:
                switch (args[1]) {
                    case "name":
                        sendChatMessage("Name is Weave Example Mod");
                        break;
                    case "version":
                        sendChatMessage("Version is 0.0.0");
                        break;
                    default:
                        sendChatMessage("Invalid subcommands");
                        break;
                }
                break;
            default:
                break;
        }
    }

    @Override
    public @Nullable String[] getSuggestions(@NotNull String[] args, @Nullable BlockPos targetPos) {
        if (args.length == 1) {
            String[] subcommands = {"name", "version"};
            return Arrays
                    .stream(subcommands)
                    .filter((c) -> c.startsWith(args[0]))
                    .toArray(String[]::new);
        } else {
            return null;
        }
    }

    private void sendChatMessage(String message) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(message));
    }
}