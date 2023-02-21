package jobieskii.mithril.blocks;

import eu.pb4.polymer.blocks.api.PolymerTexturedBlock;
import jobieskii.mithril.Mithril;
import jobieskii.mithril.items.TexturedBlockItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MithrilBlocks {
    public static final PolymerTexturedBlock CRACKED_ONYX = Registry.register(Registries.BLOCK, new Identifier(Mithril.MODID, "cracked_onyx"),
            new TexturedBlock("cracked_onyx"));
    public static final BlockItem CRACKED_ONYX_ITEM = Registry.register(Registries.ITEM, new Identifier(Mithril.MODID, "cracked_onyx"), new TexturedBlockItem((Block) CRACKED_ONYX, new FabricItemSettings(), "cracked_onyx"));
    public static final PolymerTexturedBlock MITHRIL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Mithril.MODID, "mithril_block"),
            new TexturedBlock("mithril_block"));
    public static final BlockItem MITHRIL_BLOCK_ITEM = Registry.register(Registries.ITEM, new Identifier(Mithril.MODID, "mithril_block"), new TexturedBlockItem((Block) MITHRIL_BLOCK, new FabricItemSettings(), "mithril_block"));
    public static final PolymerTexturedBlock MITHRIL_ORE = Registry.register(Registries.BLOCK, new Identifier(Mithril.MODID, "mithril_ore"),
            new TexturedBlock("mithril_ore"));
    public static final BlockItem MITHRIL_ORE_ITEM = Registry.register(Registries.ITEM, new Identifier(Mithril.MODID, "mithril_ore"), new TexturedBlockItem((Block) MITHRIL_ORE, new FabricItemSettings(), "mithril_ore"));
    public static final PolymerTexturedBlock MITHRIL_ORNAMENTAL = Registry.register(Registries.BLOCK, new Identifier(Mithril.MODID, "mithril_ornamental"),
            new TexturedBlock("mithril_ornamental"));
    public static final BlockItem MITHRIL_ORNAMENTAL_ITEM = Registry.register(Registries.ITEM, new Identifier(Mithril.MODID, "mithril_ornamental"), new TexturedBlockItem((Block) MITHRIL_ORNAMENTAL, new FabricItemSettings(), "mithril_ornamental"));
    public static final PolymerTexturedBlock ONYX = Registry.register(Registries.BLOCK, new Identifier(Mithril.MODID, "onyx"),
            new TexturedBlock("onyx"));
    public static final BlockItem ONYX_ITEM = Registry.register(Registries.ITEM, new Identifier(Mithril.MODID, "onyx"), new TexturedBlockItem((Block) ONYX, new FabricItemSettings(), "onyx"));
    public static final PolymerTexturedBlock RAW_MITHRIL_BLOCK = Registry.register(Registries.BLOCK, new Identifier(Mithril.MODID, "raw_mithril_block"),
            new TexturedBlock("raw_mithril_block"));
    public static final BlockItem RAW_MITHRIL_BLOCK_ITEM = Registry.register(Registries.ITEM, new Identifier(Mithril.MODID, "raw_mithril_block"), new TexturedBlockItem((Block) RAW_MITHRIL_BLOCK, new FabricItemSettings(), "raw_mithril_block"));
    public static final PolymerTexturedBlock SMOOTH_ONYX = Registry.register(Registries.BLOCK, new Identifier(Mithril.MODID, "smooth_onyx"),
            new TexturedBlock("smooth_onyx"));
    public static final BlockItem SMOOTH_ONYX_ITEM = Registry.register(Registries.ITEM, new Identifier(Mithril.MODID, "smooth_onyx"), new TexturedBlockItem((Block) SMOOTH_ONYX, new FabricItemSettings(), "smooth_onyx"));

    public static void init() {

    }

}
