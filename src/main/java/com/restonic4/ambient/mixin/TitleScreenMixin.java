package com.restonic4.ambient.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import com.restonic4.ambient.Ambient;

import net.minecraft.client.gui.screen.TitleScreen;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
	@Inject(method = "init", at = @At("TAIL"))
	private void ambient$onInit(CallbackInfo ci) {
		Ambient.LOGGER.info("This line is printed by {} mixin!", Ambient.MOD_NAME);
	}
}
