package com.restonic4.ambient.mixin;

import net.minecraft.block.material.Material;
import net.minecraft.entity.vehicle.BoatEntity;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Random;

@Mixin(BoatEntity.class)
public class BoatEntityMixin {
	@Unique
	private Random ambient$random = new Random();

	@Unique
	private int ambient$rowingTicks = 0;

	@Inject(method = "tick", at = @At("TAIL"))
	private void ambient$addBoatSounds(CallbackInfo ci) {
		BoatEntity self = (BoatEntity) (Object) this;
		double speed = Math.sqrt(self.velocityX * self.velocityX + self.velocityZ * self.velocityZ);

		Box checkBox = Box.fromPool(
			self.shape.minX, self.shape.minY - 0.125, self.shape.minZ,
			self.shape.maxX, self.shape.maxY, self.shape.maxZ
		);
		boolean isInWater = self.world.containsLiquid(checkBox, Material.WATER);

		if (isInWater && speed > 0.05d) {
			this.ambient$rowingTicks++;
			int interval = (int) Math.max(1 / speed, 5);

			if (this.ambient$rowingTicks > interval) {
				this.ambient$rowingTicks = 0 ;

				float pitch = 0.6f + ambient$random.nextFloat() * 0.6f; // [0.6, 1.2]

				self.world.playSound(self.x, self.y, self.z, "liquid.splash", 0.02f, pitch);
			}
		} else {
			this.ambient$rowingTicks = 0;
		}
	}
}
