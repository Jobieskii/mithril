package jobieskii.mithril;

import jobieskii.mithril.items.MithrilItems;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class MithrilToolMaterial implements ToolMaterial {
    @Override
    public int getDurability() {
        return 3122;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.0f;
    }

    @Override
    public float getAttackDamage() {
        return 3.0f;
    }

    @Override
    public int getMiningLevel() {
        return 4;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems((ItemConvertible) MithrilItems.MITHRIL_INGOT);
    }
}
