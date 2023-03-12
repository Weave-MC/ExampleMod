package com.example.mod;

import club.maxstats.weave.loader.api.ModInitializer;
import club.maxstats.weave.loader.api.HookManager;
import club.maxstats.weave.loader.api.event.*;
import com.example.mod.listener.RenderGameOverlayListener;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.MethodInsnNode;

public class ExampleMod implements ModInitializer {
    @Override
    public void preInit(HookManager hookManager) {
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

        EventBus.INSTANCE.subscribe(KeyboardEvent.class, e -> {
            Minecraft.getMinecraft().thePlayer.addChatMessage(
                    new ChatComponentText("Key Pressed: " + Keyboard.getKeyName(e.getKeyCode()))
            );
        });

        EventBus.INSTANCE.subscribe(MouseEvent.class, e -> {
            if (e.getButton() >= 0) {
                Minecraft.getMinecraft().thePlayer.addChatMessage(
                        new ChatComponentText("Mouse Pressed: " + Mouse.getButtonName(e.getButton()))
                );
            }
        });

        EventBus.INSTANCE.subscribe(ShutdownEvent.class, e-> {
            System.out.println("Shutdown Event");
        });

        EventBus.INSTANCE.subscribe(ChatSentEvent.class, e -> {
            if (e.getMessage().equals("Test")) {
                e.setCancelled(true);
                Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText("Cancelled 'Test' Message"));
            }
        });

        EventBus.INSTANCE.subscribe(new RenderGameOverlayListener());

        EventBus.INSTANCE.subscribe(StartGameEvent.Pre.class, e -> {
            System.out.println("Pre StartGame");
        });

        EventBus.INSTANCE.subscribe(StartGameEvent.Post.class, e -> {
            System.out.println("Post StartGame");
        });
    }
    public static void onStart() {
        System.out.println("Hello World from Minecraft#startGame");
    }
}