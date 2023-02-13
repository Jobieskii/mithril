package jobieskii.mithril.mixin;

import jobieskii.mithril.Mithril;
import net.minecraft.client.particle.Particle;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

@Mixin(AreaEffectCloudEntity.class)
abstract class DragonBreathConversionMixin extends Entity {
    public DragonBreathConversionMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(CallbackInfo ci) {
        AreaEffectCloudEntity t = ((AreaEffectCloudEntity)(Object)this);
        if (t.getParticleType() == ParticleTypes.DRAGON_BREATH) {
            List<ItemEntity> itemEntities = t.world.getNonSpectatingEntities(ItemEntity.class, t.getBoundingBox());
            for (ItemEntity ie : itemEntities) {
                if (ie.getStack().getItem() == Mithril.RAW_MITHRIL) {
                    NbtCompound nbt = ie.getStack().getOrCreateNbt();
                    int i = nbt.getInt("smoking");
                    if (i >= 60) {
                        int amount = ie.getStack().getCount();
                        ItemStack newStack = ((Item)Mithril.MITHRIL_INGOT).getDefaultStack();
                        newStack.setCount(amount);
                        ie.setStack(newStack);
                        t.world.playSound(
                                null,
                                ie.getBlockPos(),
                                SoundEvents.BLOCK_FIRE_EXTINGUISH,
                                SoundCategory.BLOCKS,
                                1f,
                                1f
                        );
                    } else {
                        nbt.putInt("smoking", i+1);
                        ie.getStack().setNbt(nbt);
                    }
                }
            }
        }
    }
}
