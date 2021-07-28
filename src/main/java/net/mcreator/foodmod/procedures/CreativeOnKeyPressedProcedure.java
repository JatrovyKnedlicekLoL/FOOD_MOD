package net.mcreator.foodmod.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.foodmod.FoodModModElements;
import net.mcreator.foodmod.FoodModMod;

import java.util.Map;

@FoodModModElements.ModElement.Tag
public class CreativeOnKeyPressedProcedure extends FoodModModElements.ModElement {
	public CreativeOnKeyPressedProcedure(FoodModModElements instance) {
		super(instance, 47);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				FoodModMod.LOGGER.warn("Failed to load dependency entity for procedure CreativeOnKeyPressed!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"/gamemode creative");
			}
		}
	}
}
