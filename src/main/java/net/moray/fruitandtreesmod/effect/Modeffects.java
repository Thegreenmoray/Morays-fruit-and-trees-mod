package net.moray.fruitandtreesmod.effect;

import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.moray.fruitandtreesmod.Item.ModItems;
import net.moray.fruitandtreesmod.fruitandtreesMod;

public class Modeffects {

    public static final DeferredRegister<MobEffect>MOD_EFFECTS=DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, fruitandtreesMod.MODID);

    public static final RegistryObject<MobEffect> Miraculin=MOD_EFFECTS.register("miraculin",()-> new Miraculin(
            MobEffectCategory.BENEFICIAL,16733545));



    public static void register(IEventBus eventBus)  {
        MOD_EFFECTS.register(eventBus);
    }

}
