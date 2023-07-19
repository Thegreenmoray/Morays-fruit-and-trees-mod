package net.moray.fruitandtreesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.moray.fruitandtreesmod.block.Modblocks;
import net.moray.fruitandtreesmod.fruitandtreesMod;

public class ModBlockStateProvider extends BlockStateProvider {


    public ModBlockStateProvider(PackOutput output,  ExistingFileHelper exFileHelper) {
        super(output, fruitandtreesMod.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
       blockWithItem(Modblocks.MIRACLE_BERRY_BUSH);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }














}
