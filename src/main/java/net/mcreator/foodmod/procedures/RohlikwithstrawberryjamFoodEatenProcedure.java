package net.mcreator.foodmod.procedures;

@FoodModModElements.ModElement.Tag
public class RohlikwithstrawberryjamFoodEatenProcedure extends FoodModModElements.ModElement {

	public RohlikwithstrawberryjamFoodEatenProcedure(FoodModModElements instance) {
		super(instance, 64);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure RohlikwithstrawberryjamFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.HASTE, (int) 2000, (int) 1));

	}

}
