package com.myuki69.inject;

import com.myuki69.inject.*;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.Type;
import static org.objectweb.asm.Opcodes.*;

import java.util.Arrays;
import java.io.FileOutputStream;


public class TransformerClass implements IClassTransformer
{
	private static final String[] classesBeingTransformed =
        {
                "noppes.npcs.scripted.ScriptWorld"
        		//"net.minecraft.world.World"
        };

	@Override
	public byte[] transform(String name, String transformedName, byte[] classBeingTransformed)
	{
		//System.out.println(name + ' ' + transformedName + '\n');
		boolean isObfuscated = !name.equals(transformedName);
		int index = Arrays.asList(classesBeingTransformed).indexOf(transformedName);
		return index != -1 ? transform(index, classBeingTransformed, isObfuscated) : classBeingTransformed;
	}
	
	private static byte[] transform(int index, byte[] classBeingTransformed, boolean isObfuscated)
    {
        System.out.println("Transforming: " + classesBeingTransformed[index]);
        System.out.println(classBeingTransformed);
        try
        {
        	
        	ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            ClassReader cr = new ClassReader(classBeingTransformed);
            MyClassVisitor cv = new MyClassVisitor(ASM4, cw);
            cr.accept(cv, 0);



            //System.out.println("Class should have been transformed and written by now!");
            
            //FileOutputStream out = new FileOutputStream("modified.class");
    		//out.write(cw.toByteArray());
    		//out.close();
    		
            return cw.toByteArray();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return classBeingTransformed;
    }
}
	