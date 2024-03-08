package com.bluelotuscoding.examplemod.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class modFoods {
    public static final FoodProperties TURNUP = new FoodProperties.Builder().nutrition(4).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.HERO_OF_THE_VILLAGE, 300), 1f).build();
}
