package net.moray.fruitandtreesmod.datagen;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.moray.fruitandtreesmod.Item.ModItems;
import net.moray.fruitandtreesmod.block.Modblocks;
import net.moray.fruitandtreesmod.block.custom.Miracle_berry_bush;

import java.util.Set;


public class ModBlockLootTables extends BlockLootSubProvider {


    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(Modblocks.MIRACLE_BERRY_BUSH.get(), (p_249159_) -> this.applyExplosionDecay(p_249159_,
                LootTable.lootTable().withPool(LootPool.lootPool()
                        .when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(Modblocks.MIRACLE_BERRY_BUSH.get())
                       .setProperties(StatePropertiesPredicate.Builder.properties()
                               .hasProperty(Miracle_berry_bush.AGE, 3)))
               .add(LootItem.lootTableItem(ModItems.Miracle_berry.get()))
                       .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
               .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));


    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return Modblocks.MOD_BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }




}
