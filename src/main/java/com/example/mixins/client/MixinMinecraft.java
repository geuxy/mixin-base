package com.example.mixins.client;

import com.example.Example;
import com.example.gui.GuiPosition;
import com.example.util.Keybinds;
import net.minecraft.client.Minecraft;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Minecraft.class)
public class MixinMinecraft {
    private GuiPosition guiPosition;

    @Inject(method = "startGame", at = @At("RETURN"))
    public void start(CallbackInfo c) {
        Example.instance.onStart();
    }

    @Inject(method = "shutdownMinecraftApplet", at = @At("HEAD"))
    public void stop(CallbackInfo c) {
        Example.instance.onStop();
    }

    @Inject(method = "runTick", at = @At("HEAD"))
    private void tick(CallbackInfo callbackInfo) {
        if(Keybinds.keyBindToggleMenu.isPressed()) {
            if(guiPosition == null) {
                guiPosition = new GuiPosition();
            }
            Minecraft.getMinecraft().displayGuiScreen(new GuiPosition());
        }
    }
}
