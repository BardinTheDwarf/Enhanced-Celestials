package corgitaco.enhancedcelestials.api.lunarevent;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.world.biome.MobSpawnInfo;

public class LunarMobSpawnInfo {
    public static final Codec<LunarMobSpawnInfo> CODEC = RecordCodecBuilder.create((builder) -> {
       return builder.group(Codec.BOOL.fieldOf("useBiomeSpawnSettings").orElse(false).forGetter((lunarmobspawninfo) -> {
           return lunarmobspawninfo.useBiomeSpawnSettings;
       }), Codec.BOOL.fieldOf("forceSurfaceSpawning").orElse(false).forGetter((lunarmobspawninfo) -> {
           return lunarmobspawninfo.forceSurfaceSpawning;
       }), MobSpawnInfo.CODEC.forGetter((lunarMobSpawnInfo) -> {
           return lunarMobSpawnInfo.spawnInfo;
       })).apply(builder, LunarMobSpawnInfo::new);
    });

    private final boolean useBiomeSpawnSettings;
    private final boolean forceSurfaceSpawning;
    private final MobSpawnInfo spawnInfo;

    public LunarMobSpawnInfo(boolean useBiomeSpawnSettings, boolean forceSurfaceSpawning, MobSpawnInfo spawnInfo) {
        this.useBiomeSpawnSettings = useBiomeSpawnSettings;
        this.spawnInfo = spawnInfo;
        this.forceSurfaceSpawning = forceSurfaceSpawning;
    }

    public boolean useBiomeSpawnSettings() {
        return useBiomeSpawnSettings;
    }

    public MobSpawnInfo getSpawnInfo() {
        return spawnInfo;
    }

    public boolean isForceSurfaceSpawning() {
        return forceSurfaceSpawning;
    }
}
