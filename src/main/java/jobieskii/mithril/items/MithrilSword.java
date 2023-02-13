package jobieskii.mithril.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import jobieskii.mithril.Mithril;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;

public class MithrilSword extends SwordItem implements PolymerItem {

    public static PolymerModelData modelData = PolymerResourcePackUtils.requestModel(Items.IRON_SWORD, new Identifier(Mithril.MODID, "item/mithril_sword"));;

    public MithrilSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.IRON_SWORD;
    }
    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return modelData.value();
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.mithril.forged.tooltip").formatted(Formatting.DARK_PURPLE));
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
