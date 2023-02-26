package com.example.mod

import club.maxstats.weave.api.ModInitializer
import club.maxstats.weave.api.hook.HookManager

class Entry: ModInitializer {
    override fun init(hookManager: HookManager){
        println("Example Mod Initialized")
    }
}