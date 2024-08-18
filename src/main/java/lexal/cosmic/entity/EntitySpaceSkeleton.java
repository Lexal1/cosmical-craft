package lexal.cosmic.entity;

import net.minecraft.core.entity.Entity;
import net.minecraft.core.entity.monster.EntitySkeleton;
import net.minecraft.core.entity.projectile.EntityArrow;
import net.minecraft.core.entity.projectile.EntityCannonball;
import net.minecraft.core.item.Item;
import net.minecraft.core.item.ItemStack;
import net.minecraft.core.util.helper.MathHelper;
import net.minecraft.core.util.collection.NamespaceID;
import net.minecraft.core.world.World;

public class EntitySpaceSkeleton extends EntitySkeleton {
    private static final ItemStack defaultHeldItem;
    public EntitySpaceSkeleton(World world) {
        super(world);
        this.textureIdentifier = new NamespaceID("minecraft", "skeleton");
        this.scoreValue = 1000;
    }
    @Override
    protected void dropFewItems() {
        int i = this.random.nextInt(3);

        int k;
        for(k = 0; k < i; ++k) {
            this.spawnAtLocation(Item.ammoChargeExplosive.id, 1);
        }

        i = this.random.nextInt(3);

        for(k = 0; k < i; ++k) {
            this.spawnAtLocation(Item.bone.id, 1);
        }
    }

    public void setCannonballHeading(EntityCannonball ball, double mx, double my, double mz, float speed, float randomness) {
        float velocity = MathHelper.sqrt_double(mx * mx + my * my + mz * mz);
        mx /= velocity;
        my /= velocity;
        mz /= velocity;
        mx += random.nextGaussian() * 0.0075D * randomness;
        my += random.nextGaussian() * 0.0075D * randomness;
        mz += random.nextGaussian() * 0.0075D * randomness;
        mx *= speed;
        my *= speed;
        mz *= speed;
        ball.xd = mx;
        ball.yd = my;
        ball.zd = mz;
        float velocityHorizontal = MathHelper.sqrt_double(mx * mx + mz * mz);
        ball.yRotO = ball.yRot = (float)(Math.atan2(mx, mz) * 180.0D / Math.PI);
        ball.xRotO = ball.xRot = (float)(Math.atan2(my, velocityHorizontal) * 180.0D / Math.PI);
    }

    @Override
    protected void attackEntity(Entity entity, float distance) {
        if (distance < 10.0F) {
            double d = entity.x - this.x;
            double d1 = entity.z - this.z;
            if (this.attackTime == 0) {
                if (!this.world.isClientSide) {
                    EntityCannonball cannonball = new EntityCannonball(this.world, this.x, this.y+1, this.z);
                    ++cannonball.y;
                    double d2 = entity.y + (double)entity.getHeadHeight() - 0.20000000298023224 - cannonball.y;
                    float f1 = MathHelper.sqrt_double(d * d + d1 * d1) * 0.2F;
                    this.world.playSoundAtEntity(null, this, "random.bow", 1.0F, 1.0F / (this.random.nextFloat() * 0.4F + 0.8F));
                    this.world.entityJoinedWorld(cannonball);
                    setCannonballHeading(cannonball, d, d2 + (double)f1, d1, 0.7f, 0);
                }
                this.attackTime = 50;
            }
            this.yRot = (float)(Math.atan2(d1, d) * 180.0 / 3.1415927410125732) - 90.0F;
            this.hasAttacked = true;
        }
    }
    @Override
    public boolean canBreatheUnderwater(){
        return true;
    }
    @Override
    public String getEntityTexture() {
        return getDefaultEntityTexture();
    }
    public ItemStack getHeldItem() {
        return defaultHeldItem;
    }
    static {
        defaultHeldItem = new ItemStack(Item.handcannonUnloaded, 1);
    }
}

