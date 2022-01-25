package com.example;

import com.example.mod.Mods;
import org.lwjgl.opengl.Display;

public class Example {
    public static final Example instance = new Example();
    public Mods modManager;

    /** TODO: Make a optimized and simple base and release it on github (USE ABSTRACTS) */
    public void onStart() {
        String name = "Example", build = "1.0";
        Display.setTitle(name + " " + build);
        this.modManager = new Mods();
    }

    public void onStop() {

    }

}
