package com.NovaCraft;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

public class ThornsDurabilityTransformer implements IClassTransformer {
    private static final String TARGET_CLASS = "net.minecraft.enchantment.EnchantmentThorns";
    private static final String THORNS_METHOD_DESCRIPTOR = "(Lnet/minecraft/entity/EntityLivingBase;" + "Lnet/minecraft/entity/Entity;I)V";
    private static final String DAMAGE_ITEM_DESCRIPTOR = "(ILnet/minecraft/entity/EntityLivingBase;)V";

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (basicClass == null || !TARGET_CLASS.equals(transformedName)) {
            return basicClass;
        }

        ClassNode classNode = new ClassNode();
        new ClassReader(basicClass).accept(classNode, 0);
        FMLDeobfuscatingRemapper remapper = FMLDeobfuscatingRemapper.INSTANCE;
        int removedCalls = 0;

        for (Object object : classNode.methods) {
            MethodNode method = (MethodNode)object;
            String mappedName = remapper.mapMethodName(classNode.name, method.name, method.desc);
            String mappedDescriptor = remapper.mapMethodDesc(method.desc);
            if (!THORNS_METHOD_DESCRIPTOR.equals(mappedDescriptor) || !("func_151367_b".equals(mappedName) || "func_151367_b".equals(method.name))) {
                continue;
            }

            AbstractInsnNode instruction = method.instructions.getFirst();
            while (instruction != null) {
                AbstractInsnNode next = instruction.getNext();
                if (instruction instanceof MethodInsnNode) {
                    MethodInsnNode call = (MethodInsnNode)instruction;
                    if (this.isDamageItemCall(call)) {
                        InsnList replacement = new InsnList();
                        replacement.add(new InsnNode(Opcodes.POP));
                        replacement.add(new InsnNode(Opcodes.POP));
                        replacement.add(new InsnNode(Opcodes.POP));
                        method.instructions.insertBefore(call, replacement);
                        method.instructions.remove(call);
                        ++removedCalls;
                    }
                }

                instruction = next;
            }
        }

        if (removedCalls != 2) {
            throw new IllegalStateException("NovaCraft: expected two Thorns durability calls, " + "but removed " + removedCalls + ".");
        }

        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS);
        classNode.accept(writer);

        return writer.toByteArray();
    }

    private boolean isDamageItemCall(MethodInsnNode call) {
        if (call.getOpcode() != Opcodes.INVOKEVIRTUAL) {
            return false;
        }

        FMLDeobfuscatingRemapper remapper = FMLDeobfuscatingRemapper.INSTANCE;
        String mappedOwner = remapper.map(call.owner);
        String mappedName = remapper.mapMethodName(call.owner, call.name, call.desc);
        String mappedDescriptor = remapper.mapMethodDesc(call.desc);

        return "net/minecraft/item/ItemStack".equals(mappedOwner) && DAMAGE_ITEM_DESCRIPTOR.equals(mappedDescriptor) && ("func_77972_a".equals(mappedName) || "func_77972_a".equals(call.name) || "damageItem".equals(call.name));
    }
}
