package com.myuki69.inject;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

import net.minecraft.entity.EntityLivingBase;

import static org.objectweb.asm.Opcodes.*;

public class MyClassVisitor extends ClassVisitor
{
	public MyClassVisitor(int x) 
	{
		super(x);
	}
	public MyClassVisitor(int x, ClassWriter cw)
	{
		super(x, cw);
	}
	
	@Override
	public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) 
	{
	MethodVisitor mv;
	mv = cv.visitMethod(access, name, desc, signature, exceptions);
	System.out.println(name + " " + desc);
	return mv;
	
	}
	
	@Override
	public void visitEnd() 
	{
		MethodVisitor inject;
		inject = cv.visitMethod(ACC_PUBLIC, "target", "(Lnet/minecraft/entity/EntityLivingBase;)V", null, null);
		inject.visitCode();
		Label l0 = new Label();
		inject.visitLabel(l0);
		//inject.visitLineNumber(78, l0);
		inject.visitVarInsn(ALOAD, 1);
		inject.visitFieldInsn(GETFIELD, "net/minecraft/entity/EntityLivingBase", "field_70170_p", "Lnet/minecraft/world/World;");
		inject.visitVarInsn(ASTORE, 2);
		Label l1 = new Label();
		inject.visitLabel(l1);
		//inject.visitLineNumber(81, l1);
		inject.visitVarInsn(ALOAD, 2);
		inject.visitTypeInsn(NEW, "techguns/entities/projectiles/LaserProjectile");
		inject.visitInsn(DUP);
		inject.visitVarInsn(ALOAD, 2);
		inject.visitVarInsn(ALOAD, 1);
		inject.visitLdcInsn(new Float("40.0"));
		inject.visitLdcInsn(new Float("100.0"));
		inject.visitIntInsn(SIPUSH, 10);
		inject.visitLdcInsn(new Float("0.5"));
		inject.visitIntInsn(SIPUSH, 40);
		inject.visitIntInsn(SIPUSH, 140);
		inject.visitLdcInsn(new Float("8.0"));
		inject.visitLdcInsn(new Float("10.0"));
		inject.visitInsn(ICONST_0);
		inject.visitMethodInsn(INVOKESPECIAL, "techguns/entities/projectiles/LaserProjectile", "<init>", "(Lnet/minecraft/world/World;Lnet/minecraft/entity/EntityLivingBase;FFIFIIFFZ)V", false);
		inject.visitMethodInsn(INVOKEVIRTUAL, "net/minecraft/world/World", "func_72838_d", "(Lnet/minecraft/entity/Entity;)Z", false);
		inject.visitInsn(POP);
		Label l2 = new Label();
		inject.visitLabel(l2);
		//inject.visitLineNumber(83, l2);
		inject.visitInsn(RETURN);
		Label l3 = new Label();
		inject.visitLabel(l3);
		inject.visitLocalVariable("this", "Lcom/myuki69/inject/ScriptLivingBase;", null, l0, l3, 0);
		inject.visitLocalVariable("cur", "Lnet/minecraft/entity/EntityLivingBase;", null, l0, l3, 1);
		inject.visitLocalVariable("thisworld", "Lnet/minecraft/world/World;", null, l1, l3, 2);
		inject.visitMaxs(14, 3);
		inject.visitEnd();
		
		MethodVisitor tesla;	//public void spawnProjectile(EntityLivingBase shooter, float damage, int damageDropStart, int damageDropEnd, float damageMin, float penetration, int chain, float chainDmgDrop)
		tesla =  cv.visitMethod(ACC_PUBLIC, "shootTesla", "(Lnet/minecraft/entity/EntityLivingBase;FIIFFIF)V", null, null);
		tesla.visitCode();
		Label teslal0 = new Label();
		tesla.visitLabel(teslal0);
		//tesla.visitLineNumber(34, l0);
		tesla.visitVarInsn(ALOAD, 1);
		tesla.visitFieldInsn(GETFIELD, "net/minecraft/entity/EntityLivingBase", "field_70170_p", "Lnet/minecraft/world/World;");
		tesla.visitVarInsn(ASTORE, 9);
		Label teslal1 = new Label();
		tesla.visitLabel(teslal1);
		//tesla.visitLineNumber(35, l1);
		tesla.visitVarInsn(ALOAD, 9);
		tesla.visitTypeInsn(NEW, "techguns/entities/projectiles/TeslaBeam");
		tesla.visitInsn(DUP);
		tesla.visitVarInsn(ALOAD, 9);
		tesla.visitVarInsn(ALOAD, 1);
		tesla.visitMethodInsn(INVOKESPECIAL, "techguns/entities/projectiles/TeslaBeam", "<init>", "(Lnet/minecraft/world/World;Lnet/minecraft/entity/EntityLivingBase;)V", false);
		tesla.visitMethodInsn(INVOKEVIRTUAL, "net/minecraft/world/World", "func_72838_d", "(Lnet/minecraft/entity/Entity;)Z", false);
		tesla.visitInsn(POP);
		Label teslal2 = new Label();
		tesla.visitLabel(teslal2);
		//tesla.visitLineNumber(36, l2);
		tesla.visitVarInsn(ALOAD, 9);
		tesla.visitTypeInsn(NEW, "techguns/entities/projectiles/TeslaProjectile");
		tesla.visitInsn(DUP);
		tesla.visitVarInsn(ALOAD, 9);
		tesla.visitVarInsn(ALOAD, 1);
		tesla.visitVarInsn(FLOAD, 2);
		tesla.visitVarInsn(ILOAD, 3);
		tesla.visitVarInsn(ILOAD, 4);
		tesla.visitVarInsn(FLOAD, 5);
		tesla.visitVarInsn(FLOAD, 6);
		tesla.visitVarInsn(ILOAD, 7);
		tesla.visitVarInsn(FLOAD, 8);
		tesla.visitInsn(ICONST_0);
		tesla.visitMethodInsn(INVOKESPECIAL, "techguns/entities/projectiles/TeslaProjectile", "<init>", "(Lnet/minecraft/world/World;Lnet/minecraft/entity/EntityLivingBase;FIIFFIFZ)V", false);
		tesla.visitMethodInsn(INVOKEVIRTUAL, "net/minecraft/world/World", "func_72838_d", "(Lnet/minecraft/entity/Entity;)Z", false);
		tesla.visitInsn(POP);
		Label teslal3 = new Label();
		tesla.visitLabel(teslal3);
		//tesla.visitLineNumber(37, l3);
		tesla.visitInsn(RETURN);
		Label teslal4 = new Label();
		tesla.visitLabel(teslal4);
		tesla.visitLocalVariable("this", "Ltechguns/items/guns/Teslagun;", null, teslal0, teslal4, 0);
		tesla.visitLocalVariable("shooter", "Lnet/minecraft/entity/EntityLivingBase;", null, teslal0, teslal4, 1);
		tesla.visitLocalVariable("damage", "F", null, teslal0, teslal4, 2);
		tesla.visitLocalVariable("damageDropStart", "I", null, teslal0, teslal4, 3);
		tesla.visitLocalVariable("damageDropEnd", "I", null, teslal0, teslal4, 4);
		tesla.visitLocalVariable("damageMin", "F", null, teslal0, teslal4, 5);
		tesla.visitLocalVariable("penetration", "F", null, teslal0, teslal4, 6);
		tesla.visitLocalVariable("chain", "I", null, teslal0, teslal4, 7);
		tesla.visitLocalVariable("chainDmgDrop", "F", null, teslal0, teslal4, 8);
		tesla.visitLocalVariable("world", "Lnet/minecraft/world/World;", null, teslal1, teslal4, 9);
		tesla.visitMaxs(13, 10);
		tesla.visitEnd();
		
		cv.visitEnd();
	}
}
