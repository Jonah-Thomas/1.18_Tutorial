package com.bluelotuscoding.examplemod.block;

import com.bluelotuscoding.examplemod.ExampleMod;
import com.bluelotuscoding.examplemod.block.custom.speedyBlock;
import com.bluelotuscoding.examplemod.item.modCreativeModeTab;
import com.bluelotuscoding.examplemod.item.modItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class modBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, ExampleMod.MOD_ID);

    //This is our declartion of our block objects that we will see in game.
    public static final  RegistryObject<Block> COBALT_BLOCK = registerBlock("cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);

    public static final  RegistryObject<Block> COBALT_ORE = registerBlock("cobalt_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(4f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);

    public static final  RegistryObject<Block> RAW_COBALT_BLOCK = registerBlock("raw_cobalt_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);

    public static final  RegistryObject<Block> DEEPSLATE_COBALT_ORE = registerBlock("deepslate_cobalt_ore",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);

    //This is the code for our custom block item
    public static final  RegistryObject<Block> BUFFING_BLOCK = registerBlock("buffing_block",
            () -> new speedyBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB, "tooltip.block.buffing_block"); //here is an example of creating tool tips for our blocks.

    //This is the code for custom structure block items like stairs and slabs here we call the StairBlock method and the Slab Block method to create our new blocks!
    public static final  RegistryObject<Block> COBALT_STAIRS = registerBlock("cobalt_stairs",
            () -> new StairBlock(() -> modBlocks.COBALT_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL)

                    .strength(3f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);
    public static final  RegistryObject<Block> COBALT_SLAB = registerBlock("cobalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);


    public static final  RegistryObject<Block> COBALT_BUTTON = registerBlock("cobalt_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops().noCollission()), modCreativeModeTab.COURSE_TAB);

    public static final  RegistryObject<Block> COBALT_PRESSURE_PLATE = registerBlock("cobalt_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of(Material.METAL)
                    .strength(2f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);

    public static final  RegistryObject<Block> COBALT_FENCE = registerBlock("cobalt_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);
    public static final  RegistryObject<Block> COBALT_FENCE_GATE = registerBlock("cobalt_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);
    public static final  RegistryObject<Block> COBALT_WALL = registerBlock("cobalt_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()), modCreativeModeTab.COURSE_TAB);

    //Here we are adding custom doors and trap doors!
    public static final  RegistryObject<Block> CHERRY_BLOSSOM_DOOR = registerBlock("cherry_blossom_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(3f).requiresCorrectToolForDrops().noOcclusion()), modCreativeModeTab.COURSE_TAB);
    public static final  RegistryObject<Block> CHERRY_BLOSSOM_TRAPDOOR = registerBlock("cherry_blossom_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(3f).requiresCorrectToolForDrops().noOcclusion()), modCreativeModeTab.COURSE_TAB);// noOcclusion is because of the Alpha Values in the texture



    //Helper Methods to help us make block items
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block,
                                                                     CreativeModeTab tab, String tooltipKey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab, tooltipKey); // here we add the tooltipKey interger
        return toReturn;
    }

    // This code here lets us create tooltips for our blocks. what we will do above is create a new param next to COURSE_TAB that gives the tooltip in the form of a string.
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block,
                                                                           CreativeModeTab tab, String tooltipKey) {
        return modItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)){
            @Override
            public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltip, TooltipFlag pFlag) {
                pTooltip.add(new TranslatableComponent(tooltipKey));
            }
        });
    }

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, tab);
        return toReturn;
    }

    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, CreativeModeTab tab) {
        return modItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                new Item.Properties().tab(tab)));
    }

    public static void register(IEventBus eventBus) {

        BLOCKS.register(eventBus);
    }
}
