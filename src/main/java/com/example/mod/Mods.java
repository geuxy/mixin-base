package com.example.mod;

import com.example.mod.impl.ModTest;

import java.util.ArrayList;
import java.util.List;

public class Mods {
    public List<Mod> mods = new ArrayList<>();

    public Mods() {
        mods.add(new ModTest());
    }

}
