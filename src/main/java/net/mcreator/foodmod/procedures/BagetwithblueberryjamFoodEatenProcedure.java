package net.mcreator.foodmod.procedures;

import net.minecraft.potion.Effects;
import net.minecraft.potion.EffectInstance;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Entity;

import net.mcreator.foodmod.FoodModModElements;
import net.mcreator.foodmod.FoodModMod;

import java.util.Map;

@FoodModModElements.ModElement.Tag
public class BagetwithblueberryjamFoodEatenProcedure extends FoodModModElements.ModElement {
	public BagetwithblueberryjamFoodEatenProcedure(FoodModModElements instance) {
		super(instance, 57);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure BagetwithblueberryjamFoodEaten!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 60, (int) 1));
	}
}
