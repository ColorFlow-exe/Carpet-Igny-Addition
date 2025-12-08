package com.liuyue.igny;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;

import java.util.List;
import java.util.stream.Collectors;

public class IGNYServerMod implements ModInitializer {
    private static final String MOD_ID = "carpet_igny_addition";
    private static String version;
    public static final List<String> CARPET_ADDITION_MOD_IDS;

    static {
        CARPET_ADDITION_MOD_IDS = FabricLoader.getInstance().getAllMods()
                .stream()
                .map(ModContainer::getMetadata)
                .map(ModMetadata::getId)
                .filter(id -> id.contains("carpet") && id.contains("addition"))
                .collect(Collectors.toList());
    }
    @Override
    public void onInitialize() {
        version = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata().getVersion().getFriendlyString();
        IGNYServer.init();
    }

    public static String getModId() {
        return MOD_ID;
    }

    public static String getVersion() {
        return version;
    }
}
