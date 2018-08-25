package com.myuki69.inject;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;

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
		/*inject = cv.visitMethod(ACC_PUBLIC, "target", "(Lnet/minecraft/entity/EntityLivingBase;)V", null, null);
		inject.visitCode();
		Label l0 = new Label();
		inject.visitLabel(l0);
		//mv.visitLineNumber(10, l0);
		inject.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
		inject.visitLdcInsn("FUNCTIE HOOKUITA CU SUCCESS!\n");
		inject.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(Ljava/lang/String;)V", false);
		Label l1 = new Label();
		inject.visitLabel(l1);
		//mv.visitLineNumber(11, l1);
		inject.visitVarInsn(ALOAD, 1);
		inject.visitMethodInsn(INVOKEVIRTUAL, "net/minecraft/entity/EntityLivingBase", "func_70076_C", "()V", false);
		Label l2 = new Label();
		inject.visitLabel(l2);
		//inject.visitLineNumber(23, l2);
		inject.visitInsn(RETURN);
		Label l3 = new Label();
		inject.visitLabel(l3);
		inject.visitLocalVariable("this", "Lcom/myuki69/inject/Hook;", null, l0, l3, 0);
		inject.visitLocalVariable("cur", "Lnet/minecraft/entity/EntityLivingBase;", null, l0, l3, 1);
		inject.visitMaxs(2, 2);
		inject.visitEnd();*/ //functie de test - o sa crashuie jocul pentru ca EntityLivingBase.kill() nu e accesibil din net.minecraft.world.World (protected)
		
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
	}
}
