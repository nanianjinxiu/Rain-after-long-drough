package com.nanianjinxiu.shamoxiayumod.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.biome.Biome;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Biome.class)
public class ShamoxiayuMixin {
    @Inject(method = "getPrecipitationAt"
            , at = @At("HEAD"), cancellable = true)
    private void onGetPrecipitationAt(BlockPos pos, CallbackInfoReturnable<Biome.Precipitation> cir) {
        cir.setReturnValue(Biome.Precipitation.RAIN);
    }

    @Inject(method = "hasPrecipitation", at = @At("RETURN"), cancellable = true)
    private void hasPrecipitation(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(true);
    }
}