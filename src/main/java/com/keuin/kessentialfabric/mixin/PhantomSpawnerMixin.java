package com.keuin.kessentialfabric.mixin;

import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.gen.PhantomSpawner;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PhantomSpawner.class)
public class PhantomSpawnerMixin {
    private boolean spawningPhantom = false;

    @Inject(method = "spawn", at = @At("HEAD"), cancellable = true)
    public void tickPhantomSpawning(ServerWorld world, boolean spawnHostileMobs, boolean spawnPeacefulMobs, CallbackInfoReturnable<Integer> callbackInfo) {
        if(!spawningPhantom) {
            callbackInfo.setReturnValue(0);
            callbackInfo.cancel();
        }
    }

//    /**
//     * @reason Disable the phantom spawning
//     * @author Keuin
//     */
//    @Overwrite
//    public int spawn(ServerWorld world, boolean spawnHostileMobs, boolean spawnPeacefulMobs) {
//        return 0;
//    }
}
