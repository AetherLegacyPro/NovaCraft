package com.NovaCraft;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import java.util.Map;

public class BookshelfPowerOverride implements IFMLLoadingPlugin {

    @Override
    public String[] getASMTransformerClass() {
        System.out.println("[NovaCraft] getASMTransformerClass called!");
        return new String[] { "com.NovaCraft.BookshelfPowerTransformer" };
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
