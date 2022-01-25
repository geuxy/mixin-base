package com.example;

import com.example.mod.Mods;
import org.lwjgl.opengl.Display;

public class Example {
    public static final Example instance = new Example();
    public Mods modManager;

    public void onStart() {
        String name = "Example", build = "1.0";
        Display.setTitle(name + " " + build);
        this.modManager = new Mods();
    }

    public void onStop() {

    }

}
