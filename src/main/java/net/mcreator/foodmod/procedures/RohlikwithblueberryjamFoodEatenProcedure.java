package net.mcreator.foodmod.procedures;

@FoodModModElements.ModElement.Tag
public class RohlikwithblueberryjamFoodEatenProcedure extends FoodModModElements.ModElement {

	public RohlikwithblueberryjamFoodEatenProcedure(FoodModModElements instance) {
		super(instance, 61);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure RohlikwithblueberryjamFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.SPEED, (int) 2000, (int) 1));

	}

}
