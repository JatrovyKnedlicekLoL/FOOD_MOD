
package net.mcreator.foodmod.block;

import net.minecraft.block.material.Material;

@FoodModModElements.ModElement.Tag
public class BlackberrybushBlock extends FoodModModElements.ModElement {

	@ObjectHolder("food_mod:blackberrybush")
	public static final Block block = null;

	public BlackberrybushBlock(FoodModModElements instance) {
		super(instance, 63);

		MinecraftForge.EVENT_BUS.register(this);
		FMLJavaModLoadingContext.get().getModEventBus().register(new FeatureRegisterHandler());
	}

	@Override
	public void initElements() {
		elements.blocks.add(() -> new BlockCustomFlower());
		elements.items.add(() -> new BlockItem(block, new Item.Properties().group(ItemGroup.DECORATIONS)).setRegistryName(block.getRegistryName()));
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void clientLoad(FMLClientSetupEvent event) {
		RenderTypeLookup.setRenderLayer(block, RenderType.getCutout());
	}

	private static Feature<BlockClusterFeatureConfig> feature = null;
	private static ConfiguredFeature<?, ?> configuredFeature = null;

	private static class FeatureRegisterHandler {

		@SubscribeEvent
		public void registerFeature(RegistryEvent.Register<Feature<?>> event) {
			feature = new DefaultFlowersFeature(BlockClusterFeatureConfig.field_236587_a_) {
				@Override
				public BlockState getFlowerToPlace(Random random, BlockPos bp, BlockClusterFeatureConfig fc) {
					return block.getDefaultState();
				}

				@Override
				public boolean generate(ISeedReader world, ChunkGenerator generator, Random random, BlockPos pos, BlockClusterFeatureConfig config) {
					RegistryKey<World> dimensionType = world.getWorld().getDimensionKey();
					boolean dimensionCriteria = false;

					if (dimensionType == World.OVERWORLD)
						dimensionCriteria = true;

					if (!dimensionCriteria)
						return false;

					return super.generate(world, generator, random, pos, config);
				}
			};

			configuredFeature = feature
					.withConfiguration(
							(new BlockClusterFeatureConfig.Builder(new SimpleBlockStateProvider(block.getDefaultState()), new SimpleBlockPlacer()))
									.tries(64).build())
					.withPlacement(Features.Placements.VEGETATION_PLACEMENT).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT).func_242731_b(5);

			event.getRegistry().register(feature.setRegistryName("blackberrybush"));
			Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation("food_mod:blackberrybush"), configuredFeature);
		}

	}

	@SubscribeEvent
	public void addFeatureToBiomes(BiomeLoadingEvent event) {
		boolean biomeCriteria = false;
		if (new ResourceLocation("food_mod:foodbiom").equals(event.getName()))
			biomeCriteria = true;
		if (!biomeCriteria)
			return;

		event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).add(() -> configuredFeature);
	}

	public static class BlockCustomFlower extends FlowerBlock {

		public BlockCustomFlower() {
			super(Effects.SATURATION, 0, Block.Properties.create(Material.PLANTS).doesNotBlockMovement().sound(SoundType.PLANT)
					.hardnessAndResistance(0f, 0f).setLightLevel(s -> 0));
			setRegistryName("blackberrybush");
		}

		@Override
		public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 100;
		}

		@Override
		public int getFireSpreadSpeed(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
			return 60;
		}

		@Override
		public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {

			List<ItemStack> dropsOriginal = super.getDrops(state, builder);
			if (!dropsOriginal.isEmpty())
				return dropsOriginal;
			return Collections.singletonList(new ItemStack(BlackberryItem.block, (int) (4)));
		}

		@Override
		public PlantType getPlantType(IBlockReader world, BlockPos pos) {
			return PlantType.PLAINS;
		}

	}

}
