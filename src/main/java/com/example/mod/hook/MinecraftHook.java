package com.example.mod.hook;

import net.weavemc.api.Hook;
import org.jetbrains.annotations.NotNull;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.MethodInsnNode;

public class MinecraftHook extends Hook {
    public MinecraftHook() {
        super("net/minecraft/client/Minecraft");
    }

    @Override
    public void transform(@NotNull ClassNode classNode, @NotNull AssemblerConfig assemblerConfig) {
        classNode.methods.stream()
                .filter(m -> m.name.equals("startGame"))
                .findFirst()
                .ifPresent(m -> m.instructions.insert(
                        new MethodInsnNode(
                                Opcodes.INVOKESTATIC,
                                Type.getInternalName(MinecraftHook.class),
                                "onStartGame",
                                "()V"
                        )
                ));
    }

    @SuppressWarnings("unused")
    public static void onStartGame() {
        System.out.println("Hook Test");
    }
}
