package com.bluelotuscoding.examplemod.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class speedyBlock extends Block {
    public speedyBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(!pLevel.isClientSide()) {
            if(pEntity instanceof LivingEntity) {
                LivingEntity entity = ((LivingEntity) pEntity);
                entity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED,200,1));
                entity.addEffect(new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE,200,1));
                entity.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,300,5));
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);
    }
}
