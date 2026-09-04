package com.restonic4.ambient.mixin;

import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public class WorldMixin {
	/*@Inject(method = "isRaining()Z", at = @At("HEAD"), cancellable = true)
	private void ambient$forceRain1(CallbackInfoReturnable<Boolean> cir) {
		cir.setReturnValue(true);
	}

	@Inject(method = "getRain", at = @At("HEAD"), cancellable = true)
	private void ambient$forceRain2(CallbackInfoReturnable<Float> cir) {
		cir.setReturnValue(1.0f);
	}*/
}
