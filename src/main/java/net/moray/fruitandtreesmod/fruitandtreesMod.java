package net.moray.fruitandtreesmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.moray.fruitandtreesmod.block.Modblocks;
import net.moray.fruitandtreesmod.Item.ModItems;
import net.moray.fruitandtreesmod.effect.Modeffects;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(fruitandtreesMod.MODID)
public class fruitandtreesMod {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "moraysfruitandtreesmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();


    public fruitandtreesMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        Modeffects.register(modEventBus);

        Modblocks.register(modEventBus);


        modEventBus.addListener(this::commonSetup);



        MinecraftForge.EVENT_BUS.register(this);


        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {

        if(event.getTabKey()==CreativeModeTabs.FOOD_AND_DRINKS){
            event.accept(ModItems.Miracle_berry);}

        if (event.getTabKey()==CreativeModeTabs.INGREDIENTS){
            event.accept(ModItems.Miracle_seed);
        }
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent

        public static void onClientSetup(FMLClientSetupEvent event) {



        }
    }
}
