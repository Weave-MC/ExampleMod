package com.example.mod.hooks

import club.maxstats.weave.api.hook.Hook
import org.objectweb.asm.Opcodes
import org.objectweb.asm.tree.ClassNode
import org.objectweb.asm.tree.FieldInsnNode
import org.objectweb.asm.tree.InsnList
import org.objectweb.asm.tree.LdcInsnNode
import org.objectweb.asm.tree.MethodInsnNode
import org.objectweb.asm.tree.MethodNode

class MinecraftHook: Hook("net.minecraft.client.Minecraft") {
    override fun transform(cn: ClassNode) {
        for (method: MethodNode in cn.methods) {
            if (method.name.equals("startGame")) {
                this.startGameInject(method)
            }
        }
    }

    private fun startGameInject(method: MethodNode) {
        val inject = InsnList()
        inject.add(FieldInsnNode(Opcodes.GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;"))
        inject.add(LdcInsnNode("Hello World from Minecraft#startGame"))
        inject.add(MethodInsnNode(Opcodes.INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V"))
        method.instructions.insert(inject)
    }
}