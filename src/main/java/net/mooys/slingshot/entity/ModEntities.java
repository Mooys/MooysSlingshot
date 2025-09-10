package net.mooys.slingshot.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mooys.slingshot.MooysSlingshot;
import net.mooys.slingshot.entity.custom.PebbleProjectileEntity;

public class ModEntities {
    public static final EntityType<PebbleProjectileEntity> PEBBLE = Registry.register(Registries.ENTITY_TYPE,
            Identifier.of(MooysSlingshot.MOD_ID, "pebble"),
            EntityType.Builder.<PebbleProjectileEntity>create(PebbleProjectileEntity::new, SpawnGroup.MISC)
                    .dimensions(0.25f, 0.25f).build());


    public static void registerModEntities() {
        MooysSlingshot.LOGGER.info("Registering Mod Entities for" + MooysSlingshot.MOD_ID);
    }
}
