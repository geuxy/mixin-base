package com.example.gui;

import com.example.Example;
import com.example.mod.Mod;
import net.minecraft.client.gui.GuiScreen;
import org.lwjgl.input.Mouse;

public class GuiPosition extends GuiScreen {
    private boolean dragging;
    private int lastX, lastY;

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        drawDefaultBackground();
        for(Mod mod : Example.instance.modManager.mods) {
            draw(mouseX, mouseY);
            mod.render();
        }
        mc.fontRendererObj.drawStringWithShadow("Example Client", width / 2 - mc.fontRendererObj.getStringWidth("Example Client") / 2, height / 2 - mc.fontRendererObj.FONT_HEIGHT - 6, -1);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    public void draw(int mouseX, int mouseY) {
        for(Mod mod : Example.instance.modManager.mods) {
            if (this.dragging) {
                mod.x = mouseX + this.lastX;
                mod.y = mouseY + this.lastY;

                if (!Mouse.isButtonDown(0)) {
                    this.dragging = false;
                }
            }
            boolean overX = (mouseX >= mod.x && mouseX <= mod.x + mod.width());
            boolean overY = (mouseY >= mod.y && mouseY <= mod.y + mod.height());
            if(overX && overY){
                if(Mouse.isButtonDown(0)) {
                    if (!this.dragging) {
                        this.lastX = mod.x - mouseX;
                        this.lastY = mod.y - mouseY;
                        this.dragging = true;
                    }
                }
            }
        }
    }
}
