package com.bluelotuscoding.examplemod.util;

import com.bluelotuscoding.examplemod.ExampleMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;

public class modTags {
    //here we make  public static classes for blocks and items and then include the tags for each one.
    //We also have this here to reference the tags made in out data/tags folder.
    public static class Blocks {
        public static final Tags.IOptionalNamedTag<Block> DOWSING_ROD_VALUABLES =
                tag("dowsing_rod_valuables");

        private static Tags.IOptionalNamedTag<Block> tag(String name) {
            return BlockTags.createOptional(new ResourceLocation(ExampleMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Block> forgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }
    }


    public static class Items {

        public static final Tags.IOptionalNamedTag<Item> COBALT_INGOTS = forgeTag("ingots/cobalt");
        public static final Tags.IOptionalNamedTag<Item> DEEPSLATE_COBALT_INGOTS = forgeTag("ingots/deepslate_cobalt");
        public static final Tags.IOptionalNamedTag<Item> COBALT_NUGGETS = forgeTag("nuggets/cobalt");
        public static final Tags.IOptionalNamedTag<Item> RAW_COBALT = forgeTag("nuggets/raw_cobalt");

        private static Tags.IOptionalNamedTag<Item> tag(String name) {
            return ItemTags.createOptional(new ResourceLocation(ExampleMod.MOD_ID, name));
        }

        private static Tags.IOptionalNamedTag<Item> forgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }
    }
}
