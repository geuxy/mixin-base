package com.example.mixins;

import net.minecraft.launchwrapper.ITweaker;
import net.minecraft.launchwrapper.LaunchClassLoader;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.MixinEnvironment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Tweaker implements  ITweaker {
    private final List<String> launchArgs = new ArrayList<>();

    @Override
    public void acceptOptions(List<String> args, File gameDir, File assetsDir, String p) {
        this.launchArgs.addAll(args);

        String version = "--version";
        String assetsDirectory = "--assetDir";
        String gameDirectory = "--gameDir";

        if (!args.contains(version) && p != null) {
            launchArgs.add(version);
            launchArgs.add(p);
        }

        if (!args.contains(assetsDirectory) && p != null) {
            launchArgs.add(assetsDirectory);
            launchArgs.add(p);
        }

        if (!args.contains(gameDirectory) && p != null) {
            launchArgs.add(gameDirectory);
            launchArgs.add(p);
        }
    }

    @Override
    public final void injectIntoClassLoader(LaunchClassLoader classLoader) {
        MixinBootstrap.init();
        MixinEnvironment environment = MixinEnvironment.getDefaultEnvironment();
        environment.addConfiguration("mixins.client.json");
        if (environment.getObfuscationContext() == null) {
            environment.setObfuscationContext("notch");
        }
        environment.setSide(MixinEnvironment.Side.CLIENT);
    }

    @Override
    public String getLaunchTarget() {
        return MixinBootstrap.getPlatform().getLaunchTarget();
    }

    @Override
    public String[] getLaunchArguments() {
        return launchArgs.toArray(new String[0]);
    }
}
