package net.mooys.slingshot.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.mooys.slingshot.MooysSlingshot;
import net.mooys.slingshot.item.custom.SlingshotItem;


public class ModItems {

    public static final Item PEBBLE = registerItem("pebble", new Item(new Item.Settings()));
    public static final Item SLINGSHOT = registerItem("slingshot", new SlingshotItem(new Item.Settings().maxCount(1)));

    public static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MooysSlingshot.MOD_ID, name), item);
    }


    public static void registerModItems() {
        MooysSlingshot.LOGGER.info("Registering Mod Items for" + MooysSlingshot.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(PEBBLE);
        });
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(SLINGSHOT);
        });
    }
}