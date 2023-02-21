package jobieskii.mithril.blocks;

import eu.pb4.polymer.blocks.api.BlockModelType;
import eu.pb4.polymer.blocks.api.PolymerBlockModel;
import eu.pb4.polymer.blocks.api.PolymerBlockResourceUtils;
import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import jobieskii.mithril.Mithril;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.util.Identifier;

import static net.minecraft.block.Blocks.COBBLED_DEEPSLATE;

public class TexturedBlock extends Block implements PolymerTexturedBlock {
    private BlockState bs;
    public TexturedBlock(Settings settings) {
        super(settings);
    }
    public TexturedBlock(String name) {
        super(FabricBlockSettings.of(Material.METAL));
        bs = PolymerBlockResourceUtils.requestBlock(BlockModelType.FULL_BLOCK, PolymerBlockModel.of(new Identifier(Mithril.MODID, "block/"+name)));
    }

    @Override
    public Block getPolymerBlock(BlockState state) {
        return COBBLED_DEEPSLATE;
    }

    @Override
    public BlockState getPolymerBlockState(BlockState state) {
        return bs;
    }
}
