package com.myuki69.inject;

import java.util.Map;

import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin.MCVersion;

@IFMLLoadingPlugin.MCVersion("1.7.10")
@IFMLLoadingPlugin.TransformerExclusions({"com.myuki69.inject"})
public class CorePlugin implements IFMLLoadingPlugin
{
    @Override
    public String[] getASMTransformerClass()
    {
        return new String[]{"com.myuki69.inject.TransformerClass"};
    }

    @Override
    public String getModContainerClass()
    {
        return  "com.myuki69.inject.ModContainer";
    }

    @Override
    public String getSetupClass()
    {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data)
    {

    }

    @Override
    public String getAccessTransformerClass()
    {
        return null;
    }
}
