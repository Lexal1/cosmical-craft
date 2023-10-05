package lexal.cosmic.world.worldType;

import net.minecraft.core.world.World;
import net.minecraft.core.world.config.season.SeasonConfig;
import net.minecraft.core.world.season.Seasons;
import net.minecraft.core.world.weather.Weather;
import net.minecraft.core.world.wind.WindManagerGeneric;

public class WorldTypeMoonDefault extends WorldTypeMoon {
    public WorldTypeMoonDefault(String languageKey) {
        super(languageKey,
                Weather.overworldClear,
                new WindManagerGeneric(),
                false,
                new float[]{0.0f, 0.0f, 0.0f, 0.0f},
                SeasonConfig.builder()
                        .withSingleSeason(Seasons.NULL)
                        .build()
        );
    }
    @Override
    public int getMinY() {
        return 0;
    }
    @Override
    public int getMaxY() {
        return 127;
    }

    @Override
    public float getGravityScalar() {
        return 0.45f;
    }

    @Override
    public boolean suffocate() {
        return true;
    }

    @Override
    public String getCelestialMoonTexture() {
        return "/assets/cosmic/terrain/earth.png";
    }

    @Override
    public String getCelestialSunTexture() {
        return "/terrain/sun.png";
    }

    @Override
    public float getStarBrightness(World world) {
        return 0.75f;
    }
}
