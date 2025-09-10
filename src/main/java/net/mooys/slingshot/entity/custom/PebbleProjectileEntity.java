package net.mooys.slingshot.entity.custom;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.ThrownItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import net.mooys.slingshot.entity.ModEntities;
import net.mooys.slingshot.item.ModItems;

public class PebbleProjectileEntity extends ThrownItemEntity {
    //constructors
    public PebbleProjectileEntity(EntityType<? extends ThrownItemEntity> entityType, World world) {
        super(entityType, world);
    }

    public PebbleProjectileEntity(World world, PlayerEntity player) {
        super(ModEntities.PEBBLE, player, world);
    }


    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        super.onEntityHit(entityHitResult);
        Entity entity = entityHitResult.getEntity();
        entity.damage(this.getDamageSources().thrown(this, this.getOwner()), 2);
    }



    //This defines what the entity will look like if the item isn't set.
    @Override
    protected Item getDefaultItem() {
        return ModItems.PEBBLE;
    }
    }
