package jobieskii.mithril.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerArmorModel;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import jobieskii.mithril.Mithril;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MithrilArmor extends ArmorItem implements PolymerItem {

    private static final PolymerArmorModel armorModel = PolymerResourcePackUtils.requestArmor(new Identifier(Mithril.MODID,"mithril"));
    private PolymerModelData md;
    private Item item;
    public MithrilArmor(ArmorMaterial material, EquipmentSlot slot, Settings settings) {
        super(material, slot, settings);
        md = switch (slot) {
            case MAINHAND, OFFHAND -> null;
            case FEET -> PolymerResourcePackUtils.requestModel(Items.LEATHER_BOOTS, new Identifier(Mithril.MODID, "item/mithril_boots"));
            case LEGS -> PolymerResourcePackUtils.requestModel(Items.LEATHER_LEGGINGS, new Identifier(Mithril.MODID, "item/mithril_leggings"));
            case CHEST -> PolymerResourcePackUtils.requestModel(Items.LEATHER_CHESTPLATE, new Identifier(Mithril.MODID, "item/mithril_chestplate"));
            case HEAD -> PolymerResourcePackUtils.requestModel(Items.LEATHER_HELMET, new Identifier(Mithril.MODID, "item/mithril_helmet"));
        };
        item = switch (slot) {
            case MAINHAND, OFFHAND -> null;
            case FEET -> Items.LEATHER_BOOTS;
            case LEGS -> Items.LEATHER_LEGGINGS;
            case CHEST -> Items.LEATHER_CHESTPLATE;
            case HEAD -> Items.LEATHER_HELMET;
        };
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return item;
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return md.value();
    }

    @Override
    public int getPolymerArmorColor(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return armorModel.color();
    }

    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player) {
        super.onCraft(stack, world, player);
        Mithril.addRandomOpEnchant(stack, world);
        if (!world.isClient()) {
            world.playSound(
                    null,
                    player.getBlockPos(),
                    SoundEvents.BLOCK_BEACON_POWER_SELECT,
                    SoundCategory.BLOCKS,
                    0.7f,
                    0.7f
            );
            world.playSound(
                    null,
                    player.getBlockPos(),
                    SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE,
                    SoundCategory.BLOCKS,
                    1f,
                    1f
            );
        }
    }
}
