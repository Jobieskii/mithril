package jobieskii.mithril.items;

import eu.pb4.polymer.core.api.item.PolymerItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

import static jobieskii.mithril.Mithril.MITHRIL_TOOL_MATERIAL;
import static jobieskii.mithril.Mithril.MODID;

public class MithrilItems {
    public static final PolymerItem MITHRIL_INGOT = Registry.register(Registries.ITEM, new Identifier(MODID, "mithril_ingot"),
            new MithrilIngot(new FabricItemSettings().maxCount(64).rarity(Rarity.RARE)));
    public static final PolymerItem RAW_MITHRIL = Registry.register(Registries.ITEM, new Identifier(MODID, "raw_mithril"),
            new RawMithril(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final PolymerItem MITHRIL_SWORD = Registry.register(Registries.ITEM, new Identifier(MODID, "mithril_sword"),
            new MithrilSword(MITHRIL_TOOL_MATERIAL, 3, -2.4f, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final PolymerItem MITHRIL_PICKAXE = Registry.register(Registries.ITEM, new Identifier(MODID, "mithril_pickaxe"),
            new MithrilPickaxe(MITHRIL_TOOL_MATERIAL, 3, -2.4f, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final PolymerItem MITHRIL_AXE = Registry.register(Registries.ITEM, new Identifier(MODID, "mithril_axe"),
            new MithrilAxe(MITHRIL_TOOL_MATERIAL, 3, -2.4f, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final PolymerItem MITHRIL_SHOVEL = Registry.register(Registries.ITEM, new Identifier(MODID, "mithril_shovel"),
            new MithrilShovel(MITHRIL_TOOL_MATERIAL, 3, -2.4f, new FabricItemSettings().rarity(Rarity.RARE)));
    public static final PolymerItem MITHRIL_HOE = Registry.register(Registries.ITEM, new Identifier(MODID, "mithril_hoe"),
            new MithrilHoe(MITHRIL_TOOL_MATERIAL, 3, -2.4f, new FabricItemSettings().rarity(Rarity.RARE)));

    public static void init() {

    }
}
