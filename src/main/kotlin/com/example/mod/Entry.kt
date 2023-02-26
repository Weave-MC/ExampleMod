package com.example.mod

import club.maxstats.weave.api.ModInitializer
import club.maxstats.weave.api.hook.HookManager
import com.example.mod.hooks.MinecraftHook

class Entry: ModInitializer {
    override fun init(hookManager: HookManager){
        hookManager.add(MinecraftHook())
        println("Example Mod Initialized")
    }
}