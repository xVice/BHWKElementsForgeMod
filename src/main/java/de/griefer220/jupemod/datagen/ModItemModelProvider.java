package de.griefer220.jupemod.datagen;

import de.griefer220.jupemod.BHWK;
import de.griefer220.jupemod.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.item.*;
public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, BHWK.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        //Julion items
        simpleItem(ModItems.csharp);

        //Juber items
        simpleItem(ModItems.juber_axe);
        simpleItem(ModItems.juber_shovel);
        simpleItem(ModItems.juber_pickaxe);
        simpleItem(ModItems.juber_axe);
        simpleItem(ModItems.juber_hoe);
        simpleItem(ModItems.juber_nugget);
        simpleItem(ModItems.juber_ingot);
        simpleItem(ModItems.juber_raw);
        simpleSwordItem(ModItems.juber_sword);

        //Leon challanger items
        simpleItem(ModItems.gelencser_ingot);

        //oarsch items
        simpleItem(ModItems.oarschi_platte);

        //juperion items
        simpleItem(ModItems.jupe_ingot);
        simpleItem(ModItems.raw_jupe);
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BHWK.MODID, "item/" + item.getId().getPath()));
    }

    private ItemModelBuilder simpleSwordItem(RegistryObject<SwordItem> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(BHWK.MODID, "item/" + item.getId().getPath()));
    }
}
