package com.NovaCraft;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;

//Replaces Bane of Arthropods with "Bane of the Unknown"; mobs with the arthropods or undefined entityattribute will be dealt extra damage similar to smite
public class BaneOfTheUnknownTransformer implements IClassTransformer {
    private static final String TARGET_CLASS = "net.minecraft.enchantment.EnchantmentDamage";
    private static final String ATTRIBUTE_OWNER = "net/minecraft/entity/EnumCreatureAttribute";
    private static final String ATTRIBUTE_DESCRIPTOR = "Lnet/minecraft/entity/EnumCreatureAttribute;";
    private static final String HOOK_OWNER = "com/NovaCraft/BaneOfTheUnknownHooks";
    private static final String HOOK_DESCRIPTOR = "(" + ATTRIBUTE_DESCRIPTOR + ")Z";

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (basicClass == null || !TARGET_CLASS.equals(transformedName)) {
            return basicClass;
        }

        ClassNode classNode = new ClassNode();
        ClassReader reader = new ClassReader(basicClass);
        reader.accept(classNode, 0);

        int damageChecksPatched = 0;
        int slowdownChecksPatched = 0;

        for (Object object : classNode.methods) {
            MethodNode method = (MethodNode)object;

            if ("func_152376_a".equals(method.name) && ("(I" + ATTRIBUTE_DESCRIPTOR + ")F").equals(method.desc)) {
                damageChecksPatched += this.patchArthropodChecks(method);
            }

            if ("func_151368_a".equals(method.name) && ("(Lnet/minecraft/entity/EntityLivingBase;" + "Lnet/minecraft/entity/Entity;I)V").equals(method.desc)) {
                slowdownChecksPatched += this.patchArthropodChecks(method);
            }
        }

        if (damageChecksPatched != 1 || slowdownChecksPatched != 1) {
            throw new IllegalStateException("NovaCraft could not patch Bane of Arthropods. " + "Damage checks patched: " + damageChecksPatched + "; slowdown checks patched: " + slowdownChecksPatched);
        }

        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(writer);
        System.out.println("[NovaCraft] Successfully patched " + "Bane of Arthropods into Bane of the Unknown.");
        return writer.toByteArray();
    }

    private int patchArthropodChecks(MethodNode method) {
        int patched = 0;

        AbstractInsnNode instruction = method.instructions.getFirst();

        while (instruction != null) {
            AbstractInsnNode next = instruction.getNext();

            if (instruction instanceof FieldInsnNode) {
                FieldInsnNode field = (FieldInsnNode)instruction;

                if (this.isArthropodConstant(field)) {
                    AbstractInsnNode comparison = this.nextExecutableInstruction(field);

                    if (!(comparison instanceof JumpInsnNode)) {
                        throw new IllegalStateException("Unexpected arthropod comparison in " + method.name);
                    }

                    JumpInsnNode jump = (JumpInsnNode)comparison;

                    int newOpcode;
                    if (jump.getOpcode() == Opcodes.IF_ACMPNE) {
                        newOpcode = Opcodes.IFEQ;
                    } else if (jump.getOpcode() == Opcodes.IF_ACMPEQ) {
                        newOpcode = Opcodes.IFNE;
                    } else {
                        throw new IllegalStateException("Unexpected comparison opcode in " + method.name + ": " + jump.getOpcode());
                    }

                    method.instructions.set(field, new MethodInsnNode(Opcodes.INVOKESTATIC, HOOK_OWNER, "isValidTarget", HOOK_DESCRIPTOR, false));
                    method.instructions.set(jump, new JumpInsnNode(newOpcode, jump.label));

                    ++patched;
                }
            }

            instruction = next;
        }

        return patched;
    }

    private boolean isArthropodConstant(FieldInsnNode field) {
        return field.getOpcode() == Opcodes.GETSTATIC && ATTRIBUTE_OWNER.equals(field.owner) && ATTRIBUTE_DESCRIPTOR.equals(field.desc)
                && ("ARTHROPOD".equals(field.name) || "field_75611_c".equals(field.name));
    }

    private AbstractInsnNode nextExecutableInstruction(AbstractInsnNode instruction) {
        AbstractInsnNode next = instruction.getNext();

        while (next != null && next.getOpcode() < 0) {
            next = next.getNext();
        }

        return next;
    }
}
