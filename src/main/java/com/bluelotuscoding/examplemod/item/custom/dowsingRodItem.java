package com.bluelotuscoding.examplemod.item.custom;

import com.bluelotuscoding.examplemod.util.modTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class dowsingRodItem extends Item {
    public dowsingRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        //we want to make sure that we are on the clientside, the methods used in the if statement
        if(pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for(int i = -64; i <= positionClicked.getY() + 64; i++){
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow)){
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                foundBlock = true;
                break;
                }
            }

            if (!foundBlock){
                player.sendMessage(new TranslatableComponent("item.examplemod.dowsing_rod.no_valuables"),
                player.getUUID());
            }
        }

        //We are assigning damage to the item by calling the getItemInHand method.
        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    //class we create to display the tool tips of the Dowsing Rod
    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        if(Screen.hasShiftDown()) {
            pTooltipComponents.add(new TranslatableComponent("tooltip.examplemod.dowsing_rod.tooltip.shift"));
        } else {
            pTooltipComponents.add(new TranslatableComponent("tooltip.examplemod.dowsing_rod.tooltip"));

        }
    }

    //Helper Methods
    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow) {
        player.sendMessage(new TextComponent("Found " + blockBelow.asItem().getRegistryName().toString() + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"), player.getUUID());
    }

    private boolean isValuableBlock(Block block) {
        //This looks for if a block that we are searching for is within the DOWSING_ROD_VALUABLES tag
        return modTags.Blocks.DOWSING_ROD_VALUABLES.contains(block);
    }
}
