package net.mcreator.foodmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.foodmod.FoodModModElements;
import net.mcreator.foodmod.FoodModMod;

import java.util.Map;

@FoodModModElements.ModElement.Tag
public class BagetwithstrawberryjamFoodEatenProcedure extends FoodModModElements.ModElement {
	public BagetwithstrawberryjamFoodEatenProcedure(FoodModModElements instance) {
		super(instance, 60);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure BagetwithstrawberryjamFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 60, (int) 1));
	}
}
