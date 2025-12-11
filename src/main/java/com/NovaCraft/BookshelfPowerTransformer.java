package com.NovaCraft;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.*;

 //Why I spent 8 hours trying to understand IClassTransformer and how to get it to work is beyond me...

 //This transformer modifies the "bookshelf power" used in Minecraft enchantment tables.
 //It patches both vanilla and Et Futurum Requiem ContainerEnchantment classes such that each bookshelf provides half the enchanting power vanilla does.
 //You could have made a new block that replaces the vanilla bookshelf/enchantment table but that would have been pain to add compact for so decided to not do this.
 //Had no choice other than to use an IClassTransformer as the method that assigns the bookshelf power is hardcoded in 1.7.10.

 //This launches before mods load as it modifies the vanilla code so, I could not get a config option to work with it as the Config had not loaded yet...
public class BookshelfPowerTransformer implements IClassTransformer {

     //className -> The original class name (dot or slash format, depending on context)
     //transformedClassName -> The fully qualified name of the class after potential remapping
     //classBytes -> The raw bytecode of the class
     //Returns the modified bytecode, or original bytecode if no changes were made

    @Override
    public byte[] transform(String className, String transformedClassName, byte[] originalClassBytes) {

        //Only patch these two classes
        if (!"net.minecraft.inventory.ContainerEnchantment".equals(transformedClassName) && !"ganymedes01.etfuturum.inventory.ContainerEnchantment".equals(transformedClassName)) {
            return originalClassBytes;
        }

        System.out.println("[NovaCraft] Patching ContainerEnchantment: " + transformedClassName);

        //No idea what this is doing beyond this point other than finding the correct strings in the classes above and altering them
        ClassReader classReader = new ClassReader(originalClassBytes);
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM4, classWriter) {

            @Override
            public MethodVisitor visitMethod(int access, String methodName, String methodDescriptor, String signature, String[] exceptions) {
                MethodVisitor originalMethodVisitor = super.visitMethod(access, methodName, methodDescriptor, signature, exceptions);

                //Find method 'onCraftMatrixChanged(IInventory)'
                if (!methodName.equals("onCraftMatrixChanged")) return originalMethodVisitor;
                if (!methodDescriptor.equals("(Lnet/minecraft/inventory/IInventory;)V")) return originalMethodVisitor;

                return new MethodVisitor(Opcodes.ASM4, originalMethodVisitor) {

                    @Override
                    public void visitMethodInsn(int opcode, String calledClassOwner, String calledMethodName, String calledMethodDesc, boolean isInterface) {

                        //Target only the call to EnchantmentHelper.calcItemStackEnchantability
                        if (calledClassOwner.equals("net/minecraft/enchantment/EnchantmentHelper") && calledMethodName.equals("calcItemStackEnchantability")) {
                            super.visitInsn(Opcodes.SWAP);
                            super.visitInsn(Opcodes.ICONST_2);
                            super.visitInsn(Opcodes.IDIV);
                            super.visitInsn(Opcodes.SWAP);
                        }

                        super.visitMethodInsn(opcode, calledClassOwner, calledMethodName, calledMethodDesc, isInterface);
                    }

                };
            }
        };

        //Apply our ClassVisitor to the original class
        classReader.accept(classVisitor, 0);

        //Return the modified bytecode
        return classWriter.toByteArray();
    }
}
