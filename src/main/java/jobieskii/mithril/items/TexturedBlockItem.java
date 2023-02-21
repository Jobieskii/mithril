package jobieskii.mithril.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerModelData;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import jobieskii.mithril.Mithril;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

public class TexturedBlockItem extends BlockItem implements PolymerItem {
    private final PolymerModelData md;
    @Override
    public Item getPolymerItem(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return Items.COBBLED_DEEPSLATE;
    }
    @Override
    public int getPolymerCustomModelData(ItemStack itemStack, @Nullable ServerPlayerEntity player) {
        return md.value();
    }
    public TexturedBlockItem(Block block, Settings settings, String name) {
        super(block, settings);
        md = PolymerResourcePackUtils.requestModel(Items.COBBLED_DEEPSLATE, new Identifier(Mithril.MODID, "item/"+name));
    }
}
