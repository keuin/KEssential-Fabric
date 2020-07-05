package com.keuin.kessentialfabric.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.gen.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {
    private boolean spawningPhantom = false;
    @Shadow private int ticksUntilSpawn;

    @Inject(method = "tick", at = @At("HEAD"))
    public void tick(ServerWorld worldIn, boolean spawnHostileMobs, boolean spawnPeacefulMobs, CallbackInfo callbackInfo) {
        if(!spawningPhantom)
            callbackInfo.cancel();
    }
}
