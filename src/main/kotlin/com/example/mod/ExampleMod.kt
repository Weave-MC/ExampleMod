package com.example.mod

import club.maxstats.weave.loader.api.HookManager
import club.maxstats.weave.loader.api.ModInitializer
import com.example.mod.hooks.MinecraftHook

class ExampleMod : ModInitializer {
    override fun preinit(hookManager: HookManager) {
        hookManager.add(MinecraftHook())
        println("Example Mod Initialized")
    }
}