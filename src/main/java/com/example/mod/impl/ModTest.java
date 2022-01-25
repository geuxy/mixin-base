package com.example.mod.impl;

import com.example.mod.Mod;
import net.minecraft.client.Minecraft;

public class ModTest extends Mod {

    @Override
    public String name() {
        return "TestMod";
    }

    @Override
    public int width() {
        return Minecraft.getMinecraft().fontRendererObj.getStringWidth(name());
    }

    @Override
    public int height() {
        return Minecraft.getMinecraft().fontRendererObj.FONT_HEIGHT;
    }

    @Override
    public void render() {
        Minecraft.getMinecraft().fontRendererObj.drawStringWithShadow(name(), x, y, -1);
    }

}
