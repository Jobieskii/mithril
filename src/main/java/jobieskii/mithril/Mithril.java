package jobieskii.mithril;

import eu.pb4.polymer.core.api.item.PolymerItem;
import eu.pb4.polymer.core.api.item.SimplePolymerItem;
import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import jobieskii.mithril.items.MithrilIngot;
import jobieskii.mithril.items.MithrilSword;
import jobieskii.mithril.items.RawMithril;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Mithril implements ModInitializer {
    public static final String MODID = "mithril";

    public static final ToolMaterial MITHRIL_TOOL_MATERIAL = new MithrilToolMaterial();
    public static final PolymerItem MITHRIL_INGOT = Registry.register(Registries.ITEM, new Identifier(Mithril.MODID, "mithril_ingot"),
            new MithrilIngot(new FabricItemSettings().maxCount(64).rarity(Rarity.RARE)));
    public static final PolymerItem RAW_MITHRIL = Registry.register(Registries.ITEM, new Identifier(Mithril.MODID, "raw_mithril"),
            new RawMithril(new FabricItemSettings().maxCount(64).rarity(Rarity.COMMON)));
    public static final PolymerItem MITHRIL_SWORD = Registry.register(Registries.ITEM, new Identifier(MODID, "mithril_sword"),
            new MithrilSword(MITHRIL_TOOL_MATERIAL, 3, -2.4f, new FabricItemSettings().rarity(Rarity.RARE)));

    @Override
    public void onInitialize() {

        PolymerResourcePackUtils.addModAssets(MODID);
    }

    public static void addRandomOpEnchant(ItemStack stack, World world) {
        Item item = stack.getItem();
        List<EnchantmentLevelEntry> possibleEnchantments = new ArrayList();
        for (Enchantment enchantment : Registries.ENCHANTMENT) {
            if (enchantment.type.isAcceptableItem(item) && enchantment.getMaxLevel() > 1) {
                possibleEnchantments.add(new EnchantmentLevelEntry(enchantment, enchantment.getMaxLevel()));
            }
        }
        EnchantmentLevelEntry chosen = possibleEnchantments.get(world.getRandom().nextInt(possibleEnchantments.size()));
        if (chosen != null) {
            stack.addEnchantment(chosen.enchantment, chosen.level + 2);
        }
    }
}
