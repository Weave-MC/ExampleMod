package com.example.mod.hook

import net.weavemc.api.Hook
import org.objectweb.asm.Opcodes
import org.objectweb.asm.Type
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.MethodInsnNode

class MinecraftHook : Hook("net/minecraft/client/Minecraft") {
    override fun transform(node: ClassNode, cfg: AssemblerConfig) {
        node.methods.firstOrNull { method -> method.name == "startGame" }?.let { method ->
            method.instructions.insert(
                MethodInsnNode(
                    Opcodes.INVOKESTATIC,
                    Type.getInternalName(MinecraftHook::class.java),
                    "onStartGame",
                    "()V"
                )
            )
            println("onStartGame transformed")
        }
    }

    companion object {
        @JvmStatic
        @Suppress("unused")
        fun onStartGame() {
            println("Hook Test")
        }
    }
}
