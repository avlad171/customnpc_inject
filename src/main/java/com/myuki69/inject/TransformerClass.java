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
                //"noppes.npcs.scripted.ScriptWorld"
        		"net.minecraft.world.World"
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
            //ClassNode classNode = new ClassNode();
        	
        	ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
            ClassReader cr = new ClassReader(classBeingTransformed);
            MyClassVisitor cv = new MyClassVisitor(ASM4, cw);
            cr.accept(cv, 0);



            System.out.println("Class should have been transformed and written by now!");
            
            FileOutputStream out = new FileOutputStream("modified.class");
    		out.write(cw.toByteArray());
    		out.close();
    		
            return cw.toByteArray();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return classBeingTransformed;
    }
}
	/*private static void transformClass(ClassNode npcScriptClass, boolean isObfuscated)
    {
        //final String ENTITY_COLLIDE = "setTime";
		final String ENTITY_COLLIDE = "spawnProjectile";

        for (MethodNode method : npcScriptClass.methods)
        {
            if (method.name.equals(ENTITY_COLLIDE))
            {
                AbstractInsnNode targetNode = null;
                for (AbstractInsnNode instruction : method.instructions.toArray())
                {
                    if (instruction.getOpcode() == ALOAD)
                    {
                        if (((VarInsnNode) instruction).var == 1)
                        {
                            targetNode = instruction;
                            break;
                        }
                    }
                }
                if (targetNode != null)
                {
                	System.out.println("E PE DRUMUL CEL BUN!\n");
                    /*
                    protected spawnProjectile(Lnet/minecraft/world/World;Lnet/minecraft/entity/EntityLivingBase;Lnet/minecraft/item/ItemStack;FFFZ)V
   L0
    LINENUMBER 30 L0
    ALOAD 1
    NEW com/myuki69/inject/LaserProjectile
    DUP
    ALOAD 1		//world
    ALOAD 2		//enitatea care a tras
    FCONST_2	//damaju
    LDC 3.0 	//viteza proiectil
    ICONST_4	//TTL
    FLOAD 4		//spread aka bloom
    ICONST_5	//dmgdrop start
    BIPUSH 6	//dmgdrop end
    LDC 7.0 	//dmg minim
    LDC 8.0		//penetrare
    ICONST_0	//da damaj la bloace
    INVOKESPECIAL com/myuki69/inject/LaserProjectile.<init>(Lnet/minecraft/world/World;Lnet/minecraft/entity/EntityLivingBase;FFIFIIFFZ)V
    INVOKEVIRTUAL net/minecraft/world/World.spawnEntityInWorld(Lnet/minecraft/entity/Entity;)Z
    POP
   L1
    LINENUMBER 31 L1
    RETURN
   L2
    LOCALVARIABLE this Lcom/myuki69/inject/Lasergun; L0 L2 0
    LOCALVARIABLE world Lnet/minecraft/world/World; L0 L2 1
    LOCALVARIABLE player Lnet/minecraft/entity/EntityLivingBase; L0 L2 2
    LOCALVARIABLE itemstack Lnet/minecraft/item/ItemStack; L0 L2 3
    LOCALVARIABLE spread F L0 L2 4
    LOCALVARIABLE offset F L0 L2 5
    LOCALVARIABLE damagebonus F L0 L2 6
    LOCALVARIABLE leftGun Z L0 L2 7
    MAXSTACK = 14
    MAXLOCALS = 8
                     

                    /*AbstractInsnNode popNode = targetNode;
                    for (int i = 0; i < 4; i++)
                    {
                        popNode = popNode.getNext();
                    }

                    LabelNode newLabelNode = new LabelNode();

                    InsnList toInsert = new InsnList();
                    //toInsert.add(new VarInsnNode(ALOAD, 0));
                    toInsert.add(new MethodInsnNode(INVOKESTATIC, Type.getInternalName(Hook.class), "target", "()V", false));

                    method.instructions.insertBefore(targetNode, toInsert);
                    //method.instructions.insert(popNode, newLabelNode);
                }
                else
                {
                    System.out.println("Something went wrong transforming BlockCactus!");
                }
            }
        }
    }
}
*/