package com.example.mod;

import com.example.mod.command.CommandExampleMod;
import com.example.mod.listener.RenderGameOverlayEventListener;
import net.weavemc.api.ModInitializer;
import net.weavemc.api.command.CommandBus;
import net.weavemc.api.event.EventBus;
import net.weavemc.api.event.KeyboardEvent;
import org.jetbrains.annotations.NotNull;

import java.lang.instrument.Instrumentation;

public class ExampleMod implements ModInitializer {
    @Override
    public void init() {
        System.out.println("Hello from ExampleMod!");

        EventBus.subscribe(new RenderGameOverlayEventListener());

        EventBus.subscribe(KeyboardEvent.class, (e) -> {
            int keyCode = e.getKeyCode();
            System.out.println("Key pressed: " + keyCode);
        });

        CommandBus.register(new CommandExampleMod());
    }

    @Override
    public void preInit(@NotNull Instrumentation instrumentation) {
        System.out.println("This message is printed before Minecraft initialises");
    }
}