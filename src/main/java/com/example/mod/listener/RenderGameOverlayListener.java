package com.example.mod.listener;

import club.maxstats.weave.loader.api.event.RenderGameOverlayEvent;
import club.maxstats.weave.loader.api.event.SubscribeEvent;
import net.minecraft.client.renderer.GlStateManager;
import org.lwjgl.opengl.GL11;

public class RenderGameOverlayListener {

    @SubscribeEvent
    public void onRender(RenderGameOverlayEvent.Post event) {
        GlStateManager.disableAlpha();
        GlStateManager.color(1.0F, 0.0F, 0.0F);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(0, 0);
        GL11.glVertex2f(0, 100);
        GL11.glVertex2d(100, 100);
        GL11.glVertex2d(100, 0);
        GL11.glEnd();
        GlStateManager.color(1.0F, 1.0F, 1.0F);
        GlStateManager.enableAlpha();
    }
}
