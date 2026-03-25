package com.example.mod.listener;

import net.weavemc.api.RenderGameOverlayEvent;
import net.weavemc.api.event.SubscribeEvent;

public class RenderGameOverlayEventListener {
    @SubscribeEvent
    public void onEvent(RenderGameOverlayEvent event) {
        System.out.println("Render overlay event");
    }
}