package com.myuki69.inject;

import java.util.Arrays;
import net.minecraft.entity.EntityLivingBase;

//just a test function, not used
public class Hook 
{
	public void target(EntityLivingBase cur)
	{
		System.out.println("FUNCTIE HOOKUITA CU SUCCESS!\n");
		cur.onEntityUpdate();

	}
}
