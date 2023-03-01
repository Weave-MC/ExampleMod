package com.example.mod;

import club.maxstats.weave.loader.api.HookManager;
import club.maxstats.weave.loader.api.ModInitializer;
import club.maxstats.weave.loader.api.event.EventBus;
import club.maxstats.weave.loader.api.event.annotation.SubscribeEvent;
import club.maxstats.weave.loader.api.event.impl.InputEvent;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.LdcInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;

public class ExampleMod implements ModInitializer {
    @Override
    public void preinit(@NotNull HookManager hookManager) {
        hookManager.register("net/minecraft/client/Minecraft", cn -> {
            cn.methods.stream()
                    .filter(m -> m.name.equals("startGame"))
                    .findFirst().orElseThrow()
                    .instructions.insert(new InsnList() {{
                        add(new FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"));
                        add(new LdcInsnNode("Hello World from Minecraft#startGame"));
                        add(new MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V"));
                    }});
        });

        EventBus.INSTANCE.subscribe(this);
    }

    @SubscribeEvent
    public void onInput(InputEvent e) {
        System.out.println("Pressed: " + e.getKeycode());
    }
}
