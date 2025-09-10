package net.mooys.slingshot.mixin;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolItem;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ToolItem.class)
public class PickaxeRecipeRetainer {

    public boolean hasRecipeRemainder() {
        return true;
    }

    public ItemStack getRecipeRemainder(ItemStack stack) {
        ItemStack copy = stack.copy();
        copy.setDamage(copy.getDamage() + 1);
        if (copy.getDamage() >= copy.getMaxDamage()) {
            return ItemStack.EMPTY;
        }

        return copy;
    }
}
