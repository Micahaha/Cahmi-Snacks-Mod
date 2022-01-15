package net.fabricmc.firstmod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.fabricmc.firstmod.blocks.PantryBlock;
import net.fabricmc.firstmod.blocks.entity.PantryBlockEntity;
import net.fabricmc.firstmod.items.ImposterSnack;
import net.fabricmc.firstmod.items.PowderedCocoa;
import net.fabricmc.firstmod.items.ReesesCup;
import net.fabricmc.firstmod.items.SnickersBar;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class Main implements ModInitializer {

	// Change strength level later
	public static final Block CANDY_PANTRY = new PantryBlock(FabricBlockSettings.of(Material.METAL));

	public static final ItemGroup SNACK_GROUP = FabricItemGroupBuilder.build(new Identifier("firstmod", "snacks"),
			() -> new ItemStack(Main.SUS_FOOD));
	public static final Item NEW_ITEM = new ImposterSnack(new FabricItemSettings().group(ItemGroup.MISC).group(SNACK_GROUP));
	// Snickers Bar
 	public static final Item SUS_FOOD = new SnickersBar(new FabricItemSettings().group(ItemGroup.FOOD)
			.maxCount(16)
			.food(new FoodComponent.Builder()
					.hunger(3).saturationModifier(15f)
					.snack()
					.meat()
					.alwaysEdible()
					.statusEffect(new StatusEffectInstance(StatusEffects.HEALTH_BOOST,20*30),1F).build()).group(SNACK_GROUP));
	// Reeses Cup
	public static final Item REESES_CUP = new ReesesCup(new FabricItemSettings().group(ItemGroup.MISC).group(SNACK_GROUP)
			.maxCount(16)
			.food(new FoodComponent.Builder()
					.hunger(3).
					snack()
					.meat()
					.alwaysEdible()
					.statusEffect(new StatusEffectInstance(StatusEffects.SPEED,20*30),1F).build()).group(SNACK_GROUP));

	public static final Item POWDERED_COCOA = new PowderedCocoa(new FabricItemSettings().group(ItemGroup.MISC)
			.maxCount(64)
			.food(new FoodComponent.Builder()
					.snack()
					.statusEffect(new StatusEffectInstance(StatusEffects.POISON,20*60), 1F)
					.statusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, 20*60), 1F)
					.build()).group(SNACK_GROUP));

	public static BlockEntityType<PantryBlockEntity> PANTRY_BLOCK_ENTITY;
	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.



		PANTRY_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, "firstmod:pantry_block_entity", BlockEntityType.Builder.create(PantryBlockEntity::new, CANDY_PANTRY).build(null));


		Registry.register(Registry.ITEM, new Identifier("firstmod", "sus_food"), SUS_FOOD);
		Registry.register(Registry.ITEM, new Identifier("firstmod", "new_item"), NEW_ITEM);
		Registry.register(Registry.BLOCK, new Identifier("firstmod","pantry_block"), CANDY_PANTRY);
		Registry.register(Registry.ITEM, new Identifier("firstmod", "pantry_block"), new BlockItem(CANDY_PANTRY, new FabricItemSettings().group(ItemGroup.INVENTORY).group(SNACK_GROUP)));
		Registry.register(Registry.ITEM, new Identifier("firstmod","reeses_cup"), REESES_CUP);
		Registry.register(Registry.ITEM, new Identifier("firstmod", "powdered_cocoa"), POWDERED_COCOA);

	}
}
