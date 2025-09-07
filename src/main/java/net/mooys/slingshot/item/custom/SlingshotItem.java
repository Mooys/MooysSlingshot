package net.mooys.slingshot.item.custom;

import com.mojang.serialization.DataResult;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;
import net.mooys.slingshot.entity.custom.PebbleProjectileEntity;
import net.mooys.slingshot.item.ModItems;

public class SlingshotItem extends Item {
    public SlingshotItem(Settings settings) {
        super(settings);
    }


    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        ItemStack itemStack = user.getStackInHand(hand);
        world.playSound(
                null, user.getX(), user.getY(), user.getZ(), SoundEvents.ENTITY_EGG_THROW, SoundCategory.PLAYERS, 0.5F, 0.4F / (world.getRandom().nextFloat() * 0.4F + 0.8F)
        );
        if (!world.isClient) {
            PebbleProjectileEntity pebbleEntity = new PebbleProjectileEntity(world, user);
            pebbleEntity.setItem(ModItems.PEBBLE.getDefaultStack());
            pebbleEntity.setVelocity(user, user.getPitch(), user.getYaw(), 0.0F, 1.5F, 1.0F);
            world.spawnEntity(pebbleEntity);



        }
        return TypedActionResult.success(itemStack, world.isClient());
    }


}

