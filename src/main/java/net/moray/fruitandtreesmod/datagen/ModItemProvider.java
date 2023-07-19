package net.moray.fruitandtreesmod.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.moray.fruitandtreesmod.Item.ModItems;
import net.moray.fruitandtreesmod.fruitandtreesMod;

public class ModItemProvider extends ItemModelProvider {




    public ModItemProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, fruitandtreesMod.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.Miracle_berry);
        simpleItem(ModItems.Miracle_seed);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(fruitandtreesMod.MODID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(fruitandtreesMod.MODID,"item/" + item.getId().getPath()));
    }
}





