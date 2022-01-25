package com.example.mixins.client.gui;

import com.example.Example;
import com.example.gui.GuiPosition;
import com.example.mod.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GuiIngame.class)
public class MixinGuiInGame {

    @Inject(method = "renderGameOverlay", at = @At("RETURN"))
    public void render(float partialTicks, CallbackInfo c) {
        for(Mod mod : Example.instance.modManager.mods) {
            if(Minecraft.getMinecraft().currentScreen instanceof GuiPosition) {
                return;
            }
            mod.render();
        }
    }
}
