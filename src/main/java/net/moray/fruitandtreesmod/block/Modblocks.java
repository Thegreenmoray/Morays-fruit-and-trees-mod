package net.moray.fruitandtreesmod.block;


import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moray.fruitandtreesmod.block.custom.Miracle_berry_bush;
import net.moray.fruitandtreesmod.Item.ModItems;
import net.moray.fruitandtreesmod.fruitandtreesMod;

import java.util.function.Supplier;


public class Modblocks {

    public static final DeferredRegister<Block> MOD_BLOCKS=DeferredRegister.create(ForgeRegistries.BLOCKS, fruitandtreesMod.MODID);


 public static final RegistryObject<Block> MIRACLE_BERRY_BUSH=MOD_BLOCKS.register("miracle_berry_bush_berry",
         ()-> new Miracle_berry_bush(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion().instabreak()));


    private static <B extends Block> RegistryObject<B> register_block(String name, Supplier<B> block){
      RegistryObject<B>  toreturn= MOD_BLOCKS.register(name,block);
       register_block_item(name,toreturn);
        return toreturn;
    }



    private static <B extends Block> RegistryObject<Item> register_block_item(String name, RegistryObject<B> block){


        return ModItems.ITEM.register(name,()->new BlockItem(block.get(),new BlockItem.Properties()));
    }



    public static void register(IEventBus eventBus)  {
        MOD_BLOCKS.register(eventBus);}
}
