package com.example.mod;

import club.maxstats.weave.loader.api.HookManager;
import club.maxstats.weave.loader.api.ModInitializer;
import club.maxstats.weave.loader.api.event.EventBus;
import club.maxstats.weave.loader.api.event.annotation.SubscribeEvent;
import club.maxstats.weave.loader.api.event.impl.InputEvent;
import org.jetbrains.annotations.NotNull;
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

        EventBus.INSTANCE.subscribe(this);
    }

    @SubscribeEvent
    public void onInput(InputEvent e) {
        System.out.println("Pressed: " + e.getKeycode());
    }

    public static void onStart() {
        System.out.println("Hello World from Minecraft#startGame");
    }
}
