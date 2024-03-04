package com.bluelotuscoding.examplemod.item;

import com.bluelotuscoding.examplemod.ExampleMod;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class modItems {
    public static final DeferredRegister<Item> ITEMS =
            //list of all items from the mod mentioned below
        DeferredRegister.create(ForgeRegistries.ITEMS, ExampleMod.MOD_ID);

    //These are the items as they need to be called inorder to show in the inventory.
    public static final RegistryObject<Item> COBALT_INGOT = ITEMS.register("cobalt_ingot",
            () -> new Item(new Item.Properties().tab(modCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> DEEPSLATE_COBALT_INGOT = ITEMS.register("deepslate_cobalt_ingot",
            () -> new Item(new Item.Properties().tab(modCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> COBALT_NUGGET = ITEMS.register("cobalt_nugget",
            () -> new Item(new Item.Properties().tab(modCreativeModeTab.COURSE_TAB)));

    public static final RegistryObject<Item> RAW_COBALT = ITEMS.register("raw_cobalt",
            () -> new Item(new Item.Properties().tab(modCreativeModeTab.COURSE_TAB)));

    //Register method
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

