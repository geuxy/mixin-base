package com.example.mod;

public abstract class Mod {
    public boolean dragging;

    public abstract void render();
    public abstract String name();
    public abstract int width();
    public abstract int height();
    public int y;
    public int x;
}
