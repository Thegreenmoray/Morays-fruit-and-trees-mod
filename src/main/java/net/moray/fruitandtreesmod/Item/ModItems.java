package net.moray.fruitandtreesmod.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moray.fruitandtreesmod.block.Modblocks;
import net.moray.fruitandtreesmod.effect.Modeffects;
import net.moray.fruitandtreesmod.fruitandtreesMod;

public class ModItems {
    public static final DeferredRegister<Item> ITEM=DeferredRegister.create(ForgeRegistries.ITEMS,
            fruitandtreesMod.MODID);

public static final RegistryObject<Item> Miracle_berry=ITEM.register("miracle_berry",()->new Item(new Item.Properties()
        .food(new FoodProperties.Builder()
                .nutrition(1).saturationMod(0.5f).effect(
                        ()-> new MobEffectInstance(Modeffects.Miraculin.get(),500,0),1).fast().build())));

public static final RegistryObject<Item> Miracle_seed=ITEM.register("miracle_seed",()->new ItemNameBlockItem
        (Modblocks.MIRACLE_BERRY_BUSH.get(),new Item.Properties()));



   public static void register(IEventBus eventBus)  {
       ITEM.register(eventBus);
    }
}
