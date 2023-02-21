package jobieskii.mithril;

import eu.pb4.polymer.resourcepack.api.PolymerResourcePackUtils;
import jobieskii.mithril.blocks.MithrilBlocks;
import jobieskii.mithril.items.MithrilItems;
import net.fabricmc.api.ModInitializer;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ToolMaterial;
import net.minecraft.registry.Registries;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.List;

public class Mithril implements ModInitializer {
    public static final String MODID = "mithril";

    public static final ToolMaterial MITHRIL_TOOL_MATERIAL = new MithrilToolMaterial();


    @Override
    public void onInitialize() {
        MithrilItems.init();
        MithrilBlocks.init();
        PolymerResourcePackUtils.addModAssets(MODID);
    }

    public static void addRandomOpEnchant(ItemStack stack, World world) {
        Item item = stack.getItem();
        List<EnchantmentLevelEntry> possibleEnchantments = new ArrayList<>();
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
