package com.example.mod;

import club.maxstats.weave.loader.api.ModInitializer;
import club.maxstats.weave.loader.api.HookManager;
import club.maxstats.weave.loader.api.event.ChatReceivedEvent;
import club.maxstats.weave.loader.api.event.EventBus;
import club.maxstats.weave.loader.api.event.InputEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.jetbrains.annotations.NotNull;
import org.lwjgl.input.Keyboard;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodInsnNode;

public class ExampleMod implements ModInitializer {
    @Override
    public void preinit(@NotNull HookManager hookManager) {
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

        EventBus.INSTANCE.subscribe(ChatReceivedEvent.class, e -> {
            if (e.getMessage().getUnformattedText().contains("Hello Computer")) {
                e.setCancelled(true);
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Hello Player"));
            }
        });
    }
    public static void onStart() {
        System.out.println("Hello World from Minecraft#startGame");
    }
}