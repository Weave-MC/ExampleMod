package com.example.mod;

import club.maxstats.weave.loader.api.ModInitializer;
import club.maxstats.weave.loader.api.HookManager;
import club.maxstats.weave.loader.api.event.*;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodInsnNode;

public class ExampleMod implements ModInitializer {
    @Override
    public void preInit(@NotNull HookManager hookManager) {
        hookManager.register("net/minecraft/client/Minecraft", cn -> {
            cn.methods.stream()
                    .filter(m -> m.name.equals("startGame"))
                    .findFirst().orElseThrow()
                    .instructions.insert(
                            new MethodInsnNode(
                                    Opcodes.INVOKESTATIC,
                                    Type.getInternalName(this.getClass()),
                                    "onStart",
                                    "()V"
                            )
                    );
        });

        EventBus.INSTANCE.subscribe(InputEvent.class, e -> {
            Minecraft.getMinecraft().thePlayer.addChatMessage(
                    new ChatComponentText("Pressed: " + Keyboard.getKeyName(e.getKeyCode()))
            );
        });

        EventBus.INSTANCE.subscribe(ChatSentEvent.class, e -> {
            if (e.getMessage().equalsIgnoreCase("hello computer")) {
                e.setCancelled(true);
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Hello Player"));
            }
        });
    }
    public static void onStart() {
        System.out.println("Hello World from Minecraft#startGame");
    }
}