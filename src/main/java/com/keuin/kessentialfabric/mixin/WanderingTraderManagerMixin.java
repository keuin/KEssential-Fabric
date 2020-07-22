package com.keuin.kessentialfabric.mixin;

import net.minecraft.world.WanderingTraderManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WanderingTraderManager.class)
public class WanderingTraderManagerMixin {
    private boolean spawningWanderingTrader = false;

    // WanderingTraderManager
    @Inject(method = "tick", at = @At("HEAD"), cancellable = true)
    public void tickWanderingTraderSpawning(CallbackInfo callbackInfo) {
        if(!spawningWanderingTrader)
            callbackInfo.cancel();
    }

}
