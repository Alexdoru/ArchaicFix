package org.embeddedt.archaicfix.mixins.gt6.client;

import gregapi.GT_API_Proxy_Client;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import org.lwjgl.input.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GT_API_Proxy_Client.class)
public class MixinGT_API_Proxy_Client {
    @Inject(method = "onItemTooltip", at = @At("HEAD"), cancellable = true, remap = false)
    private void skipTooltipIfNotHoldingShift(ItemTooltipEvent aEvent, CallbackInfo ci) {
        if(!Keyboard.isCreated() || !Keyboard.isKeyDown(Keyboard.KEY_LSHIFT)) {
            ci.cancel();
        }
    }
}
