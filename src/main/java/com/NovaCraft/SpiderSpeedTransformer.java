package com.NovaCraft;

import net.minecraft.launchwrapper.IClassTransformer;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

public class SpiderSpeedTransformer implements IClassTransformer {

    //Why is the speed of the spider hardcoded...
    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {

        if (!transformedName.equals("net.minecraft.entity.monster.EntitySpider") && !transformedName.equals("net.minecraft.entity.monster.EntityCaveSpider"))
            return basicClass;

        System.out.println("[SpiderTransformer] Patching EntitySpider...");

        ClassNode classNode = new ClassNode();
        ClassReader reader = new ClassReader(basicClass);
        reader.accept(classNode, 0);

        for (MethodNode method : classNode.methods) {

            boolean isAttack = method.name.equals("attackEntity") || method.name.equals("func_70785_a");
            boolean isAttributes = method.name.equals("applyEntityAttributes") || method.name.equals("func_110147_ax");

            if (isAttack || isAttributes) {

                for (AbstractInsnNode insn : method.instructions.toArray()) {

                    if (insn instanceof LdcInsnNode) {
                        LdcInsnNode ldc = (LdcInsnNode) insn;

                        if (ldc.cst instanceof Double) {
                            double value = (Double) ldc.cst;

                            if (value == 0.800000011920929D) {

                                ldc.cst = 1.600000023841858D;
                            }
                        }
                    }
                }
            }
        }

        ClassWriter writer = new ClassWriter(0);
        classNode.accept(writer);
        return writer.toByteArray();
    }
}
