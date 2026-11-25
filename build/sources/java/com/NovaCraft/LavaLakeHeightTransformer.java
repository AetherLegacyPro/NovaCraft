package com.NovaCraft;

import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.FieldNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.IincInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.objectweb.asm.tree.VarInsnNode;

public class LavaLakeHeightTransformer implements IClassTransformer {
    private static final String TARGET_CLASS = "net.minecraft.world.gen.feature.WorldGenLakes";
    private static final String GENERATE_DESCRIPTOR = "(Lnet/minecraft/world/World;" + "Ljava/util/Random;III)Z";
    private static final String BLOCK_DESCRIPTOR = "Lnet/minecraft/block/Block;";
    private static final String HOOK_OWNER = "com/NovaCraft/LakeGenerationHooks";
    private static final String HOOK_DESCRIPTOR = "(Ljava/lang/Object;Ljava/lang/Object;I)Z";

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        if (basicClass == null || !TARGET_CLASS.equals(transformedName)) {
            return basicClass;
        }

        ClassNode classNode = new ClassNode();
        new ClassReader(basicClass).accept(classNode, 0);

        FMLDeobfuscatingRemapper remapper = FMLDeobfuscatingRemapper.INSTANCE;
        FieldNode lakeBlockField = null;
        for (Object object : classNode.fields) {
            FieldNode field = (FieldNode)object;

            String mappedName = remapper.mapFieldName(classNode.name, field.name, field.desc);
            if (BLOCK_DESCRIPTOR.equals(remapper.mapDesc(field.desc)) && ("field_150556_a".equals(mappedName) || "field_150556_a".equals(field.name))) {
                lakeBlockField = field;
                break;
            }
        }

        if (lakeBlockField == null) {
            throw new IllegalStateException("NovaCraft: WorldGenLakes liquid field not found.");
        }

        int patches = 0;

        for (Object object : classNode.methods) {
            MethodNode method = (MethodNode)object;
            String mappedName = remapper.mapMethodName(classNode.name, method.name, method.desc);

            if (!GENERATE_DESCRIPTOR.equals(remapper.mapMethodDesc(method.desc))) {
                continue;
            }

            if (!"func_76484_a".equals(mappedName) && !"func_76484_a".equals(method.name) && !"generate".equals(method.name)) {
                continue;
            }

            for (AbstractInsnNode instruction = method.instructions.getFirst(); instruction != null; instruction = instruction.getNext()) {
                if (!(instruction instanceof IincInsnNode)) {
                    continue;
                }

                IincInsnNode increment = (IincInsnNode)instruction;

                if (increment.var == 4 && increment.incr == -4) {
                    LabelNode continueGeneration = new LabelNode();
                    InsnList injected = new InsnList();
                    injected.add(new VarInsnNode(Opcodes.ALOAD, 1));
                    injected.add(new VarInsnNode(Opcodes.ALOAD, 0));
                    injected.add(new FieldInsnNode(Opcodes.GETFIELD, classNode.name, lakeBlockField.name, lakeBlockField.desc));
                    injected.add(new VarInsnNode(Opcodes.ILOAD, 4));
                    injected.add(new MethodInsnNode(Opcodes.INVOKESTATIC, HOOK_OWNER, "shouldCancelLake", HOOK_DESCRIPTOR, false));
                    injected.add(new JumpInsnNode(Opcodes.IFEQ, continueGeneration));
                    injected.add(new InsnNode(Opcodes.ICONST_0));
                    injected.add(new InsnNode(Opcodes.IRETURN));
                    injected.add(continueGeneration);

                    method.instructions.insert(instruction, injected);

                    ++patches;
                    break;
                }
            }
        }

        if (patches != 1) {
            throw new IllegalStateException("NovaCraft: expected one lava lake height patch, " + "but applied " + patches + ".");
        }

        ClassWriter writer = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
        classNode.accept(writer);

        return writer.toByteArray();
    }
}
