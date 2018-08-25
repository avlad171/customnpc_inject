package com.myuki69.inject;

import com.google.common.eventbus.EventBus;
import cpw.mods.fml.common.DummyModContainer;
import cpw.mods.fml.common.LoadController;
import cpw.mods.fml.common.ModMetadata;

import java.util.Arrays;

public class ModContainer extends DummyModContainer 
{
	public ModContainer()
    {
        super(new ModMetadata());
        ModMetadata meta = getMetadata();
        meta.modId = "inject";
        meta.name = "Inject";
        meta.description = "Injects functions into net.minecraft.world.World so you can call them using customNPCs with w=world.getMCWorld() and then w.yourfunction(yourparam)";
        meta.version = "1.0.4";
        meta.authorList = Arrays.asList("Yuki Malagar");
    }

    @Override
    public boolean registerBus(EventBus bus, LoadController controller)
    {
        bus.register(this);
        return true;
    }
}
