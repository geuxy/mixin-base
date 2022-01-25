package com.example.mixins.client.settings;

import com.example.util.Keybinds;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import org.apache.commons.lang3.ArrayUtils;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameSettings.class)
public class MixinGameSettings {

    @Shadow
    private KeyBinding[] keyBindings;

    @Inject(method = "<init>()V", at = @At("RETURN"))
    private void addKeybindtoFirstConstructor(CallbackInfo c) {
        this.keyBindings = ((KeyBinding[]) ArrayUtils.add(this.keyBindings, Keybinds.keyBindToggleMenu));
    }

    @Inject(method = "<init>(Lnet/minecraft/client/Minecraft;Ljava/io/File;)V", at = @At("RETURN"))
    private void addKeybindtoSecondConstructor(CallbackInfo c) {
        this.keyBindings = ((KeyBinding[]) ArrayUtils.add(this.keyBindings, Keybinds.keyBindToggleMenu));
    }
}
