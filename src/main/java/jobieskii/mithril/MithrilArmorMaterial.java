package jobieskii.mithril;

import jobieskii.mithril.items.MithrilItems;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

public class MithrilArmorMaterial implements ArmorMaterial {

    private static final String name = "mithril";
    static int[] BASE_DURABILITY = new int[]{13, 15, 16, 11};
    private final int durabilityMultiplier = 60;
    private final int[] protectionAmounts = {3, 6, 8, 3};
    private final int enchantability = 15;
    private final SoundEvent equipSound = SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE;
    private final float toughness = 2.5f;
    private final float knockbackResistance = 0.1f;
    private final Lazy<Ingredient> repairIngredientSupplier = new Lazy<>(() -> Ingredient.ofItems((Item) MithrilItems.MITHRIL_INGOT));

    @Override
    public int getDurability(EquipmentSlot slot) {
        return BASE_DURABILITY[slot.getEntitySlotId()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slot) {
        return this.protectionAmounts[slot.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
