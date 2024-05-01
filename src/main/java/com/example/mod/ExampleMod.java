package com.example.mod;

import net.weavemc.api.ModInitializer;
import org.jetbrains.annotations.NotNull;

import java.lang.instrument.Instrumentation;

public class ExampleMod implements ModInitializer {
    @Override
    public void init() {
        System.out.println("Initializing ExampleMod!");
    }

    //TODO: This will be removed
    @SuppressWarnings({"deprecation", "RedundantSuppression"})
    @Override public void preInit(@NotNull Instrumentation instrumentation) {}
}