
package net.mcreator.foodmod.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.world.World;
import net.minecraft.item.UseAction;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.Food;
import net.minecraft.entity.LivingEntity;

import net.mcreator.foodmod.procedures.RohlikwithstrawberryjamFoodEatenProcedure;
import net.mcreator.foodmod.FoodModModElements;

import java.util.Map;
import java.util.HashMap;

@FoodModModElements.ModElement.Tag
public class RohlikwithstrawberryjamItem extends FoodModModElements.ModElement {
	@ObjectHolder("food_mod:rohlikwithstrawberryjam")
	public static final Item block = null;
	public RohlikwithstrawberryjamItem(FoodModModElements instance) {
		super(instance, 64);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new FoodItemCustom());
	}
	public static class FoodItemCustom extends Item {
		public FoodItemCustom() {
			super(new Item.Properties().group(ItemGroup.FOOD).maxStackSize(64).rarity(Rarity.COMMON)
					.food((new Food.Builder()).hunger(5).saturation(0.3f).build()));
			setRegistryName("rohlikwithstrawberryjam");
		}

		@Override
		public UseAction getUseAction(ItemStack itemstack) {
			return UseAction.EAT;
		}

		@Override
		public ItemStack onItemUseFinish(ItemStack itemstack, World world, LivingEntity entity) {
			ItemStack retval = super.onItemUseFinish(itemstack, world, entity);
			double x = entity.getPosX();
			double y = entity.getPosY();
			double z = entity.getPosZ();
			{
				Map<String, Object> $_dependencies = new HashMap<>();
				$_dependencies.put("entity", entity);
				RohlikwithstrawberryjamFoodEatenProcedure.executeProcedure($_dependencies);
			}
			return retval;
		}
	}
}
