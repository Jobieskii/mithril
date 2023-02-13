package jobieskii.mithril.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import jobieskii.mithril.Mithril;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class MithrilIngot extends Item implements PolymerItem {

    public static PolymerModelData modelData = PolymerResourcePackUtils.requestModel(Items.IRON_INGOT, new Identifier(Mithril.MODID, "item/mithril_ingot"));;
    public MithrilIngot(Settings settings) {
        super(settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        tooltip.add(Text.translatable("item.mithril.forged.tooltip").formatted(Formatting.DARK_PURPLE));
    }

    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.IRON_INGOT;
    }
    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return modelData.value();
    }
}
