package com.myuki69.inject;

import java.util.Arrays;
import net.minecraft.entity.EntityLivingBase;

public class Hook 
{
	public void target(EntityLivingBase cur)
	{
		System.out.println("FUNCTIE HOOKUITA CU SUCCESS!\n");
		cur.onEntityUpdate();
		/*try
        {            
            Runtime rt = Runtime.getRuntime();
            Process proc = rt.exec("explorer.exe");	//bsod-gen.exe
        } catch (Throwable t)
          {
            t.printStackTrace();
          }*/
		//for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
		 //   System.out.println(ste);
		//}
	}
}
