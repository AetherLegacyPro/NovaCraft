package com.NovaCraft;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;

public class BookshelfPowerOverride implements IFMLLoadingPlugin {

    //Main ASM Transformer class: initially I only used it for one thing but it got expanded upon
    @Override
    public String[] getASMTransformerClass() {
        System.out.println("[NovaCraft] getASMTransformerClass called!"); //"com.NovaCraft.ThornsDurabilityTransformer"
        return new String[] { "com.NovaCraft.BookshelfPowerTransformer", "com.NovaCraft.SpiderSpeedTransformer",  "com.NovaCraft.BaneOfTheUnknownTransformer", "com.NovaCraft.LavaLakeHeightTransformer" };
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {
        System.out.println("[NovaCraft] injectData called!");
    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }

}
