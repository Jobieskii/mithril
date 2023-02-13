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
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class RawMithril extends Item implements PolymerItem {
    public static PolymerModelData modelData = PolymerResourcePackUtils.requestModel(Items.RAW_IRON, new Identifier(Mithril.MODID, "item/raw_mithril"));;
    public RawMithril(Item.Settings settings) {
        super(settings);
    }
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.RAW_IRON;
    }

    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return modelData.value();
    }

}
