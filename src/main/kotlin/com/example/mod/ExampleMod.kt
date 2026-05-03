package com.example.mod

import com.example.mod.listener.RenderGameOverlayEventListener
import net.weavemc.api.KeyboardEvent
import net.weavemc.api.ModInitializer
import net.weavemc.api.event.EventBus
import java.lang.instrument.Instrumentation

@Suppress("unused")
class ExampleMod : ModInitializer {
    override fun init() {
        println("Hello from ExampleMod!")

        EventBus.subscribe(RenderGameOverlayEventListener())

        EventBus.subscribe(KeyboardEvent::class.java) { event ->
            val keyCode = event.keyCode
            println("Key pressed: $keyCode")
        }
    }

    override fun preInit(inst: Instrumentation) {
        println("This message is printed before Minecraft initialises")
    }
}
