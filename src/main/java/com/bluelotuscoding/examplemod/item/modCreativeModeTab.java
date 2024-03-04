package com.bluelotuscoding.examplemod.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class modCreativeModeTab {
    public static final CreativeModeTab COURSE_TAB = new CreativeModeTab("coursemodtab") {
        @Override
        public ItemStack makeIcon() {
            //Any item you put here becomes displayed in the Creative Mode Tab
            return new ItemStack(modItems.COBALT_INGOT.get());
        }
    };
}
