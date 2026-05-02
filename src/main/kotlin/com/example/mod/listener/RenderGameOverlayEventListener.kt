package com.example.mod.listener

import net.weavemc.api.RenderGameOverlayEvent
import net.weavemc.api.event.SubscribeEvent

class RenderGameOverlayEventListener {
    @SubscribeEvent
    fun onEvent(event: RenderGameOverlayEvent) {
        println("Render overlay event")
    }
}
