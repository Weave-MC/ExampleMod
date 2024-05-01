package com.example.mod;

import net.weavemc.api.ModInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jetbrains.annotations.NotNull;

import java.lang.instrument.Instrumentation;

public class ExampleMod implements ModInitializer {
    private final Logger logger = LogManager.getLogger();

    @Override
    public void init() {
        logger.info("Hello from ExampleMod!");
    }

    //TODO: This will be removed
    @SuppressWarnings({"deprecation", "RedundantSuppression"})
    @Override public void preInit(@NotNull Instrumentation instrumentation) {}
}