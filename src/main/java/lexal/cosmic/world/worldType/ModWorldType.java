package lexal.cosmic.world.worldType;

import net.minecraft.core.world.type.WorldType;
import net.minecraft.core.world.type.WorldTypes;

public class ModWorldType {
    public static final WorldType worldTypeMoon = WorldTypes.register("cosmic:moon.default", new WorldTypeMoonDefault("worldType.moon.default"));

    public static void register() {}
}
