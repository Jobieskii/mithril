package jobieskii.mithril.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import jobieskii.mithril.Mithril;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class MithrilAxe extends AxeItem implements PolymerItem {

    public static PolymerModelData modelData = PolymerResourcePackUtils.requestModel(Items.IRON_AXE, new Identifier(Mithril.MODID, "item/mithril_axe"));

    public MithrilAxe(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.IRON_AXE;
    }
    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return modelData.value();
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
