package com.restonic4.ambient.mixin;

import net.minecraft.client.render.GameRenderer;
import net.minecraft.world.biome.source.BiomeSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(GameRenderer.class)
public class GameRendererMixin {
	@Redirect(
		method = "tickRain",
		at = @At(
			value = "INVOKE",
			target = "Lnet/minecraft/world/biome/source/BiomeSource;getTemperature(III)F"
		)
	)
	private float ambient$fixRainSound(BiomeSource biomeSource, int x, int y, int z) {
		float rawTemp = biomeSource.getTemperature(x, y, z);
		float heightAdjustedTemp = biomeSource.adjustTemperatureForHeight(rawTemp, y);
		return (heightAdjustedTemp >= 0.15F) ? 1.0F : 0.0F;
	}
}
