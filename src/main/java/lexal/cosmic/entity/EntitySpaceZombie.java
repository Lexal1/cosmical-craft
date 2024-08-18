package lexal.cosmic.entity;

import net.minecraft.core.entity.monster.EntityArmoredZombie;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.world.World;
import net.minecraft.core.util.collection.NamespaceID;

import java.util.Random;

public class EntitySpaceZombie extends EntityArmoredZombie {
    private static final ItemStack defaultHeldItem;
    private final boolean isHoldingSword;
    public EntitySpaceZombie(World world) {
        super(world);
        Random rand = new Random();
        this.isHoldingSword = rand.nextInt(3) == 0;
        this.textureIdentifier = new NamespaceID("minecraft", "zombie");
        this.attackStrength = this.isHoldingSword ? 5 : 3;
    }

    @Override
    public boolean canBreatheUnderwater(){
        return true;
    }
    @Override
    public String getEntityTexture() {
        return getDefaultEntityTexture();
    }
    @Override
    public String getDefaultEntityTexture() {
        return "/assets/minecraft/textures/entity/zombie/2.png";
    }
    @Override
    public ItemStack getHeldItem() {
        return this.isHoldingSword ? defaultHeldItem : null;
    }
    @Override
    public int getMaxHealth() {
        return 50;
    }

    static {
        defaultHeldItem = new ItemStack(Item.toolSwordDiamond, 1);
    }
}

