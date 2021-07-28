package net.mcreator.foodmod.procedures;

@FoodModModElements.ModElement.Tag
public class RohlikwithraspberryjamFoodEatenProcedure extends FoodModModElements.ModElement {

	public RohlikwithraspberryjamFoodEatenProcedure(FoodModModElements instance) {
		super(instance, 62);

	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure RohlikwithraspberryjamFoodEaten!");
			return;
		}

		Entity entity = (Entity) dependencies.get("entity");

		if (entity instanceof LivingEntity)
			((LivingEntity) entity).addPotionEffect(new EffectInstance(Effects.REGENERATION, (int) 2000, (int) 1));

	}

}
